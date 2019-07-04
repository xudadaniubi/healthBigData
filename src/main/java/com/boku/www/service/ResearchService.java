package com.boku.www.service;

import com.boku.www.pojo.TResearch;
import com.boku.www.utils.PageResult;

public interface ResearchService {
	public void add(TResearch research);
	public PageResult search(TResearch research, int pageNum, int pageSize);
	public void delete(Integer[] ids);
}
