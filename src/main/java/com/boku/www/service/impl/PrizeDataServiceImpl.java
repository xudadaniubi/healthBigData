/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: PrizeDataServiceImpl
 * Author:   dell
 * Date:     2018/12/24 14:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.service.impl;

import com.boku.www.mapper.*;
import com.boku.www.pojo.*;
import com.boku.www.pojo.system.URole;
import com.boku.www.pojo.system.UUser;
import com.boku.www.service.PrizeDataService;
import com.boku.www.service.system.RoleService;
import com.boku.www.utils.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.xml.bind.JAXBIntrospector.getValue;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author dell
 * @create 2018/12/24
 * @since 1.0.0
 */

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
@Transactional
public class PrizeDataServiceImpl implements PrizeDataService {

	@Autowired
	private TPrizeDataMapper prizeDataMapper;

	@Autowired
	private RoleService roleService;

	@Autowired
	private TAreaAndCompanyMapper areaAndCompanyMapper;
	/**
	 * 查询全部
	 */
	@Override
	public List<TPrizeData> findAll() {
		TPrizeDataExample example=new TPrizeDataExample();
		TPrizeDataExample.Criteria criteria = example.createCriteria();
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		List<TPrizeData> list = prizeDataMapper.selectByExample(example);
		return list;
	}


	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {

		TPrizeDataExample example=new TPrizeDataExample();
		TPrizeDataExample.Criteria criteria = example.createCriteria();

		//根据角色添加查询条件(将角色级别返回)
		String roleGrade = addCriteriaByRoles(criteria);
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");

		//将查询结果进行分页
		PageHelper.startPage(pageNum, pageSize);
		List<TPrizeData> list = prizeDataMapper.selectByExample(example);
		Page<TPrizeData> page = (Page<TPrizeData>) list;
		//将查询到的角色和已确认/未确认的信息保存到PageResult里面，然后返回给前端
		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
		pageResult.setRoleGrade(roleGrade);

		return pageResult;
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TPrizeData prizeData) {
		//设置状态为1，即可用状态
		prizeData.setStatus("1");
		prizeDataMapper.insert(prizeData);
	}


