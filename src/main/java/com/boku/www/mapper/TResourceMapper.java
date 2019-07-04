package com.boku.www.mapper;

import com.boku.www.pojo.TResource;
import com.boku.www.pojo.TResourceCategory;
import com.boku.www.pojo.TResourceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TResourceMapper {
    int countByExample(TResourceExample example);

    int deleteByExample(TResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TResource record);

    int insertSelective(TResource record);

    List<TResource> selectByExampleWithBLOBs(TResourceExample example);

    List<TResource> selectByExample(TResourceExample example);

    TResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TResource record, @Param("example") TResourceExample example);

    int updateByExampleWithBLOBs(@Param("record") TResource record, @Param("example") TResourceExample example);

    int updateByExample(@Param("record") TResource record, @Param("example") TResourceExample example);

    int updateByPrimaryKeySelective(TResource record);

    int updateByPrimaryKeyWithBLOBs(TResource record);

    int updateByPrimaryKey(TResource record);

    List<TResourceCategory> initCategory();
}