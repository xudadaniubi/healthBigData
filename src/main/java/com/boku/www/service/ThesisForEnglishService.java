package com.boku.www.service;

import com.boku.www.pojo.TThesisForEnglish;
import com.boku.www.utils.Count;
import com.boku.www.utils.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ThesisForEnglishService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TThesisForEnglish> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TThesisForEnglish thesis);
	
	
	/**
	 * 修改
	 */
	public void update(TThesisForEnglish thesisForEnglish);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TThesisForEnglish findOne(Integer id);
	
	
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
	public PageResult findPage(TThesisForEnglish thesis, int pageNum, int pageSize);

	/**
	 * 根据条件查询出条件范围内的所有数据（不分页，与分页条件查询的区别），然后控制层将集合所有的数据转存储为excel的方式进行下载
	 * @param thesisForEnglish
	 * @return
	 */
	public List<TThesisForEnglish> findThesisForEnglishToExcel(TThesisForEnglish thesisForEnglish);

	/**
	 * 论文（英文）数据使用的批量确认
	 * @param ids
	 */
	public void confirmThesisForEnglishStatus(Integer[] ids);

	/**
	 * 统计各地区论文的数量
	 */
	public List<Count> countTheNumberOfThesisForEnglishInEachArea();
}
