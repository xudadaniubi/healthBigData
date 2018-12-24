package com.boku.www.controller;
import java.util.List;

import com.boku.www.pojo.TSubjectCategory;
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
import com.boku.www.service.SubjectCategoryService;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/subjectCategory")
//解决跨域问题
@CrossOrigin
public class SubjectCategoryController {
	private static Logger logger = LoggerFactory.getLogger(SubjectCategoryController.class);
	@Autowired
	private SubjectCategoryService subjectCategoryService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TSubjectCategory> findAll(){
		try {
			return subjectCategoryService.findAll();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询所有学科分类失败,Exception:"+e);
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
			return subjectCategoryService.findPage(page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"分页查询学科分类失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 增加
	 * @param subjectCategory
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TSubjectCategory subjectCategory){
		try {
			subjectCategoryService.add(subjectCategory);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"增加学科分类失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param subjectCategory
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TSubjectCategory subjectCategory){
		try {
			subjectCategoryService.update(subjectCategory);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"修改学科分类失败,Exception:"+e);
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
	public TSubjectCategory findOne(Integer id){
		try {
			return subjectCategoryService.findOne(id);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"根据id查询学科分类失败,Exception:"+e);
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
			subjectCategoryService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"删除学科分类失败,Exception:"+e);
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
	@RequestMapping("/search")
	public PageResult search(@RequestBody TSubjectCategory subjectCategory, int page, int rows  ){
		try {
			return subjectCategoryService.findPage(subjectCategory, page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"分页条件查询学科分类失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据parentId查询子分类
	 */
	@RequestMapping("/findByParentId")
	public List<TSubjectCategory> findByParentId(Integer parentId){
		try {
			return subjectCategoryService.findByParentId(parentId);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"根据父id查询子学科失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
}
