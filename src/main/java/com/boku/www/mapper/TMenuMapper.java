package com.boku.www.mapper;

import com.boku.www.pojo.TMenu;
import com.boku.www.pojo.TMenuExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TMenuMapper {
    int countByExample(TMenuExample example);

    int deleteByExample(TMenuExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(TMenu record);

    int insertSelective(TMenu record);

    List<TMenu> selectByExample(TMenuExample example);

    TMenu selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") TMenu record, @Param("example") TMenuExample example);

    int updateByExample(@Param("record") TMenu record, @Param("example") TMenuExample example);

    int updateByPrimaryKeySelective(TMenu record);

    int updateByPrimaryKey(TMenu record);
}