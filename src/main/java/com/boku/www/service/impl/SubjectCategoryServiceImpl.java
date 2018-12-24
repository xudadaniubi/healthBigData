package com.boku.www.service.impl;
import java.util.List;

import com.boku.www.mapper.TSubjectCategoryMapper;
import com.boku.www.pojo.TSubjectCategory;
import com.boku.www.pojo.TSubjectCategoryExample;
import com.boku.www.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.boku.www.service.SubjectCategoryService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
@Transactional
public class SubjectCategoryServiceImpl implements SubjectCategoryService {
	String roleGrade = null;
	@Autowired
	private TSubjectCategoryMapper subjectCategoryMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TSubjectCategory> findAll() {
		TSubjectCategoryExample example=new TSubjectCategoryExample();
		TSubjectCategoryExample.Criteria criteria = example.createCriteria();
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		return subjectCategoryMapper.selectByExample(example);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TSubjectCategoryExample example=new TSubjectCategoryExample();
		TSubjectCategoryExample.Criteria criteria = example.createCriteria();
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		Page<TSubjectCategory> page=   (Page<TSubjectCategory>) subjectCategoryMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 * 	逻辑;
	 * 	因为增加的学科分类是不知道自己本身的subjectId的，所以我们只能通过parentSubjectId查找出所有的subjectId
	 *	在原有最大的subjectId的基础上添加++1，来实现添加subjectId的目的
	 */
	@Override
	public void add(TSubjectCategory subjectCategory) {
		List<TSubjectCategory> subjectCategoryList = findByParentId(Integer.parseInt(subjectCategory.getParentSubjectId()));
		int maxSubjectId = 0;
		//遍历得到数据库中最大的SubjectId
		System.out.println(subjectCategoryList.size());
		//有可能parentSubjectId下没有一个子类
		if(subjectCategoryList.size()!=0){
			for (TSubjectCategory TSubjectCategory: subjectCategoryList) {
				System.out.println(maxSubjectId+"-----"+ TSubjectCategory.getSubjectId());
				if(maxSubjectId<=Integer.parseInt(TSubjectCategory.getSubjectId())){
					maxSubjectId = Integer.parseInt(TSubjectCategory.getSubjectId());
				}
			}
			if(subjectCategory.getParentSubjectId().equals("0")){
				//一级学科
				maxSubjectId = maxSubjectId + 10;
			}else{
				//二级学科
				maxSubjectId = maxSubjectId + 1;
			}
		}else{
			//没有子类，就在父类id的基础上新建

			//一级学科下没有二级学科
			maxSubjectId = Integer.parseInt(subjectCategory.getParentSubjectId()+"10");
			System.out.println(subjectCategory.getParentSubjectId());

		}
		System.out.println(""+(maxSubjectId));
		//在最大的maxSubjectId基础上加1
		subjectCategory.setSubjectId(""+(maxSubjectId));
		subjectCategory.setStatus("1");
		subjectCategoryMapper.insert(subjectCategory);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TSubjectCategory subjectCategory){
		subjectCategory.setStatus("1");
		subjectCategoryMapper.updateByPrimaryKey(subjectCategory);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TSubjectCategory findOne(Integer id){
		return subjectCategoryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
		public void delete(Integer[] ids) {
		for(Integer id:ids){
			TSubjectCategory subjectCategory = subjectCategoryMapper.selectByPrimaryKey(id);
			subjectCategory.setStatus("2");
			subjectCategoryMapper.updateByPrimaryKey(subjectCategory);
		}		
	}

	/**
	 * 分页条件查询
	 * @param subjectCategory
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
		@Override
	public PageResult findPage(TSubjectCategory subjectCategory, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TSubjectCategoryExample example=new TSubjectCategoryExample();
		TSubjectCategoryExample.Criteria criteria = example.createCriteria();
		
		if(subjectCategory!=null){			
				if(subjectCategory.getSubjectId()!=null && subjectCategory.getSubjectId().length()>0){
				criteria.andSubjectIdLike("%"+subjectCategory.getSubjectId()+"%");
			}
			if(subjectCategory.getParentSubjectId()!=null && subjectCategory.getParentSubjectId().length()>0){
				criteria.andParentSubjectIdLike("%"+subjectCategory.getParentSubjectId()+"%");
			}
			if(subjectCategory.getSubjectName()!=null && subjectCategory.getSubjectName().length()>0){
				criteria.andSubjectNameLike("%"+subjectCategory.getSubjectName()+"%");
			}
		}
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		Page<TSubjectCategory> page= (Page<TSubjectCategory>)subjectCategoryMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 根据parentId查询子分类
	 * @param parentId
	 * @return
	 */
	@Override
	public List<TSubjectCategory> findByParentId(Integer parentId) {

		TSubjectCategoryExample example = new TSubjectCategoryExample();
		TSubjectCategoryExample.Criteria criteria = example.createCriteria();
		if(parentId!=null){
			criteria.andParentSubjectIdEqualTo(""+parentId);
		}
		criteria.andStatusEqualTo("1");
		return subjectCategoryMapper.selectByExample(example );
	}


}
