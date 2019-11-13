package com.boku.www.controller;
import java.util.List;
import java.util.Map;

import com.boku.www.pojo.TPatent;
import com.boku.www.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boku.www.service.PatentService;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/patent")
public class PatentController {
	private static Logger logger = LoggerFactory.getLogger(PatentController.class);
	@Autowired
	private PatentService patentService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TPatent> findAll(){
		try {
			return patentService.findAll();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"返回全部专利列表数据失败,Exception:"+e);
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
			return patentService.findPage(page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"返回分页专利列表数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 增加
	 * @param patent
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TPatent patent){
		try {
			patentService.add(patent);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"增加专利数据失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param patent
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TPatent patent){
		try {
			patentService.update(patent);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"修改专利信息失败,Exception:"+e);
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
	public TPatent findOne(Integer id){
		try {
			return patentService.findOne(id);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"根据id查询专利信息失败,Exception:"+e);
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
			patentService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"删除专利信息失败,Exception:"+e);
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
	public ResultUtils search(@RequestBody TPatent patent, int page, int rows  ){
		try {
			return patentService.findPage(patent, page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"分页条件查询专利信息失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 批量确认专利数据
	 * @param ids
	 * @return
	 */
	@RequestMapping("/confirmPatentStatus")
	public Result confirmPatentStatus(@RequestBody Integer [] ids){
		try {
			patentService.confirmPatentStatus(ids);
			return new Result(true, "确认成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"确认专利信息失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "确认失败");
		}
	}

	/**
	 * 统计各地区专利的数量
	 */
	@RequestMapping("/countTheNumberOfPatentsInEachArea")
	public List<Count> countTheNumberOfPatentsInEachArea(){
		try {
			return patentService.countTheNumberOfPatentsInEachArea();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"统计各地区专利的数量失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
}
