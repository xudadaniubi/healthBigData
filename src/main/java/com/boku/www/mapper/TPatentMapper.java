package com.boku.www.mapper;

import com.boku.www.pojo.TPatent;

import java.util.List;
import java.util.Map;

import com.boku.www.pojo.TPatentExample;
import com.boku.www.utils.Count;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TPatentMapper {
    int countByExample(TPatentExample example);

    int deleteByExample(TPatentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPatent record);

    int insertSelective(TPatent record);

    List<TPatent> selectByExample(TPatentExample example);

    TPatent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPatent record, @Param("example") TPatentExample example);

    int updateByExample(@Param("record") TPatent record, @Param("example") TPatentExample example);

    int updateByPrimaryKeySelective(TPatent record);

    int updateByPrimaryKey(TPatent record);
	/**
	 * 统计各地区专利的数量
	 */
    List<Count> countTheNumberOfPatentsInEachArea();
}