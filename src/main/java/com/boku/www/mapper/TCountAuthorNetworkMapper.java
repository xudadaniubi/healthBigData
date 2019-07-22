package com.boku.www.mapper;

import com.boku.www.pojo.TCountAuthorNetwork1;
import com.boku.www.pojo.TCountAuthorNetwork2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TCountAuthorNetworkMapper {
	int insert1(TCountAuthorNetwork1 record);
	int insert2(TCountAuthorNetwork2 record);
	List<TCountAuthorNetwork1> selectByArea(String area);
	List<TCountAuthorNetwork2> selectByForeignKey(Integer id);
}
