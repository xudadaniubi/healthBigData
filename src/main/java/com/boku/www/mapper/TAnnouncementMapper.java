package com.boku.www.mapper;

import com.boku.www.pojo.TAnnouncement;
import com.boku.www.pojo.TAnnouncementExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TAnnouncementMapper {
    int countByExample(TAnnouncementExample example);

    int deleteByExample(TAnnouncementExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TAnnouncement record);

    int insertSelective(TAnnouncement record);

    List<TAnnouncement> selectByExampleWithBLOBs(TAnnouncementExample example);

    List<TAnnouncement> selectByExample(TAnnouncementExample example);

    TAnnouncement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TAnnouncement record, @Param("example") TAnnouncementExample example);

    int updateByExampleWithBLOBs(@Param("record") TAnnouncement record, @Param("example") TAnnouncementExample example);

    int updateByExample(@Param("record") TAnnouncement record, @Param("example") TAnnouncementExample example);

    int updateByPrimaryKeySelective(TAnnouncement record);

    int updateByPrimaryKeyWithBLOBs(TAnnouncement record);

    int updateByPrimaryKey(TAnnouncement record);
}