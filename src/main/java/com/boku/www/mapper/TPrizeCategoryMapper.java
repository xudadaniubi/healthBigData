package com.boku.www.mapper;

import com.boku.www.pojo.TPrizeCategory;
import com.boku.www.pojo.TPrizeCategoryExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TPrizeCategoryMapper {
    int countByExample(TPrizeCategoryExample example);

    int deleteByExample(TPrizeCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPrizeCategory record);

    int insertSelective(TPrizeCategory record);

    List<TPrizeCategory> selectByExample(TPrizeCategoryExample example);

    TPrizeCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPrizeCategory record, @Param("example") TPrizeCategoryExample example);

    int updateByExample(@Param("record") TPrizeCategory record, @Param("example") TPrizeCategoryExample example);

    int updateByPrimaryKeySelective(TPrizeCategory record);

    int updateByPrimaryKey(TPrizeCategory record);

	/**
	 * 查询所有的级别
	 * @return
	 */
	public List<String> findAllGrade();
}