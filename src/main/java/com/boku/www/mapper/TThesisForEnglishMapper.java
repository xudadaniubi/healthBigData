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
	 * 查询学科影响因子总和top20
	 * @return
	 */
	List<Count> selectIfSubjectBeforeTwentieth();

	/**
	 * 查询jcr分区
	 * @return
	 */
	List<TCountTopJcr> selectJcrDistribution(String type);


}