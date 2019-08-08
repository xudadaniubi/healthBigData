package com.boku.www.service.impl;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.boku.www.mapper.*;
import com.boku.www.pojo.*;
import com.boku.www.pojo.system.URole;
import com.boku.www.pojo.system.UUser;
import com.boku.www.service.system.RoleService;
import com.boku.www.utils.Count;
import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.PageResult;

import com.boku.www.utils.ParseExcelUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.boku.www.service.ProjectDataService;

import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static javax.xml.bind.JAXBIntrospector.getValue;

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

	@Autowired
	private TAreaAndCompanyMapper areaAndCompanyMapper;

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
			//projectDataMapper.selectByPrimaryKey(1);
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

	/**
	 * 根据用户的单位信息清理项目数据
	 * 	由于项目数据的1单位与用户的单位数据不完全对应，所以在做数据权限的时候查询出来的数据会出现偏差
	 * 	所以必须先清理好数据的单位信息，将数据添加单位id的信息，这样就能够精确匹配到数据，为客户提供更加准确地数据
	 * 	1.查询出所有不同的单位数据，装入set集合中
	 * 	2.在用户表中查询所有的单位是否有用户id，有用户id的，说明单位信息是正确的，没有用户id的说明查询的时候该单位的数据无法查询出来
	 * 	3.将无法查询出来的数据添加到集合中
	 *
	 * 	人工确认哪些数据是需要查询出来的
	 * 	补充新添加的单位和id
	 * 	替换需要查询出来的数据的单位名称
	 * 	替换完成后将单位的id拼接到单位id的字段中，并更新数据，这样查询出来的数据就能够准确的查询数据了
	 */
	@Override
	public void cleanProjectData() throws Exception{
		Set<String> set = new HashSet();
		Set<String> setNew = new HashSet();
		List<String> organizerList = projectDataMapper.selectDistinctOrganizer();
		for (String organizer:organizerList) {
			String[] split = organizer.split(",");
			for (String s:split) {
				set.add(s);
			}
		}
		for (String organizer:set) {
			TAreaAndCompanyExample example = new TAreaAndCompanyExample();
			TAreaAndCompanyExample.Criteria criteria = example.createCriteria();
			criteria.andCompanyEqualTo(organizer);
			List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectByExample(example);
			if(areaAndCompanyList.isEmpty()){
				setNew.add(organizer);
			}
		}
		for (String organizer:setNew) {
			System.out.println(organizer);
		}
		System.out.println(setNew.size());


	}

	/**
	 * 替换项目数据的单位
	 * 	由于项目数据里的单位与省卫计委标准名称不一致，所以在检索和替换单位id的时候会出现问题，所以需要将这些单位数据进行替换为标准数据，然后进行清理
	 */
	@Override
	public void repeatCompany(File file, String fileName) throws Exception {
		Sheet sheet = ParseExcelUtils.parseExcel(file, fileName);
		//行数
		int rowNumber = 0;
		//总行数
		int rowCount = sheet.getPhysicalNumberOfRows();
		if(rowCount>1){
			//标题行
			Row titleRow = sheet.getRow(0);
			//遍历行，略过标题行，从第二行开始
			for(int i=1;i<rowCount;i++){
				Row row = sheet.getRow(i);
				//跳过空行
				if(i>=1){
					if(row==null){continue;}
					else if(org.springframework.util.StringUtils.isEmpty(getValue(row.getCell(0)))&&org.springframework.util.StringUtils.isEmpty(getValue(row.getCell(1)))){
						continue;
					}
				}
				//行数
				rowNumber = row.getRowNum();
				//System.out.println(rowNumber+1);
				//被替换的单位
				String repeatCompany = row.getCell(0).getStringCellValue();
				//省卫计委名下单位
				String provinceCompany = row.getCell(1).getStringCellValue();
				String companyId = null;
				//单位id
				if(titleRow.getCell(2).getStringCellValue().indexOf("单位id")>=0){
					if(row.getCell(2)!=null && row.getCell(2).getCellType()==row.getCell(2).CELL_TYPE_NUMERIC){
						row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
						companyId = row.getCell(2).getStringCellValue().trim();
					}else if(row.getCell(2)!=null && row.getCell(2).getCellType()==row.getCell(2).CELL_TYPE_STRING){
						companyId = row.getCell(2).getStringCellValue().trim();
					}
				}
				//System.out.println("替换单位："+repeatCompany + "，省卫计委单位："+provinceCompany + "，单位id："+companyId);
				//将手工处理的医院进行替换
				//1.查询出所有的项目数据
				TProjectDataExample example = new TProjectDataExample();
				List<TProjectData> projectDataList = projectDataMapper.selectByExample(example);
				for (TProjectData projectData:projectDataList) {
					String organizer = projectData.getOrganizer();
					String otherOrganizerCompany = projectData.getOtherOrganizerCompany();
					String firstOrganizerCompany = projectData.getFirstOrganizerCompany();
					if(StringUtils.isNotBlank(organizer)){
						String[] split = organizer.split(",");
						for (String s:split) {
							//如果项目数据的单位里存在和需要替换的单位相同的，将其进行替换
							if(repeatCompany.equals(s)){
								//如果原数据库里不包含需要替换的单位就替换单位，如果有就不替换，避免重复
								if(!organizer.contains(provinceCompany)){
									organizer = organizer.replace(repeatCompany,provinceCompany);
									projectData.setOrganizer(organizer);
								}else {
									//江山衢州市人民医院 衢州市人民医院 避免这种情况不替换的情况
									if(repeatCompany.contains(provinceCompany)){
										organizer = organizer.replace(repeatCompany,provinceCompany);
										projectData.setOrganizer(organizer);
									}
								}
								//如果不为空就拼接，为空就直接添加
								if(StringUtils.isNotBlank(projectData.getOrganizerCompanyId())){
									//如果不包含当前的id，就拼接，如果包含了，说明重复了，就不做处理
									if(!projectData.getOrganizerCompanyId().contains(companyId)){
										projectData.setOrganizerCompanyId(projectData.getOrganizerCompanyId()+","+companyId);
										System.out.println(projectData.getOrganizerCompanyId());
									}
								}else if(StringUtils.isBlank(projectData.getOrganizerCompanyId())){
									projectData.setOrganizerCompanyId(companyId);

								}
							}
						}
					}
					if(StringUtils.isNotBlank(otherOrganizerCompany)){
						String[] split = otherOrganizerCompany.split(",");
						for (String s:split) {
							//如果项目数据的单位里存在和需要替换的单位向同的，将其进行替换
							if(repeatCompany.equals(s)){
								//如果原数据库里不包含需要替换的单位就替换单位，如果有就不替换，避免重复
								if(!otherOrganizerCompany.contains(provinceCompany)){
									otherOrganizerCompany = otherOrganizerCompany.replace(repeatCompany,provinceCompany);
									projectData.setOtherOrganizerCompany(otherOrganizerCompany);
								}else {
									//江山衢州市人民医院 衢州市人民医院 避免这种情况不替换的情况
									if(repeatCompany.contains(provinceCompany)){
										otherOrganizerCompany = otherOrganizerCompany.replace(repeatCompany,provinceCompany);
										projectData.setOtherOrganizerCompany(otherOrganizerCompany);
									}
								}
								//System.out.println("其他单位："+otherOrganizerCompany);
							}
						}
					}
					if(StringUtils.isNotBlank(firstOrganizerCompany)){
						//如果原数据库里不包含需要替换的单位就替换单位，如果有就不替换，避免重复
						if(!firstOrganizerCompany.contains(provinceCompany)){
							//如果项目数据的单位里存在和需要替换的单位向同的，将其进行替换
							if(repeatCompany.equals(firstOrganizerCompany)){
								firstOrganizerCompany = firstOrganizerCompany.replace(repeatCompany,provinceCompany);
								projectData.setFirstOrganizerCompany(firstOrganizerCompany);
								//System.out.println("第一单位："+firstOrganizerCompany);
							}
						}else {
							//江山衢州市人民医院 衢州市人民医院 避免这种情况不替换的情况
							if(repeatCompany.contains(provinceCompany)){
								firstOrganizerCompany = firstOrganizerCompany.replace(repeatCompany,provinceCompany);
								projectData.setFirstOrganizerCompany(firstOrganizerCompany);
							}
						}
					}
					if(StringUtils.isNotBlank(projectData.getOrganizerCompanyId())){
						//System.out.println(projectData);
						projectDataMapper.updateByPrimaryKey(projectData);
					}
				}
			}
		}
	}

	/**
	 * 根据单位信息表插入单位所属区域和单位id
	 * @throws Exception
	 */
	@Override
	public void insertCompanyAndArea()throws Exception{
		TProjectDataExample example = new TProjectDataExample();
		List<TProjectData> projectDataList = projectDataMapper.selectByExample(example);
		for (TProjectData projectData:projectDataList) {
			String organizer = projectData.getOrganizer();
			if(StringUtils.isNotBlank(organizer)) {
				String[] split = organizer.split(",");
				for (String s : split) {
					TAreaAndCompanyExample areaAndCompanyExample = new TAreaAndCompanyExample();
					TAreaAndCompanyExample.Criteria criteria = areaAndCompanyExample.createCriteria();
					criteria.andCompanyEqualTo(s);
					List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectByExample(areaAndCompanyExample);
					if(areaAndCompanyList!=null && areaAndCompanyList.size()>0){
						//projectData.setArea(areaAndCompanyList.get(0).getCity());
						if(StringUtils.isNotBlank(projectData.getOrganizerCompanyId())){
							if(!projectData.getOrganizerCompanyId().contains(areaAndCompanyList.get(0).getCompanyId())){
								projectData.setOrganizerCompanyId(projectData.getOrganizerCompanyId()+","+areaAndCompanyList.get(0).getCompanyId());
							}
						}else{
							projectData.setOrganizerCompanyId(areaAndCompanyList.get(0).getCompanyId());
						}
					}
				}
			}
			projectDataMapper.updateByPrimaryKey(projectData);
			System.out.println("地区："+projectData.getArea()+"---单位："+projectData.getOrganizer()+"---单位id："+projectData.getOrganizerCompanyId());
		}
	}

}
