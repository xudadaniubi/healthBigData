package com.boku.www.service.impl;
import java.util.List;
import com.boku.www.mapper.TThesisForEnglishMapper;
import com.boku.www.pojo.*;
import com.boku.www.pojo.system.URole;
import com.boku.www.pojo.system.UUser;
import com.boku.www.service.system.RoleService;
import com.boku.www.utils.Count;
import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.PageResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.boku.www.service.ThesisForEnglishService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
@Transactional
public class ThesisForEnglishServiceImpl implements ThesisForEnglishService {

	@Autowired
	private TThesisForEnglishMapper thesisForEnglishMapper;

	@Autowired
	private RoleService roleService;
	/**
	 * 查询全部
	 */
	@Override
	public List<TThesisForEnglish> findAll() {
		TThesisForEnglishExample example=new TThesisForEnglishExample();
		TThesisForEnglishExample.Criteria criteria = example.createCriteria();
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		return thesisForEnglishMapper.selectByExample(example);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {

		TThesisForEnglishExample example=new TThesisForEnglishExample();
		TThesisForEnglishExample.Criteria criteria = example.createCriteria();
		//根据角色添加查询条件，每个用户只能查询本自己权限范围内的数据
		String roleGrade = addCriteriaByRoles(criteria);
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		//分页插件中分页只对下一个查询分页，所以需要紧跟想要转换的查询语句
		PageHelper.startPage(pageNum, pageSize);
		Page<TThesisForEnglish> page=   (Page<TThesisForEnglish>) thesisForEnglishMapper.selectByExample(example);
		//将查询到的角色和已确认/未确认的信息保存到PageResult里面，然后返回给前端
		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
		pageResult.setRoleGrade(roleGrade);
		return pageResult;
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TThesisForEnglish thesisForEnglish) {
		thesisForEnglishMapper.insert(thesisForEnglish);
	}


	/**
	 * 修改
	 */
	@Override
	public void update(TThesisForEnglish thesisForEnglish){
		thesisForEnglishMapper.updateByPrimaryKeyWithBLOBs(thesisForEnglish);
		//thesisForEnglishExampleMapper.updateByPrimaryKey(thesisForEnglish);
	}

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TThesisForEnglish findOne(Integer id){
		return thesisForEnglishMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(@RequestBody Integer[] ids) {
		for(Integer id:ids){
			TThesisForEnglish thesisForEnglish = thesisForEnglishMapper.selectByPrimaryKey(id);
			thesisForEnglish.setStatus("2");
			thesisForEnglishMapper.updateByPrimaryKey(thesisForEnglish);
		}
	}

	/**
	 * 分页条件查询
	 * @param thesisForEnglish
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	@Override
	public PageResult findPage(TThesisForEnglish thesisForEnglish, int pageNum, int pageSize) {

		TThesisForEnglishExample example=new TThesisForEnglishExample();
		example.setOrderByClause("`confirm_status` DESC,id ASC");
		TThesisForEnglishExample.Criteria criteria = example.createCriteria();
		String roleGrade = null;
		if(thesisForEnglish!=null){
			roleGrade = addThesisForChineseCriteria(thesisForEnglish, criteria);
		}
		PageHelper.startPage(pageNum, pageSize);
		Page<TThesisForEnglish> page= (Page<TThesisForEnglish>)thesisForEnglishMapper.selectByExampleWithBLOBs(example);
		//查询已确认和未确认的数量
		//将查询到的角色和已确认/未确认的信息保存到PageResult里面，然后返回给前端
		PageResult pageResult = getPageResult(page);

		pageResult.setRoleGrade(roleGrade);
		return pageResult;
	}

	/**
	 * 统计论文的已确认和为确认的数据信息
	 * @param page
	 * @return
	 */
	private PageResult getPageResult(Page page) {
		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
		//统计查询所有未确认的论文信息
		TThesisForEnglishExample unconfirmedCountExample=new TThesisForEnglishExample();
		TThesisForEnglishExample.Criteria unconfirmedCountCriteria = unconfirmedCountExample.createCriteria();
		addCriteriaByRoles(unconfirmedCountCriteria);
		//统计未确认的论文信息
		unconfirmedCountCriteria.andConfirmStatusEqualTo("2");
		unconfirmedCountCriteria.andStatusEqualTo("1");
		int unconfirmedCount = thesisForEnglishMapper.countByExample(unconfirmedCountExample);
		pageResult.setUnconfirmedCount(unconfirmedCount);
		//统计查询所有已确认的论文信息
		TThesisForEnglishExample confirmedCountExample=new TThesisForEnglishExample();
		TThesisForEnglishExample.Criteria confirmedCountCriteria = confirmedCountExample.createCriteria();
		addCriteriaByRoles(confirmedCountCriteria);
		//分别统计已确认的论文信息
		confirmedCountCriteria.andConfirmStatusEqualTo("1");
		confirmedCountCriteria.andStatusEqualTo("1");
		int confirmedCount = thesisForEnglishMapper.countByExample(confirmedCountExample);
		pageResult.setConfirmedCount(confirmedCount);
		return pageResult;
	}

	/**
	 * 添加查询论文数据的条件
	 * @param thesisForEnglish
	 * @param criteria
	 */
	private String addThesisForChineseCriteria(TThesisForEnglish thesisForEnglish, TThesisForEnglishExample.Criteria criteria) {
		//标题
		if(thesisForEnglish.getTitle()!=null && thesisForEnglish.getTitle().length()>0){
			criteria.andTitleLike("%"+thesisForEnglish.getTitle()+"%");
		}
		//作者
		if(thesisForEnglish.getAuthor()!=null && thesisForEnglish.getAuthor().length()>0){
			criteria.andAuthorLike("%"+thesisForEnglish.getAuthor()+"%");
		}
		//卷
		if(thesisForEnglish.getRoll()!=null && thesisForEnglish.getRoll().length()>0){
			criteria.andRollEqualTo(thesisForEnglish.getRoll());
		}
		//期
		if(thesisForEnglish.getJournal()!=null && thesisForEnglish.getJournal().length()>0){
			criteria.andJournalEqualTo(thesisForEnglish.getJournal());
		}
		//ISSN
		if(thesisForEnglish.getIssn()!=null && thesisForEnglish.getIssn().length()>0){
			criteria.andIssnEqualTo(thesisForEnglish.getIssn());
		}
		//页码
		if(thesisForEnglish.getPage()!=null && thesisForEnglish.getPage().length()>0){
			criteria.andPageEqualTo(thesisForEnglish.getPage());
		}
		//根据时间段查询
		if(thesisForEnglish.getSearchStartTime() != null && thesisForEnglish.getSearchEndTime()!= null){
			if (thesisForEnglish.getSearchStartTime().toString() != null && thesisForEnglish.getSearchStartTime().toString().length()>0
					&& thesisForEnglish.getSearchEndTime().toString() != null && thesisForEnglish.getSearchEndTime().toString().length()>0) {
				criteria.andYearBetween(thesisForEnglish.getSearchStartTime(),thesisForEnglish.getSearchEndTime());
			}
		}
		//单位
		if(thesisForEnglish.getAuthorCompany()!=null && thesisForEnglish.getAuthorCompany().length()>0){
			criteria.andAuthorCompanyLike("%"+thesisForEnglish.getAuthorCompany()+"%");
		}
		//地区
		if(thesisForEnglish.getArea()!=null && thesisForEnglish.getArea().length()>0){
			criteria.andAreaEqualTo(thesisForEnglish.getArea());
		}
		//确认状态
		if(thesisForEnglish.getConfirmStatus()!=null && thesisForEnglish.getConfirmStatus().length()>0){
			criteria.andConfirmStatusEqualTo(thesisForEnglish.getConfirmStatus());
		}
		//只查询状态为1的数据
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
	private String addCriteriaByRoles(TThesisForEnglishExample.Criteria criteria) {
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
				}else if("个人".equals(role.getName())){
					if(currentUser.getCompany()!=null && currentUser.getCompany().length()>0){
						//添加本单位的名称
						//criteria.andAuthorCompanyEqualTo(currentUser.getCompany());
						criteria.andAuthorCompanyLike("%"+currentUser.getCompany()+"%");
					}
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本人所属地区
						criteria.andAreaEqualTo(currentUser.getArea());
					}
					if(currentUser.getUsername()!=null && currentUser.getUsername().length()>0){
						//添加本人的名称
						criteria.andAuthorEqualTo(currentUser.getUsername());
					}
				}else if("医院".equals(role.getName())){
					if(currentUser.getCompany()!=null && currentUser.getCompany().length()>0){
						//添加本单位的名称
						criteria.andAuthorCompanyLike("%"+currentUser.getCompany()+"%");
					}
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本人所属地区
						criteria.andAreaEqualTo(currentUser.getArea());
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
	 * @param thesisForEnglish
	 * @return
	 */
	@Override
	public List<TThesisForEnglish> findThesisForEnglishToExcel(TThesisForEnglish thesisForEnglish) {
		TThesisForEnglishExample example = new TThesisForEnglishExample();
		TThesisForEnglishExample.Criteria criteria = example.createCriteria();
		if (thesisForEnglish != null) {
			addThesisForChineseCriteria(thesisForEnglish, criteria);
			//只查询状态为1的数据
			criteria.andStatusEqualTo("1");
		}
		//条件查询
		List<TThesisForEnglish> list = thesisForEnglishMapper.selectByExample(example);
		return list;
	}

	/**
	 * 批量确认
	 * @param ids
	 */
	@Override
	public void confirmThesisForEnglishStatus(Integer[] ids) {
		for(Integer id:ids){
			TThesisForEnglish thesisForEnglish = thesisForEnglishMapper.selectByPrimaryKey(id);
			//已确认 确认状态修改为“1”
			thesisForEnglish.setConfirmStatus("1");
			thesisForEnglishMapper.updateByPrimaryKey(thesisForEnglish);
		}
	}

	/**
	 * 统计各地区论文的数量
	 */
	@Override
	public List<Count> countTheNumberOfThesisForEnglishInEachArea(){
		return thesisForEnglishMapper.countTheNumberOfThesisForEnglishInEachArea();
	}
}
