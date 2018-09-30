package com.boku.www.mapper;

import com.boku.www.pojo.TUserRole;
import com.boku.www.pojo.TUserRoleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TUserRoleMapper {
    int countByExample(TUserRoleExample example);

    int deleteByExample(TUserRoleExample example);

    int deleteByPrimaryKey(String userRoleId);

    int insert(TUserRole record);

    int insertSelective(TUserRole record);

    List<TUserRole> selectByExample(TUserRoleExample example);

    TUserRole selectByPrimaryKey(String userRoleId);

    int updateByExampleSelective(@Param("record") TUserRole record, @Param("example") TUserRoleExample example);

    int updateByExample(@Param("record") TUserRole record, @Param("example") TUserRoleExample example);

    int updateByPrimaryKeySelective(TUserRole record);

    int updateByPrimaryKey(TUserRole record);
}