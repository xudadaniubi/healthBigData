package com.boku.www.controller;
import java.util.List;

import com.boku.www.pojo.TPrizeCategory;
import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.PageResult;
import com.boku.www.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boku.www.service.PrizeCategoryService;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/prizeCategory")
@CrossOrigin//解决跨域问题
public class PrizeCategoryController {
	private static Logger logger = LoggerFactory.getLogger(PrizeCategoryController.class);
	@Autowired
	private PrizeCategoryService prizeCategoryService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TPrizeCategory> findAll(){
		try {
			return prizeCategoryService.findAll();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询全部奖励分类失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		try {
			return prizeCategoryService.findPage(page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"分页查询全部奖励分类失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 增加
	 * @param prizeCategory
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TPrizeCategory prizeCategory){
		try {
			prizeCategoryService.add(prizeCategory);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"增加奖励分类失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param prizeCategory
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TPrizeCategory prizeCategory){
		try {
			prizeCategoryService.update(prizeCategory);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"修改奖励分类失败,Exception:"+e);
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
	public TPrizeCategory findOne(Integer id){
		try {
			return prizeCategoryService.findOne(id);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"根据id查询奖励分类实体失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer [] ids){
		try {
			prizeCategoryService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"删除奖励分类失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TPrizeCategory prizeCategory, int page, int rows  ){
		try {
			return prizeCategoryService.findPage(prizeCategory, page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"分页条件查询奖励分类失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 查询所有的级别
	 */
	@RequestMapping("/findAllGrade")
	public List<String> findAllGrade(){
		try {
			return prizeCategoryService.findAllGrade();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询所有的奖励级别失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据级别查询对应的奖励类别
	 */
	@RequestMapping("/findByGrade")
	public List<TPrizeCategory> findByGrade(String grade){
		try {
			if(grade!=null && grade.length()>0){
				return prizeCategoryService.findByGrade(grade);
			}
			return null;
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"根据级别查询对应的奖励类别失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	
}
