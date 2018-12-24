package com.boku.www.service;
import java.util.List;


import com.boku.www.pojo.TProjectCategory;
import com.boku.www.utils.PageResult;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ProjectCategoryService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TProjectCategory> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TProjectCategory projectCategory);
	
	
	/**
	 * 修改
	 */
	public void update(TProjectCategory projectCategory);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TProjectCategory findOne(Integer id);
	
	
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
	public PageResult findPage(TProjectCategory projectCategory, int pageNum, int pageSize);

	/**
	 * 查询所有的级别
	 */
	public List<String> findAllGrade();

	/**
	 * 根据级别查询对应的项目类别
	 */
	public List<TProjectCategory> findByGrade(String grade);
}
