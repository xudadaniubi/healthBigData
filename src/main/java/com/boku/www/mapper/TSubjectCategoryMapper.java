package com.boku.www.mapper;

import com.boku.www.pojo.TSubjectCategory;
import com.boku.www.pojo.TSubjectCategoryExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TSubjectCategoryMapper {
    int countByExample(TSubjectCategoryExample example);

    int deleteByExample(TSubjectCategoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(TSubjectCategory record);

    int insertSelective(TSubjectCategory record);

    List<TSubjectCategory> selectByExample(TSubjectCategoryExample example);

    TSubjectCategory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TSubjectCategory record, @Param("example") TSubjectCategoryExample example);

    int updateByExample(@Param("record") TSubjectCategory record, @Param("example") TSubjectCategoryExample example);

    int updateByPrimaryKeySelective(TSubjectCategory record);

    int updateByPrimaryKey(TSubjectCategory record);
}