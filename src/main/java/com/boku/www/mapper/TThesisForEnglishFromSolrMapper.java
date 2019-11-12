package com.boku.www.mapper;

import com.boku.www.pojo.TThesisForEnglishFromSolr;
import com.boku.www.pojo.TThesisForEnglishFromSolrExample;
import com.boku.www.pojo.TThesisForEnglishFromSolrWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TThesisForEnglishFromSolrMapper {
    int countByExample(TThesisForEnglishFromSolrExample example);

    int deleteByExample(TThesisForEnglishFromSolrExample example);

    int deleteByPrimaryKey(String abstractId);

    int insert(TThesisForEnglishFromSolrWithBLOBs record);

    int insertSelective(TThesisForEnglishFromSolrWithBLOBs record);

    List<TThesisForEnglishFromSolrWithBLOBs> selectByExampleWithBLOBs(TThesisForEnglishFromSolrExample example);

    List<TThesisForEnglishFromSolr> selectByExample(TThesisForEnglishFromSolrExample example);

    TThesisForEnglishFromSolrWithBLOBs selectByPrimaryKey(String abstractId);

    int updateByExampleSelective(@Param("record") TThesisForEnglishFromSolrWithBLOBs record, @Param("example") TThesisForEnglishFromSolrExample example);

    int updateByExampleWithBLOBs(@Param("record") TThesisForEnglishFromSolrWithBLOBs record, @Param("example") TThesisForEnglishFromSolrExample example);

    int updateByExample(@Param("record") TThesisForEnglishFromSolr record, @Param("example") TThesisForEnglishFromSolrExample example);

    int updateByPrimaryKeySelective(TThesisForEnglishFromSolrWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TThesisForEnglishFromSolrWithBLOBs record);

    int updateByPrimaryKey(TThesisForEnglishFromSolr record);
}