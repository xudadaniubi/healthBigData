package com.boku.www.mapper;

import com.boku.www.pojo.TStudies;
import com.boku.www.pojo.TStudiesExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TStudiesMapper {
    int countByExample(TStudiesExample example);

    int deleteByExample(TStudiesExample example);

    int deleteByPrimaryKey(String studyId);

    int insert(TStudies record);

    int insertSelective(TStudies record);

    List<TStudies> selectByExample(TStudiesExample example);

    TStudies selectByPrimaryKey(String studyId);

    int updateByExampleSelective(@Param("record") TStudies record, @Param("example") TStudiesExample example);

    int updateByExample(@Param("record") TStudies record, @Param("example") TStudiesExample example);

    int updateByPrimaryKeySelective(TStudies record);

    int updateByPrimaryKey(TStudies record);
}