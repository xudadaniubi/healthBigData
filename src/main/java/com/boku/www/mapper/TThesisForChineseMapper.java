package com.boku.www.mapper;

import com.boku.www.pojo.*;

import java.util.List;

import com.boku.www.utils.Count;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TThesisForChineseMapper {
    int countByExample(TThesisForChineseExample example);

    int deleteByExample(TThesisForChineseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TThesisForChinese record);

    int insertSelective(TThesisForChinese record);

    List<TThesisForChinese> selectByExample(TThesisForChineseExample example);

    TThesisForChinese selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TThesisForChinese record, @Param("example") TThesisForChineseExample example);

    int updateByExample(@Param("record") TThesisForChinese record, @Param("example") TThesisForChineseExample example);

    int updateByPrimaryKeySelective(TThesisForChinese record);

    int updateByPrimaryKey(TThesisForChinese record);

	/**
	 * 统计各地区论文的数量
	 */
	List<Count> countTheNumberOfThesisForChineseInEachArea();

	List<TThesisForChinese> findByPage(@Param("currIndex") int currIndex,@Param("pageSize")int pageSize);

	List<TbWanfangDocumentCommonWithBLOBs> selectDataByTitle(String title);

	/**
	 * 第一作者top20（如杭州市内单位排名）
	 * @param area
	 * @return
	 */
	List<Count> selectFirstAuthorBeforeTwentiethInEachArea(@Param("area") String area,@Param("top") int top);

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
	/**
	 * 查询关键词前20
	 */
	List<TCountTopKeywords> selectKeywordsBeforeTwentieth(@Param("type") String type,@Param("area") String area);

	/**
	 * 核心期刊单位top20
	 */
	//selectCompanyBeforeTwentiethInCorePerio();
	/**
	 * 核心期刊学科top20
	 */
	List<Count> selectSujectBeforeTwentiethInCorePerio();
	/**
	 * 核心期刊中期刊文献量top20
	 */
	List<Count> selectBeforeTwentiethInCorePerio();

	/**
	 * 根据作者查询与之合作的所有作者
	 * @param author
	 * @return
	 */
	List<String> selectAuthorByExample(String author);
	/**
	 根据单位查询与之合作的所有单位
	 */
	List<String> selectCompanyByExample(String company);


}