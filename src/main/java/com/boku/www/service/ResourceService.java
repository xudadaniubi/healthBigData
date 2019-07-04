package com.boku.www.service;

import com.boku.www.pojo.TResource;
import com.boku.www.pojo.TResourceCategory;
import com.boku.www.utils.PageResult;

import java.util.List;

public interface ResourceService {
	public void add(TResource resource);
	public PageResult search(TResource resource, int pageNum, int pageSize);
	public void delete(Integer[] ids);
	public List<TResourceCategory> initCategory();
}
