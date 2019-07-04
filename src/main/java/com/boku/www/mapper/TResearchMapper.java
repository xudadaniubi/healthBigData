package com.boku.www.mapper;

import com.boku.www.pojo.TResearch;
import com.boku.www.pojo.TResearchExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TResearchMapper {
	int countByExample(TResearchExample example);

	int deleteByExample(TResearchExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TResearch record);

	int insertSelective(TResearch record);

	List<TResearch> selectByExample(TResearchExample example);

	TResearch selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TResearch record, @Param("example") TResearchExample example);

	int updateByExample(@Param("record") TResearch record, @Param("example") TResearchExample example);

	int updateByPrimaryKeySelective(TResearch record);

	int updateByPrimaryKey(TResearch record);
}