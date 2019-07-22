package com.boku.www.mapper;

import com.boku.www.pojo.TbCnkiJournal;
import com.boku.www.pojo.TbCnkiJournalExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbCnkiJournalMapper {
	int countByExample(TbCnkiJournalExample example);

	int deleteByExample(TbCnkiJournalExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TbCnkiJournal record);

	int insertSelective(TbCnkiJournal record);

	List<TbCnkiJournal> selectByExampleWithBLOBs(TbCnkiJournalExample example);

	List<TbCnkiJournal> selectByExample(TbCnkiJournalExample example);

	TbCnkiJournal selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TbCnkiJournal record, @Param("example") TbCnkiJournalExample example);

	int updateByExampleWithBLOBs(@Param("record") TbCnkiJournal record, @Param("example") TbCnkiJournalExample example);

	int updateByExample(@Param("record") TbCnkiJournal record, @Param("example") TbCnkiJournalExample example);

	int updateByPrimaryKeySelective(TbCnkiJournal record);

	int updateByPrimaryKeyWithBLOBs(TbCnkiJournal record);

	int updateByPrimaryKey(TbCnkiJournal record);

	TbCnkiJournal selectTbJournal(String journalId);

	TbCnkiJournal selectCe();
}