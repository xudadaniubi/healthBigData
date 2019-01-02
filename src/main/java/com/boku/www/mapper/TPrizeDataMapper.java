package com.boku.www.mapper;

import com.boku.www.pojo.TPrizeData;
import com.boku.www.pojo.TPrizeDataExample;
import java.util.List;

import com.boku.www.utils.Count;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TPrizeDataMapper {
    int countByExample(TPrizeDataExample example);

    int deleteByExample(TPrizeDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPrizeData record);

    int insertSelective(TPrizeData record);

    List<TPrizeData> selectByExample(TPrizeDataExample example);

    TPrizeData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPrizeData record, @Param("example") TPrizeDataExample example);

    int updateByExample(@Param("record") TPrizeData record, @Param("example") TPrizeDataExample example);

    int updateByPrimaryKeySelective(TPrizeData record);

    int updateByPrimaryKey(TPrizeData record);
	/**
	 * 统计各地区奖励的数量
	 */
	List<Count> countTheNumberOfPrizeDataInEachArea();
}