package com.boku.www.service;
import java.util.List;

import com.boku.www.pojo.TPrizeCategory;
import com.boku.www.utils.PageResult;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface PrizeCategoryService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TPrizeCategory> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TPrizeCategory prizeCategory);
	
	
	/**
	 * 修改
	 */
	public void update(TPrizeCategory prizeCategory);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TPrizeCategory findOne(Integer id);
	
	
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
	public PageResult findPage(TPrizeCategory prizeCategory, int pageNum, int pageSize);

	/**
	 * 查询所有的级别
	 */
	public List<String> findAllGrade();

	/**
	 * 根据级别查询对应的奖励类别
	 */
	public List<TPrizeCategory> findByGrade(String grade);
}
