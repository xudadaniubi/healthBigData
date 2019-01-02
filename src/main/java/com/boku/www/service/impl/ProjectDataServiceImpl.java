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
		projectDataMapper.updateByPrimaryKeySelective(projectData);
	}

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TProjectData findOne(Integer id){
		return projectDataMapper.selectByPrimaryKey(id);
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
			example.setOrderByClause("`confirm_status` DESC,id ASC");

			TProjectDataExample.Criteria criteria = example.createCriteria();
			String roleGrade = null;
			if (projectData != null) {
				roleGrade = addProjectDatCriteria(projectData, criteria);
			}
			//只查询状态为1的数据
			criteria.andStatusEqualTo("1");
			PageHelper.startPage(pageNum, pageSize);
			//分页查询,得到符合条件的项目数据表的集合
			List<TProjectData> list = projectDataMapper.selectByExample(example);

			//将成果数量存到PageResult对应的属性里面
			Page<TProjectData> page = (Page<TProjectData>) list;
			//将查询到的角色和已确认/未确认的信息保存到PageResult里面，然后返回给前端
			PageResult pageResult = getPageResult(roleGrade, page ,projectData.getConfirmStatus());

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
		//项目管理单位
		if (projectData.getManagementCompany() != null && projectData.getManagementCompany().length() > 0) {
			criteria.andManagementCompanyEqualTo(projectData.getManagementCompany());
		}
		//项目分类级别
		if (projectData.getProjectCategoryGrade() != null && projectData.getProjectCategoryGrade().length() > 0) {
			criteria.andProjectCategoryGradeEqualTo(projectData.getProjectCategoryGrade());
		}
		//项目类别
		if (projectData.getProjectCategory() != null && projectData.getProjectCategory().length() > 0) {
			criteria.andProjectCategoryEqualTo(projectData.getProjectCategory());
		}
		//一级学科分类名称
		if (projectData.getSubjectName1() != null && projectData.getSubjectName1().length() > 0) {
			criteria.andSubjectName1EqualTo(projectData.getSubjectName1());
		}
		//二级学科分类名称
		if (projectData.getSubjectName2() != null && projectData.getSubjectName2().length() > 0) {
			criteria.andSubjectName2EqualTo(projectData.getSubjectName2());
		}
		//项目名称
		if (projectData.getProjectName() != null && projectData.getProjectName().length() > 0) {
			criteria.andProjectNameEqualTo(projectData.getProjectName());
		}
		//项目子类
		if (projectData.getProjectKidcat() != null && projectData.getProjectKidcat().length() > 0) {
			criteria.andProjectKidcatEqualTo(projectData.getProjectKidcat());
		}
		//类目
		if (projectData.getCategory() != null && projectData.getCategory().length() > 0) {
			criteria.andCategoryEqualTo(projectData.getCategory());
		}
		//根据时间段查询 立项时间
		if(projectData.getSearchStartTime() != null && projectData.getSearchEndTime()!= null){
			if (projectData.getSearchStartTime().toString() != null && projectData.getSearchStartTime().toString().length()>0
					&& projectData.getSearchEndTime().toString() != null && projectData.getSearchEndTime().toString().length()>0) {
				criteria.andProjectStartTimeBetween(projectData.getSearchStartTime(),projectData.getSearchEndTime());
			}
		}
		//根据时间段查询 结题时间
		/*if(projectData.getSearchStartTime() != null && projectData.getSearchEndTime()!= null){
			if (projectData.getSearchStartTime().toString() != null && projectData.getSearchStartTime().toString().length()>0
					&& projectData.getSearchEndTime().toString() != null && projectData.getSearchEndTime().toString().length()>0) {
				criteria.andProjectEndTimeBetween(projectData.getSearchStartTime(),projectData.getSearchEndTime());
			}
		}*/
		//所在地区
		if (projectData.getArea() != null && projectData.getArea().length() > 0) {
			criteria.andAreaEqualTo(projectData.getArea());
		}
		//模糊查询 承办单位
		if (projectData.getOrganizer() != null && projectData.getOrganizer().length() > 0) {
			criteria.andOrganizerLike("%"+projectData.getOrganizer()+ "%");
		}
		if (projectData.getFirstOrganizerCompany() != null && projectData.getFirstOrganizerCompany().length() > 0) {
			criteria.andFirstOrganizerCompanyLike("%"+projectData.getFirstOrganizerCompany()+ "%");
		}
		if (projectData.getOtherOrganizerCompany() != null && projectData.getOtherOrganizerCompany().length() > 0) {
			criteria.andOtherOrganizerCompanyLike("%"+projectData.getOtherOrganizerCompany()+ "%");
		}
		//模糊查询 项目负责人
		if (projectData.getProjectLeader() != null && projectData.getProjectLeader().length() > 0) {
			criteria.andProjectLeaderLike("%"+projectData.getProjectLeader() + "%");
		}
		//团队成员
		if (projectData.getTeamMembers() != null && projectData.getTeamMembers().length() > 0) {
			criteria.andTeamMembersLike("%" + projectData.getTeamMembers() + "%");
		}
		//根据角色添加条件
		//疑问？这里添加的条件会不会直接覆盖上面的条件，如区域/单位/负责人这三个条件是否会被覆盖掉？
		String roleGrade = addCriteriaByRoles(criteria);

		//添加确认状态的查询条件，主要用于信息确认页面，在默认状态下确认状态为null，在点击待确认的按钮时，查询出所有待确认的信息，将待确认的状态"2"作为条件，
		// 同理点击已确认按钮时，查询出所有已确认的信息，将已确认的状态"1"作为条件
		//确认分为项目确认和奖项确认，根据确认字段的不同查询出不同的细信息
		//项目确认
		if(projectData.getConfirmStatus() != null && projectData.getConfirmStatus().length()>0){
			criteria.andConfirmStatusEqualTo(projectData.getConfirmStatus());
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
	private PageResult getPageResult(String roleGrade, Page<TProjectData> page ,String confirmStatus ) {

		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());

		//统计查询所有未确认的项目信息
		TProjectDataExample unconfirmedCountExample=new TProjectDataExample();
		TProjectDataExample.Criteria unconfirmedCountCriteria = unconfirmedCountExample.createCriteria();
		addCriteriaByRoles(unconfirmedCountCriteria);
		unconfirmedCountCriteria.andConfirmStatusEqualTo("2");
		unconfirmedCountCriteria.andStatusEqualTo("1");
		int unconfirmedCount = projectDataMapper.countByExample(unconfirmedCountExample);
		pageResult.setUnconfirmedCount(unconfirmedCount);

		//统计查询所有已确认的项目信息
		TProjectDataExample confirmedCountExample=new TProjectDataExample();
		TProjectDataExample.Criteria confirmedCountCriteria = confirmedCountExample.createCriteria();
		addCriteriaByRoles(confirmedCountCriteria);
		confirmedCountCriteria.andConfirmStatusEqualTo("1");
		confirmedCountCriteria.andStatusEqualTo("1");
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
		if (projectData != null) {
			addProjectDatCriteria(projectData, criteria);
			//只查询状态为1的数据
			criteria.andStatusEqualTo("1");

		}
		//条件查询,得到符合条件的项目数据表的集合
		List<TProjectData> list = projectDataMapper.selectByExample(example);
		return list;
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
			projectData.setConfirmStatus("1");
			projectDataMapper.updateByPrimaryKey(projectData);
		}
	}

	/**
	 * 统计各地区项目的数量
	 */
	@Override
	public List<Count> countTheNumberOfProjectDataInEachArea(){
		return projectDataMapper.countTheNumberOfProjectDataInEachArea();
	}
}
