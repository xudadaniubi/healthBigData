package com.boku.www.controller;
import java.util.List;

import com.boku.www.pojo.TThesisForEnglish;
import com.boku.www.utils.Count;
import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.PageResult;
import com.boku.www.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.boku.www.service.ThesisForEnglishService;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/thesisForEnglish")
@CrossOrigin//解决跨域问题
public class ThesisForEnglishController {
	private static Logger logger = LoggerFactory.getLogger(ThesisForEnglishController.class);
	@Autowired
	private ThesisForEnglishService thesisForEnglishService;

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TThesisForEnglish> findAll(){
		try {
			return thesisForEnglishService.findAll();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询所有英文论文失败,Exception:"+e);
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
			return thesisForEnglishService.findPage(page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"分页查询英文论文失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 增加
	 * @param thesisForEnglish
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TThesisForEnglish thesisForEnglish){
		try {
			thesisForEnglishService.add(thesisForEnglish);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"增加英文论文失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}

	/**
	 * 修改
	 * @param thesisForEnglish
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TThesisForEnglish thesisForEnglish){
		try {
			thesisForEnglishService.update(thesisForEnglish);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"修改英文论文失败,Exception:"+e);
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
	public TThesisForEnglish findOne(Integer id){
		try {
			return thesisForEnglishService.findOne(id);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"根据id获取英文论文实体失败,Exception:"+e);
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
			thesisForEnglishService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"删除英文论文失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}

	/**
	 * 查询+分页
	 * @param thesisForEnglish
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public PageResult search(@RequestBody TThesisForEnglish thesisForEnglish, int page, int rows  ){
		try {
			return thesisForEnglishService.findPage(thesisForEnglish, page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"分页条件查询英文论文失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * 批量确认论文（英文）数据
	 * @param ids
	 * @return
	 */
	@RequestMapping("/confirmThesisForEnglishStatus")
	public Result confirmThesisForEnglishStatus(@RequestBody Integer [] ids){
		try {
			thesisForEnglishService.confirmThesisForEnglishStatus(ids);
			return new Result(true, "确认成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"确认英文论文失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "确认失败");
		}
	}
	/**
	 * 统计各地区论文的数量
	 */
	@RequestMapping("/countTheNumberOfThesisForEnglishInEachArea")
	public List<Count> countTheNumberOfThesisForEnglishInEachArea(){
		try {
			return thesisForEnglishService.countTheNumberOfThesisForEnglishInEachArea();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"统计各地区英文论文的数量失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
}
