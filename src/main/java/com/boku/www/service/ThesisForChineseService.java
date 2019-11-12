package com.boku.www.service;

import com.boku.www.pojo.*;
import com.boku.www.utils.Count;
import com.boku.www.utils.CountAuthorNetwork;
import com.boku.www.utils.CountCompanyNetwork;
import com.boku.www.utils.PageResult;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ThesisForChineseService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TThesisForChinese> findAll();


	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);


	/**
	 * 增加
	 */
	public void add(TThesisForChinese thesisForChinese);


	/**
	 * 修改
	 */
	public void update(TThesisForChinese thesisForChinese);


	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TThesisForChinese findOne(Integer id);


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
	public PageResult findPage(TThesisForChinese thesisForChinese, int pageNum, int pageSize);

	/**
	 * 根据条件查询出条件范围内的所有数据（不分页，与分页条件查询的区别），然后控制层将集合所有的数据转存储为excel的方式进行下载
	 * @param thesisForChinese
	 * @return
	 */
	public List<TThesisForChinese> findThesisForChineseToExcel(TThesisForChinese thesisForChinese);

	/**
	 * 论文（中文）数据使用的批量确认
	 * @param ids
	 */
	public void confirmThesisForChineseStatus(Integer[] ids);

	/**
	 * 统计各地区论文的数量
	 */
	public List<Count> countTheNumberOfThesisForChineseInEachArea();

	public void addCommpanyId();
	/**
	 * 插入各单位中文文献的数量
	 * 	做定时更新
	 * 	当文献数据新增和删除时，相应的加减，详见add和delete方法
	 */
	public void insertCompanyChesisNum();
	/**
	 * 查询各单位中文文献的数量
	 * 单位top20
	 */
	public List<TAreaAndCompany> selectBeforeTwentieth();
	/**
	 *查询各市单位文献量前20的
	 */
	public List<TAreaAndCompany> selectBeforeTwentiethInEachArea();
	/**
	 *插入关键词出现在前20的热词
	 */
	public void insertKeywordsBeforeTwentieth();
	/**
	 *查询关键词出现在前20的热词
	 */
	public List<TCountTopKeywords> selectKeywordsBeforeTwentieth();
	/**
	 * 插入各地级市关键词出现前20的
	 */
	public void insertKeywordsBeforeTwentiethInEachArea();
	/**
	 * 查询各地级市关键词出现前20的
	 */
	public List selectKeywordsBeforeTwentiethInEachArea();
	/**
	 * 第一作者top20（如杭州市内单位排名）
	 */
	public Map<String,List>  insertFirstAuthorBeforeTwentiethInEachArea();
	public List  selectFirstAuthorBeforeTwentiethInEachArea();
	/**
	 * 插入学科前20的数据
	 */
	public void insertSujectBeforeTwentieth();

	/**
	 * 学科前20
	 * @return
	 */
	public List<TCountTopSubject>  selectSujectBeforeTwentieth();

	public void insertSujectBeforeTwentiethInCorePerio();
	public List<TCountTopCorePerio> selectSujectBeforeTwentiethInCorePerio();
	/**
	 * 核心期刊中期刊文献量top20
	 */
	public void insertJournalTopTwentieth();

	public  List<TCountTopJournal> selectBeforeTwentiethInCorePerio();

	/**
	 * 插入和查询核心期刊单位top20
	 */
	public void insertCompanyBeforeTwentiethInCorePerio();
	public List<TCountTopCorePerio> selectCompanyBeforeTwentiethInCorePerio();

	public void insertAuthorNetwork();

	public CountAuthorNetwork selectAuthorNetwork();

	public void insertCompanyNetwork();

	public CountCompanyNetwork selectCompanyNetwork();

	public List selectAuthorPostNumTopTen();

	public void updateThiesis(File file, String fileName) throws Exception;

	public void  cleanRepateArea();

    List<String> thesisForChineseTitle(String title);
}
