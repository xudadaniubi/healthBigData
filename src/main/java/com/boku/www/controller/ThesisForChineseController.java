package com.boku.www.controller;
import java.util.List;

import com.boku.www.pojo.TThesisForChinese;
import com.boku.www.service.ThesisForChineseService;
import com.boku.www.utils.Count;
import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.PageResult;
import com.boku.www.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/thesisForChinese")
@CrossOrigin//解决跨域问题
public class ThesisForChineseController {
	private static Logger logger = LoggerFactory.getLogger(ThesisForChineseController.class);
	@Autowired
	private ThesisForChineseService thesisForChineseService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TThesisForChinese> findAll(){
		try {
			return thesisForChineseService.findAll();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询所有中文论文失败,Exception:"+e);
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
			return thesisForChineseService.findPage(page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"分页查询中文论文失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 增加
	 * @param thesisForChinese
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TThesisForChinese thesisForChinese){
		try {
			thesisForChineseService.add(thesisForChinese);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"增加中文论文失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param thesisForChinese
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TThesisForChinese thesisForChinese){
		try {
			thesisForChineseService.update(thesisForChinese);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"修改中文论文失败,Exception:"+e);
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
	public TThesisForChinese findOne(Integer id){
		try {
			return thesisForChineseService.findOne(id);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"增根据id获取中文论文实体失败,Exception:"+e);
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
			thesisForChineseService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"删除中文论文失败,Exception:"+e);
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
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public PageResult search(@RequestBody TThesisForChinese thesisForChinese, int page, int rows  ){
		try {
			return thesisForChineseService.findPage(thesisForChinese, page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"分页条件查询中文论文失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}


	/**
	 *
	 * 论文（中文）数据使用的批量确认
	 * @param ids
	 * @return
	 */
	@RequestMapping("/confirmThesisForChineseStatus")
	public Result confirmThesisForChineseStatus(@RequestBody Integer [] ids){
		try {
			thesisForChineseService.confirmThesisForChineseStatus(ids);
			return new Result(true, "确认成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"确认中文论文失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "确认失败");
		}
	}

	/**
	 * 统计各地区论文的数量
	 */
	@RequestMapping("/countTheNumberOfThesisForChineseInEachArea")
	public List<Count> countTheNumberOfThesisForChineseInEachArea(){
		try {
			return thesisForChineseService.countTheNumberOfThesisForChineseInEachArea();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"统计各地区论文的数量失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 统计各地区论文的数量
	 */
	@RequestMapping("/addCommpanyId")
	public void addCommpanyId(){
		try {
			thesisForChineseService.addCommpanyId();
		} catch (Exception e) {
			logger.info("添加失败");
			e.printStackTrace();
		}
	}
}
