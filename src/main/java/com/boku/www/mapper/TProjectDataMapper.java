package com.boku.www.mapper;

import java.util.List;

import com.boku.www.pojo.TProjectData;
import com.boku.www.pojo.TProjectDataExample;
import com.boku.www.utils.Count;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TProjectDataMapper {
	int countByExample(TProjectDataExample example);

	int deleteByExample(TProjectDataExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TProjectData record);

	int insertSelective(TProjectData record);

	List<TProjectData> selectByExample(TProjectDataExample example);

	TProjectData selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TProjectData record, @Param("example") TProjectDataExample example);

	int updateByExample(@Param("record") TProjectData record, @Param("example") TProjectDataExample example);

	int updateByPrimaryKeySelective(TProjectData record);

	int updateByPrimaryKey(TProjectData record);

	/**
	 * 统计各地区项目的数量
	 */
	List<Count> countTheNumberOfProjectDataInEachArea();

	List<String> selectDistinctOrganizer();
}