package com.boku.www.mapper;

import com.boku.www.pojo.TbWanfangJournal;
import com.boku.www.pojo.TbWanfangJournalExample;
import com.boku.www.pojo.TbWanfangJournalWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbWanfangJournalMapper {
	int countByExample(TbWanfangJournalExample example);

	int deleteByExample(TbWanfangJournalExample example);

	int deleteByPrimaryKey(String id);

	int insert(TbWanfangJournalWithBLOBs record);

	int insertSelective(TbWanfangJournalWithBLOBs record);

	List<TbWanfangJournalWithBLOBs> selectByExampleWithBLOBs(TbWanfangJournalExample example);

	List<TbWanfangJournal> selectByExample(TbWanfangJournalExample example);

	TbWanfangJournalWithBLOBs selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") TbWanfangJournalWithBLOBs record, @Param("example") TbWanfangJournalExample example);

	int updateByExampleWithBLOBs(@Param("record") TbWanfangJournalWithBLOBs record, @Param("example") TbWanfangJournalExample example);

	int updateByExample(@Param("record") TbWanfangJournal record, @Param("example") TbWanfangJournalExample example);

	int updateByPrimaryKeySelective(TbWanfangJournalWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs(TbWanfangJournalWithBLOBs record);

	int updateByPrimaryKey(TbWanfangJournal record);

	int insertBatch(List<TbWanfangJournalWithBLOBs> list);
}