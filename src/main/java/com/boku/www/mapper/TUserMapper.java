package com.boku.www.mapper;

import com.boku.www.pojo.TUser;
import com.boku.www.pojo.TUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TUserMapper {
    int countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUserExample example);

    TUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}