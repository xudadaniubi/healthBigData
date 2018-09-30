package com.boku.www.mapper;

import com.boku.www.pojo.TRole;
import com.boku.www.pojo.TRoleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TRoleMapper {
    int countByExample(TRoleExample example);

    int deleteByExample(TRoleExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(TRole record);

    int insertSelective(TRole record);

    List<TRole> selectByExample(TRoleExample example);

    TRole selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByExample(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);
}