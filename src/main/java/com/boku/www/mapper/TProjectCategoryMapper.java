package com.boku.www.mapper;

import com.boku.www.pojo.TProjectCategory;
import com.boku.www.pojo.TProjectCategoryExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TProjectCategoryMapper {
    int countByExample(TProjectCategoryExample example);

    int deleteByExample(TProjectCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProjectCategory record);

    int insertSelective(TProjectCategory record);

    List<TProjectCategory> selectByExample(TProjectCategoryExample example);

    TProjectCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProjectCategory record, @Param("example") TProjectCategoryExample example);

    int updateByExample(@Param("record") TProjectCategory record, @Param("example") TProjectCategoryExample example);

    int updateByPrimaryKeySelective(TProjectCategory record);

    int updateByPrimaryKey(TProjectCategory record);

	/**
	 * 查询所有的级别
	 * @return
	 */
	public List<String> findAllGrade();
}