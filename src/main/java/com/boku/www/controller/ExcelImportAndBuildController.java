/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ExcelImportAndBuildController
 * Author:   dell
 * Date:     2018/10/8 14:15
 * Description: excel文件上传下载
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.controller;

import com.boku.www.service.ExcelImportAndBuildService;
import com.boku.www.utils.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


/**
 * 〈一句话功能简述〉<br> 
 * 〈excel文件上传下载〉
 *
 * @author dell
 * @create 2018/10/8
 * @since 1.0.0
 */
@Controller
@RequestMapping("/file")
@CrossOrigin//解决跨域问题
public class ExcelImportAndBuildController {

	@Autowired
	private ExcelImportAndBuildService excelImportAndBuildService;

	private static Logger logger = LoggerFactory.getLogger(ExcelImportAndBuildController.class);
	// 解析项目数据表
	@RequestMapping(value = "/importProjectDataExcel", method = RequestMethod.POST)
	@ResponseBody
	public String importProjectDataExcel(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			if (file.isEmpty()) {
				return "文件为空";
			}
			// 获取文件名
			String fileName = file.getOriginalFilename();
			File f = null;
			if(file.equals("")||file.getSize()<=0){
				file = null;
			}else{
				InputStream ins = file.getInputStream();
				f=new File(fileName);
				inputStreamToFile(ins, f);
			}
			//调用服务层解析excel文件
			message= excelImportAndBuildService.importProjectDataExcel(f, fileName);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			message =  "数据导入失败！请注意：立项时间、结题时间、获奖时间必须要有固定的格式，如：‘2018’，项目管理单位、" +
					"级别、项目类别、项目名称、项目子类、类目、所在地区、承担单位、项目负责人、团队成员、奖项类别、奖项名称不能为纯数字，" +
					"一级学科分类id、二级学科分类id、三级学科分类id、项目编号可以位数字也可以是文字。";
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"下载论文（中文）表数据失败,Exception:message"+e);
			return message;
		}
	}
	// 解析学科分类表
	@RequestMapping(value = "/importSubjectExcel", method = RequestMethod.POST)
	@ResponseBody
	public String importSubjectExcel(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			if (file.isEmpty()) {
				System.out.println("文件为空");
				return "文件为空";
			}
			// 获取文件名
			String fileName = file.getOriginalFilename();
			File f = null;
			if(file.equals("")||file.getSize()<=0){
				file = null;
			}else{
				InputStream ins = file.getInputStream();
				f=new File(fileName);
				inputStreamToFile(ins, f);
			}
			//调用服务层解析excel文件
			message= excelImportAndBuildService.importSubjectExcel(f, fileName);
			return message;
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"导入学科数据失败,Exception:"+e);
			e.printStackTrace();
			message =  "数据导入失败！请注意：立项时间、结题时间、获奖时间必须要有固定的格式，如：‘2018’，项目管理单位、" +
					"级别、项目类别、项目名称、项目子类、类目、所在地区、承担单位、项目负责人、团队成员、奖项类别、奖项名称不能为纯数字，" +
					"一级学科分类id、二级学科分类id、三级学科分类id、项目编号可以位数字也可以是文字。";
			return message;
		}
	}


	// 解析论文表(中文)
	@RequestMapping(value = "/importThesisForChineseExcel", method = RequestMethod.POST)
	@ResponseBody
	public String importThesisForChineseExcel(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			if (file.isEmpty()) {
				return "文件为空";
			}
			// 获取文件名
			String fileName = file.getOriginalFilename();
			File f = null;
			if(file.equals("")||file.getSize()<=0){
				file = null;
			}else{
				InputStream ins = file.getInputStream();
				f=new File(fileName);
				inputStreamToFile(ins, f);
			}
			//调用服务层解析excel文件
			message = excelImportAndBuildService.importThesisForChineseExcel(f, fileName);
			return message;
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"导入论文（中文）数据失败,Exception:"+e);
			e.printStackTrace();
			return "数据导入失败！";
		}
	}

	// 解析论文表(英文)
	@RequestMapping(value = "/importThesisForEnglishExcel", method = RequestMethod.POST)
	@ResponseBody
	public String importThesisForEnglishExcel(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			if (file.isEmpty()) {
				return "文件为空";
			}
			// 获取文件名
			String fileName = file.getOriginalFilename();
			File f = null;
			if(file.equals("")||file.getSize()<=0){
				file = null;
			}else{
				InputStream ins = file.getInputStream();
				f=new File(fileName);
				inputStreamToFile(ins, f);
			}
			//调用服务层解析excel文件
			message = excelImportAndBuildService.importThesisForEnglishExcel(f, fileName);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"导入论文（英文）数据失败,Exception:"+e);
			return "数据导入失败！";
		}
	}

	// 解析专利表
	@RequestMapping(value = "/importPatentExcel", method = RequestMethod.POST)
	@ResponseBody
	public String importPatentExcel(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			if (file.isEmpty()) {
				System.out.println("文件为空");
				return "文件为空";
			}
			// 获取文件名
			String fileName = file.getOriginalFilename();
			File f = null;
			if(file.equals("")||file.getSize()<=0){
				file = null;
			}else{
				InputStream ins = file.getInputStream();
				f=new File(fileName);
				inputStreamToFile(ins, f);
			}
			//调用服务层解析excel文件
			message = excelImportAndBuildService.importPatentExcel(f, fileName);
			return message;
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"导入专利数据失败,Exception:"+e);
			e.printStackTrace();
			return "数据导入失败！";
		}
	}

	// 解析图书表
	@RequestMapping(value = "/importBooksExcel", method = RequestMethod.POST)
	@ResponseBody
	public String importBooksExcel(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			if (file.isEmpty()) {
				System.out.println("文件为空");
				return "文件为空";
			}
			// 获取文件名
			String fileName = file.getOriginalFilename();
			File f = null;
			if(file.equals("")||file.getSize()<=0){
				file = null;
			}else{
				InputStream ins = file.getInputStream();
				f=new File(fileName);
				inputStreamToFile(ins, f);
			}
			//调用服务层解析excel文件
			message = excelImportAndBuildService.importBooksExcel(f, fileName);
			return message;
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"导入论图书数据失败,Exception:"+e);
			e.printStackTrace();
			message =  "数据导入失败！请注意：立项时间、结题时间、获奖时间必须要有固定的格式，如：‘2018’，项目管理单位、" +
					"级别、项目类别、项目名称、项目子类、类目、所在地区、承担单位、项目负责人、团队成员、奖项类别、奖项名称不能为纯数字，" +
					"一级学科分类id、二级学科分类id、三级学科分类id、项目编号可以位数字也可以是文字。";
			return message;
		}
	}

	public static void inputStreamToFile(InputStream ins,File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			ins.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}