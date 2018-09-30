package com.boku.www.mapper;

import com.boku.www.pojo.TJobs;
import com.boku.www.pojo.TJobsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TJobsMapper {
    int countByExample(TJobsExample example);

    int deleteByExample(TJobsExample example);

    int deleteByPrimaryKey(String jobsId);

    int insert(TJobs record);

    int insertSelective(TJobs record);

    List<TJobs> selectByExample(TJobsExample example);

    TJobs selectByPrimaryKey(String jobsId);

    int updateByExampleSelective(@Param("record") TJobs record, @Param("example") TJobsExample example);

    int updateByExample(@Param("record") TJobs record, @Param("example") TJobsExample example);

    int updateByPrimaryKeySelective(TJobs record);

    int updateByPrimaryKey(TJobs record);
}