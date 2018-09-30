/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ExcelImportServiceImpl
 * Author:   dell
 * Date:     2018/9/29 13:52
 * Description: excel表格数据导入
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.service.impl;

import com.boku.www.mapper.TProjectDataMapper;
import com.boku.www.pojo.TProjectData;
import com.boku.www.service.ExcelImportService;
import com.mysql.jdbc.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈excel表格数据导入〉
 *
 * @author dell
 * @create 2018/9/29
 * @since 1.0.0
 */
@Service
public class ExcelImportServiceImpl implements ExcelImportService {
	@Autowired
	private TProjectDataMapper projectDataMapper;

	@Override
	public String importExcel(File file, String fileName) throws Exception{
		List<TProjectData> projectDatas = new ArrayList<TProjectData>();
		//用于判断表格是否上传成功
		String message = "Import success";

		boolean isE2007 = false;
		//判断是否是excel2007格式
		if(fileName.endsWith("xlsx")){
			isE2007 = true;
		}

		int rowIndex = 0;
		try {
			//建立输入流
			InputStream input = new FileInputStream(file);
			Workbook wb;
			//根据文件格式(2003或者2007)来初始化
			if(isE2007){
				wb = new XSSFWorkbook(input);
			}else{
				wb = new HSSFWorkbook(input);
			}
			//获得第一个表单
			Sheet sheet = wb.getSheetAt(0);

			//3.读取sheet中的每一行
			for (Row row : sheet) {
				//一行数据对应每一个区域对象
				if(row.getRowNum()==0){
					//第一行跳过
					continue;
				}
				//跳过空行
				if(row.getCell(0)==null||
						StringUtils.isNullOrEmpty(row.getCell(0).getStringCellValue()) ){
					continue;
				}

				TProjectData projectData = new TProjectData();
				//projectData.setId(row.getCell(0).getStringCellValue());



				//项目管理单位
				projectData.setManagementCompany(row.getCell(0).getStringCellValue());
				//项目类别
				projectData.setSubject(row.getCell(1).getStringCellValue());

				row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				projectData.setSubject1Id(row.getCell(2).getStringCellValue());
				//一级学科分类id
				projectData.setSubject1Id(doubleToString(row ,2));
				//二级学科分类id
				projectData.setSubject2Id(doubleToString(row ,3));
				//三级学科分类id
				projectData.setSubject3Id(doubleToString(row ,4));
				//项目编号（必填）
				projectData.setProjectNum(row.getCell(5).getStringCellValue());
				//项目名称
				projectData.setProjectName(row.getCell(6).getStringCellValue());
				//项目子类
				projectData.setProjectKidcat(row.getCell(7).getStringCellValue());
				//类目
				projectData.setCategory(row.getCell(8).getStringCellValue());
				//立项时间
				Date date = row.getCell(9).getDateCellValue();
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				formater.format(date);
				projectData.setProjectSatrtTime(date);
				System.out.println(date);
				/*case HSSFCell.CELL_TYPE_NUMERIC;
					// 数字
					if (0 == cell.getCellType()) {
						//判断单元格的类型是否则NUMERIC类型
						if (HSSFDateUtil.isCellDateFormatted(cell)) {
							// 判断是否为日期类型
							Date date = cell.getDateCellValue();
							DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
							cellValue = formater.format(date);
						}else{cellValue = cell.getNumericCellValue() + "";}
						}
					}*/
				//所在地区
				projectData.setArea(row.getCell(10).getStringCellValue());
				//承办单位
				projectData.setOrganizer(row.getCell(10).getStringCellValue());
				//项目负责人
				projectData.setProjectLeader(row.getCell(12).getStringCellValue());
				//团队成员
				projectData.setTeamMembers(row.getCell(13).getStringCellValue());
				//奖项类别
				projectData.setPrizeCategory(row.getCell(14).getStringCellValue());
				//奖项名称
				projectData.setPrizeName(row.getCell(15).getStringCellValue());
				//成果类别
				projectData.setResultCategory(row.getCell(16).getStringCellValue());
				//成果类别编号（其他：0，论文：1，图书：2，专利：3）
				projectData.setResultCategoryId(doubleToString(row ,2));
				//成果名称
				projectData.setResultName(row.getCell(18).getStringCellValue());
				//成果发表时间
				projectData.setResultTime(date);
				//projectData.setResultTime(row.getCell(19).getStringCellValue());
				//讲数据添加到集合中
				projectDatas.add(projectData);
			}
			//将集合中所有的数据存入到数据库中
			for (TProjectData data : projectDatas) {
				projectDataMapper.insert(data);
				System.out.println(data);
			}
		} catch (Exception ex) {
			message =  "Import failed, please check the data in "+rowIndex+" rows " +ex;
		}
		return message;
	}

	private String doubleToString(Row row,int i){
		row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
		String rowValue = row.getCell(i).getStringCellValue();

		//String b = String.valueOf(a);
		//b.substring(0,b.indexOf("."))
		return rowValue;
	}

}