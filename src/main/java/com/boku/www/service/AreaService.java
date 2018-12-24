package com.boku.www.service;
import java.util.List;

import com.boku.www.pojo.TArea;
import com.boku.www.utils.PageResult;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface AreaService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TArea> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TArea area);
	
	
	/**
	 * 修改
	 */
	public void update(TArea area);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TArea findOne(Integer id);
	
	
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
	public PageResult findPage(TArea area, int pageNum, int pageSize);

	/**
	 * 根据parentId查询子分类
	 */
	public List<TArea> findByParentId(Integer parentId);
}
