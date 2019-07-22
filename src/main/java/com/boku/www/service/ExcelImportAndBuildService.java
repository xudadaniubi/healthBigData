package com.boku.www.service;



import java.io.File;
import java.util.List;
public interface ExcelImportAndBuildService {
	//解析项目数据表
	public String importProjectDataExcel(File file, String fileName) throws Exception;

	//解析项目数据表
	public String importPrizeDataExcel(File file, String fileName) throws Exception;

	//解析学科分类表
	public String importSubjectExcel(File file, String fileName) throws Exception;

	//解析论文表（中文）
	public String importThesisForChineseExcel(File file, String fileName) throws Exception;

	//解析论文表（英文）
	public String importThesisForEnglishExcel(File file, String fileName) throws Exception;

	//解析图书表
	public String importBooksExcel(File file, String fileName) throws Exception;

	//解析专利表
	public String importPatentExcel(File file, String fileName) throws Exception;

	//解析地区表
	public String importAreaExcel(File file, String fileName) throws Exception;

	//解析地区表
	public String importAreaAndCompanyExcel(File file, String fileName) throws Exception;

	//将地区表的部分信息传入用户表
	public String importAreaAndCompanyExcelToUser(File file, String fileName) throws Exception;

	public String importUser(File file, String fileName) throws Exception;

	public String repeatUserCompany(File file, String fileName) throws Exception;
}
