/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ExcelImportAndBuildServiceImpl
 * Author:   dell
 * Date:     2018/10/8 13:47
 * Description: excel文件上传下载
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.service.impl;

import com.boku.www.mapper.*;
import com.boku.www.mapper.system.UUserDao;
import com.boku.www.pojo.*;
import com.boku.www.pojo.system.UUser;
import com.boku.www.service.ExcelImportAndBuildService;
import com.boku.www.utils.ParseExcelUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import static javax.xml.bind.JAXBIntrospector.getValue;

/**
 * 〈一句话功能简述〉<br> 
 * 〈excel文件上传下载〉
 *
 * @author dell
 * @create 2018/10/8
 * @since 1.0.0
 */
@Service
@Transactional
public class ExcelImportAndBuildServiceImpl implements ExcelImportAndBuildService {
	@Autowired
	private TProjectDataMapper projectDataMapper;

	@Autowired
	private TSubjectCategoryMapper subjectCategoryMapper;

	@Autowired
	private TThesisForChineseMapper thesisForChineseMapper;

	@Autowired
	private TThesisForEnglishMapper thesisForEnglishMapper;

	@Autowired
	private TBooksMapper booksMapper;

	@Autowired
	private TPatentMapper patentMapper;

	@Autowired
	private  TAreaMapper areaMapper;

	@Autowired
	private TPrizeCategoryMapper prizeCategoryMapper;

	@Autowired
	private  TProjectCategoryMapper projectCategoryMapper;

	@Autowired
	private TAreaAndCompanyMapper areaAndCompanyMapper;

	@Autowired
	private UUserDao userDao;

	/**插入项目数据到数据库
	 * @param file
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	@Override
	public String importProjectDataExcel(File file, String fileName) throws Exception {
		String message = "Import success";
		//转换文件
		Sheet sheet = ParseExcelUtils.parseExcel(file, fileName);
		//解析数据
		List<TProjectData> projectDataList = getProjectDataExcelContent(sheet);
		for (TProjectData projectData : projectDataList) {
			//将集合中所有的数据存入到数据库中
			projectDataMapper.insert(projectData);
		}
		return message;
	}

	/**插入学科分类表数据到数据库
	 * @param file
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	@Override
	public String importSubjectExcel(File file, String fileName) throws Exception {
		String message = "Import success";
		Sheet sheet =ParseExcelUtils.parseExcel(file, fileName);
		List<TSubjectCategory> subjectCategoryList = getSubjectCategoryExcelContent(sheet);
		//将集合中所有的数据存入到数据库中
		for (TSubjectCategory subjectCategory : subjectCategoryList) {
			subjectCategoryMapper.insert(subjectCategory);
		}
		return message;
	}

	/**插入论文表(中文)数据到数据库
	 * @param file
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	@Override
	public String importThesisForChineseExcel(File file, String fileName) throws Exception {
		String message = "Import success";
		Sheet sheet =ParseExcelUtils.parseExcel(file, fileName);
		List<TThesisForChinese> thesisForChineseList = getTThesisForChineseContent(sheet);
		//将集合中所有的数据存入到数据库中
		for (TThesisForChinese thesisForChinese : thesisForChineseList) {
			thesisForChineseMapper.insert(thesisForChinese);
		}
		return message;
	}

	/**插入论文表(英文)数据到数据库
	 * @param file
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	@Override
	public String importThesisForEnglishExcel(File file, String fileName) throws Exception {
		String message = "Import success";
		Sheet sheet =ParseExcelUtils.parseExcel(file, fileName);
		List<TThesisForEnglish> thesisForChineseList = getTThesisForEnglishContent(sheet);
		//将集合中所有的数据存入到数据库中
		for (TThesisForEnglish thesisForEnglish : thesisForChineseList) {
			thesisForEnglishMapper.insert(thesisForEnglish);
		}
		return message;
	}

	/**插入图书表数据到数据库
	 * @param file
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	@Override
	public String importBooksExcel(File file, String fileName) throws Exception {
		String message = "Import success";
		Sheet sheet =ParseExcelUtils.parseExcel(file, fileName);
		List<TBooks> booksList = getBooksExcelContent(sheet);
		//将集合中所有的数据存入到数据库中
		for (TBooks books : booksList) {
			booksMapper.insert(books);
			System.out.println(books);
		}
		return message;
	}
	/**
	 * 插入专利表数据到数据库
	 */
	@Override
	public String importPatentExcel(File file, String fileName) throws Exception {
		String message = "Import success";
		Sheet sheet =ParseExcelUtils.parseExcel(file, fileName);
		List<TPatent> patentList = getPatentExcelContent(sheet);
		//将集合中所有的数据存入到数据库中
		for (TPatent patent : patentList) {
			patentMapper.insert(patent);
			System.out.println(patent);
		}
		return message;
	}

