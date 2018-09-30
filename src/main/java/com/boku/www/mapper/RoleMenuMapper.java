package com.boku.www.mapper;

import com.boku.www.pojo.RoleMenu;
import com.boku.www.pojo.RoleMenuExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMenuMapper {
    int countByExample(RoleMenuExample example);

    int deleteByExample(RoleMenuExample example);

    int deleteByPrimaryKey(String roleMenuId);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    List<RoleMenu> selectByExample(RoleMenuExample example);

    RoleMenu selectByPrimaryKey(String roleMenuId);

    int updateByExampleSelective(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    int updateByExample(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);
}