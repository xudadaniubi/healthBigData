package com.boku.www.service.impl;
import java.util.List;

import com.boku.www.mapper.TAreaMapper;
import com.boku.www.mapper.TPrizeCategoryMapper;
import com.boku.www.pojo.TArea;
import com.boku.www.pojo.TAreaExample;
import com.boku.www.pojo.TPrizeCategory;
import com.boku.www.pojo.TPrizeCategoryExample;
import com.boku.www.utils.PageResult;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.boku.www.service.PrizeCategoryService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
@Transactional
public class PrizeCategoryServiceImpl implements PrizeCategoryService {
	String roleGrade = null;
	@Autowired
	private TPrizeCategoryMapper prizeCategoryMapper;
	@Autowired
	private TAreaMapper areaMapper;
	/**
	 * 查询全部
	 */
	@Override
	public List<TPrizeCategory> findAll() {
		TPrizeCategoryExample example=new TPrizeCategoryExample();
		TPrizeCategoryExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo("1");
		return prizeCategoryMapper.selectByExample(example);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TPrizeCategoryExample example=new TPrizeCategoryExample();
		TPrizeCategoryExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo("1");
		Page<TPrizeCategory> page=   (Page<TPrizeCategory>) prizeCategoryMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TPrizeCategory prizeCategory) {
		if(prizeCategory != null){
			if(prizeCategory.getGrade() != null && prizeCategory.getGrade().length()>0){
				//不是国家级和省级，就根据前端传的市、区县医院的id查询对应的名称，将名词存入进去即可
				if(!"国家级".equals(prizeCategory.getGrade()) && !"省级".equals(prizeCategory.getGrade())){
					//这时前端传过来的Grade是这样的"地市级（330500）"  区/县/院级（33062401）
					if(prizeCategory.getGrade().contains("地市级")){
						String a = prizeCategory.getGrade().substring(0,4);
						String b = prizeCategory.getGrade().substring(4);
						TAreaExample example = new TAreaExample();
						TAreaExample.Criteria criteria = example.createCriteria();
						criteria.andAreaIdEqualTo(b);
						List<TArea> areaList = areaMapper.selectByExample(example);
						prizeCategory.setGrade(a+areaList.get(0).getAreaOrCompany()+"）");
					}else if(prizeCategory.getGrade().contains("区/县/院级")){
						String a = prizeCategory.getGrade().substring(0,7);
						String b = prizeCategory.getGrade().substring(7);
						TAreaExample example = new TAreaExample();
						TAreaExample.Criteria criteria = example.createCriteria();
						criteria.andAreaIdEqualTo(b);
						List<TArea> areaList = areaMapper.selectByExample(example);
						prizeCategory.setGrade(a+areaList.get(0).getAreaOrCompany()+"）");
					}
				}
			}
		}
		prizeCategory.setStatus("1");
		prizeCategoryMapper.insert(prizeCategory);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TPrizeCategory prizeCategory){
		prizeCategory.setStatus("1");
		prizeCategoryMapper.updateByPrimaryKey(prizeCategory);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TPrizeCategory findOne(Integer id){
		return prizeCategoryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			TPrizeCategory prizeCategory= prizeCategoryMapper.selectByPrimaryKey(id);
			prizeCategory.setStatus("2");
			prizeCategoryMapper.updateByPrimaryKey(prizeCategory);
		}		
	}
	
	
		@Override
	public PageResult findPage(TPrizeCategory prizeCategory, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TPrizeCategoryExample example=new TPrizeCategoryExample();
		TPrizeCategoryExample.Criteria criteria = example.createCriteria();
		
		if(prizeCategory!=null){			
			if(prizeCategory.getGrade()!=null && prizeCategory.getGrade().length()>0){
				criteria.andGradeLike("%"+prizeCategory.getGrade()+"%");
			}
			if(prizeCategory.getPrizeCategory()!=null && prizeCategory.getPrizeCategory().length()>0){
				criteria.andPrizeCategoryLike("%"+prizeCategory.getPrizeCategory()+"%");
			}
			if(prizeCategory.getStatus()!=null && prizeCategory.getStatus().length()>0){
				criteria.andStatusLike("%"+prizeCategory.getStatus()+"%");
			}
	
		}

		criteria.andStatusEqualTo("1");
		Page<TPrizeCategory> page= (Page<TPrizeCategory>)prizeCategoryMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 查询所有的级别
	 */
	@Override
	public List<String> findAllGrade() {
		List<String> allGrade = prizeCategoryMapper.findAllGrade();
		return allGrade;
	}



	/**
	 * 根据级别查询对应的奖励类别
	 */
	@Override
	public List<TPrizeCategory> findByGrade(String grade) {
		TPrizeCategoryExample example=new TPrizeCategoryExample();
		TPrizeCategoryExample.Criteria criteria = example.createCriteria();
		//在配置管理的查询页面中国家级查询出所有国家级奖励类别，省级查询出所有省级奖励类别，地市级查询出所有地市级奖励类别，区县级查询出所有区县级奖励类别
		//在三级联动中，根据级别传递就可以了
		if(grade!=null && grade.length()>0){
			if("所有地市级奖励".equals(grade)){
				criteria.andGradeLike("%"+"地市级"+"%");
			}else if("所有区/县/院级奖励".equals(grade)){
				criteria.andGradeLike("%"+"区/县/院级"+"%");
			}else{
				criteria.andGradeEqualTo(grade);
			}
		}
		criteria.andStatusEqualTo("1");
		return prizeCategoryMapper.selectByExample(example);
	}

}
