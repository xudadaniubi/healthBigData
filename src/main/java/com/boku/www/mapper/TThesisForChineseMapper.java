package com.boku.www.mapper;

import com.boku.www.pojo.TThesisForChinese;

import java.util.List;

import com.boku.www.pojo.TThesisForChineseExample;
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

}