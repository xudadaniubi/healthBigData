package com.boku.www.controller;
import java.util.List;

import com.boku.www.pojo.TProjectCategory;
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
import com.boku.www.service.ProjectCategoryService;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@CrossOrigin//解决跨域问题
@RequestMapping("/projectCategory")
public class ProjectCategoryController {
	private static Logger logger = LoggerFactory.getLogger(ProjectCategoryController.class);
	@Autowired
	private ProjectCategoryService projectCategoryService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TProjectCategory> findAll(){
		try {
			return projectCategoryService.findAll();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"返回全部列表项目类别失败,Exception:"+e);
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
			return projectCategoryService.findPage(page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"分页返回全部列表项目类别失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 增加
	 * @param projectCategory
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TProjectCategory projectCategory){
		try {
			System.out.println(projectCategory);
			//projectCategoryService.add(projectCategory);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"增加项目分类失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param projectCategory
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TProjectCategory projectCategory){
		try {
			projectCategoryService.update(projectCategory);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"修改项目分类失败,Exception:"+e);
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
	public TProjectCategory findOne(Integer id){
		try {
			return projectCategoryService.findOne(id);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"根据id获取项目分类实体失败,Exception:"+e);
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
			projectCategoryService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"删除项目分类失败,Exception:"+e);
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
	public PageResult search(@RequestBody TProjectCategory projectCategory, int page, int rows  ){
		try {
			return projectCategoryService.findPage(projectCategory, page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"分页条件查询项目分类失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 查询所有的级别
	 */
	@RequestMapping("/findAllGrade")
	public List<String> findAllGrade(){
		logger.info("查询所有的项目级别");
		try {
			return projectCategoryService.findAllGrade();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询所有的项目级别失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	* 根据级别查询对应的项目类别
	 * */
	@RequestMapping("/findByGrade")
	public List<TProjectCategory> findByGrade(String grade){
		try {
			if(grade!=null && grade.length()>0){
				return projectCategoryService.findByGrade(grade);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
