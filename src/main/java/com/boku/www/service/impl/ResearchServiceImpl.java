/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ResearchServiceImpl
 * Author:   dell
 * Date:     2019/6/28 17:00
 * Description: 研究书籍
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.service.impl;

import com.boku.www.mapper.TResearchMapper;
import com.boku.www.mapper.system.URoleDao;
import com.boku.www.pojo.TResearch;
import com.boku.www.pojo.TResearchExample;
import com.boku.www.pojo.system.URole;
import com.boku.www.pojo.system.UUser;
import com.boku.www.service.ResearchService;
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
 * 〈研究书籍〉
 *
 * @author dell
 * @create 2019/6/28
 * @since 1.0.0
 */
@Service
@Transactional
public class ResearchServiceImpl implements ResearchService {

	@Autowired
	private TResearchMapper researchMapper;

	@Autowired
	private URoleDao roleDao;

	/**
	 * 只有管理员才有权限新增资源
	 * @param research 资源
	 */
	@Override
	public void add(TResearch research){
		UUser currentUser = CurrentUser.returnCurrentUser();
		if(currentUser != null){
			List<URole> roleList = roleDao.findRoleByUid(currentUser.getId());
			for (URole role:roleList) {
				if("admin".equals(role.getName())){
					research.setStatus("1");
					researchMapper.insert(research);
				}
			}
		}
	}

	@Override
	public PageResult search(TResearch research, int pageNum, int pageSize){
		TResearchExample example = new TResearchExample();
		TResearchExample.Criteria criteria = example.createCriteria();
		if(research!=null){
			if(StringUtils.isNotBlank(research.getTitle())){
				criteria.andTitleLike("%"+research.getTitle()+"%");
			}
			if(StringUtils.isNotBlank(research.getCategory())){
				criteria.andCategoryEqualTo(research.getCategory());
			}
		}
		criteria.andStatusEqualTo("1");
		PageHelper.startPage(pageNum, pageSize);
		List<TResearch> list = researchMapper.selectByExample(example);
		Page<TResearch> page = (Page<TResearch>) list;
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
						System.out.println(id);
						TResearch research = researchMapper.selectByPrimaryKey(id);
						research.setStatus("2");
						researchMapper.updateByPrimaryKey(research);
					}
				}
			}
		}
	}
}