	/**
	 * 修改
	 *
	 * 因为projectData数据表中包含奖项数据和项目数据以及其他数据，而我们在前端提交过来的数据只用奖项数据和项目数据
	 * 所以我们可以根据id查询出来需要修改的数据，然后将新填写的数据重新赋值，再将数据存入到数据库中
	 */
	@Override
	public void update(TPrizeData prizeData){
		prizeDataMapper.updateByPrimaryKeySelective(prizeData);
	}

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TPrizeData findOne(Integer id){
		return prizeDataMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除，逻辑删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			TPrizeData prizeData = prizeDataMapper.selectByPrimaryKey(id);
			prizeData.setStatus("2");
			prizeDataMapper.updateByPrimaryKey(prizeData);
		}
	}

	/**
	 * 分页条件查询
	 * @param prizeData
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	@Override
	public ResultUtils findPage(TPrizeData prizeData, int pageNum, int pageSize) {
		UUser currentUser = CurrentUser.returnCurrentUser();
		if (currentUser == null){
			return ResultUtils.build(400,"登录失效,请重新登录");
		}
		TPrizeDataExample example = new TPrizeDataExample();
		//添加升序降序排列条件，DESC为降序
		example.setOrderByClause("`confirm_status` DESC,id ASC");
		TPrizeDataExample.Criteria criteria = example.createCriteria();
		String roleGrade = null;
		if (prizeData != null) {
			roleGrade = addProjectDatCriteria(prizeData, criteria);
		}
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		PageHelper.startPage(pageNum, pageSize);
		//分页查询,得到符合条件的项目数据表的集合
		List<TPrizeData> list = prizeDataMapper.selectByExample(example);
		//将成果数量存到PageResult对应的属性里面
		//PageInfo<TProjectData> pageInfo = new PageInfo<TProjectData>(list);
		Page<TPrizeData> page = (Page<TPrizeData>) list;
		//将查询到的角色和已确认/未确认的信息保存到PageResult里面，然后返回给前端
		PageResult pageResult = getPageResult(roleGrade, page ,prizeData.getConfirmStatus());

		return ResultUtils.ok(pageResult);
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
	private String addCriteriaByRoles(TPrizeDataExample.Criteria criteria) {
		UUser currentUser = CurrentUser.returnCurrentUser();
		if (currentUser != null) {
			String roleGrade = null;
			//prizeDataMapper.selectByPrimaryKey(1);
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
					if(currentUser.getCompanyId()!=null && currentUser.getCompanyId().length()>0){
						//添加本单位的名称
						criteria.andOrganizerCompanyIdLike("%"+currentUser.getCompanyId()+"%");
					}
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本人所属地区
						criteria.andAreaLike("%"+currentUser.getArea()+"%");
					}
				}else if("个人".equals(role.getName())){
					if(currentUser.getCompanyId()!=null && currentUser.getCompanyId().length()>0){
						//添加本单位的名称
						criteria.andOrganizerCompanyIdLike("%"+currentUser.getCompanyId()+"%");
					}
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本人所属地区
						criteria.andAreaLike("%"+currentUser.getArea()+"%");
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
	 * @param prizeData
	 * @param criteria
	 */
	private String addProjectDatCriteria(TPrizeData prizeData, TPrizeDataExample.Criteria criteria){
		//项目名称
		if (prizeData.getProjectName() != null && prizeData.getProjectName().length() > 0) {
			criteria.andProjectNameLike("%"+prizeData.getProjectName()+"%");
		}
		//项目类别
		if (prizeData.getProjectCategory() != null && prizeData.getProjectCategory().length() > 0) {
			criteria.andProjectCategoryEqualTo(prizeData.getProjectCategory());
		}
		//一级学科分类名称
		if (prizeData.getSubjectName1() != null && prizeData.getSubjectName1().length() > 0) {
			criteria.andSubjectName1EqualTo(prizeData.getSubjectName1());
		}
		//二级学科分类名称
		if (prizeData.getSubjectName2() != null && prizeData.getSubjectName2().length() > 0) {
			criteria.andSubjectName2EqualTo(prizeData.getSubjectName2());
		}
		//模糊查询  第一承担单位
		if (prizeData.getFirstOrganizerCompany() != null && prizeData.getFirstOrganizerCompany().length() > 0) {
			criteria.andFirstOrganizerCompanyLike("%"+prizeData.getFirstOrganizerCompany()+ "%");
		}
		//模糊查询  其他承担单位
		if (prizeData.getOtherOrganizerCompany() != null && prizeData.getOtherOrganizerCompany().length() > 0) {
			criteria.andOtherOrganizerCompanyLike("%"+prizeData.getOtherOrganizerCompany()+ "%");
		}
		//所在地区
		if (prizeData.getArea() != null && prizeData.getArea().length() > 0) {
			criteria.andAreaEqualTo(prizeData.getArea());
		}
		//模糊查询  项目负责人
		if (prizeData.getProjectLeader() != null && prizeData.getProjectLeader().length() > 0) {
			criteria.andProjectLeaderLike("%"+prizeData.getProjectLeader() + "%");
		}
		//团队成员
		if (prizeData.getTeamMembers() != null && prizeData.getTeamMembers().length() > 0) {
			criteria.andTeamMembersLike("%" + prizeData.getTeamMembers() + "%");
		}
		//奖励级别
		if (prizeData.getPrizeCategoryGrade() != null && prizeData.getPrizeCategoryGrade().length() > 0) {
			criteria.andPrizeCategoryGradeEqualTo(prizeData.getPrizeCategoryGrade());
		}
		//所获奖项
		if (prizeData.getPrizeCategory() != null && prizeData.getPrizeCategory().length() > 0) {
			criteria.andPrizeCategoryEqualTo(prizeData.getPrizeCategory());
		}
		//奖项等级（一等奖）
		if (prizeData.getAwardGrade() != null && prizeData.getAwardGrade().length() > 0) {
			criteria.andAwardGradeEqualTo(prizeData.getAwardGrade());
		}
		//根据时间段查询
		if(prizeData.getSearchStartTime() != null && prizeData.getSearchEndTime()!= null){
			if (prizeData.getSearchStartTime().toString() != null && prizeData.getSearchStartTime().toString().length()>0
					&& prizeData.getSearchEndTime().toString() != null && prizeData.getSearchEndTime().toString().length()>0) {
				criteria.andPrizeTimeBetween(prizeData.getSearchStartTime(),prizeData.getSearchEndTime());
			}
		}
		//根据角色添加条件
		String roleGrade = addCriteriaByRoles(criteria);

		//添加确认状态的查询条件，主要用于信息确认页面，在默认状态下确认状态为null，在点击待确认的按钮时，查询出所有待确认的信息，将待确认的状态"2"作为条件，
		// 同理点击已确认按钮时，查询出所有已确认的信息，将已确认的状态"1"作为条件
		//确认分为项目确认和奖项确认，根据确认字段的不同查询出不同的细信息
		//奖项确认
		if(prizeData.getConfirmStatus() != null && prizeData.getConfirmStatus().length()>0){
			criteria.andConfirmStatusEqualTo(prizeData.getConfirmStatus());
		}

		/*//查询奖励部位空的数据
		criteria.andPrizeCategoryIsNotNull();
		criteria.andPrizeCategoryNotEqualTo("''");*/

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
	private PageResult getPageResult(String roleGrade, Page<TPrizeData> page ,String confirmStatus) {

		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());

		//统计查询所有未确认的项目信息
		TPrizeDataExample unconfirmedCountExample=new TPrizeDataExample();
		TPrizeDataExample.Criteria unconfirmedCountCriteria = unconfirmedCountExample.createCriteria();
		addCriteriaByRoles(unconfirmedCountCriteria);
		unconfirmedCountCriteria.andConfirmStatusEqualTo("2");
		unconfirmedCountCriteria.andStatusEqualTo("1");
		//查询奖励不为空的数据
		/*unconfirmedCountCriteria.andPrizeCategoryIsNotNull();
		unconfirmedCountCriteria.andPrizeCategoryNotEqualTo("''");*/
		int unconfirmedCount = prizeDataMapper.countByExample(unconfirmedCountExample);
		pageResult.setUnconfirmedCount(unconfirmedCount);

		//统计查询所有已确认的项目信息
		TPrizeDataExample confirmedCountExample=new TPrizeDataExample();
		TPrizeDataExample.Criteria confirmedCountCriteria = confirmedCountExample.createCriteria();
		addCriteriaByRoles(confirmedCountCriteria);
		confirmedCountCriteria.andConfirmStatusEqualTo("1");
		confirmedCountCriteria.andStatusEqualTo("1");
		//查询奖励不为空的数据
		/*confirmedCountCriteria.andPrizeCategoryIsNotNull();
		confirmedCountCriteria.andPrizeCategoryNotEqualTo("''");*/
		int confirmedCount = prizeDataMapper.countByExample(confirmedCountExample);
		pageResult.setConfirmedCount(confirmedCount);

		pageResult.setRoleGrade(roleGrade);
		return pageResult;
	}

	/**
	 * 根据条件查询项目数据及统计信息，将数据返回controller，controller将集合转换为excel文件，下载到本地文件(这个方法和分页条件查询大部分相同，能不能进行优化？)
	 * @param prizeData
	 * @return
	 */
	@Override
	public List<TPrizeData> findTPrizeDataToExcel(TPrizeData prizeData) {

		TPrizeDataExample example = new TPrizeDataExample();
		TPrizeDataExample.Criteria criteria = example.createCriteria();
		if (prizeData != null) {
			addProjectDatCriteria(prizeData, criteria);
			//只查询状态为1的数据
			criteria.andStatusEqualTo("1");

		}
		//条件查询,得到符合条件的项目数据表的集合
		List<TPrizeData> list = prizeDataMapper.selectByExample(example);
		return list;
	}

	/**
	 * 奖励数据使用的批量确认
	 * @param ids
	 */
	@Override
	public void confirmPrizeStatus(Integer[] ids) {
		for(Integer id:ids){
			TPrizeData prizeData = prizeDataMapper.selectByPrimaryKey(id);
			//已确认 确认状态修改为“1”
			prizeData.setConfirmStatus("1");
			prizeDataMapper.updateByPrimaryKey(prizeData);
		}
	}

	/**
	 * 统计各地区奖励的数量
	 */
	@Override
	public List<Count> countTheNumberOfPrizeDataInEachArea(){
		return prizeDataMapper.countTheNumberOfPrizeDataInEachArea();
	}

	@Override
	public void cleanPrizeData() throws Exception{
		Set<String> set = new HashSet();
		Set<String> setNew = new HashSet();
		List<String> firstOrganizerList = prizeDataMapper.selectDistinctFirstOrganizerCompany();
		List<String> otherOrganizerList = prizeDataMapper.selectDistinctOtherOrganizerCompany();
		for (String organizer:firstOrganizerList) {
			String[] split = organizer.split(",");
			for (String s:split) {
				set.add(s);
			}
		}
		for (String organizer:otherOrganizerList) {
			if(StringUtils.isNotBlank(organizer)){
				String[] split = organizer.split(",");
				for (String s:split) {
					set.add(s);
				}
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
	 * 替换奖励数据的单位
	 * 	由于奖励数据里的单位与省卫计委标准名称不一致，所以在检索和替换单位id的时候会出现问题，所以需要将这些单位数据进行替换为标准数据，然后进行清理
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
				TPrizeDataExample example = new TPrizeDataExample();
				List<TPrizeData> prizeDataList = prizeDataMapper.selectByExample(example);
				for (TPrizeData prizeData:prizeDataList) {
					String otherOrganizerCompany = prizeData.getOtherOrganizerCompany();
					String firstOrganizerCompany = prizeData.getFirstOrganizerCompany();
					boolean flag = false;
					if(StringUtils.isNotBlank(firstOrganizerCompany)){
						if(repeatCompany.equals(firstOrganizerCompany)){
							firstOrganizerCompany = firstOrganizerCompany.replace(repeatCompany,provinceCompany);
							flag = true;
						}
					}
					if(StringUtils.isNotBlank(otherOrganizerCompany)){
						String[] split = otherOrganizerCompany.split(",");
						for (String s:split) {
							//如果项目数据的单位里存在和需要替换的单位相同的，将其进行替换
							if(repeatCompany.equals(s)){
								otherOrganizerCompany = otherOrganizerCompany.replace(repeatCompany,provinceCompany);
								flag = true;
							}
						}
					}

					if(flag){
						prizeData.setFirstOrganizerCompany(firstOrganizerCompany);
						prizeData.setOtherOrganizerCompany(otherOrganizerCompany);
						System.out.println(prizeData);
						prizeDataMapper.updateByPrimaryKey(prizeData);
					}

				}
			}
		}
	}
	@Override
	public void insertCompanyAndArea()throws Exception{
		TPrizeDataExample example = new TPrizeDataExample();
		List<TPrizeData> prizeDataList = prizeDataMapper.selectByExample(example);
		for (TPrizeData prizeData:prizeDataList) {
			String organizer = null;
			if(StringUtils.isNotBlank(prizeData.getFirstOrganizerCompany())){
				if(StringUtils.isNotBlank(prizeData.getOtherOrganizerCompany())){
					organizer = prizeData.getFirstOrganizerCompany() + ","+ prizeData.getOtherOrganizerCompany();
				}else{
					organizer = prizeData.getFirstOrganizerCompany();
				}
			}
			String companyId = "";
			if(StringUtils.isNotBlank(organizer)) {
				String[] split = organizer.split(",");
				for (String s : split) {
					TAreaAndCompanyExample areaAndCompanyExample = new TAreaAndCompanyExample();
					TAreaAndCompanyExample.Criteria criteria = areaAndCompanyExample.createCriteria();
					criteria.andCompanyEqualTo(s);
					List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectByExample(areaAndCompanyExample);
					if(areaAndCompanyList!=null && areaAndCompanyList.size()>0){
						prizeData.setArea(areaAndCompanyList.get(0).getCity());
						if(StringUtils.isNotBlank(prizeData.getOrganizerCompanyId())){
							if(!prizeData.getOrganizerCompanyId().contains(areaAndCompanyList.get(0).getCompanyId())){
								companyId += prizeData.getOrganizerCompanyId()+","+areaAndCompanyList.get(0).getCompanyId()+",";
							}
						}else{
							companyId += areaAndCompanyList.get(0).getCompanyId()+",";

						}
					}
				}
			}
			if(StringUtils.isNotBlank(companyId)){
				companyId = companyId.substring(0,companyId.lastIndexOf(","));
			}
			prizeData.setOrganizerCompanyId(companyId);
			prizeDataMapper.updateByPrimaryKey(prizeData);
			System.out.println("地区："+prizeData.getArea()+"---单位："+organizer+"---单位id："+companyId);
		}
	}

	@Override
	public List<String> likeProjectName(String projectName) {
		if(StringUtils.isNotBlank(projectName)){
			projectName = "%"+projectName+"%";
			List<String> list = prizeDataMapper.likeProjectName(projectName);
			return list;
		}
		return null;
	}

}
