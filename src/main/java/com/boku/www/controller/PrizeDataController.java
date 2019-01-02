/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: PrizeController
 * Author:   dell
 * Date:     2018/12/24 13:59
 * Description: 奖励数据
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.controller;

import com.boku.www.pojo.TPrizeData;
import com.boku.www.service.PrizeDataService;
import com.boku.www.utils.Count;
import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.PageResult;
import com.boku.www.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈奖励数据〉
 *
 * @author dell
 * @create 2018/12/24
 * @since 1.0.0
 */
@RestController
@RequestMapping("/prizeData")
@CrossOrigin//解决跨域问题
public class PrizeDataController {
	private static Logger logger = LoggerFactory.getLogger(PrizeDataController.class);
	@Autowired
	private PrizeDataService prizeDataService;

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TPrizeData> findAll(){
		try {
			return prizeDataService.findAll();
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"查询所有的奖励数据失败,Exception:"+e);
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
			return prizeDataService.findPage(page, rows);
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"分页查询所有的奖励数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 增加
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TPrizeData prizeData){
		try {
			prizeDataService.add(prizeData);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"增加奖励数据失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}

	/**
	 * 修改
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TPrizeData prizeData){
		try {
			prizeDataService.update(prizeData);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"修改奖励数据失败,Exception:"+e);
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
	public TPrizeData findOne(Integer id){
		try {
			return prizeDataService.findOne(id);
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"根据id获取奖励实体失败,Exception:"+e);
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
			prizeDataService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"删除奖励数据失败,Exception:"+e);
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
	public PageResult search(@RequestBody TPrizeData prizeData, int page, int rows  ){
		try {
			return prizeDataService.findPage(prizeData, page, rows);
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"分页条件查询奖励数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 批量确认奖励数据
	 * @param ids
	 * @return
	 */
	@RequestMapping("/confirmPrizeStatus")
	public Result confirmPrizeStatus(@RequestBody Integer [] ids){
		try {
			prizeDataService.confirmPrizeStatus(ids);
			return new Result(true, "确认成功");
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"确认奖励数据失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "确认失败");
		}
	}

	/**
	 * 统计各地区奖励的数量
	 */
	@RequestMapping("/countTheNumberOfPrizeDataInEachArea")
	public List<Count> countTheNumberOfPrizeDataInEachArea(){
		try {
			return prizeDataService.countTheNumberOfPrizeDataInEachArea();
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"统计各地区奖励的数量失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
}

