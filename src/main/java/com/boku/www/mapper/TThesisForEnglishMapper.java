package com.boku.www.mapper;

import com.boku.www.pojo.*;

import java.util.List;

import com.boku.www.utils.Count;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TThesisForEnglishMapper {
	int countByExample(TThesisForEnglishExample example);

	int deleteByExample(TThesisForEnglishExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TThesisForEnglish record);

	int insertSelective(TThesisForEnglish record);

	List<TThesisForEnglish> selectByExample(TThesisForEnglishExample example);

	TThesisForEnglish selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TThesisForEnglish record, @Param("example") TThesisForEnglishExample example);

	int updateByExample(@Param("record") TThesisForEnglish record, @Param("example") TThesisForEnglishExample example);

	int updateByPrimaryKeySelective(TThesisForEnglish record);

	int updateByPrimaryKey(TThesisForEnglish record);

	/**
	 * 统计各地区论文的数量
	 */
	List<Count> countTheNumberOfThesisForEnglishInEachArea();

	List<String> selectDistinctOrganizer();

	/**
	 * 批量插入外文数据
	 */
	int insertBatch( List<AbstractMysql> list);

	int insertOne( AbstractMysql abstractMysql);

	List<AbstractMysql> selectThesisForEnglishFromSolr();

	/**
	 * 根据期刊id查询学科
	 * @param journalId
	 * @return
	 */
	List<String> selectSubjectByJournalId(String journalId);

	/**
	 * 根据期刊id查询jcr分区
	 * @param journalId
	 * @return
	 */
	List<String> selectJcrByJournalId(String journalId);

	/**
	 * 根据期刊id查询外文期刊IF
	 * @param journalId
	 * @return
	 */
	List<String> selectIfByJournalId(String journalId);

	/**
	 * 根据单位id查询所属地区
	 * @param companyId
	 * @return
	 */
	List<String> selectAreaByCompanyId(String companyId);

	/**
	 * 学科前20
	 */
	List<Count> selectSujectBeforeTwentieth();
	/**
	 * 插入学科前20
	 */
	int insertSujectBeforeTwentieth(TCountTopSubject countTopSubject);

	/**
	 *在统计表中查询学科前20的
	 */
	List<TCountTopSubject> selectSujectTopTwentieth();

	/**
	 * 插入关键词前20
	 */
	int insertKeywordsBeforeTwentieth(TCountTopKeywords countTopKeywords);

	List<TCountTopKeywords> selectKeywordsBeforeTwentieth(@Param("type") String type,@Param("area") String area);

	/**
	 * 根据单位id查询影响因子总和
	 */
	Object selectIfByCompanyId(String companyId);

	/**
	 * 插入统计的影响因子数据
	 */
	int insertCountImpactFactor(TCountTopIf countTopIf);

	/**
	 * 根据type查询统计影响因子的数据
	 */
	List<TCountTopIf> selectCountImpactFactor(String type);

	/**
	 * 论文top20（影响因子最高的、单个、附带这篇文章的单位）
	 * @return
	 */
	List<TCountTopIf> selectIfThesisBeforeTwentieth();

	/**
	 * 查询学科影响因子总和top20
	 * @return
	 */
	List<TCountTopIf> selectIfSubjectBeforeTwentieth();

	/**
	 * 根据学科查询该学科的平均影响因子
	 * @param subject
	 * @return
	 */
	double selectAvgIfBySubject(String subject);

	int countJcrNum(@Param("jcr") String jcr);

	int insertJcrDistribution(@Param("jcr") String jcr,@Param("count")int count,@Param("type")String type);

	/**
	 * 查询jcr分区
	 * @return
	 */
	List<TCountTopJcr> selectJcrDistribution(String type);

	/**
	 * 统计各地级市jcr分区分布
	 * @param jcr
	 * @param area
	 * @return
	 */
	int countJcrByArea(@Param("jcr") String jcr,@Param("area")String area);

	/**
	 * 插入jcr分区
	 * @param countTopJcr
	 * @return
	 */
	int insertJcr(TCountTopJcr countTopJcr);
	/**
	 * 查询jcr分区
	 */
	List selectJcrDistributionByJcr(@Param("type") String type,@Param("jcr")String jcr);

	/**
	 * 查询期刊发文前20的数据
	 * @return
	 */
	List<Count> selectJournalTopTwentieth();

	/**
	 * 插入期刊发文前20的数据
	 * @param countTopJournal
	 * @return
	 */
	int insertJournalTopTwentieth(TCountTopJournal countTopJournal);

	/**
	 * 查询期刊发文前20的数据(存储在表格里的)
	 * @param type
	 * @return
	 */
	List<TCountTopJournal> selectJournalTopTwentiethByTable( String type);

	/**
	 * 查询各地区的所有作者
	 * @param area
	 * @return
	 */
	List<String> selectAllAuthorInEachArea(String area);

	List<String> selectAuthorByExample(String area);

	/**
	 根据单位查询与之合作的所有单位
	 */
	List<String> selectCompanyByCompanyId(String companyId);

	List<String> selectCompanyByCompany(String company);

	/**
	 * 根据issn号查询期刊
	 */
	List<TThesisForEnglish> selectJournalByIssn(String issn);

	/**
	 * 查询单位的平均影响因子
	 */
	Object selectAvgIf(String companyId);
	/**
	 * 查询单位的影响因子总和
	 */
	Object selectSumIf(String companyId);


	/*
	查热词
	 */

	List<TCountTopKeywords> selectKeywordsBeforeTwentiethHot(String type);

    List<String> selectThesisForEnglishTitle(String title);
}