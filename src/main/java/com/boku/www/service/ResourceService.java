package com.boku.www.service;

import com.boku.www.pojo.TResource;
import com.boku.www.utils.PageResult;

public interface ResourceService {
	public void add(TResource resource);
	public PageResult search(TResource resource, int pageNum, int pageSize);
	public void delete(Integer[] ids);
}
