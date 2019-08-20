package com.boku.www.mapper;

import com.boku.www.pojo.TCountIf;
import com.boku.www.pojo.TCountIfExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TCountIfMapper {
    int countByExample(TCountIfExample example);

    int deleteByExample(TCountIfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCountIf record);

    int insertSelective(TCountIf record);

    List<TCountIf> selectByExample(TCountIfExample example);

    TCountIf selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCountIf record, @Param("example") TCountIfExample example);

    int updateByExample(@Param("record") TCountIf record, @Param("example") TCountIfExample example);

    int updateByPrimaryKeySelective(TCountIf record);

    int updateByPrimaryKey(TCountIf record);

	List<TCountIf> selectAvgIfTopTwentieth();
}