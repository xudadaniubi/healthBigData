package com.boku.www.service.impl;
import java.util.List;

import com.boku.www.mapper.TBooksMapper;
import com.boku.www.pojo.TBooks;
import com.boku.www.pojo.TBooksExample;
import com.boku.www.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.boku.www.service.BooksService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
@Transactional
public class BooksServiceImpl implements BooksService {
	String roleGrade = null;
	@Autowired
	private TBooksMapper booksMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TBooks> findAll() {
		TBooksExample example=new TBooksExample();
		TBooksExample.Criteria criteria = example.createCriteria();
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		return booksMapper.selectByExample(example);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TBooksExample example=new TBooksExample();
		TBooksExample.Criteria criteria = example.createCriteria();
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		Page<TBooks> page=   (Page<TBooks>) booksMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TBooks books) {
		booksMapper.insert(books);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TBooks books){
		booksMapper.updateByPrimaryKey(books);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TBooks findOne(Integer id){
		return booksMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除，逻辑删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			TBooks books = booksMapper.selectByPrimaryKey(id);
			books.setStatus("2");
			booksMapper.updateByPrimaryKey(books);
		}		
	}
	
	
		@Override
	public PageResult findPage(TBooks books, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TBooksExample example=new TBooksExample();
		TBooksExample.Criteria criteria = example.createCriteria();
		
		if(books!=null){			
			if(books.getAuthor()!=null && books.getAuthor().length()>0){
				criteria.andAuthorLike("%"+books.getAuthor()+"%");
			}
			if(books.getPublisher()!=null && books.getPublisher().length()>0){
				criteria.andPublisherLike("%"+books.getPublisher()+"%");
			}

			if(books.getProjectNum()!=null && books.getProjectNum().length()>0){
				criteria.andProjectNumLike("%"+books.getProjectNum()+"%");
			}
			if(books.getTitle()!=null && books.getTitle().length()>0){
				criteria.andTitleLike("%"+books.getTitle()+"%");
			}
			//只查询状态为1的数据
			criteria.andStatusEqualTo("1");
		}
		
		Page<TBooks> page= (Page<TBooks>)booksMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
