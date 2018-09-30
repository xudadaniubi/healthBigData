package com.boku.www.mapper;

import com.boku.www.pojo.TThesis;
import com.boku.www.pojo.TThesisExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TThesisMapper {
    int countByExample(TThesisExample example);

    int deleteByExample(TThesisExample example);

    int deleteByPrimaryKey(String id);

    int insert(TThesis record);

    int insertSelective(TThesis record);

    List<TThesis> selectByExample(TThesisExample example);

    TThesis selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TThesis record, @Param("example") TThesisExample example);

    int updateByExample(@Param("record") TThesis record, @Param("example") TThesisExample example);

    int updateByPrimaryKeySelective(TThesis record);

    int updateByPrimaryKey(TThesis record);
}