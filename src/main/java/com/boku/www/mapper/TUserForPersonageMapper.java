package com.boku.www.mapper;

import com.boku.www.pojo.TUserForPersonage;
import com.boku.www.pojo.TUserForPersonageExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TUserForPersonageMapper {
    int countByExample(TUserForPersonageExample example);

    int deleteByExample(TUserForPersonageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserForPersonage record);

    int insertSelective(TUserForPersonage record);

    List<TUserForPersonage> selectByExample(TUserForPersonageExample example);

    TUserForPersonage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserForPersonage record, @Param("example") TUserForPersonageExample example);

    int updateByExample(@Param("record") TUserForPersonage record, @Param("example") TUserForPersonageExample example);

    int updateByPrimaryKeySelective(TUserForPersonage record);

    int updateByPrimaryKey(TUserForPersonage record);


    List<TUserForPersonage> select();
    int update(TUserForPersonage record);
    List<TUserForPersonage> selectByName(@Param("username")String username);
}