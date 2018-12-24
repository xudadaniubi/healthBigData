package com.boku.www.controller;
import java.util.List;

import com.boku.www.pojo.TBooks;
import com.boku.www.service.BooksService;
import com.boku.www.utils.PageResult;
import com.boku.www.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/books")
@CrossOrigin//解决跨域问题
public class BooksController {

	@Autowired
	private BooksService booksService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TBooks> findAll(){
		return booksService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return booksService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param books
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TBooks books){
		try {
			booksService.add(books);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param books
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TBooks books){
		try {
			booksService.update(books);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TBooks findOne(Integer id){
		return booksService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer [] ids){
		try {
			booksService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public PageResult search(@RequestBody TBooks books, int page, int rows  ){
		return booksService.findPage(books, page, rows);		
	}
	
}
