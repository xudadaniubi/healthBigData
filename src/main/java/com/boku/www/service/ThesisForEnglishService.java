package com.boku.www.service;

import com.boku.www.pojo.*;
import com.boku.www.utils.*;

import java.util.HashMap;
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
	public ResultUtils findPage(TThesisForEnglish thesis, int pageNum, int pageSize);

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

	public void cleanThesisForEnglish() throws Exception;

	public  void getThesisForEnglishFromSolr() throws Exception;

	public void insertDataFromSolr();
	/**
	 *sci论文
	 数量
	 插入单位top20
	 */
	public void insertCompanyBeforeTwentieth();
	/**
	 *sci论文
	 数量
	 查询单位top20
	 */
	public List<TAreaAndCompany> selectBeforeTwentieth();
	/**
	 * 插入学科前20的数据
	 */
	public void insertSujectBeforeTwentieth();
	/**
	 * 查询学科前20的数据
	 */
	public List<TCountTopSubject>  selectSujectBeforeTwentieth();
	/**
	 *sci论文
	 数量
	 关键词、热词研究top20
	 */
	public void insertKeywordsBeforeTwentieth();

	/**
	 *sci论文
	 数量
	 关键词、热词研究top20
	 */
	public List<TCountTopKeywords> selectKeywordsBeforeTwentieth();

	/**
	 *sci论文
	 *	if（影响因子总和）
	 *		单位top20
	 */
	public void insertIfCompanyBeforeTwentieth();

	public List<TCountTopIf> selectIfCompanyBeforeTwentieth();

	/**
	 *sci论文
	 *	if（影响因子总和）
	 *		插入学科top20
	 */
	public void insertIfSubjectBeforeTwentieth();

	/**
	 *sci论文
	 *	if（影响因子总和）
	 *		查询学科top20
	 */
	public List<TCountTopIf> selectIfSubjectBeforeTwentieth();

	public List<TCountTopIf> selectIfThesisBeforeTwentieth();
	/**
	 *sci论文
	 *	地区
	 *		区域研究热词（top20，每个地区的）
	 */
	public void insertKeywordsBeforeTwentiethInEachArea();
	public List selectKeywordsBeforeTwentiethInEachArea();

	/**
	 *sci论文
	 *	地区
	 *		区域单位排名
	 */
	public List selectBeforeTwentiethInEachArea();

	public void cleanJcr();

	public void insertJcrDistribution();
	/**
	 *sci论文
	 *	jcr分区
	 *		浙江省论文jcr分区分布(饼状图，各分区的数量)
	 */
	public List<TCountTopJcr> selectJcrDistribution();
	/**
	 *sci论文
	 *	jcr分区
	 *		各地区jcr分区分布(饼状图，杭州市各分区的数量)
	 */
	public void insertJcrAndArea();

	public List<TCountTopJcr> selectJcrAndAreaDistribution();
	/**
	 *sci论文
	 *	jcr分区
	 *		插入jcr分区单位top10
	 */
	public void insertJcrTopTenCompany();
	/**
	 *sci论文
	 *	jcr分区
	 *		一至四区单位top10
	 */
	public List<TCountTopJcr> oneAreaTopTenCompany();
	public List<TCountTopJcr> twoAreaTopTenCompany();
	public List<TCountTopJcr> threeAreaTopTenCompany();
	public List<TCountTopJcr> foreAreaTopTenCompany();
	/**
	 *sci论文
	 期刊发文排名top20（期刊发表文献数量前20）
	 */
	public void insertJournalTopTwentieth();
	public List<TCountTopJournal> selectJournalTopTwentieth();

	public void insertAuthorNetwork();
	public CountAuthorNetwork selectAuthorNetwork();
	public void insertCompanyNetwork();
	public CountCompanyNetwork selectCompanyNetwork();

	public void insertIfAvgInEachCompany();

	public List<TCountIf> selectAvgIfTopTwentieth();

	public List selectAuthorPostNumTopTen();

    List<String> thesisForEnglishTitle(String title);

    //void getThesisForEnglish();
}
