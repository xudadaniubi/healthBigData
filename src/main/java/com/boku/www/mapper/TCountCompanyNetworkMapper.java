package com.boku.www.mapper;

import com.boku.www.pojo.TCountCompanyNetwork1;
import com.boku.www.pojo.TCountCompanyNetwork2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TCountCompanyNetworkMapper {
	int insert1(TCountCompanyNetwork1 record);
	int insert2(TCountCompanyNetwork2 record);
	List<TCountCompanyNetwork1> selectByAll();
	List<TCountCompanyNetwork2> selectByForeignKey(Integer id);
}
