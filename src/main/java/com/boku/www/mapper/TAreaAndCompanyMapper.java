package com.boku.www.mapper;

import java.util.List;

import com.boku.www.pojo.TAreaAndCompany;
import com.boku.www.pojo.TAreaAndCompanyExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TAreaAndCompanyMapper {
    int countByExample(TAreaAndCompanyExample example);

    int deleteByExample(TAreaAndCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TAreaAndCompany record);

    int insertSelective(TAreaAndCompany record);

    List<TAreaAndCompany> selectByExample(TAreaAndCompanyExample example);

    TAreaAndCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TAreaAndCompany record, @Param("example") TAreaAndCompanyExample example);

    int updateByExample(@Param("record") TAreaAndCompany record, @Param("example") TAreaAndCompanyExample example);

    int updateByPrimaryKeySelective(TAreaAndCompany record);

    int updateByPrimaryKey(TAreaAndCompany record);

	List<String> selectAllCompany();

	List<String> selectAllCompanyId();

	List<TAreaAndCompany> selectChineseBeforeX(int X);

	List<TAreaAndCompany> selectEnglishBeforeX(int X);

	List<TAreaAndCompany> selectChineseBeforeTwentiethInEachArea();

	List<TAreaAndCompany> selectEnglishBeforeTwentiethInEachArea();

}