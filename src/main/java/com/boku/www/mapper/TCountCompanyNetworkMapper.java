package com.boku.www.mapper;

import com.boku.www.pojo.TCountCompanyNetwork1;
import com.boku.www.pojo.TCountCompanyNetwork2;
import com.boku.www.pojo.TCountEnglishCompanyNetwork1;
import com.boku.www.pojo.TCountEnglishCompanyNetwork2;
import com.boku.www.utils.Relation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TCountCompanyNetworkMapper {
	int insert1(TCountCompanyNetwork1 record);
	int insert2(TCountCompanyNetwork2 record);
	List<TCountCompanyNetwork1> selectByAll();
	List<TCountCompanyNetwork2> selectByForeignKey(Integer id);
	int insertEnglish1(TCountEnglishCompanyNetwork1 record);
	int insertEnglish2(TCountEnglishCompanyNetwork2 record);

	List<String> selectAllCompany();
	List<String> selectAllEnglishCompany();
	List<Relation> selectAllCooperator1();
	List<Relation> selectAllCooperator2();
	List<Relation> selectEnglishAllCooperator1();
	List<Relation> selectEnglishAllCooperator2();
	List<TCountCompanyNetwork1> selectCompanyPostNum();
	List<TCountEnglishCompanyNetwork1> selectEnglishCompanyPostNum();
}
