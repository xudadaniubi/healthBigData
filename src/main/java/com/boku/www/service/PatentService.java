package com.boku.www.service;
import com.boku.www.pojo.TPatent;
import com.boku.www.pojo.TThesisForEnglish;
import com.boku.www.utils.Count;
import com.boku.www.utils.PageResult;
import com.boku.www.utils.ResultUtils;

import java.util.List;
import java.util.Map;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface PatentService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TPatent> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TPatent patent);
	
	
	/**
	 * 修改
	 */
	public void update(TPatent patent);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TPatent findOne(Integer id);
	
	
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
	public ResultUtils findPage(TPatent patent, int pageNum, int pageSize);

	/**
	 * 根据条件查询出条件范围内的所有数据（不分页，与分页条件查询的区别），然后控制层将集合所有的数据转存储为excel的方式进行下载
	 * @param patent
	 * @return
	 */
	public List<TPatent> findPatentToExcel(TPatent patent);

	/**
	 * 批量确认
	 * @param ids
	 */
	public void confirmPatentStatus(Integer[] ids);

	/**
	 * 统计各地区专利的数量
	 */
	public List<Count> countTheNumberOfPatentsInEachArea();
}
