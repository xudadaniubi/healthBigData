package com.boku.www.service;

import com.boku.www.pojo.TProjectData;
import com.boku.www.utils.Count;
import com.boku.www.utils.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ProjectDataService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TProjectData> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TProjectData projectData);
	
	
	/**
	 * 修改
	 */
	public void update(TProjectData projectData);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TProjectData findOne(Integer id);
	
	
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
	public PageResult findPage(TProjectData projectData, int pageNum, int pageSize);

	/**
	 * 根据条件查询项目数据及统计信息，将数据返回controller，controller将集合转换为excel文件，
	 * 下载到本地文件(这个方法和分页条件查询大部分相同，能不能进行优化？)
	 * 和findPage方法的区别在于参数不同
	 * @param projectData
	 * @return
	 */
	public List<TProjectData> findTProjectDataToExcel(TProjectData projectData) ;



	/**
	 * 批量确认
	 * @param ids
	 */
	public void confirmProjectDataStatus(Integer[] ids);

	/**
	 * 统计各地区项目的数量
	 */
	public List<Count> countTheNumberOfProjectDataInEachArea();
}
