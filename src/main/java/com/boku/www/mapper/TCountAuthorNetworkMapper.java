package com.boku.www.mapper;

import com.boku.www.pojo.*;
import com.boku.www.utils.Relation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TCountAuthorNetworkMapper {
	int insert1(TCountAuthorNetwork1 record);
	int insert2(TCountAuthorNetwork2 record);
	List<TCountAuthorNetwork1> selectByArea(String area);
	List<TCountAuthorNetwork2> selectByForeignKey(Integer id);
	int insertEnglish1(TCountEnglishAuthorNetwork1 record);
	int insertEnglish2(TCountEnglishAuthorNetwork2 record);

	List<String> selectAllAuthor();
	List<String> selectEnglishAllAuthor();
	List<Relation> selectAllCooperator1();
	List<Relation> selectAllCooperator2();
	List<Relation> selectEnglishAllCooperator1();
	List<Relation> selectEnglishAllCooperator2();
	List<TCountAuthorNetwork1> selectAuthorPostNum();
	List<TCountEnglishAuthorNetwork1> selectEnglishAuthorPostNum();
	/**
	 * 查询作者top10发文量
	 */
	List<TCountAuthorNetwork1> selectAuthorPostNumTopTen();
	List<TCountEnglishAuthorNetwork1> selectEnglishAuthorPostNumTopTen();
}
