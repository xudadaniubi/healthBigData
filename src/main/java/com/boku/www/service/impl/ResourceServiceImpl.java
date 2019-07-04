/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ResourceServiceImpl
 * Author:   dell
 * Date:     2019/6/28 17:01
 * Description: 资源
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.service.impl;

import com.boku.www.mapper.TResearchMapper;
import com.boku.www.mapper.TResourceMapper;
import com.boku.www.mapper.system.URoleDao;
import com.boku.www.pojo.*;
import com.boku.www.pojo.system.URole;
import com.boku.www.pojo.system.UUser;
import com.boku.www.service.ResourceService;
import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈资源〉
 *
 * @author dell
 * @create 2019/6/28
 * @since 1.0.0
 */
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	private TResourceMapper researchMapper;

	@Autowired
	private URoleDao roleDao;

	/**
	 * 只有管理员才有权限新增资源
	 * @param resource 资源
	 */
	@Override
	public void add(TResource resource){
		UUser currentUser = CurrentUser.returnCurrentUser();
		if(currentUser != null){
			List<URole> roleList = roleDao.findRoleByUid(currentUser.getId());
			for (URole role:roleList) {
				if("admin".equals(role.getName())){
					resource.setStatus("1");
					researchMapper.insert(resource);
				}
			}
		}
	}

	@Override
	public PageResult search(TResource resource, int pageNum, int pageSize){
		TResourceExample example = new TResourceExample();
		TResourceExample.Criteria criteria = example.createCriteria();
		if(resource!=null){
			if(StringUtils.isNotBlank(resource.getTitle())){
				criteria.andTitleLike("%"+resource.getTitle()+"%");
			}
			if(StringUtils.isNotBlank(resource.getCategory())){
				criteria.andCategoryEqualTo(resource.getCategory());
			}
		}
		criteria.andStatusEqualTo("1");
		PageHelper.startPage(pageNum, pageSize);
		List<TResource> list = researchMapper.selectByExampleWithBLOBs(example);
		Page<TResource> page = (Page<TResource>) list;
		PageResult pageResult  = new PageResult();
		pageResult.setRows(page.getResult());
		pageResult.setTotal(page.getTotal());
		return pageResult;
	}

	@Override
	public void delete(Integer[] ids){
		UUser currentUser = CurrentUser.returnCurrentUser();
		if(currentUser != null){
			List<URole> roleList = roleDao.findRoleByUid(currentUser.getId());
			for (URole role:roleList) {
				if("admin".equals(role.getName())){
					for (Integer id:ids) {
						TResource resource = researchMapper.selectByPrimaryKey(id);
						resource.setStatus("2");
						researchMapper.updateByPrimaryKey(resource);
					}
				}
			}
		}
	}

	@Override
	public List<TResourceCategory> initCategory(){
		return researchMapper.initCategory();
	}
}