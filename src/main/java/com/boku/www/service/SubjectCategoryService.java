package com.boku.www.service;



import com.boku.www.pojo.TSubjectCategory;
import com.boku.www.utils.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SubjectCategoryService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TSubjectCategory> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TSubjectCategory subjectCategory);
	
	
	/**
	 * 修改
	 */
	public void update(TSubjectCategory subjectCategory);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TSubjectCategory findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TSubjectCategory subjectCategory, int pageNum, int pageSize);

	/**
	 * 根据parentId查询子分类
	 */
	public List<TSubjectCategory> findByParentId(Integer parentId);
}
