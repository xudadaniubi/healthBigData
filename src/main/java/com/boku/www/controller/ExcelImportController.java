/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: addReportByExcel
 * Author:   dell
 * Date:     2018/9/28 16:48
 * Description: 解析excel表格
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.controller;

import com.boku.www.service.ExcelImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 〈一句话功能简述〉<br> 
 * 〈解析excel表格〉
 *
 * @author dell
 * @create 2018/9/28
 * @since 1.0.0
 */
@Controller
public class ExcelImportController {

	@Autowired
	private ExcelImportService excelImportService;
	@RequestMapping("/importProjectData")
	public String importExcel(File file , String filePath) throws Exception{
		file = new File(filePath);
		//InputStream inputStream = new FileInputStream("filePath");
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportService.importExcel(file, fileName);
		System.out.println(message);
		return message;

	}
}