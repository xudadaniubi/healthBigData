package com.boku.www.service.impl;
import java.util.List;
import java.util.Map;

import com.boku.www.mapper.TPatentMapper;
import com.boku.www.pojo.*;
import com.boku.www.pojo.system.URole;
import com.boku.www.pojo.system.UUser;
import com.boku.www.service.system.RoleService;
import com.boku.www.utils.Count;
import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.PageResult;
import com.boku.www.utils.ResultUtils;
import com.github.pagehelper.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.boku.www.service.PatentService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
@Transactional
public class PatentServiceImpl implements PatentService {
	@Autowired
	private TPatentMapper patentMapper;

	@Autowired
	private RoleService roleService;
	/**
	 * 查询全部
	 */
	@Override
	public List<TPatent> findAll() {
		TPatentExample example=new TPatentExample();
		TPatentExample.Criteria criteria = example.createCriteria();
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		return patentMapper.selectByExample(example);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		TPatentExample example=new TPatentExample();
		TPatentExample.Criteria criteria = example.createCriteria();
		//根据角色添加查询条件，每个用户只能查询本自己权限范围内的数据
		String roleGrade = addCriteriaByRoles(criteria);
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		//分页插件中分页只对下一个查询分页，所以需要紧跟想要转换的查询语句
		PageHelper.startPage(pageNum, pageSize);
		Page<TPatent> page= (Page<TPatent>) patentMapper.selectByExample(example);
		//将查询到的角色和已确认/未确认的信息保存到PageResult里面，然后返回给前端
		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
		pageResult.setRoleGrade(roleGrade);
		return pageResult;
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TPatent patent) {
		patent.setStatus("1");
		patentMapper.insert(patent);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TPatent patent){
		patentMapper.updateByPrimaryKeySelective(patent);
		//patentMapper.updateByPrimaryKey(patent);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TPatent findOne(Integer id){
		return patentMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			TPatent patent = patentMapper.selectByPrimaryKey(id);
			patent.setStatus("2");
			patentMapper.updateByPrimaryKey(patent);
		}		
	}

	/**
	 * 分页条件查询
	 * @param patent
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	@Override
	public ResultUtils findPage(TPatent patent, int pageNum, int pageSize) {
		UUser currentUser = CurrentUser.returnCurrentUser();
		if (currentUser == null){
			return ResultUtils.build(400,"登录失效,请重新登录");
		}
		TPatentExample example=new TPatentExample();
		example.setOrderByClause("`confirm_status` DESC,id ASC");
		TPatentExample.Criteria criteria = example.createCriteria();
		String roleGrade = null;
		if(patent!=null){
			roleGrade = addThesisForChineseCriteria(patent, criteria);
		}
		PageHelper.startPage(pageNum, pageSize);
		Page<TPatent> page= (Page<TPatent>)patentMapper.selectByExample(example);
		//查询已确认和未确认的数量
		//将查询到的角色和已确认/未确认的信息保存到PageResult里面，然后返回给前端
		PageResult pageResult = getPageResult(page);
		pageResult.setRoleGrade(roleGrade);
		return ResultUtils.ok(pageResult);
	}


	/**
	 * 统计论文的已确认和为确认的数据信息
	 * @param page
	 * @return
	 */
	private PageResult getPageResult(Page page) {
		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
		//统计查询所有未确认的论文信息
		TPatentExample unconfirmedCountExample=new TPatentExample();
		TPatentExample.Criteria unconfirmedCountCriteria = unconfirmedCountExample.createCriteria();
		addCriteriaByRoles(unconfirmedCountCriteria);
		//统计未确认的论文信息
		unconfirmedCountCriteria.andConfirmStatusEqualTo("2");
		unconfirmedCountCriteria.andStatusEqualTo("1");
		int unconfirmedCount = patentMapper.countByExample(unconfirmedCountExample);
		pageResult.setUnconfirmedCount(unconfirmedCount);
		//统计查询所有已确认的论文信息
		TPatentExample confirmedCountExample=new TPatentExample();
		TPatentExample.Criteria confirmedCountCriteria = confirmedCountExample.createCriteria();
		addCriteriaByRoles(confirmedCountCriteria);
		//分别统计已确认的论文信息
		confirmedCountCriteria.andConfirmStatusEqualTo("1");
		confirmedCountCriteria.andStatusEqualTo("1");
		int confirmedCount = patentMapper.countByExample(confirmedCountExample);
		pageResult.setConfirmedCount(confirmedCount);
		return pageResult;
	}

	/**
	 * 添加查询论文数据的条件
	 * @param patent
	 * @param criteria
	 */
	private String addThesisForChineseCriteria(TPatent patent, TPatentExample.Criteria criteria) {
		//模糊查询发明人  产品想要查询两个发明人用or的关系
		if(patent.getFirstInvento()!=null && patent.getFirstInvento().length()>0){
			criteria.andFirstInventoLike("%"+patent.getFirstInvento()+"%");
		}
		if(patent.getOtherInventors()!=null && patent.getOtherInventors().length()>0){
			criteria.andOtherInventorsLike("%"+patent.getOtherInventors()+"%");
		}
		//专利名称
		if(patent.getPatentName()!=null && patent.getPatentName().length()>0){
			criteria.andPatentNameLike("%"+patent.getPatentName()+"%");
		}
		//专利权人
		if(patent.getPatentee()!=null && patent.getPatentee().length()>0){
			criteria.andPatenteeLike("%"+patent.getPatentee()+"%");
		}
		//专利号
		if(patent.getPatentNum()!=null && patent.getPatentNum().length()>0){
			criteria.andPatentNumEqualTo(patent.getPatentNum());
		}
		//所属区域
		if(patent.getArea()!=null && patent.getArea().length()>0){
			criteria.andAreaEqualTo(patent.getArea());
		}
		//根据时间段查询(授权公告日)
		/*if(patent.getSearchStartTime() != null && patent.getSearchEndTime()!= null){
			if (patent.getSearchStartTime().toString() != null && patent.getSearchStartTime().toString().length()>0
					&& patent.getSearchEndTime().toString() != null && patent.getSearchEndTime().toString().length()>0) {
				criteria.andAuthorizedAnnouncementDateBetween(patent.getSearchStartTime(),patent.getSearchEndTime());
			}
		}*/
		//专利类别
		if(StringUtils.isNotBlank(patent.getPatentCategory())){
			criteria.andPatentCategoryEqualTo(patent.getPatentCategory());
		}
		//确认状态
		if(patent.getConfirmStatus()!= null && patent.getConfirmStatus().length()>0){
			criteria.andConfirmStatusEqualTo(patent.getConfirmStatus());
		}
		criteria.andStatusEqualTo("1");
		//根据用户角色添加本角色的限制条件，及该用户的权限范围内的数据查询
		String roleGrade = addCriteriaByRoles(criteria);
		return roleGrade;
	}

	/**
	 根据角色添加查询条件
	 * 设置省、市、医院、个人四级权限，根据不同的权限，修改服务层代码，查询不同的数据，
	 *不同的权限返回不同的数据，同时返回权限级别，不同的权限显示不同的按钮（级别给前端进行判断，根据级别的不同，显示不同的按钮。
	 *如专家按钮，在个人级别的时候不现实，单位查询按钮在单位级别以下的不显示，地区选择按钮省级可选择地级市以下的地区和单位，
	 *地级市只能查询本市以下的地区和单位）
	 */
	private String addCriteriaByRoles(TPatentExample.Criteria criteria) {
		UUser currentUser = CurrentUser.returnCurrentUser();
		if (currentUser != null) {
			String roleGrade = null;
			//获取用户角色
			List<URole> rlist = roleService.findRoleByUid(currentUser.getId());
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
						//criteria.andFirstInventoCompanyEqualTo(currentUser.getCompany());
						criteria.andFirstInventoCompanyLike("%"+currentUser.getCompany()+"%");
					}
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本人所属地区
						criteria.andAreaEqualTo(currentUser.getArea());
					}
				}else if("个人".equals(role.getName())){
					if(currentUser.getCompany()!=null && currentUser.getCompany().length()>0){
						//添加本单位的名称
						criteria.andFirstInventoCompanyLike("%"+currentUser.getCompany()+"%");
						//criteria.andFirstInventoCompanyEqualTo(currentUser.getCompany());
					}
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本人所属地区
						criteria.andAreaEqualTo(currentUser.getArea());
					}
					if(currentUser.getUsername()!=null && currentUser.getUsername().length()>0){
						//添加本人的名称
						criteria.andFirstInventoEqualTo(currentUser.getUsername());
					}
				}
				roleGrade = role.getName();
			}
			return roleGrade;
		}
		return "该用户角色非法";
	}

	/**
	 * 根据条件查询出条件范围内的所有数据（不分页，与分页条件查询的区别），然后控制层将集合所有的数据转存储为excel的方式进行下载
	 * @param patent
	 * @return
	 */
	@Override
	public List<TPatent> findPatentToExcel(TPatent patent) {
		TPatentExample example = new TPatentExample();
		TPatentExample.Criteria criteria = example.createCriteria();
		if (patent != null) {
			addThesisForChineseCriteria(patent, criteria);
			//只查询状态为1的数据
			criteria.andStatusEqualTo("1");
		}
		//条件查询
		List<TPatent> list = patentMapper.selectByExample(example);
		return list;
	}
	/**
	 * 批量确认
	 * @param ids
	 */
	@Override
	public void confirmPatentStatus(Integer[] ids) {
		for(Integer id:ids){
			TPatent patent = patentMapper.selectByPrimaryKey(id);
			//已确认 确认状态修改为“1”
			patent.setConfirmStatus("1");
			patentMapper.updateByPrimaryKey(patent);
		}
	}

	/**
	 * 统计各地区专利的数量
	 */
	@Override
	public List<Count> countTheNumberOfPatentsInEachArea(){
		return patentMapper.countTheNumberOfPatentsInEachArea();
	}
}
