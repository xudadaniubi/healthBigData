package com.boku.www.mapper;

import com.boku.www.pojo.TThesisForEnglish;

import java.util.List;

import com.boku.www.pojo.TThesisForEnglishExample;
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

    List<TThesisForEnglish> selectByExampleWithBLOBs(TThesisForEnglishExample example);

    List<TThesisForEnglish> selectByExample(TThesisForEnglishExample example);

    TThesisForEnglish selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TThesisForEnglish record, @Param("example") TThesisForEnglishExample example);

    int updateByExampleWithBLOBs(@Param("record") TThesisForEnglish record, @Param("example") TThesisForEnglishExample example);

    int updateByExample(@Param("record") TThesisForEnglish record, @Param("example") TThesisForEnglishExample example);

    int updateByPrimaryKeySelective(TThesisForEnglish record);

    int updateByPrimaryKeyWithBLOBs(TThesisForEnglish record);

    int updateByPrimaryKey(TThesisForEnglish record);

	/**
	 * 统计各地区论文的数量
	 */
	List<Count> countTheNumberOfThesisForEnglishInEachArea();
}