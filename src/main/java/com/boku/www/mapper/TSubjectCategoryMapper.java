package com.boku.www.mapper;

import java.util.List;

import com.boku.www.pojo.TSubjectCategory;
import com.boku.www.pojo.TSubjectCategoryExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TSubjectCategoryMapper {
    int countByExample(TSubjectCategoryExample example);

    int deleteByExample(TSubjectCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSubjectCategory record);

    int insertSelective(TSubjectCategory record);

    List<TSubjectCategory> selectByExample(TSubjectCategoryExample example);

    TSubjectCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSubjectCategory record, @Param("example") TSubjectCategoryExample example);

    int updateByExample(@Param("record") TSubjectCategory record, @Param("example") TSubjectCategoryExample example);

    int updateByPrimaryKeySelective(TSubjectCategory record);

    int updateByPrimaryKey(TSubjectCategory record);
}