package com.boku.www.service;

import com.boku.www.pojo.TPrizeData;
import com.boku.www.utils.Count;
import com.boku.www.utils.PageResult;

import java.util.List;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface PrizeDataService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TPrizeData> findAll();


	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);


	/**
	 * 增加
	 */
	public void add(TPrizeData prizeData);


	/**
	 * 修改
	 */
	public void update(TPrizeData prizeData);


	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TPrizeData findOne(Integer id);


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
	public PageResult findPage(TPrizeData prizeData, int pageNum, int pageSize);

	/**
	 * 根据条件查询项目数据及统计信息，将数据返回controller，controller将集合转换为excel文件，
	 * 下载到本地文件(这个方法和分页条件查询大部分相同，能不能进行优化？)
	 * 和findPage方法的区别在于参数不同
	 * @param projectData
	 * @return
	 */
	public List<TPrizeData> findTPrizeDataToExcel(TPrizeData prizeData) ;

	/**
	 * 批量确认
	 * @param ids
	 */
	public void confirmPrizeStatus(Integer[] ids);

	/**
	 * 统计各地区项目的数量
	 */
	public List<Count> countTheNumberOfPrizeDataInEachArea();

	public void cleanPrizeData() throws Exception;
}
