package com.boku.www.mapper;

import java.util.List;

import com.boku.www.pojo.TArea;
import com.boku.www.pojo.TAreaExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TAreaMapper {
    int countByExample(TAreaExample example);

    int deleteByExample(TAreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TArea record);

    int insertSelective(TArea record);

    List<TArea> selectByExample(TAreaExample example);

    TArea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TArea record, @Param("example") TAreaExample example);

    int updateByExample(@Param("record") TArea record, @Param("example") TAreaExample example);

    int updateByPrimaryKeySelective(TArea record);

    int updateByPrimaryKey(TArea record);

    //查询所有的地区和单位
	List<String> selectAllAreaOrCompany ();
}