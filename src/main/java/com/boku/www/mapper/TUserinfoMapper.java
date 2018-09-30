package com.boku.www.mapper;

import com.boku.www.pojo.TUserinfo;
import com.boku.www.pojo.TUserinfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TUserinfoMapper {
    int countByExample(TUserinfoExample example);

    int deleteByExample(TUserinfoExample example);

    int deleteByPrimaryKey(String userinfoId);

    int insert(TUserinfo record);

    int insertSelective(TUserinfo record);

    List<TUserinfo> selectByExample(TUserinfoExample example);

    TUserinfo selectByPrimaryKey(String userinfoId);

    int updateByExampleSelective(@Param("record") TUserinfo record, @Param("example") TUserinfoExample example);

    int updateByExample(@Param("record") TUserinfo record, @Param("example") TUserinfoExample example);

    int updateByPrimaryKeySelective(TUserinfo record);

    int updateByPrimaryKey(TUserinfo record);
}