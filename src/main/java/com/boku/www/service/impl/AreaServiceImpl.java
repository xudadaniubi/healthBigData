package com.boku.www.service.impl;
import java.util.List;

import com.boku.www.mapper.TAreaMapper;
import com.boku.www.pojo.TArea;
import com.boku.www.pojo.TAreaExample;
import com.boku.www.utils.PageResult;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.boku.www.service.AreaService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
@Transactional
public class AreaServiceImpl implements AreaService {
	String roleGrade = null;
	@Autowired
	private TAreaMapper areaMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TArea> findAll() {
		return areaMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TArea> page=   (Page<TArea>) areaMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TArea area) {
		List<TArea> areaList = findByParentId(Integer.parseInt(area.getParentAreaId()));
		int maxAreaId = 0;
		//遍历得到数据库中最大的SubjectId
		System.out.println(areaList.size());
		//有可能parentSubjectId下没有一个子类
		if(areaList.size()!=0){
			for (TArea TAreaCategory: areaList) {
				if(maxAreaId<=Integer.parseInt(TAreaCategory.getAreaId())){
					maxAreaId = Integer.parseInt(TAreaCategory.getAreaId());
				}
			}
			if(area.getParentAreaId().equals("330000")){
				//在浙江省下添加地级市或其他
				maxAreaId = maxAreaId + 100;
			}else{
				//在地级市下添加区县，或者在区县下添加单位（医院）
				maxAreaId = maxAreaId + 1;
			}
		}else{
			System.out.println(area.getParentAreaId().substring(2,4));
			//没有子类，就在父类id的基础上新建
			if(area.getParentAreaId().equals("330000")){
				//浙江省没有地级市或其他
				//33000-->330100
				maxAreaId = Integer.parseInt(area.getParentAreaId())+100;
			}else if(Integer.parseInt(area.getParentAreaId().substring(2,4) )!=0 && Integer.parseInt(area.getParentAreaId().substring(4,6))==0){
				//330100-->330101(市里面没有区县)
				maxAreaId = Integer.parseInt(area.getParentAreaId())+1;
			}else if(Integer.parseInt(area.getParentAreaId().substring(2,4) )!=0 && Integer.parseInt(area.getParentAreaId().substring(4,6))!=0){
				//330101-->33010101（区县里面没有单位）
				maxAreaId = Integer.parseInt(area.getParentAreaId()+"01");
			}
		}

		System.out.println(""+(maxAreaId));
		//在最大的maxSubjectId基础上加1
		area.setAreaId(""+(maxAreaId));
		area.setStatus("1");
		areaMapper.insert(area);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TArea area){
		area.setStatus("1");
		areaMapper.updateByPrimaryKey(area);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TArea findOne(Integer id){
		return areaMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			TArea area = areaMapper.selectByPrimaryKey(id);
			area.setStatus("2");
			areaMapper.updateByPrimaryKey(area);
		}
	}

	
	
	@Override
	public PageResult findPage(TArea area, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TAreaExample example=new TAreaExample();
		TAreaExample.Criteria criteria = example.createCriteria();
		
		if(area!=null){			
			if(area.getAreaId()!=null && area.getAreaId().length()>0){
				criteria.andAreaIdLike("%"+area.getAreaId()+"%");
			}
			if(area.getParentAreaId()!=null && area.getParentAreaId().length()>0){
				criteria.andParentAreaIdLike("%"+area.getParentAreaId()+"%");
			}
			if(area.getAreaOrCompany()!=null && area.getAreaOrCompany().length()>0){
				criteria.andAreaOrCompanyLike("%"+area.getAreaOrCompany()+"%");
			}
			if(area.getStatus()!=null && area.getStatus().length()>0){
				criteria.andStatusLike("%"+area.getStatus()+"%");
			}
	
		}
		criteria.andStatusEqualTo("1");
		
		Page<TArea> page= (Page<TArea>)areaMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 根据parentId查询子分类
	 * @param parentId
	 * @return
	 */
	@Override
	public List<TArea> findByParentId(Integer parentId) {

		TAreaExample example = new TAreaExample();
		TAreaExample.Criteria criteria = example.createCriteria();
		criteria.andParentAreaIdEqualTo(""+parentId);
		criteria.andStatusEqualTo("1");
		return areaMapper.selectByExample(example );
	}
}
