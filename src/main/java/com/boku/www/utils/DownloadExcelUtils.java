/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: DownloadExcelUtils
 * Author:   dell
 * Date:     2018/10/10 11:39
 * Description: excel文件下载工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.utils;

import com.boku.www.pojo.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈excel文件下载工具类〉
 *
 * @author dell
 * @create 2018/10/10
 * @since 1.0.0
 */
public class DownloadExcelUtils {
	/**
	 * 项目数据表
	 * @param request
	 * @param response
	 * @param dataset
	 * @param str
	 * @param excelName
	 * @throws IOException
	 */
	public static void downProjectDataExcel(HttpServletRequest request, HttpServletResponse response, List dataset ,String[] str,String excelName)throws IOException {
		//根据前端传来的projectData作为条件来查询数据库里的数据
		//导出的Excel头部
		String[] headers = str;
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet();
		// 设置表格默认列宽度为18个字节
		//sheet.setDefaultColumnWidth((short) 6);//设置所有的列宽

		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		int index = 0;
		Object value = null;
		HSSFFont font3 = workbook.createFont();
		font3.setColor(HSSFColor.BLUE.index);//定义Excel数据颜色
		//遍历集合数据，产生数据行
		for (Object obj:dataset) {
			index++;
			row = sheet.createRow(index);
			TProjectData t = null;
			try {
				for (int i = 0; i < headers.length; i++) {
					//创建列
					HSSFCell cell = row.createCell(i);
					//分别达到对应的属性值，将属性值转换为字符串或者日期数据，再将数据存入创建好的cell列中
					if("科研项目统计表".equals(excelName)){
						sheet.setColumnWidth(1,8000);//这里可以设置具体的列宽
						sheet.setColumnWidth(2,4000);
						sheet.setColumnWidth(3,8000);
						sheet.setColumnWidth(4,5000);
						sheet.setColumnWidth(5,10000);
						sheet.setColumnWidth(9,7000);
						t = (TProjectData)obj;
						//{ "序号", "项目管理单位", "项目类别", "学科分类","项目名称","立项时间","承担单位","项目负责人","级别"};
						if(i==0) {
							value = index;
						}else if(i==1){
							value = t.getManagementCompany();
						}else if(i==2) {
							value = t.getSubject();
						}else if(i==3){
							value = t.getSubjectName();
						}else if(i==4){
							value = t.getProjectName();
						}else if(i==5){
							value = t.getProjectSatrtTime();
						}else if(i==6){
							value = t.getOrganizer();
						}else if(i==7){
							value = t.getProjectLeader();
						}else if(i==8){
							value = t.getProjectCategoryGrade();
						}
					}else if("科研奖励统计表".equals(excelName)){
						sheet.setColumnWidth(1,8000);//这里可以设置具体的列宽
						sheet.setColumnWidth(2,4000);
						sheet.setColumnWidth(3,12000);
						sheet.setColumnWidth(4,3000);
						sheet.setColumnWidth(5,5000);
						sheet.setColumnWidth(8,7000);
						sheet.setColumnWidth(10,10000);
						t = (TProjectData)obj;
						//"序号", "奖项管理单位", "奖项名称","拟奖等级","项目名称","获奖时间","所属地区","承担单位","项目负责人","团队成员"
						//{ "序号", "奖项管理单位", "奖项名称","拟奖等级","项目名称","所属地区","承担单位","项目负责人","团队成员"};
						if(i==0) {
							value = index;
						}else if(i==1){
							value = t.getManagementCompany();
						}else if(i==2){
							value = t.getPrizeCategory();
						}else if(i==3){
							value = t.getPrizeName();
						}else if(i==4){
							value = t.getProjectName();
						}else if(i==5){
							value = t.getArea();
						}else if(i==6){
							value = t.getOrganizer();
						}else if(i==7){
							value = t.getProjectLeader();
						}else if(i==8){
							value = t.getTeamMembers();
						}
					}
					String textValue = null;
					if(value != null){
						if (value instanceof Date) {
							Date date = (Date) value;
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
							textValue = sdf.format(date);
						} else {
							//其它数据类型都当作字符串简单处理
							textValue = value.toString();
						}
						HSSFRichTextString richString = new HSSFRichTextString(textValue);

						richString.applyFont(font3);
						cell.setCellValue(richString);//将数据存入进去
					}
				}
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//将表格输出到浏览器
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=excelName.xls");//默认Excel名称
		response.flushBuffer();
		workbook.write(response.getOutputStream());
	}

	/**
	 * 模板表
	 * @param request
	 * @param response
	 * @param headers
	 * @param data1
	 * @param data2
	 * @param data3
	 * @param data4
	 * @param data5
	 * @param excelName
	 * @throws IOException
	 */
	public static void downTemplateExcel(HttpServletRequest request, HttpServletResponse response,String[] headers,String[] data1,String[] data2,String[] data3,String[] data4,String[] data5,String excelName)throws IOException {
		//根据前端传来的projectData作为条件来查询数据库里的数据
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		HSSFFont font3 = workbook.createFont();

		for (int i = 1; i < headers.length; i++) {
			//定义Excel数据颜色
			font3.setColor(HSSFColor.BLUE.index);
			//创建行
			row = sheet.createRow(i);

			if(i==1){
				for (int j = 0; j < data1.length; j++) {
					//创建列
					HSSFCell cell = row.createCell(j);
					HSSFRichTextString text = new HSSFRichTextString(data1[j]);
					cell.setCellValue(text);
				}
			}else if (i==2) {
				for (int j = 0; j < data2.length; j++) {
					//创建列
					HSSFCell cell = row.createCell(j);
					HSSFRichTextString text = new HSSFRichTextString(data2[j]);
					cell.setCellValue(text);
				}
			}else if (i==3) {
				for (int j = 0; j < data3.length; j++) {
					//创建列
					HSSFCell cell = row.createCell(j);
					HSSFRichTextString text = new HSSFRichTextString(data3[j]);
					cell.setCellValue(text);
				}
			}else if (i==4) {
				for (int j = 0; j < data4.length; j++) {
					//创建列
					HSSFCell cell = row.createCell(j);
					HSSFRichTextString text = new HSSFRichTextString(data4[j]);
					cell.setCellValue(text);
				}
			}else if (i==5) {
				for (int j = 0; j < data5.length; j++) {
					//创建列
					HSSFCell cell = row.createCell(j);
					HSSFRichTextString text = new HSSFRichTextString(data5[j]);
					cell.setCellValue(text);
				}
			}
		}

		//将表格输出到浏览器
		response.setContentType("application/octet-stream");
		//默认Excel名称
		response.setHeader("Content-disposition", "attachment;filename=excelName.xls");
		response.flushBuffer();
		workbook.write(response.getOutputStream());
	}

	/**
	 * 下载论文(中文)表查询出来的数据
	 * @param request
	 * @param response
	 * @param dataset
	 * @param str
	 * @throws IOException
	 */
	public static void downThesisForChineseExcel(HttpServletRequest request, HttpServletResponse response, List dataset ,String[] str)throws IOException {
		//导出的Excel头部
		String[] headers = str;
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		int index = 0;
		//遍历集合数据，产生数据行
		Object value = null;
		HSSFFont font3 = workbook.createFont();
		font3.setColor(HSSFColor.BLUE.index);//定义Excel数据颜色
		for (Object obj:dataset) {
			index++;
			row = sheet.createRow(index);
			TThesisForChinese t = null;
			try {
				for (int i = 0; i < headers.length; i++) {
					//创建列
					HSSFCell cell = row.createCell(i);
					//分别达到对应的属性值，将属性值转换为字符串或者日期数据，再将数据存入创建好的cell列中
						t = (TThesisForChinese)obj;
						//序号  作者	题名	文献来源	年	卷	期	页码	机构（作者单位）	所属地区
						if(i==0) {
							value = index;
						}else if(i==1){
							value = t.getAuthor();
						}else if(i==2) {
							value = t.getTitle();
						}else if(i==3){
							value = t.getLiteratureResources();
						}else if(i==4){
							value = t.getYear();
						}else if(i==5){
							value = t.getRoll();
						}else if(i==6){
							value = t.getJournal();
						}else if(i==7){
							value = t.getPage();
						}else if(i==8){
							value = t.getAuthorCompany();
						}else if(i==9){
							value = t.getArea();
						}
					String textValue = null;
					if(value != null){
						//数据类型都当作字符串简单处理
						textValue = value.toString();
						HSSFRichTextString richString = new HSSFRichTextString(textValue);
						richString.applyFont(font3);
						//将数据存入进去
						cell.setCellValue(richString);
					}
				}
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//将表格输出到浏览器
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=excelName.xls");//默认Excel名称
		response.flushBuffer();
		workbook.write(response.getOutputStream());
	}

	/**
	 * 下载论文(外文)表查询出来的数据
	 * @param request
	 * @param response
	 * @param dataset
	 * @param str
	 * @throws IOException
	 */
	public static void downThesisForEnglishExcel(HttpServletRequest request, HttpServletResponse response, List dataset ,String[] str)throws IOException {
		//导出的Excel头部
		String[] headers = str;
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		int index = 0;
		Object value = null;
		HSSFFont font3 = workbook.createFont();
		font3.setColor(HSSFColor.BLUE.index);//定义Excel数据颜色
		//遍历集合数据，产生数据行
		for (Object obj:dataset) {
			index++;
			row = sheet.createRow(index);
			TThesisForEnglish t = null;
			try {
				for (int i = 0; i < headers.length; i++) {
					//创建列
					HSSFCell cell = row.createCell(i);
					//分别达到对应的属性值，将属性值转换为字符串或者日期数据，再将数据存入创建好的cell列中
					t = (TThesisForEnglish)obj;
					//序号  作者	题名	期刊名称	年	卷	期	页码	机构（作者单位）	所属地区
					if(i==0) {
						value = index;
					}else if(i==1){
						value = t.getAuthor();
					}else if(i==2) {
						value = t.getTitle();
					}else if(i==3){
						value = t.getJournalName();
					}else if(i==4){
						value = t.getYear();
					}else if(i==5){
						value = t.getRoll();
					}else if(i==6){
						value = t.getJournal();
					}else if(i==7){
						value = t.getPage();
					}else if(i==8){
						value = t.getAuthorCompany();
					}else if(i==9){
						value = t.getArea();
					}
					String textValue = null;
					if(value != null){
						//数据类型都当作字符串简单处理
						textValue = value.toString();
						HSSFRichTextString richString = new HSSFRichTextString(textValue);
						richString.applyFont(font3);
						//将数据存入进去
						cell.setCellValue(richString);
					}
				}
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//将表格输出到浏览器
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=excelName.xls");//默认Excel名称
		response.flushBuffer();
		workbook.write(response.getOutputStream());
	}

	/**
	 * 下载专利表查询出来的数据
	 * @param request
	 * @param response
	 * @param dataset
	 * @param str
	 * @throws IOException
	 */
	public static void downPatentExcel(HttpServletRequest request, HttpServletResponse response, List dataset ,String[] str)throws IOException {
		//导出的Excel头部
		String[] headers = str;
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		int index = 0;
		Object value = null;
		HSSFFont font3 = workbook.createFont();
		font3.setColor(HSSFColor.BLUE.index);//定义Excel数据颜色
		//遍历集合数据，产生数据行
		for (Object obj:dataset) {
			index++;
			row = sheet.createRow(index);
			TPatent t = null;
			try {
				for (int i = 0; i < headers.length; i++) {
					//创建列
					HSSFCell cell = row.createCell(i);
					//分别达到对应的属性值，将属性值转换为字符串或者日期数据，再将数据存入创建好的cell列中
					t = (TPatent)obj;
					//第一发明人	其他发明人	第一发明人单位	专利名称	专利权人	专利申请日	授权公告日	专利类别	登记时间	专利号	所属地区
					if(i==0) {
						value = index;
					}else if(i==1){
						value = t.getFirstInvento();
					}else if(i==2) {
						value = t.getOtherInventors();
					}else if(i==3){
						value = t.getFirstInventoCompany();
					}else if(i==4){
						value = t.getPatentName();
					}else if(i==5){
						value = t.getPatentee();
					}else if(i==6){
						value = t.getPatentApplicationDate();
					}else if(i==7){
						value = t.getAuthorizedAnnouncementDate();
					}else if(i==8){
						value = t.getPatentCategory();
					}else if(i==9){
						value = t.getRegistTime();
					}else if(i==10){
						value = t.getPatentNum();
					}else if(i==11){
						value = t.getArea();
					}
					String textValue = null;
					if(value != null){
						//数据类型都当作字符串简单处理
						textValue = value.toString();
						HSSFRichTextString richString = new HSSFRichTextString(textValue);
						richString.applyFont(font3);
						//将数据存入进去
						cell.setCellValue(richString);
					}
				}
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//将表格输出到浏览器
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=excelName.xls");//默认Excel名称
		response.flushBuffer();
		workbook.write(response.getOutputStream());
	}
}