	/**插入地区表数据到数据库
	 * @param file
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	@Override
	public String importAreaExcel(File file, String fileName) throws Exception {
		String message = "Import success";
		Sheet sheet =ParseExcelUtils.parseExcel(file, fileName);
		List<TArea> areaList = getAreaExcelContent(sheet);

		//将集合中所有的数据存入到数据库中
		for (TArea area : areaList) {
			areaMapper.insert(area);
		}
		return message;
	}

	@Override
	public String importAreaAndCompanyExcel(File file, String fileName) throws Exception {
		String message = "Import success";
		Sheet sheet =ParseExcelUtils.parseExcel(file, fileName);
		List<TAreaAndCompany> areaAndCompanyList = getAreaAndCompanyExcelContent(sheet);

		//将集合中所有的数据存入到数据库中
		for (TAreaAndCompany areaAndCompany : areaAndCompanyList) {
			areaAndCompanyMapper.insert(areaAndCompany);
		}
		return message;
	}

	@Override
	public String importAreaAndCompanyExcelToUser(File file, String fileName) throws Exception {
		String message = "Import success";
		Sheet sheet =ParseExcelUtils.parseExcel(file, fileName);
		List<UUser> userList = getAreaAndCompanyExcelContentToUser(sheet);

		//将集合中所有的数据存入到数据库中
		for (UUser user : userList) {
			userDao.insert(user);
		}
		return message;
	}
	/**
	 * 解析(读取)Excel内容(TProjectData)
	 * @param sheet
	 * @return
	 */
	//告诉编译器忽略指定的警告，不用在编译完成后出现警告信息。
	@SuppressWarnings("static-access")
	public List<TProjectData> getProjectDataExcelContent(Sheet sheet)throws Exception{
		List<TProjectData> list = new ArrayList<TProjectData>();
		//行数
		int rowNumber = 0;
		//总行数
		int rowCount = sheet.getPhysicalNumberOfRows();
		if(rowCount>1){
			//标题行
			Row titleRow = sheet.getRow(0);
			//遍历行，略过标题行，从第二行开始
			for(int i=1;i<rowCount;i++){
				Row row = sheet.getRow(i);
				//跳过空行
				if(i>=1){
					if(row==null){continue;}
					else if(StringUtils.isEmpty(getValue(row.getCell(0)))&&StringUtils.isEmpty(getValue(row.getCell(1)))){
						continue;
					}
				}

				TProjectData projectData = new TProjectData();
				//行数
				rowNumber = row.getRowNum();
				System.out.println(rowNumber+1);
				//项目管理单位
				projectData.setManagementCompany(row.getCell(0).getStringCellValue());
				//项目级别
				projectData.setProjectCategoryGrade(row.getCell(1).getStringCellValue());
				//项目类别
				if(titleRow.getCell(2).getStringCellValue().indexOf("项目类别")>=0){
					if(row.getCell(2)!=null && row.getCell(2).getCellType()==row.getCell(2).CELL_TYPE_NUMERIC){
						row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
						projectData.setSubject(row.getCell(2).getStringCellValue().trim());
					}else if(row.getCell(2)!=null && row.getCell(2).getCellType()==row.getCell(2).CELL_TYPE_STRING){
						projectData.setSubject(row.getCell(2).getStringCellValue().trim());
					}
					if (projectData.getSubject() != null && projectData.getSubject().length() > 0) {
						//查询项目字典表里是否有修改的项目，如果有就不用重新添加新的项目，如果没有就新增新的项目类别
						TProjectCategoryExample example = new TProjectCategoryExample();
						TProjectCategoryExample.Criteria criteria = example.createCriteria();
						criteria.andProjectCategoryEqualTo(projectData.getSubject());
						List<TProjectCategory> projectCategoryList = projectCategoryMapper.selectByExample(example);

						if(projectCategoryList == null || projectCategoryList.size()<=0){
							TProjectCategory projectCategory = new TProjectCategory();
							projectCategory.setGrade(projectData.getProjectCategoryGrade());
							projectCategory.setProjectCategory(projectData.getSubject());
							projectCategory.setStatus("1");
							//将新增好的项目字典信息插入到数据库里
							projectCategoryMapper.insert(projectCategory);
						}
					}
				}

				//一级学科分类id
				if(titleRow.getCell(3).getStringCellValue().indexOf("一级学科分类id")>=0){
					if(row.getCell(3)!=null && row.getCell(3).getCellType()==row.getCell(3).CELL_TYPE_NUMERIC){
						row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
						projectData.setSubject1Id(row.getCell(3).getStringCellValue().trim());
					}else if(row.getCell(3)!=null && row.getCell(3).getCellType()==row.getCell(3).CELL_TYPE_STRING){
						projectData.setSubject1Id(row.getCell(3).getStringCellValue().trim());
					}
				}
				//二级学科分类id
				if(titleRow.getCell(4).getStringCellValue().indexOf("二级学科分类id")>=0){
					if(row.getCell(4)!=null && row.getCell(4).getCellType()==row.getCell(4).CELL_TYPE_NUMERIC){
						row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
						projectData.setSubject2Id(row.getCell(4).getStringCellValue().trim());
					}else if(row.getCell(4)!=null && row.getCell(4).getCellType()==row.getCell(4).CELL_TYPE_STRING){
						projectData.setSubject2Id(row.getCell(4).getStringCellValue().trim());
					}
				}
				//三级学科分类id
				if(titleRow.getCell(5).getStringCellValue().indexOf("三级学科分类id")>=0){
					if(row.getCell(5)!=null && row.getCell(5).getCellType()==row.getCell(5).CELL_TYPE_NUMERIC){
						row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
						projectData.setSubject3Id(row.getCell(5).getStringCellValue().trim());
					}else if(row.getCell(5)!=null && row.getCell(5).getCellType()==row.getCell(5).CELL_TYPE_STRING){
						projectData.setSubject3Id(row.getCell(5).getStringCellValue().trim());
					}
				}
				if(titleRow.getCell(6).getStringCellValue().indexOf("项目编号")>=0){
					long projectNum = 330100000000L;
					if(projectDataMapper.selectMaxProjectNum() != null && projectDataMapper.selectMaxProjectNum().length()>0){
						projectNum = Long.parseLong(projectDataMapper.selectMaxProjectNum());
					}
					projectNum += i;
					projectData.setProjectNum(""+(projectNum));
				}
				//项目名称
				projectData.setProjectName(row.getCell(7).getStringCellValue());
				//项目子类
				projectData.setProjectKidcat(row.getCell(8).getStringCellValue());
				//类目
				projectData.setCategory(row.getCell(9).getStringCellValue());
				//立项时间
				if(titleRow.getCell(10).getStringCellValue().indexOf("立项时间")>=0){
					Cell cell10 = row.getCell(10);
					//将double类型的数据转换未字符串，然后将字符串转换为date类型
					SimpleDateFormat format = new SimpleDateFormat("yyyy");
					if(cell10!=null && cell10.getCellType()==cell10.CELL_TYPE_NUMERIC){
						cell10.setCellType(Cell.CELL_TYPE_STRING);
						//将double转换为String
						String sDate=cell10.getStringCellValue().trim();
						//将String装换为Date
						Date date = format.parse(sDate);
						projectData.setProjectSatrtTime(date);
					}
				}
				//结题时间
				if(titleRow.getCell(11).getStringCellValue().indexOf("结题时间")>=0){
					Cell cell11 = row.getCell(11);
					//将double类型的数据转换未字符串，然后将字符串转换为date类型
					SimpleDateFormat format = new SimpleDateFormat("yyyy");
					if(cell11!=null && cell11.getCellType()==cell11.CELL_TYPE_NUMERIC){
						cell11.setCellType(Cell.CELL_TYPE_STRING);
						//将double转换为String
						String sDate=cell11.getStringCellValue().trim();
						//将String装换为Date
						Date date = format.parse(sDate);
						projectData.setProjectEndTime(date);
					}
				}
				//所在地区
				projectData.setArea(row.getCell(12).getStringCellValue());
				//第一承办单位
				String allOrganizerCompany = row.getCell(13).getStringCellValue();
				String[] organizerCompanys = allOrganizerCompany.split(",");
				//将第一个承办单位存到实体中
				projectData.setOrganizer(organizerCompanys[0]);
				//所有承办单位
				projectData.setOrganizerCompany(row.getCell(13).getStringCellValue());
				//项目负责人
				projectData.setProjectLeader(row.getCell(14).getStringCellValue());
				//团队成员
				projectData.setTeamMembers(row.getCell(15).getStringCellValue());
				//奖项级别
				projectData.setPrizeCategoryGrade(row.getCell(16).getStringCellValue());
				//奖项类别
				projectData.setPrizeCategory(row.getCell(17).getStringCellValue());
				if (projectData.getPrizeCategory() != null && projectData.getPrizeCategory().length() > 0) {
					//查询奖项字典表里是否有修改的奖项，如果有就不用重新添加新的奖项，如果没有就新增新的奖项类别
					TPrizeCategoryExample example = new TPrizeCategoryExample();
					TPrizeCategoryExample.Criteria criteria = example.createCriteria();
					criteria.andPrizeCategoryEqualTo(projectData.getPrizeCategory());
					List<TPrizeCategory> prizeCategoryList = prizeCategoryMapper.selectByExample(example);
					if(prizeCategoryList == null || prizeCategoryList.size()<=0) {
						TPrizeCategory prizeCategory = new TPrizeCategory();
						prizeCategory.setGrade(projectData.getPrizeCategoryGrade());
						prizeCategory.setPrizeCategory(projectData.getPrizeCategory());
						prizeCategory.setStatus("1");
						//将新增好的项目字典信息插入到数据库里
						prizeCategoryMapper.insert(prizeCategory);
					}
				}
				//奖项名称
				projectData.setPrizeName(row.getCell(18).getStringCellValue());
				//获奖时间
				if(titleRow.getCell(19).getStringCellValue().indexOf("获奖时间")>=0){
					Cell cell19 = row.getCell(19);
					//将double类型的数据转换未字符串，然后将字符串转换为date类型
					SimpleDateFormat format = new SimpleDateFormat("yyyy");
					if(cell19!=null && cell19.getCellType()==cell19.CELL_TYPE_NUMERIC){
						cell19.setCellType(Cell.CELL_TYPE_STRING);
						//将double转换为String
						String sDate=cell19.getStringCellValue().trim();
						//将String装换为Date
						Date date = format.parse(sDate);
						projectData.setPrizeTime(date);
					}
				}
				projectData.setStatus("1");
				//默认为未确认
				projectData.setConfirmPrizeStatus("2");
				projectData.setConfirmProjectStatus("2");
				list.add(projectData);
			}
		}
		return list;
	}
	/**
	 * 解析(读取)Excel内容(TThesisForChinese)
	 * @param sheet
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static List<TThesisForChinese> getTThesisForChineseContent(Sheet sheet) throws Exception{
		List<TThesisForChinese> list = new ArrayList<TThesisForChinese>();
		int rowCount = sheet.getPhysicalNumberOfRows();//总行数
		if(rowCount>1){
			Row titleRow = sheet.getRow(0);//标题行
			for(int i=1;i<rowCount;i++){//遍历行，略过标题行，从第二行开始
				Row row = sheet.getRow(i);
				/*if (row.getCell(0) != null && row.getCell(0).getCellType() == row.getCell(0).CELL_TYPE_NUMERIC) {
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				}*/
				//跳过空行
				if(i>=1){
					if(row==null){continue;}
					else if(StringUtils.isEmpty(getValue(row.getCell(0)))&&StringUtils.isEmpty(getValue(row.getCell(1)))){
						continue;
					}
				}
				TThesisForChinese thesis = new TThesisForChinese();
				//作者
				if(titleRow.getCell(0).getStringCellValue().indexOf("作者")>=0){
					if(row.getCell(0)!=null && row.getCell(0).getCellType()==row.getCell(0).CELL_TYPE_STRING){
						thesis.setAuthor(row.getCell(0).getStringCellValue().trim());
					}
				}
				//题名
				if(titleRow.getCell(1).getStringCellValue().indexOf("题名")>=0){
					if(row.getCell(1)!=null && row.getCell(1).getCellType()==row.getCell(1).CELL_TYPE_STRING){
						thesis.setTitle(row.getCell(1).getStringCellValue().trim());
					}
				}
				//文献来源
				if(titleRow.getCell(2).getStringCellValue().indexOf("文献来源")>=0){
					if(row.getCell(2)!=null && row.getCell(2).getCellType()==row.getCell(2).CELL_TYPE_STRING){
						thesis.setLiteratureResources(row.getCell(2).getStringCellValue().trim());
					}
				}
				//年
				if(titleRow.getCell(3).getStringCellValue().indexOf("年")>=0){
					if(row.getCell(3)!=null && row.getCell(3).getCellType()==row.getCell(3).CELL_TYPE_NUMERIC){
						row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
						thesis.setYear(row.getCell(3).getStringCellValue().trim());
					}else if(row.getCell(3)!=null && row.getCell(3).getCellType()==row.getCell(3).CELL_TYPE_STRING){
						thesis.setYear(row.getCell(3).getStringCellValue().trim());
					}
				}
				//卷
				if(titleRow.getCell(4).getStringCellValue().indexOf("卷")>=0){
					//卷有可能是纯数字
					if(row.getCell(4)!=null && row.getCell(4).getCellType()==row.getCell(4).CELL_TYPE_NUMERIC){
						row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
						thesis.setRoll(row.getCell(4).getStringCellValue().trim());
					}else if(row.getCell(4)!=null && row.getCell(4).getCellType()==row.getCell(4).CELL_TYPE_STRING){
						thesis.setRoll(row.getCell(4).getStringCellValue().trim());
					}
				}
				//期
				if(titleRow.getCell(5).getStringCellValue().indexOf("期")>=0){
					//卷有可能是纯数字
					if(row.getCell(5)!=null && row.getCell(5).getCellType()==row.getCell(5).CELL_TYPE_NUMERIC){
						row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
						thesis.setJournal(row.getCell(5).getStringCellValue().trim());
					}else if(row.getCell(5)!=null && row.getCell(5).getCellType()==row.getCell(5).CELL_TYPE_STRING){
						thesis.setJournal(row.getCell(5).getStringCellValue().trim());
					}
				}
				//页码
				if(titleRow.getCell(6).getStringCellValue().indexOf("页码")>=0){
					//页码有可能是纯数字
					if(row.getCell(6)!=null && row.getCell(6).getCellType()==row.getCell(6).CELL_TYPE_NUMERIC){
						row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
						thesis.setPage(row.getCell(6).getStringCellValue().trim());
					}else if(row.getCell(6)!=null && row.getCell(6).getCellType()==row.getCell(6).CELL_TYPE_STRING){
						thesis.setPage(row.getCell(6).getStringCellValue().trim());
					}
				}
				//ISSN
				if(titleRow.getCell(7).getStringCellValue().indexOf("ISSN")>=0){
					if(row.getCell(7)!=null && row.getCell(7).getCellType()==row.getCell(7).CELL_TYPE_NUMERIC){
						row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
						thesis.setIssn(row.getCell(7).getStringCellValue().trim());
					}else if(row.getCell(7)!=null && row.getCell(7).getCellType()==row.getCell(7).CELL_TYPE_STRING){
						thesis.setIssn(row.getCell(7).getStringCellValue().trim());
					}
				}
				//机构（作者单位）
				if(titleRow.getCell(8).getStringCellValue().indexOf("机构")>=0){
					if(row.getCell(8)!=null && row.getCell(8).getCellType()==row.getCell(8).CELL_TYPE_STRING){
						thesis.setAuthorCompany(row.getCell(8).getStringCellValue().trim());
					}
				}
				if(titleRow.getCell(9).getStringCellValue().indexOf("所属地区")>=0){
					if(row.getCell(9)!=null && row.getCell(9).getCellType()==row.getCell(9).CELL_TYPE_STRING){
						thesis.setArea(row.getCell(9).getStringCellValue().trim());
					}
				}
				//DOI
				if(titleRow.getCell(10).getStringCellValue().indexOf("DOI")>=0){
					if(row.getCell(10)!=null && row.getCell(10).getCellType()==row.getCell(10).CELL_TYPE_NUMERIC){
						row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
						thesis.setDoi(row.getCell(10).getStringCellValue().trim());
					}else if(row.getCell(10)!=null && row.getCell(10).getCellType()==row.getCell(10).CELL_TYPE_STRING){
						thesis.setDoi(row.getCell(10).getStringCellValue().trim());
					}
				}
				thesis.setStatus("1");
				thesis.setConfirmStatus("2");
				list.add(thesis);
			}
			System.out.println(list);
		}
		return list;
	}

	/**
	 * 解析(读取)Excel内容(TThesisForEnglish)
	 * @param sheet
	 * @return
	 */
	@SuppressWarnings("static-access")
	public List<TThesisForEnglish> getTThesisForEnglishContent(Sheet sheet) throws Exception{
		List<TThesisForEnglish> list = new ArrayList<TThesisForEnglish>();
		int rowCount = sheet.getPhysicalNumberOfRows();//总行数
		if(rowCount>1){
			Row titleRow = sheet.getRow(0);//标题行
			for(int i=1;i<rowCount;i++){//遍历行，略过标题行，从第二行开始
				Row row = sheet.getRow(i);
				//跳过空行
				if(i>=1){
					if(row==null){continue;}
					else if(StringUtils.isEmpty(getValue(row.getCell(0)))&&StringUtils.isEmpty(getValue(row.getCell(1)))){
						continue;
					}
				}
				TThesisForEnglish thesis = new TThesisForEnglish();
				if(titleRow.getCell(0).getStringCellValue().indexOf("文献")>=0){
					if(row.getCell(0)!=null && row.getCell(0).getCellType()==row.getCell(0).CELL_TYPE_STRING){
						//在数据库中查询出标题行，如果标题行和现在的标题相同，则定义为重名的数据、须进行去重，则不存入到数据库中。
						//但是这种去重方式存在效率底下的问题
						//还有一种方式就是数据库去重
						thesis.setTitle(row.getCell(0).getStringCellValue().trim());
					}
				}
				//作者
				if(titleRow.getCell(1).getStringCellValue().indexOf("作者")>=0){
					if(row.getCell(1)!=null && row.getCell(1).getCellType()==row.getCell(1).CELL_TYPE_STRING){
						thesis.setAuthor(row.getCell(1).getStringCellValue().trim());
					}
				}
				//DOI
				if(titleRow.getCell(2).getStringCellValue().indexOf("DOI")>=0){
					if(row.getCell(2)!=null && row.getCell(2).getCellType()==row.getCell(2).CELL_TYPE_NUMERIC){
						row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
						thesis.setDoi(row.getCell(2).getStringCellValue().trim());
					}else if(row.getCell(2)!=null && row.getCell(2).getCellType()==row.getCell(2).CELL_TYPE_STRING){
						thesis.setDoi(row.getCell(2).getStringCellValue().trim());
					}
				}
				//期刊名称
				if(titleRow.getCell(3).getStringCellValue().indexOf("期刊名称")>=0){
					if(row.getCell(3)!=null && row.getCell(3).getCellType()==row.getCell(3).CELL_TYPE_STRING){
						thesis.setJournalName(row.getCell(3).getStringCellValue().trim());
					}
				}
				//ISSN
				if(titleRow.getCell(4).getStringCellValue().indexOf("ISSN")>=0){
					if(row.getCell(4)!=null && row.getCell(4).getCellType()==row.getCell(4).CELL_TYPE_NUMERIC){
						row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
						thesis.setIssn(row.getCell(4).getStringCellValue().trim());
					}else if(row.getCell(4)!=null && row.getCell(4).getCellType()==row.getCell(4).CELL_TYPE_STRING){
						thesis.setIssn(row.getCell(4).getStringCellValue().trim());
					}
				}
				//年
				if(titleRow.getCell(5).getStringCellValue().indexOf("年")>=0){
					if(row.getCell(5)!=null && row.getCell(5).getCellType()==row.getCell(5).CELL_TYPE_NUMERIC){
						row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
						thesis.setYear(row.getCell(5).getStringCellValue().trim());
					}else if(row.getCell(5)!=null && row.getCell(5).getCellType()==row.getCell(5).CELL_TYPE_STRING){
						thesis.setYear(row.getCell(5).getStringCellValue().trim());
					}
				}
				//卷
				if(titleRow.getCell(6).getStringCellValue().indexOf("卷")>=0){
					//卷有可能是纯数字
					if(row.getCell(6)!=null && row.getCell(6).getCellType()==row.getCell(6).CELL_TYPE_NUMERIC){
						row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
						thesis.setRoll(row.getCell(6).getStringCellValue().trim());
					}else if(row.getCell(6)!=null && row.getCell(6).getCellType()==row.getCell(6).CELL_TYPE_STRING){
						thesis.setRoll(row.getCell(6).getStringCellValue().trim());
					}
				}
				//期
				if(titleRow.getCell(7).getStringCellValue().indexOf("期")>=0){
					//卷有可能是纯数字
					if(row.getCell(7)!=null && row.getCell(7).getCellType()==row.getCell(7).CELL_TYPE_NUMERIC){
						row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
						thesis.setJournal(row.getCell(7).getStringCellValue().trim());
					}else if(row.getCell(7)!=null && row.getCell(7).getCellType()==row.getCell(7).CELL_TYPE_STRING){
						thesis.setJournal(row.getCell(7).getStringCellValue().trim());
					}
				}
				//页码
				if(titleRow.getCell(8).getStringCellValue().indexOf("页")>=0){
					//页码有可能是纯数字
					if(row.getCell(8)!=null && row.getCell(8).getCellType()==row.getCell(8).CELL_TYPE_NUMERIC){
						row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
						thesis.setPage(row.getCell(8).getStringCellValue().trim());
					}else if(row.getCell(8)!=null && row.getCell(8).getCellType()==row.getCell(8).CELL_TYPE_STRING){
						thesis.setPage(row.getCell(8).getStringCellValue().trim());
					}
				}
				//作者单位
				if(titleRow.getCell(9).getStringCellValue().indexOf("作者单位")>=0){
					if(row.getCell(9)!=null && row.getCell(9).getCellType()==row.getCell(9).CELL_TYPE_STRING){
						thesis.setAuthorCompany(row.getCell(9).getStringCellValue().trim());
					}
				}
				//thesis.setArea("宁波市");
				if(titleRow.getCell(10).getStringCellValue().indexOf("所属地区")>=0){
					//所属地区根据作者单位进行填写
					/*String authorCompany = thesis.getAuthorCompany();
					List<String> areaOrCompanyList = areaMapper.selectAllAreaOrCompany();
					for (String areaOrCompany:areaOrCompanyList) {
						System.out.println(areaOrCompany);
					}*/
					if(row.getCell(10)!=null && row.getCell(10).getCellType()==row.getCell(10).CELL_TYPE_STRING){
						thesis.setArea(row.getCell(10).getStringCellValue().trim());
					}
				}
				//作者地址
				/*if(titleRow.getCell(11).getStringCellValue().indexOf("作者地址")>=0){
					if(row.getCell(11)!=null && row.getCell(11).getCellType()==row.getCell(11).CELL_TYPE_STRING){
						thesis.setAuthorsAddress(row.getCell(11).getStringCellValue().trim());
					}
				}
				//文摘
				if(titleRow.getCell(12).getStringCellValue().indexOf("文摘")>=0){
					if(row.getCell(12)!=null && row.getCell(12).getCellType()==row.getCell(12).CELL_TYPE_STRING){
						thesis.setAbstracts(row.getCell(12).getStringCellValue().trim());
					}
				}*/
				thesis.setStatus("1");
				thesis.setConfirmStatus("2");
				list.add(thesis);
			}
		}
		return list;
	}
	/**
	 * 解析(读取)Excel内容(TSubjectCategory)
	 * @param sheet
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static List<TSubjectCategory> getSubjectCategoryExcelContent(Sheet sheet) {
		List<TSubjectCategory> list = new ArrayList<TSubjectCategory>();
		int rowCount = sheet.getPhysicalNumberOfRows();//总行数
		if (rowCount > 1) {
			Row titleRow = sheet.getRow(0);//标题行
			for (int i = 1; i < rowCount; i++) {//遍历行，略过标题行，从第二行开始
				Row row = sheet.getRow(i);
				if (row.getCell(0) != null && row.getCell(0).getCellType() == row.getCell(0).CELL_TYPE_NUMERIC) {
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				}
				if (row.getCell(1) != null && row.getCell(1).getCellType() == row.getCell(1).CELL_TYPE_NUMERIC) {
					row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				}

				//跳过空行
				if(i>=1){
					if(row==null){continue;}
					else if(StringUtils.isEmpty(getValue(row.getCell(0)))&&StringUtils.isEmpty(getValue(row.getCell(1)))){
						continue;
					}
				}

				TSubjectCategory entity = new TSubjectCategory();

				if (titleRow.getCell(0).getStringCellValue().indexOf("学科编号") >= 0) {
					entity.setSubjectId(row.getCell(0).getStringCellValue().trim());
				}

				if (titleRow.getCell(1).getStringCellValue().indexOf("所属学科编号") >= 0) {
					entity.setParentSubjectId(row.getCell(1).getStringCellValue().trim());
				}

				if (titleRow.getCell(2).getStringCellValue().indexOf("学科名称") >= 0) {
					if (row.getCell(2) != null && row.getCell(2).getCellType() == row.getCell(1).CELL_TYPE_STRING) {
						entity.setSubjectName(row.getCell(2).getStringCellValue().trim());
					}
				}
				entity.setStatus("1");

				list.add(entity);
				System.out.println(list);
			}
		}
		return list;
	}
	/**
	 * 解析(读取)Excel内容(TBooks)
	 * @param sheet
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static List<TBooks> getBooksExcelContent (Sheet sheet) throws Exception {
		List<TBooks> list = new ArrayList<TBooks>();
		int rowCount = sheet.getPhysicalNumberOfRows();//总行数
		if (rowCount > 1) {
			Row titleRow = sheet.getRow(0);//标题行

			for (int i = 1; i < rowCount; i++) {//遍历行，略过标题行，从第二行开始
				Row row = sheet.getRow(i);
				if (row.getCell(0) != null && row.getCell(0).getCellType() == row.getCell(0).CELL_TYPE_NUMERIC) {
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				}
				//跳过空行
				if(i>=1){
					if(row==null){continue;}
					else if(StringUtils.isEmpty(getValue(row.getCell(0)))&&StringUtils.isEmpty(getValue(row.getCell(1)))){
						continue;
					}
				}
				TBooks books = new TBooks();
				if (titleRow.getCell(0).getStringCellValue().indexOf("作者") >= 0) {
					if (row.getCell(0) != null && row.getCell(0).getCellType() == row.getCell(0).CELL_TYPE_STRING) {
						books.setAuthor(row.getCell(0).getStringCellValue().trim());
					}
				}
				if (titleRow.getCell(1).getStringCellValue().indexOf("标题") >= 0) {
					if (row.getCell(1) != null && row.getCell(1).getCellType() == row.getCell(1).CELL_TYPE_STRING) {
						books.setTitle(row.getCell(1).getStringCellValue().trim());
					}
				}
				if (titleRow.getCell(2).getStringCellValue().indexOf("出版社") >= 0) {
					if (row.getCell(2) != null && row.getCell(2).getCellType() == row.getCell(2).CELL_TYPE_STRING) {
						books.setPublisher(row.getCell(2).getStringCellValue().trim());
					}
				}

				if (titleRow.getCell(3).getStringCellValue().indexOf("时间") >= 0) {
					Cell cell3 = row.getCell(3);
					//将double类型的数据转换未字符串，然后将字符串转换为date类型
					SimpleDateFormat format = new SimpleDateFormat("yyyy");
					if (cell3 != null && cell3.getCellType() == cell3.CELL_TYPE_NUMERIC) {
						cell3.setCellType(Cell.CELL_TYPE_STRING);
						//将double转换为String
						String sDate = cell3.getStringCellValue().trim();
						//将String装换为Date
						Date date = format.parse(sDate);
						books.setTime(date);
					}
				}
				if (titleRow.getCell(4).getStringCellValue().indexOf("项目编号") >= 0) {
					//项目编号有可能是纯数字
					if (row.getCell(4) != null && row.getCell(4).getCellType() == row.getCell(4).CELL_TYPE_NUMERIC) {
						row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
						books.setProjectNum(row.getCell(4).getStringCellValue().trim());
					} else if (row.getCell(4) != null && row.getCell(4).getCellType() == row.getCell(4).CELL_TYPE_STRING) {
						books.setProjectNum(row.getCell(4).getStringCellValue().trim());
					}
				}

				if (titleRow.getCell(5).getStringCellValue().indexOf("所属地区") >= 0) {
					if (row.getCell(5) != null && row.getCell(5).getCellType() == row.getCell(5).CELL_TYPE_STRING) {
						books.setArea(row.getCell(5).getStringCellValue().trim());
					}
				}
				if (titleRow.getCell(6).getStringCellValue().indexOf("作者单位") >= 0) {
					if (row.getCell(6) != null && row.getCell(6).getCellType() == row.getCell(5).CELL_TYPE_STRING) {
						books.setAuthorCompany(row.getCell(6).getStringCellValue().trim());
					}
				}
				books.setStatus("1");
				//将数据添加到集合中
				list.add(books);

			}
			System.out.println(list);
		}
		return list;
	}
	/**
	 * 解析(读取)Excel内容(TPatent)
	 * @param sheet
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static List<TPatent> getPatentExcelContent (Sheet sheet) throws Exception {
		List<TPatent> list = new ArrayList<TPatent>();
		int rowCount = sheet.getPhysicalNumberOfRows();//总行数

		if (rowCount > 1) {
			Row titleRow = sheet.getRow(0);//标题行
			for(int i=1;i<rowCount;i++){//遍历行，略过标题行，从第二行开始
				Row row = sheet.getRow(i);
				//跳过空行
				if(i>=1){
					if(row==null){continue;}
					else if(StringUtils.isEmpty(getValue(row.getCell(0)))&&StringUtils.isEmpty(getValue(row.getCell(1)))){
						continue;
					}
				}
				TPatent patent = new TPatent();
				//第一发明人
				if (titleRow.getCell(0).getStringCellValue().indexOf("第一发明人") >= 0) {
					if (row.getCell(0) != null && row.getCell(0).getCellType() == row.getCell(0).CELL_TYPE_STRING) {
						patent.setFirstInvento(row.getCell(0).getStringCellValue().trim());
					}
				}
				if (titleRow.getCell(1).getStringCellValue().indexOf("其他发明人") >= 0) {
					if (row.getCell(1) != null && row.getCell(1).getCellType() == row.getCell(1).CELL_TYPE_STRING) {
						patent.setOtherInventors(row.getCell(1).getStringCellValue().trim());
					}
				}
				if (titleRow.getCell(2).getStringCellValue().indexOf("第一发明人单位") >= 0) {
					if (row.getCell(2) != null && row.getCell(2).getCellType() == row.getCell(2).CELL_TYPE_STRING) {
						patent.setFirstInventoCompany(row.getCell(2).getStringCellValue().trim());
					}
				}

				if (titleRow.getCell(3).getStringCellValue().indexOf("专利名称") >= 0) {
					if (row.getCell(3) != null && row.getCell(3).getCellType() == row.getCell(3).CELL_TYPE_STRING) {
						patent.setPatentName(row.getCell(3).getStringCellValue().trim());
					}
				}
				//专利权人	专利申请日	授权公告日	专利类别
				if (titleRow.getCell(4).getStringCellValue().indexOf("专利权人") >= 0) {
					if (row.getCell(4) != null && row.getCell(4).getCellType() == row.getCell(4).CELL_TYPE_STRING) {
						patent.setPatentee(row.getCell(4).getStringCellValue().trim());
					}
				}
				if (titleRow.getCell(5).getStringCellValue().indexOf("专利申请日") >= 0) {
					if(row.getCell(5)!=null && row.getCell(5).getCellType()==row.getCell(5).CELL_TYPE_NUMERIC){
						row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
						patent.setPatentApplicationDate(row.getCell(5).getStringCellValue().trim());
					}else if(row.getCell(5)!=null && row.getCell(5).getCellType()==row.getCell(5).CELL_TYPE_STRING){
						patent.setPatentApplicationDate(row.getCell(5).getStringCellValue().trim());
					}
				}

				if (titleRow.getCell(6).getStringCellValue().indexOf("授权公告日") >= 0) {
					if(row.getCell(6)!=null && row.getCell(6).getCellType()==row.getCell(6).CELL_TYPE_NUMERIC){
						row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
						patent.setAuthorizedAnnouncementDate(row.getCell(6).getStringCellValue().trim());
					}else if(row.getCell(6)!=null && row.getCell(6).getCellType()==row.getCell(6).CELL_TYPE_STRING){
						patent.setAuthorizedAnnouncementDate(row.getCell(6).getStringCellValue().trim());
					}
				}
				if (titleRow.getCell(7).getStringCellValue().indexOf("专利类别") >= 0) {
					if (row.getCell(7) != null && row.getCell(7).getCellType() == row.getCell(7).CELL_TYPE_STRING) {
						patent.setPatentCategory(row.getCell(7).getStringCellValue().trim());
					}
				}
				//证书号	专利号	专利代理机构名称	登记时间
				if (titleRow.getCell(8).getStringCellValue().indexOf("证书号") >= 0) {
					if(row.getCell(8)!=null && row.getCell(8).getCellType()==row.getCell(8).CELL_TYPE_NUMERIC){
						row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
						patent.setCertificateNum(row.getCell(8).getStringCellValue().trim());
					}else if(row.getCell(8)!=null && row.getCell(8).getCellType()==row.getCell(8).CELL_TYPE_STRING){
						patent.setCertificateNum(row.getCell(8).getStringCellValue().trim());
					}
				}
				if (titleRow.getCell(9).getStringCellValue().indexOf("专利号") >= 0) {
					if(row.getCell(9)!=null && row.getCell(9).getCellType()==row.getCell(9).CELL_TYPE_NUMERIC){
						row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
						patent.setPatentNum(row.getCell(9).getStringCellValue().trim());
					}else if(row.getCell(9)!=null && row.getCell(9).getCellType()==row.getCell(9).CELL_TYPE_STRING){
						patent.setPatentNum(row.getCell(9).getStringCellValue().trim());
					}
				}
				if (titleRow.getCell(10).getStringCellValue().indexOf("专利代理机构名称") >= 0) {
					if (row.getCell(10) != null && row.getCell(10).getCellType() == row.getCell(10).CELL_TYPE_STRING) {
						patent.setPatentAgencyName(row.getCell(10).getStringCellValue().trim());
					}
				}
				if (titleRow.getCell(11).getStringCellValue().indexOf("登记时间") >= 0) {
					if(row.getCell(11)!=null && row.getCell(11).getCellType()==row.getCell(11).CELL_TYPE_NUMERIC){
						row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
						patent.setRegistTime(row.getCell(11).getStringCellValue().trim());
					}else if(row.getCell(11)!=null && row.getCell(11).getCellType()==row.getCell(11).CELL_TYPE_STRING){
						patent.setRegistTime(row.getCell(11).getStringCellValue().trim());
					}
				}
				if (titleRow.getCell(12).getStringCellValue().indexOf("所属地区") >= 0) {
					if (row.getCell(12) != null && row.getCell(12).getCellType() == row.getCell(12).CELL_TYPE_STRING) {
						patent.setArea(row.getCell(12).getStringCellValue().trim());
					}
				}
				patent.setStatus("1");
				patent.setConfirmStatus("2");
				//将数据添加到集合中
				list.add(patent);

			}
			System.out.println(list);
		}
		return list;
	}

	/**
	 * 解析(读取)Excel内容(TArea)根据父id进行查询
	 * @param sheet
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static List<TArea> getAreaExcelContent (Sheet sheet) throws Exception {
		List<TArea> list = new ArrayList<TArea>();
		int rowCount = sheet.getPhysicalNumberOfRows();//总行数
		if (rowCount > 1) {
			Row titleRow = sheet.getRow(0);//标题行
			for (int i = 1; i < rowCount; i++) {//遍历行，略过标题行，从第二行开始
				Row row = sheet.getRow(i);
				//跳过空行
				if(i>=1){
					if(row==null){continue;}
					else if(StringUtils.isEmpty(getValue(row.getCell(0)))&&StringUtils.isEmpty(getValue(row.getCell(1)))){
						continue;
					}
				}
				TArea entity = new TArea();

				if (titleRow.getCell(0).getStringCellValue().indexOf("地区编号") >= 0) {
					if (row.getCell(0) != null && row.getCell(0).getCellType() == row.getCell(0).CELL_TYPE_NUMERIC) {
						row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
						entity.setAreaId(row.getCell(0).getStringCellValue().trim());
					} else if (row.getCell(0) != null && row.getCell(0).getCellType() == row.getCell(0).CELL_TYPE_STRING) {
						entity.setAreaId(row.getCell(0).getStringCellValue().trim());
					}
				}

				if (titleRow.getCell(1).getStringCellValue().indexOf("所属地区编号") >= 0) {
					if (row.getCell(1) != null && row.getCell(1).getCellType() == row.getCell(1).CELL_TYPE_NUMERIC) {
						row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
						entity.setParentAreaId(row.getCell(1).getStringCellValue().trim());
					} else if (row.getCell(1) != null && row.getCell(1).getCellType() == row.getCell(1).CELL_TYPE_STRING) {
						entity.setParentAreaId(row.getCell(1).getStringCellValue().trim());
					}
				}

				if (titleRow.getCell(2).getStringCellValue().indexOf("地区(单位)名称") >= 0) {
					if (row.getCell(2) != null && row.getCell(2).getCellType() == row.getCell(2).CELL_TYPE_STRING) {
						entity.setAreaOrCompany(row.getCell(2).getStringCellValue().trim());
					}
				}
				entity.setStatus("1");
				list.add(entity);

			}
		}
		return list;

	}

	/**
	 * 解析(读取)Excel内容(TAreaAndCompany)根据单位匹配所属地区
	 * @param sheet
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static List<TAreaAndCompany> getAreaAndCompanyExcelContent (Sheet sheet) throws Exception {
		List<TAreaAndCompany> list = new ArrayList<TAreaAndCompany>();
		int rowCount = sheet.getPhysicalNumberOfRows();//总行数
		if (rowCount > 1) {
			Row titleRow = sheet.getRow(0);//标题行
			for (int i = 1; i < rowCount; i++) {//遍历行，略过标题行，从第二行开始
				Row row = sheet.getRow(i);
				//跳过空行
				if(i>=1){
					if(row==null){continue;}
					else if(StringUtils.isEmpty(getValue(row.getCell(0)))&&StringUtils.isEmpty(getValue(row.getCell(1)))){
						continue;
					}
				}
				TAreaAndCompany entity = new TAreaAndCompany();

				if (titleRow.getCell(0).getStringCellValue().indexOf("地市") >= 0) {
					if (row.getCell(0) != null && row.getCell(0).getCellType() == row.getCell(0).CELL_TYPE_STRING) {
						entity.setCity(row.getCell(0).getStringCellValue().trim());
					}
				}

				if (titleRow.getCell(1).getStringCellValue().indexOf("区县") >= 0) {
					if (row.getCell(1) != null && row.getCell(1).getCellType() == row.getCell(1).CELL_TYPE_STRING) {
						entity.setDistrict(row.getCell(1).getStringCellValue().trim());
					}
				}

				if (titleRow.getCell(2).getStringCellValue().indexOf("单位") >= 0) {
					if (row.getCell(2) != null && row.getCell(2).getCellType() == row.getCell(2).CELL_TYPE_STRING) {
						entity.setCompany(row.getCell(2).getStringCellValue().trim());
					}
				}
				entity.setStatus("1");
				list.add(entity);
			}
		}
		return list;
	}

	/**
	 * 解析(读取)Excel内容(UUser)将地区表的部分信息插入到用户表中
	 * @param sheet
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static List<UUser> getAreaAndCompanyExcelContentToUser (Sheet sheet) throws Exception {
		List<UUser> list = new ArrayList<UUser>();
		int rowCount = sheet.getPhysicalNumberOfRows();//总行数
		if (rowCount > 1) {
			Row titleRow = sheet.getRow(0);//标题行
			for (int i = 1; i < rowCount; i++) {//遍历行，略过标题行，从第二行开始
				Row row = sheet.getRow(i);
				//跳过空行
				if(i>=1){
					if(row==null){continue;}
					else if(StringUtils.isEmpty(getValue(row.getCell(0)))&&StringUtils.isEmpty(getValue(row.getCell(1)))){
						continue;
					}
				}
				UUser entity = new UUser();

				if (titleRow.getCell(0).getStringCellValue().indexOf("地市") >= 0) {
					if (row.getCell(0) != null && row.getCell(0).getCellType() == row.getCell(0).CELL_TYPE_STRING) {
						entity.setArea(row.getCell(0).getStringCellValue().trim());
					}
				}


				if (titleRow.getCell(2).getStringCellValue().indexOf("单位") >= 0) {
					if (row.getCell(2) != null && row.getCell(2).getCellType() == row.getCell(2).CELL_TYPE_STRING) {
						entity.setUsername(row.getCell(2).getStringCellValue().trim());
						entity.setCompany(row.getCell(2).getStringCellValue().trim());
					}
				}
				entity.setPswd("123456");
				entity.setStatus("1");
				list.add(entity);
			}
		}
		return list;
	}
}