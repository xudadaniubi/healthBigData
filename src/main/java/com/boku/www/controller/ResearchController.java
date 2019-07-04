/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ResearchController
 * Author:   dell
 * Date:     2019/6/28 17:40
 * Description: 研究
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.controller;

import com.boku.www.pojo.TResearch;
import com.boku.www.service.ResearchService;
import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.PageResult;
import com.boku.www.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈研究〉
 *
 * @author dell
 * @create 2019/6/28
 * @since 1.0.0
 */
@RestController
@CrossOrigin
@RequestMapping("research")
public class ResearchController {
	private Logger logger = LoggerFactory.getLogger(ResearchController.class);

	@Autowired
	private ResearchService researchService;

	@RequestMapping(value = "/add",method = RequestMethod.POST )
	public Result add(@RequestBody TResearch research){
		try {
			researchService.add(research);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"增加数据失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}

	@RequestMapping(value = "/search",method = RequestMethod.POST )
	public PageResult search(@RequestBody TResearch research , int page, int rows  ){
		try {
			System.out.println(research);
			return researchService.search(research,page,rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/delete",method = RequestMethod.POST )
	public Result delete(@RequestBody Integer [] ids){
		try {
			System.out.println(ids);
			researchService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"删除数据失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}

}