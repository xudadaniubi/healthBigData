package com.boku.www.mapper;

import com.boku.www.pojo.TBooks;
import com.boku.www.pojo.TBooksExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TBooksMapper {
    int countByExample(TBooksExample example);

    int deleteByExample(TBooksExample example);

    int deleteByPrimaryKey(String id);

    int insert(TBooks record);

    int insertSelective(TBooks record);

    List<TBooks> selectByExample(TBooksExample example);

    TBooks selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TBooks record, @Param("example") TBooksExample example);

    int updateByExample(@Param("record") TBooks record, @Param("example") TBooksExample example);

    int updateByPrimaryKeySelective(TBooks record);

    int updateByPrimaryKey(TBooks record);
}