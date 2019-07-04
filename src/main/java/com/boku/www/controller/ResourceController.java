/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ResourceController
 * Author:   dell
 * Date:     2019/6/28 17:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.controller;

import com.boku.www.pojo.TResearch;
import com.boku.www.pojo.TResource;
import com.boku.www.service.ResearchService;
import com.boku.www.service.ResourceService;
import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.PageResult;
import com.boku.www.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author dell
 * @create 2019/6/28
 * @since 1.0.0
 */
@RestController
@CrossOrigin
@RequestMapping("resource")
public class ResourceController {
	private Logger logger = LoggerFactory.getLogger(ResourceController.class);

	@Autowired
	private ResourceService resourceService;

	@RequestMapping(value = "/add" ,method = RequestMethod.POST)
	public Result add(@RequestBody TResource resource){
		try {
			resourceService.add(resource);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"增加数据失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}

	@RequestMapping(value = "/search",method = RequestMethod.POST )
	public PageResult search(@RequestBody TResource resource , int page, int rows  ){
		try {

			return resourceService.search(resource,page,rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/delete",method = RequestMethod.POST )
	public Result delete(@RequestBody Integer [] ids){
		try {
			resourceService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"删除数据失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}

}
