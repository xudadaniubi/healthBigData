package com.boku.www.mapper;

import com.boku.www.pojo.TNews;
import com.boku.www.pojo.TNewsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TNewsMapper {
    int countByExample(TNewsExample example);

    int deleteByExample(TNewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TNews record);

    int insertSelective(TNews record);

    List<TNews> selectByExampleWithBLOBs(TNewsExample example);

    List<TNews> selectByExample(TNewsExample example);

    TNews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TNews record, @Param("example") TNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") TNews record, @Param("example") TNewsExample example);

    int updateByExample(@Param("record") TNews record, @Param("example") TNewsExample example);

    int updateByPrimaryKeySelective(TNews record);

    int updateByPrimaryKeyWithBLOBs(TNews record);

    int updateByPrimaryKey(TNews record);
}