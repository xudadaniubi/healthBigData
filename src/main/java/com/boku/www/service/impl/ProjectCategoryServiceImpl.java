package com.boku.www.service.impl;
import java.util.List;

import com.boku.www.mapper.TAreaMapper;
import com.boku.www.mapper.TProjectCategoryMapper;
import com.boku.www.pojo.TArea;
import com.boku.www.pojo.TAreaExample;
import com.boku.www.pojo.TProjectCategory;
import com.boku.www.pojo.TProjectCategoryExample;
import com.boku.www.utils.PageResult;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

import com.boku.www.service.ProjectCategoryService;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
@Transactional
public class ProjectCategoryServiceImpl implements ProjectCategoryService {
	String roleGrade = null;
	@Autowired
	private TProjectCategoryMapper projectCategoryMapper;

	@Autowired
	private TAreaMapper areaMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<TProjectCategory> findAll() {
		TProjectCategoryExample example=new TProjectCategoryExample();
		TProjectCategoryExample.Criteria criteria = example.createCriteria();
		//查询所有状态为“1”的数据
		criteria.andStatusEqualTo("1");
		return projectCategoryMapper.selectByExample(example);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TProjectCategoryExample example=new TProjectCategoryExample();
		TProjectCategoryExample.Criteria criteria = example.createCriteria();
		//查询所有状态为“1”的数据
		criteria.andStatusEqualTo("1");
		Page<TProjectCategory> page=   (Page<TProjectCategory>) projectCategoryMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TProjectCategory projectCategory) {
		//System.out.println(projectCategory.getGrade());
		if(projectCategory != null){
			if(projectCategory.getGrade() != null && projectCategory.getGrade().length()>0){
				//不是国家级和省级，就根据前端传的市、区县医院的id查询对应的名称，将名词存入进去即可
				if(!"国家级".equals(projectCategory.getGrade()) && !"省级".equals(projectCategory.getGrade())){
					//这时前端传过来的Grade是这样的"地市级（330500）"  区/县/院级（33062401）
					//切割字符串，获取其中的编号
					if(projectCategory.getGrade().contains("地市级")){
						String a = projectCategory.getGrade().substring(0,4);
						String b = projectCategory.getGrade().substring(4);
						System.out.println(a+"-----"+b);
						TAreaExample example = new TAreaExample();
						TAreaExample.Criteria criteria = example.createCriteria();
						criteria.andAreaIdEqualTo(b);
						List<TArea> areaList = areaMapper.selectByExample(example);
						projectCategory.setGrade(a+areaList.get(0).getAreaOrCompany()+"）");
					}else if(projectCategory.getGrade().contains("区/县/院级")){
						String a = projectCategory.getGrade().substring(0,7);
						String b = projectCategory.getGrade().substring(7);
						System.out.println(a+"-----"+b);
						TAreaExample example = new TAreaExample();
						TAreaExample.Criteria criteria = example.createCriteria();
						criteria.andAreaIdEqualTo(b);
						List<TArea> areaList = areaMapper.selectByExample(example);
						projectCategory.setGrade(a+areaList.get(0).getAreaOrCompany()+"）");
					}
				}
			}
		}
		projectCategory.setStatus("1");
		projectCategoryMapper.insert(projectCategory);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TProjectCategory projectCategory){
		projectCategory.setStatus("1");
		projectCategoryMapper.updateByPrimaryKey(projectCategory);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TProjectCategory findOne(Integer id){
		return projectCategoryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			TProjectCategory projectCategory= projectCategoryMapper.selectByPrimaryKey(id);
			projectCategory.setStatus("2");
			projectCategoryMapper.updateByPrimaryKey(projectCategory);
		}		
	}
	
	
		@Override
	public PageResult findPage(TProjectCategory projectCategory, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TProjectCategoryExample example=new TProjectCategoryExample();
		TProjectCategoryExample.Criteria criteria = example.createCriteria();
		
		if(projectCategory!=null){			
			if(projectCategory.getGrade()!=null && projectCategory.getGrade().length()>0){
				criteria.andGradeLike("%"+projectCategory.getGrade()+"%");
			}
			if(projectCategory.getProjectCategory()!=null && projectCategory.getProjectCategory().length()>0){
				criteria.andProjectCategoryLike("%"+projectCategory.getProjectCategory()+"%");
			}
			if(projectCategory.getStatus()!=null && projectCategory.getStatus().length()>0){
				criteria.andStatusLike("%"+projectCategory.getStatus()+"%");
			}
	
		}
		criteria.andStatusEqualTo("1");
		Page<TProjectCategory> page= (Page<TProjectCategory>)projectCategoryMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 查询所有的级别
	 */
	@Override
	public List<String> findAllGrade() {
		List<String> allGrade = projectCategoryMapper.findAllGrade();
		return allGrade;
	}

	/**
	 * 根据级别查询对应的项目类别
	 */
	@Override
	public List<TProjectCategory> findByGrade(String grade) {
		TProjectCategoryExample example=new TProjectCategoryExample();
		TProjectCategoryExample.Criteria criteria = example.createCriteria();
		//在配置管理的查询页面中国家级查询出所有国家级项目类别，省级查询出所有省级项目类别，地市级查询出所有地市级项目类别，区县级查询出所有区县级项目类别
		//在三级联动中，根据级别传递就可以了
		if(grade!=null && grade.length()>0){
			if("所有地市级项目".equals(grade)){
				criteria.andGradeLike("%"+"地市级"+"%");
			}else if("所有区/县/院级项目".equals(grade)){
				criteria.andGradeLike("%"+"区/县/院级"+"%");
			}else{
				criteria.andGradeEqualTo(grade);
			}
		}
		criteria.andStatusEqualTo("1");
		return projectCategoryMapper.selectByExample(example);
	}
}
