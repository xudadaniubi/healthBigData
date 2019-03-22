/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ScheduledControllere
 * Author:   dell
 * Date:     2019/3/22 9:33
 * Description: 定时任务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.controller;

import com.boku.www.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 〈一句话功能简述〉<br> 
 * 〈SQL〉
 *
 * @author dell
 * @create 2019/3/22
 * @since 1.0.0
 */
@RestController
@RequestMapping("/scheduled")
//解决跨域问题
@CrossOrigin
public class SqlController {
	@Autowired
	private SqlService scheduledSqlService;
	/**
	 *返回已保存的sql文件
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/returnSqlList")
	public List returnSqlList(){
		try {
			return scheduledSqlService.returnSqlList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}