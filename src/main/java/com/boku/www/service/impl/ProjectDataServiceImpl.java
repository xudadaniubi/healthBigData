package com.boku.www.service.impl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.boku.www.mapper.*;
import com.boku.www.pojo.*;
import com.boku.www.pojo.system.URole;
import com.boku.www.pojo.system.UUser;
import com.boku.www.service.system.RoleService;
import com.boku.www.utils.Count;
import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.PageResult;

import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.boku.www.service.ProjectDataService;

import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
@Transactional
public class ProjectDataServiceImpl implements ProjectDataService {

	@Autowired
	private TProjectDataMapper projectDataMapper;

	@Autowired
	private TBooksMapper booksMapper;

	@Autowired
	private TThesisForChineseMapper thesisForChineseMapper;

	@Autowired
	private TSubjectCategoryMapper subjectCategoryMapper;

	@Autowired
	private TPatentMapper patentMapper;


	@Autowired
	private RoleService roleService;

	@Autowired
	private TPrizeCategoryMapper prizeCategoryMapper;

	@Autowired
	private  TProjectCategoryMapper projectCategoryMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<TProjectData> findAll() {
		TProjectDataExample example=new TProjectDataExample();
		TProjectDataExample.Criteria criteria = example.createCriteria();
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		List<TProjectData> list = projectDataMapper.selectByExample(example);

		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		//如果学科id为空返回空
		for (int i=0;i<list.size();i++) {
			final TProjectData projectData1 = list.get(i);
			//立项时间
			if(projectData1.getProjectSatrtTime() != null){
				String projectBeginTime = format.format(projectData1.getProjectSatrtTime());
				projectData1.setProjectBeginTime(projectBeginTime);
			}
			//获奖时间
			if(projectData1.getPrizeTime() != null){
				String prizeEchoTime = format.format(projectData1.getPrizeTime());
				projectData1.setPrizeEchoTime(prizeEchoTime);
			}
			//学科编号可能为空
			if(projectData1.getSubject2Id()!=null&&projectData1.getSubject2Id().length()>0){
				//条件查询
				List<TSubjectCategory> tSubjectCategories = gettSubjectCategories(projectData1);
				//默认情况下，一个学科编号只对应一个学科，所以根据学科编号查询出来的集合应该只有一个实体对象，将这个实体对象的学科名称存储到项目数据表中的实体名称里面，返回到页面上
				if(tSubjectCategories != null && tSubjectCategories.size()>0){
					projectData1.setSubjectName(tSubjectCategories.get(0).getSubjectName());
				}
			}
		}
		return list;
	}


	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {

		TProjectDataExample example=new TProjectDataExample();
		TProjectDataExample.Criteria criteria = example.createCriteria();

		//根据角色添加查询条件(将角色级别返回)
		String roleGrade = addCriteriaByRoles(criteria);
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");

		//将查询结果进行分页
		PageHelper.startPage(pageNum, pageSize);
		List<TProjectData> list = projectDataMapper.selectByExample(example);
		Page<TProjectData> page = (Page<TProjectData>) list;
		//将查询到的角色和已确认/未确认的信息保存到PageResult里面，然后返回给前端
		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
		pageResult.setRoleGrade(roleGrade);

		return pageResult;
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TProjectData projectData) {
		//设置状态为1，即可用状态
		projectData.setStatus("1");
		TProjectDataExample example = new TProjectDataExample();
		TProjectDataExample.Criteria criteria = example.createCriteria();
		List<TProjectData> list = projectDataMapper.selectByExample(example);
		int maxProjectNum = 0;
		for (TProjectData tProjectData:list) {
			int projectNum = Integer.parseInt(tProjectData.getProjectNum());
			if(maxProjectNum<projectNum){
				maxProjectNum = projectNum + 1;
			}
		}
		projectData.setProjectNum(""+maxProjectNum);
		projectDataMapper.insert(projectData);		
	}

	
	/**
	 * 修改
	 *
	 * 因为projectData数据表中包含奖项数据和项目数据以及其他数据，而我们在前端提交过来的数据只用奖项数据和项目数据
	 * 所以我们可以根据id查询出来需要修改的数据，然后将新填写的数据重新赋值，再将数据存入到数据库中
	 */
	@Override
	public void update(TProjectData projectData){
		//1、根据id查询当前需要修改的实体(原数据库的实体)
        TProjectData tProjectData = findOne(projectData.getId());
		//2、判断当前前端传递过来的实体中需要修改的字段，如果不为空，将实体进行重新赋值
        //项目管理单位
		if(tProjectData != null){
			//项目管理单位
			if (projectData.getManagementCompany() != null && projectData.getManagementCompany().length() > 0) {
				tProjectData.setManagementCompany(projectData.getManagementCompany());
			}
			//项目级别
			if(projectData.getProjectCategoryGrade() != null && projectData.getProjectCategoryGrade().length() > 0){
				tProjectData.setProjectCategoryGrade(projectData.getProjectCategoryGrade());
			}
			//项目类别
			if (projectData.getSubject() != null && projectData.getSubject().length() > 0) {
				tProjectData.setSubject(projectData.getSubject());
				//查询项目字典表里是否有修改的项目，如果有就不用重新添加新的项目，如果没有就新增新的项目类别
				TProjectCategoryExample example = new TProjectCategoryExample();
				TProjectCategoryExample.Criteria criteria = example.createCriteria();
				criteria.andProjectCategoryEqualTo(projectData.getSubject());
				List<TProjectCategory> projectCategoryList = projectCategoryMapper.selectByExample(example);

				if(projectCategoryList == null || projectCategoryList.size()<=0){
					TProjectCategory projectCategory = new TProjectCategory();
					projectCategory.setGrade(projectData.getProjectCategoryGrade());
					projectCategory.setProjectCategory(projectData.getSubject());
					projectCategory.setStatus("1");
					//将新增好的项目字典信息插入到数据库里
					projectCategoryMapper.insert(projectCategory);
				}
			}
			//项目编号
			if (projectData.getProjectNum() != null && projectData.getProjectNum().length() > 0) {
				tProjectData.setProjectNum(projectData.getProjectNum());
			}
			//项目名称
			if (projectData.getProjectName() != null && projectData.getProjectName().length() > 0) {
				tProjectData.setProjectName(projectData.getProjectName());
			}
			if (projectData.getSubject1Id() != null && projectData.getSubject1Id().length() > 0) {
				//一级学科id
				tProjectData.setSubject1Id(projectData.getSubject1Id());
			}
			if (projectData.getSubject2Id() != null && projectData.getSubject2Id().length() > 0) {
				//二级学科id
				tProjectData.setSubject2Id(projectData.getSubject2Id());
			}
			//立项时间
			if(projectData.getProjectSatrtTime() != null){
				tProjectData.setProjectSatrtTime(projectData.getProjectSatrtTime());
			}
			//所属地区
			if (projectData.getArea() != null && projectData.getArea().length() > 0) {
				tProjectData.setArea(projectData.getArea());
			}
			//承担单位
			if (projectData.getOrganizer() != null && projectData.getOrganizer().length() > 0) {
				tProjectData.setOrganizer(projectData.getOrganizer());
			}
			//项目级别
			if (projectData.getProjectCategoryGrade() != null && projectData.getProjectCategoryGrade().length() > 0) {
				tProjectData.setProjectCategoryGrade(projectData.getProjectCategoryGrade());
			}
			//项目负责人
			if (projectData.getProjectLeader() != null && projectData.getProjectLeader().length() > 0) {
				tProjectData.setProjectLeader(projectData.getProjectLeader());
			}
			//团队成员
			if (projectData.getTeamMembers() != null && projectData.getTeamMembers().length() > 0) {
				tProjectData.setTeamMembers(projectData.getTeamMembers());
			}
			//奖励名称（2016年杭州市科技进步奖）
			if (projectData.getPrizeCategory() != null && projectData.getPrizeCategory().length() > 0) {
				tProjectData.setPrizeCategory(projectData.getPrizeCategory());
				//查询奖项字典表里是否有修改的奖项，如果有就不用重新添加新的奖项，如果没有就新增新的奖项类别
				TPrizeCategoryExample example = new TPrizeCategoryExample();
				TPrizeCategoryExample.Criteria criteria = example.createCriteria();
				criteria.andPrizeCategoryEqualTo(projectData.getPrizeCategory());
				List<TPrizeCategory> prizeCategoryList = prizeCategoryMapper.selectByExample(example);

				if(prizeCategoryList == null || prizeCategoryList.size()<=0){
					TPrizeCategory prizeCategory = new TPrizeCategory();
					prizeCategory.setGrade(projectData.getPrizeCategoryGrade());
					prizeCategory.setPrizeCategory(projectData.getPrizeCategory());
					prizeCategory.setStatus("1");
					//将新增好的项目字典信息插入到数据库里
					prizeCategoryMapper.insert(prizeCategory);
				}
			}
			//拟奖等级（一等奖）
			if (projectData.getPrizeName() != null && projectData.getPrizeName().length() > 0) {
				tProjectData.setPrizeName(projectData.getPrizeName());
			}
			//获奖时间
			if(projectData.getPrizeTime() != null){
				tProjectData.setPrizeTime(projectData.getPrizeTime());
			}
			//奖励级别（国家级）
			if (projectData.getPrizeCategoryGrade() != null && projectData.getPrizeCategoryGrade().length() > 0) {
				tProjectData.setPrizeCategoryGrade(projectData.getPrizeCategoryGrade());
			}
		}
        //将修改好的实体存入到数据库
		projectDataMapper.updateByPrimaryKey(tProjectData);
	}

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TProjectData findOne(Integer id){
		TProjectData projectData = projectDataMapper.selectByPrimaryKey(id);
		if(projectData != null){
			//根据学科id查询出对应的学科名称，然后分别将一级学科和二级学科存入到实体中
			TSubjectCategoryExample example1 = new TSubjectCategoryExample();
			TSubjectCategoryExample.Criteria criteria1 = example1.createCriteria();
			if(projectData.getSubject1Id() != null && projectData.getSubject1Id().length()>0){
				criteria1.andSubjectIdEqualTo(projectData.getSubject1Id());
				//一级学科
				List<TSubjectCategory> subjectCategoryList = subjectCategoryMapper.selectByExample(example1);
				if(subjectCategoryList != null && subjectCategoryList.size()>0){
					projectData.setSubject1Id(subjectCategoryList.get(0).getSubjectName());
				}
			}
			TSubjectCategoryExample example2 = new TSubjectCategoryExample();
			TSubjectCategoryExample.Criteria criteria2 = example2.createCriteria();
			if(projectData.getSubject2Id() != null && projectData.getSubject2Id().length()>0){
				criteria2.andSubjectIdEqualTo(projectData.getSubject2Id());
				//二级学科
				List<TSubjectCategory> subjectCategoryList2 = subjectCategoryMapper.selectByExample(example2);
				if(subjectCategoryList2 != null && subjectCategoryList2.size()>0){
					projectData.setSubject2Id(subjectCategoryList2.get(0).getSubjectName());
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy");
				//如果学科id为空返回空
				//立项时间
				if(projectData.getProjectSatrtTime() != null){
					String projectBeginTime = format.format(projectData.getProjectSatrtTime());
					projectData.setProjectBeginTime(projectBeginTime);
				}
				//获奖时间
				if(projectData.getPrizeTime() != null){
					String prizeEchoTime = format.format(projectData.getPrizeTime());
					projectData.setPrizeEchoTime(prizeEchoTime);
				}
			}
		}
		return projectData;
	}

	/**
	 * 批量删除，逻辑删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			TProjectData projectData = projectDataMapper.selectByPrimaryKey(id);
			projectData.setStatus("2");
			projectDataMapper.updateByPrimaryKey(projectData);
		}		
	}

	/**
	 * 分页条件查询
	 * @param projectData
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
		@Override
	public PageResult findPage(TProjectData projectData, int pageNum, int pageSize) {

			TProjectDataExample example = new TProjectDataExample();
			//添加升序降序排列条件，DESC为降序
			if("1".equals(projectData.getCode())){
				example.setOrderByClause("`confirm_prize_status` DESC,id ASC");
			}else if("2".equals(projectData.getCode())){
				example.setOrderByClause("`confirm_project_status` DESC,id ASC");
			}
			TProjectDataExample.Criteria criteria = example.createCriteria();
			String roleGrade = null;
			if (projectData != null) {
				roleGrade = addProjectDatCriteria(projectData, criteria);
				//只查询状态为1的数据
				criteria.andStatusEqualTo("1");
			}
			PageHelper.startPage(pageNum, pageSize);
			//分页查询,得到符合条件的项目数据表的集合
			List<TProjectData> list = projectDataMapper.selectByExample(example);

			//根据对应的数subjectId查询出对应的学科名称，默认显示二级学科的名称，将学科名称存入到PageResult对应的属性里面
			//转换日期格式，以字符串的形式显示到页面
			SimpleDateFormat format = new SimpleDateFormat("yyyy");
			//如果学科id为空返回空
			for (int i=0;i<list.size();i++) {
				final TProjectData projectData1 = list.get(i);
				//立项时间
				if(projectData1.getProjectSatrtTime() != null){
					String projectBeginTime = format.format(projectData1.getProjectSatrtTime());
					projectData1.setProjectBeginTime(projectBeginTime);
				}
				//获奖时间
				if(projectData1.getPrizeTime() != null){
					String prizeEchoTime = format.format(projectData1.getPrizeTime());
					projectData1.setPrizeEchoTime(prizeEchoTime);
				}
				//学科编号可能为空
				if(projectData1.getSubject2Id()!=null&&projectData1.getSubject2Id().length()>0){
					//条件查询
					List<TSubjectCategory> tSubjectCategories = gettSubjectCategories(projectData1);
					//默认情况下，一个学科编号只对应一个学科，所以根据学科编号查询出来的集合应该只有一个实体对象，将这个实体对象的学科名称存储到项目数据表中的实体名称里面，返回到页面上
					if(tSubjectCategories != null && tSubjectCategories.size()>0){
						projectData1.setSubjectName(tSubjectCategories.get(0).getSubjectName());
					}
				}
			}

			//将成果数量存到PageResult对应的属性里面
			//PageInfo<TProjectData> pageInfo = new PageInfo<TProjectData>(list);
			Page<TProjectData> page = (Page<TProjectData>) list;
			//将查询到的角色和已确认/未确认的信息保存到PageResult里面，然后返回给前端
			PageResult pageResult = getPageResult(roleGrade, page ,projectData.getConfirmProjectStatus() , projectData.getConfirmPrizeStatus() ,  projectData.getCode());

			return pageResult;
		}
	/**
	 * 根据角色添加查询条件
	 *
	 * 设置省、市、医院、个人四级权限，根据不同的权限，修改服务层代码，查询不同的数据，
	 *不同的权限返回不同的数据，同时返回权限级别，不同的权限显示不同的按钮（级别给前端进行判断，根据级别的不同，显示不同的按钮。
	 *如专家按钮，在个人级别的时候不现实，单位查询按钮在单位级别以下的不显示，地区选择按钮省级可选择地级市以下的地区和单位，
	 *地级市只能查询本市以下的地区和单位）
	 * @param criteria
	 */
	private String addCriteriaByRoles(TProjectDataExample.Criteria criteria) {
		UUser currentUser = CurrentUser.returnCurrentUser();
		if (currentUser != null) {
			String roleGrade = null;
			projectDataMapper.selectByPrimaryKey(1);
			List<URole> rlist = roleService.findRoleByUid(currentUser.getId());//获取用户角色
			//根据角色的获取不同的数据，如果是admin或省级角色，查询所有的数据，如果是市级权限，查询本市的数据，
			// 如果是单位权限，查询本单位的数据，如果是个人的角色，查询个人的数据
			for (URole role : rlist) {
				if("admin".equals(role.getName())){
					//不添加任何限制条件
				}else if("省级".equals(role.getName())){
					//不添加任何限制条件
				}else if("地市级".equals(role.getName())){
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本市的名称
						criteria.andAreaEqualTo(currentUser.getArea());
					}
				}else if("医院".equals(role.getName())){
					if(currentUser.getCompany()!=null && currentUser.getCompany().length()>0){
						//添加本单位的名称
						criteria.andOrganizerEqualTo(currentUser.getCompany());
					}
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本人所属地区
						criteria.andAreaEqualTo(currentUser.getArea());
					}
				}else if("个人".equals(role.getName())){
					if(currentUser.getCompany()!=null && currentUser.getCompany().length()>0){
						//添加本单位的名称
						criteria.andOrganizerEqualTo(currentUser.getCompany());
					}
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本人所属地区
						criteria.andAreaEqualTo(currentUser.getArea());
					}
					if(currentUser.getUsername()!=null && currentUser.getUsername().length()>0){
						//添加本人的名称
						criteria.andProjectLeaderEqualTo(currentUser.getUsername());
					}
				}
				roleGrade = role.getName();

			}
			return roleGrade;
		}
		return "该用户角色非法";
	}
	/**添加查询条件
	 * @param projectData
	 * @param criteria
	 */
	private String addProjectDatCriteria(TProjectData projectData, TProjectDataExample.Criteria criteria){
		if (projectData.getManagementCompany() != null && projectData.getManagementCompany().length() > 0) {
			criteria.andManagementCompanyEqualTo(projectData.getManagementCompany());
		}
		//项目类别
		if (projectData.getSubject() != null && projectData.getSubject().length() > 0) {
			criteria.andSubjectEqualTo(projectData.getSubject());
		}
		if (projectData.getProjectNum() != null && projectData.getProjectNum().length() > 0) {
			criteria.andProjectNumEqualTo( projectData.getProjectNum());
		}
		if (projectData.getProjectName() != null && projectData.getProjectName().length() > 0) {
			criteria.andProjectNameEqualTo(projectData.getProjectName());
		}
		if (projectData.getProjectKidcat() != null && projectData.getProjectKidcat().length() > 0) {
			criteria.andProjectKidcatEqualTo(projectData.getProjectKidcat());
		}
		if (projectData.getCategory() != null && projectData.getCategory().length() > 0) {
			criteria.andCategoryEqualTo(projectData.getCategory());
		}
		if (projectData.getSubject1Id() != null && projectData.getSubject1Id().length() > 0) {
			criteria.andSubject1IdEqualTo(projectData.getSubject1Id());
		}
		if (projectData.getSubject2Id() != null && projectData.getSubject2Id().length() > 0) {
			criteria.andSubject2IdEqualTo(projectData.getSubject2Id());
		}
		if (projectData.getSubject3Id() != null && projectData.getSubject3Id().length() > 0) {
			criteria.andSubject3IdEqualTo(projectData.getSubject3Id());
		}
		//根据时间段查询
		if(projectData.getSearchStartTime() != null && projectData.getSearchEndTime()!= null){
			if (projectData.getSearchStartTime().toString() != null && projectData.getSearchStartTime().toString().length()>0
					&& projectData.getSearchEndTime().toString() != null && projectData.getSearchEndTime().toString().length()>0) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy");
				//将String装换为Date
				try {
					Date searchStartTime = format.parse(projectData.getSearchStartTime());
					Date searchEndTime = format.parse(projectData.getSearchEndTime());
					criteria.andProjectSatrtTimeBetween(searchStartTime,searchEndTime);
				}  catch (ParseException e) {
					e.printStackTrace();
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		if (projectData.getArea() != null && projectData.getArea().length() > 0) {
			criteria.andAreaEqualTo(projectData.getArea());
		}
		//模糊查询
		if (projectData.getOrganizer() != null && projectData.getOrganizer().length() > 0) {
			criteria.andOrganizerLike("%"+projectData.getOrganizer()+ "%");
		}
		//模糊查询
		if (projectData.getProjectLeader() != null && projectData.getProjectLeader().length() > 0) {
			criteria.andProjectLeaderLike("%"+projectData.getProjectLeader() + "%");
		}
		if (projectData.getTeamMembers() != null && projectData.getTeamMembers().length() > 0) {
			criteria.andTeamMembersLike("%" + projectData.getTeamMembers() + "%");
		}
		if (projectData.getPrizeCategory() != null && projectData.getPrizeCategory().length() > 0) {
			criteria.andPrizeCategoryEqualTo(projectData.getPrizeCategory());
		}
		if (projectData.getPrizeName() != null && projectData.getPrizeName().length() > 0) {
			criteria.andPrizeNameEqualTo(projectData.getPrizeName());
		}
		if (projectData.getProjectCategoryGrade() != null && projectData.getProjectCategoryGrade().length() > 0) {
			criteria.andProjectCategoryGradeEqualTo(projectData.getProjectCategoryGrade());
		}
		if (projectData.getPrizeCategoryGrade() != null && projectData.getPrizeCategoryGrade().length() > 0) {
			criteria.andPrizeCategoryGradeEqualTo(projectData.getPrizeCategoryGrade());
		}
		//根据角色添加条件
		//疑问？这里添加的条件会不会直接覆盖上面的条件，如区域/单位/负责人这三个条件是否会被覆盖掉？
		String roleGrade = addCriteriaByRoles(criteria);

		//添加确认状态的查询条件，主要用于信息确认页面，在默认状态下确认状态为null，在点击待确认的按钮时，查询出所有待确认的信息，将待确认的状态"2"作为条件，
		// 同理点击已确认按钮时，查询出所有已确认的信息，将已确认的状态"1"作为条件
		//确认分为项目确认和奖项确认，根据确认字段的不同查询出不同的细信息
		//项目确认
		if(projectData.getConfirmProjectStatus() != null && projectData.getConfirmProjectStatus().length()>0){
			criteria.andConfirmProjectStatusEqualTo(projectData.getConfirmProjectStatus());
		}
		//System.out.println("确认项目状态"+projectData.getConfirmProjectStatus());
		//System.out.println("确认奖励状态"+projectData.getConfirmPrizeStatus());
		//奖项确认
		if(projectData.getConfirmPrizeStatus() != null && projectData.getConfirmPrizeStatus().length()>0){
			criteria.andConfirmPrizeStatusEqualTo(projectData.getConfirmPrizeStatus());
		}
		if(projectData.getCode()!=null && projectData.getCode().length()>0){
			if(projectData.getCode().equals("1")){
				//查询奖励部位空的数据
				criteria.andPrizeCategoryIsNotNull();
				criteria.andPrizeCategoryNotEqualTo("''");
			}
		}
		return roleGrade;
	}

	/**
	 * 将查询到的角色和已确认/未确认的数量信息保存到PageResult里面，然后返回给前端
	 * 设置确认状态的一个状态码code：
	 * 1代表奖励状态为空，也就是刚进入奖励确认这个页面的时候，这时就添加奖励的查询条件；
	 * 2代表项目状态为空，也就是刚进入项目确认页面的时候，添加项目的查询条件。
	 * @param roleGrade
	 * @param page
	 * @return
	 */
	private PageResult getPageResult(String roleGrade, Page<TProjectData> page ,String confirmProjectStatus , String confirmPrizeStatus ,String code) {

		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());

		//统计查询所有未确认的项目信息
		TProjectDataExample unconfirmedCountExample=new TProjectDataExample();
		TProjectDataExample.Criteria unconfirmedCountCriteria = unconfirmedCountExample.createCriteria();
		addCriteriaByRoles(unconfirmedCountCriteria);
		//分别统计未确认的项目和奖项信息
		if("1".equals(code)){
			//奖励
			unconfirmedCountCriteria.andConfirmPrizeStatusEqualTo("2");
			unconfirmedCountCriteria.andStatusEqualTo("1");
			//查询奖励不为空的数据
			unconfirmedCountCriteria.andPrizeCategoryIsNotNull();
			unconfirmedCountCriteria.andPrizeCategoryNotEqualTo("''");
		}else if("2".equals(code)){
			//项目
			unconfirmedCountCriteria.andConfirmProjectStatusEqualTo("2");
			unconfirmedCountCriteria.andStatusEqualTo("1");
		}

		int unconfirmedCount = projectDataMapper.countByExample(unconfirmedCountExample);
		pageResult.setUnconfirmedCount(unconfirmedCount);
		//统计查询所有已确认的项目信息
		TProjectDataExample confirmedCountExample=new TProjectDataExample();
		TProjectDataExample.Criteria confirmedCountCriteria = confirmedCountExample.createCriteria();
		addCriteriaByRoles(confirmedCountCriteria);
		//分别统计已确认的项目和奖项信息
		if("1".equals(code)){
			//奖励
			confirmedCountCriteria.andConfirmPrizeStatusEqualTo("1");
			confirmedCountCriteria.andStatusEqualTo("1");
			//查询奖励不为空的数据
			confirmedCountCriteria.andPrizeCategoryIsNotNull();
			confirmedCountCriteria.andPrizeCategoryNotEqualTo("''");
		}else if("2".equals(code)){
			//项目
			confirmedCountCriteria.andConfirmProjectStatusEqualTo("1");
			confirmedCountCriteria.andStatusEqualTo("1");
		}

		int confirmedCount = projectDataMapper.countByExample(confirmedCountExample);
		pageResult.setConfirmedCount(confirmedCount);

		pageResult.setRoleGrade(roleGrade);
		return pageResult;
	}

	/**
	 * 根据条件查询项目数据及统计信息，将数据返回controller，controller将集合转换为excel文件，下载到本地文件(这个方法和分页条件查询大部分相同，能不能进行优化？)
	 * @param projectData
	 * @return
	 */
	@Override
	public List<TProjectData> findTProjectDataToExcel(TProjectData projectData) {

		TProjectDataExample example = new TProjectDataExample();
		TProjectDataExample.Criteria criteria = example.createCriteria();
		//System.out.println(projectData);
		if (projectData != null) {
			addProjectDatCriteria(projectData, criteria);
			//只查询状态为1的数据
			criteria.andStatusEqualTo("1");

		}
		//条件查询,得到符合条件的项目数据表的集合
		List<TProjectData> list = projectDataMapper.selectByExample(example);

		//根据对应的数subjectId查询出对应的学科名称，默认显示二级学科的名称，将学科名称存入到PageResult对应的属性里面
		for (int i=0;i<list.size();i++) {
			final TProjectData projectData1 = list.get(i);
			//学科编号可能为空
			if(projectData1.getSubject2Id()!=null && projectData1.getSubject2Id().length()>0){
				//条件查询
				List<TSubjectCategory> tSubjectCategories = gettSubjectCategories(projectData1);
				//默认情况下，一个学科编号只对应一个学科，所以根据学科编号查询出来的集合应该只有一个实体对象，将这个实体对象的学科名称存储到项目数据表中的实体名称里面，返回到页面上
				if(tSubjectCategories != null && tSubjectCategories.size()>0){
					projectData1.setSubjectName(tSubjectCategories.get(0).getSubjectName());
				}
			}
		}

		return list;
	}

	/**查询所有的成果数据（科研成果统计）
	 * 根据成果名称如：论文，查询所有的论文数据，将数据存储到对应的实体，封装到list集合里面进行返回
	 */
	@Override
	public List downloadResultStatisticsExcel(String resultCategory) {

		//判断当前成果的类别
		if(resultCategory != null && resultCategory.length()>0) {
			/*if (resultCategory.equals("论文")) {
				TThesisExample example = new TThesisExample();
				TThesisExample.Criteria criteria = example.createCriteria();
				criteria.andStatusEqualTo("1");

				List<TThesis> thesisList = thesisMapper.selectByExample(example);
				for (TThesis thesis: thesisList) {
					//thesis.getProjectNum()可能为空
					if(thesis.getProjectNum()!=null && thesis.getProjectNum().length()>0){
						TProjectDataExample projectDataExample = new TProjectDataExample();
						TProjectDataExample.Criteria projectDataCriteria = projectDataExample.createCriteria();
						projectDataCriteria.andStatusEqualTo("1");
						//添加查询条件（项目编号）
						projectDataCriteria.andProjectNumEqualTo(thesis.getProjectNum());
						//因为项目编号是唯一的，所以在项目表里面只有一条数据对应成果表的项目编号（一（项目数据表）对多（成果数据表）的关系）
						List<TProjectData> list = projectDataMapper.selectByExample(projectDataExample);
						//将唯一的数据拿出来，放到指定的实体中
						TProjectData projectData = list.get(0);
						//学科编号可能为空
						if(projectData.getSubject2Id()!=null && projectData.getSubject2Id().length()>0){
							//学科分类//条件查询
							List<TSubjectCategory> tSubjectCategories = gettSubjectCategories(projectData);
							//默认情况下，一个学科编号只对应一个学科，所以根据学科编号查询出来的集合应该只有一个实体对象，将这个实体对象的学科名称存储到项目数据表中的实体名称里面，返回到页面上
							thesis.setSubjectName(tSubjectCategories.get(0).getSubjectName());
						}

					}
					//成果类别
					thesis.setResultCategory("论文");
				}
				return thesisList;
			} else if (resultCategory.equals("专著")) {
				TBooksExample example = new TBooksExample();
				TBooksExample.Criteria criteria = example.createCriteria();
				criteria.andStatusEqualTo("1");
				List<TBooks> booksList = booksMapper.selectByExample(example);
				for (TBooks books: booksList) {
					//books.getProjectNum()可能为空
					if(books.getProjectNum()!=null && books.getProjectNum().length()>0){
						TProjectDataExample projectDataExample = new TProjectDataExample();
						TProjectDataExample.Criteria projectDataCriteria = projectDataExample.createCriteria();
						projectDataCriteria.andStatusEqualTo("1");
						//添加查询条件（项目编号）
						projectDataCriteria.andProjectNumEqualTo(books.getProjectNum());
						//因为项目编号是唯一的，所以在项目表里面只有一条数据对应成果表的项目编号（一（项目数据表）对多（成果数据表）的关系）
						List<TProjectData> list = projectDataMapper.selectByExample(projectDataExample);
						//System.out.println(list.size());
						//将唯一的数据拿出来，放到指定的实体中
						TProjectData projectData = list.get(0);
						//学科编号可能为空
						if(projectData.getSubject2Id()!=null && projectData.getSubject2Id().length()>0){
							//学科分类
							//条件查询
							List<TSubjectCategory> tSubjectCategories = gettSubjectCategories(projectData);
							//默认情况下，一个学科编号只对应一个学科，所以根据学科编号查询出来的集合应该只有一个实体对象，将这个实体对象的学科名称存储到项目数据表中的实体名称里面，返回到页面上
							books.setSubjectName(tSubjectCategories.get(0).getSubjectName());
						}
					}
					//成果类别
					books.setResultCategory("专著");
				}
				return booksList;
			} else if (resultCategory.equals("专利")) {
				TPatentExample example = new TPatentExample();
				TPatentExample.Criteria criteria = example.createCriteria();
				criteria.andStatusEqualTo("1");
				List<TPatent> patentList = patentMapper.selectByExample(example);
				for (TPatent patent: patentList) {
					//books.getProjectNum()可能为空
					if(patent.getProjectNum()!=null && patent.getProjectNum().length()>0){
						TProjectDataExample projectDataExample = new TProjectDataExample();
						TProjectDataExample.Criteria projectDataCriteria = projectDataExample.createCriteria();
						projectDataCriteria.andStatusEqualTo("1");
						//添加查询条件（项目编号）
						projectDataCriteria.andProjectNumEqualTo(patent.getProjectNum());
						//因为项目编号是唯一的，所以在项目表里面只有一条数据对应成果表的项目编号（一（项目数据表）对多（成果数据表）的关系）
						List<TProjectData> list = projectDataMapper.selectByExample(projectDataExample);
						//将唯一的数据拿出来，放到指定的实体中
						TProjectData projectData = list.get(0);
						if(projectData.getSubject2Id()!=null && projectData.getSubject2Id().length()>0){
							//学科分类
							//条件查询
							List<TSubjectCategory> tSubjectCategories = gettSubjectCategories(projectData);
							//默认情况下，一个学科编号只对应一个学科，所以根据学科编号查询出来的集合应该只有一个实体对象，将这个实体对象的学科名称存储到项目数据表中的实体名称里面，返回到页面上
							patent.setSubjectName(tSubjectCategories.get(0).getSubjectName());
						}
					}
					//成果类别
					patent.setResultCategory("专利");
				}
				return patentList;
			}*/
		}
		return null;
	}

	/**
	 * 查询学科编号的方法
	 * @param projectData
	 * @return
	 */
	private List<TSubjectCategory> gettSubjectCategories(TProjectData projectData) {
		TSubjectCategoryExample subjectCategoryExample = new TSubjectCategoryExample();
		TSubjectCategoryExample.Criteria subjectCategoryCriteria = subjectCategoryExample.createCriteria();
		subjectCategoryCriteria.andSubjectIdEqualTo(projectData.getSubject2Id());
		return subjectCategoryMapper.selectByExample(subjectCategoryExample);
	}

	/**
	 * 项目数据使用的批量确认
	 * @param ids
	 */
	@Override
	public void confirmProjectDataStatus(Integer[] ids) {
		for(Integer id:ids){
			TProjectData projectData = projectDataMapper.selectByPrimaryKey(id);
			//已确认 确认状态修改为“1”
			projectData.setConfirmProjectStatus("1");
			projectDataMapper.updateByPrimaryKey(projectData);
		}
	}
	/**
	 * 奖励数据使用的批量确认
	 * @param ids
	 */
	@Override
	public void confirmPrizeStatus(Integer[] ids) {
		for(Integer id:ids){
			TProjectData projectData = projectDataMapper.selectByPrimaryKey(id);
			//已确认 确认状态修改为“1”
			projectData.setConfirmPrizeStatus("1");
			projectDataMapper.updateByPrimaryKey(projectData);
		}
	}

	/**
	 * 详情的时候使用的批量确认
	 * @param ids
	 */
	@Override
	public void confirmProjectAndPrizeStatus(Integer[] ids) {
		for(Integer id:ids){
			TProjectData projectData = projectDataMapper.selectByPrimaryKey(id);
			//已确认 确认状态修改为“1”
			projectData.setConfirmProjectStatus("1");
			projectData.setConfirmPrizeStatus("1");
			projectDataMapper.updateByPrimaryKey(projectData);
		}
	}

	/**
	 * 查询最大的项目编号
	 */
	@Override
	public String selectMaxProjectNum(){
		return projectDataMapper.selectMaxProjectNum();
	}

	/**
	 * 统计各地区项目的数量
	 */
	@Override
	public List<Count> countTheNumberOfProjectDataInEachArea(){
		return projectDataMapper.countTheNumberOfProjectDataInEachArea();
	}
}
