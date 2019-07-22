package com.boku.www;

import com.boku.www.mapper.TAreaAndCompanyMapper;
import com.boku.www.mapper.system.UUserDao;
import com.boku.www.mapper.system.UUserRoleDao;
import com.boku.www.pojo.TThesisForEnglish;
import com.boku.www.pojo.system.UUserRole;
import com.boku.www.service.*;
import com.boku.www.service.system.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class MybatisTest {

	@Autowired
	private ThesisForChineseService thesisForChineseService;

	@Autowired
	private ProjectDataService projectDataService;

	@Autowired
	private PrizeDataService prizeDataService;

	@Autowired
	private ExcelImportAndBuildService excelImportAndBuildService;

	@Autowired
	private ThesisForEnglishService thesisForEnglishService;

	@Autowired
	private TAreaAndCompanyMapper areaAndCompanyMapper;

	@Autowired
	private UUserRoleDao userRoleDao;

	@Autowired
	private UserService userService;
	@Test
	public void test2() throws Exception {
		//String filePath = "E:\\模板.xls";
		String filePath = "E:\\healthybigdata\\2019年5月20日飞蝶给的数据\\浙江省自然基金项目.xlsx";
		File file = new File(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportAndBuildService.importProjectDataExcel(file, fileName);
		System.out.println(message);
	}
	/*@Test
	public void test3() throws Exception {
		//String filePath = "E:\\模板.xls";
		String filePath = "E:\\奖励数据表.xlsx";
		File file = new File(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportAndBuildService.importPrizeDataExcel(file, fileName);
		System.out.println(message);
	}*/

	/*@Test
	public void test2() throws Exception {
		UUserRole userRole = new UUserRole();

		for (int i = 1;i<=404; i++) {
			userRole.setUid(i);
			userRoleDao.insert(userRole);
		}
	}*/
	/*@Test
	public void test4() throws Exception {
		String filePath = "E:\\学科表.xls";
		File file = new File(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportAndBuildService.importSubjectExcel(file, fileName);
		System.out.println(message);
	}*/

	/*@Test
	public void test5() throws Exception {
		String filePath = "E:\\知网（空白）.xlsx";
		File file = new File(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportAndBuildService.importThesisForChineseExcel(file, fileName);
		System.out.println(message);
	}
*/
	/*@Test
	public void test6() throws Exception {
		String filePath = "E:\\论文（英文数据清洗）\\数据清洗20180210卢.xlsx";
		File file = new File(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportAndBuildService.importThesisForEnglishExcel(file, fileName);

		System.out.println(message);
	}*/

	/*@Test
	public void test() throws Exception {

		List<TThesisForEnglish> thesisForEnglishList = thesisForEnglishService.findAll();
		for (TThesisForEnglish thesisForEnglish: thesisForEnglishList) {
			String area = thesisForEnglish.getAuthorCompany();
			String company = null;
			HashSet<String> companySet = new HashSet<String>();
			if(area!=null && area.length()>0){
				String[] splits = area.split("；");
				if(splits!=null || (splits==null && splits.length!=0)){

					List<String> allCompany = areaAndCompanyMapper.selectAllCompany();
					for (String a: splits) {
						//System.out.println(a);
						String[] b = a.split("，");
						for (String d: b) {
							//System.out.println(d);
							d = d.replaceAll("[a-zA-Z0-9@#/]","" );
							for (String c: allCompany) {
								if(d.contains(c)){
									companySet.add(d);
								}else if(d.length()>4){
									companySet.add(d);
								}
							}
						}
					}
				}
			}
			for (String str : companySet) {
				company += str+";";
				thesisForEnglish.setAuthorCompany(company);
			}
			//thesisForEnglish.setAuthorCompany();
			//System.out.println("单位："+company);
			thesisForEnglishService.update(thesisForEnglish);
		}

	}
*/
	/*@Test
	public void test6() throws Exception {
		String filePath = "E:\\图书表.xls";
		File file = new File(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportAndBuildService.importBooksExcel(file, fileName);
		System.out.println(message);
	}*/


	/*@Test
	public void test10() throws Exception {
		String filePath = "E:\\地区单位表.xls";
		File file = new File(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportAndBuildService.importAreaExcel(file, fileName);
		System.out.println(message);
	}*/
	@Test
	public void test10() throws Exception {
		String filePath = "E:\\地区表.xlsx";
		File file = new File(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportAndBuildService.importAreaAndCompanyExcel(file, fileName);
		System.out.println(message);
	}
	/*@Test
	public void addCommpanyId() throws Exception {
		thesisForChineseService.addCommpanyId();
		System.out.println("添加成功");
	}
	@Test
	*//**
	 * 给用户的单位添加单位id
	 *//*
	public void addUnitId(){
		try {
			userService.addUnitId();
		}catch (Exception e){
			e.printStackTrace();
		}
	}*/
	@Test
	/**
	 * 清理项目数据的单位信息
	 */
	public void cleanProjectData(){
		try {
			projectDataService.cleanProjectData();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	/**
	 * 清理奖励数据的单位信息，并添加单位id
	 */
	public void cleanPrizeData(){
		try {
			prizeDataService.cleanPrizeData();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	/**
	 * 替换奖励数据的单位信息，并添加单位id
	 */
	public void repeatPrizeDataCompany(){

		try {
			String filePath = "E:\\healthybigdata\\奖励数据替换单位.xlsx";
			File file = new File(filePath);
			//截取字符串名称
			String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
			System.out.println(fileName);
			prizeDataService.repeatCompany(file, fileName);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	/**
	 * 替换奖励数据的单位信息，并添加单位id
	 */
	public void insertPrizeCompanyAndArea(){
		try {
			prizeDataService.insertCompanyAndArea();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	/**
	 * 清理奖励数据的单位信息，并添加单位id
	 */
	public void cleanThesisForEnglish(){
		try {
			thesisForEnglishService.cleanThesisForEnglish();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void test11() throws Exception {
		String filePath = "E:\\地区表.xlsx";
		File file = new File(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportAndBuildService.importAreaAndCompanyExcelToUser(file, fileName);
		System.out.println(message);
	}
	@Test
	public void test12() throws Exception {
		File file=new File("E:\\healthybigdata\\2019年5月20日飞蝶给的数据\\2004-2018职称系统信息（删减版+）");
		File[] files=file.listFiles();

		for(File a:files) {
			String filePath = a.getAbsolutePath();
			System.out.println(filePath);
			File myFile = new File(filePath);

			//截取字符串名称
			String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
			System.out.println(fileName);
			String message = excelImportAndBuildService.importUser(myFile, fileName);
			System.out.println(message);
		}

	}
	@Test
	public void test13() throws Exception {
		String filePath = "E:\\healthybigdata\\2019年5月20日飞蝶给的数据\\2004-2018职称系统信息（删减版+）\\作者单位.xlsx";
		File file = new File(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportAndBuildService.repeatUserCompany(file, fileName);
		System.out.println(message);
	}
	@Test
	public void addPersonUser(){
		try {
			userService.addPersonUser();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void countTheNumberOfThesisForChineseInEachCompany(){
		try {
			thesisForChineseService.selectBeforeTwentieth();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void updateThiesis(){
		try {

			String filePath = "E:\\healthybigdata\\recordHashMap2File.txt";
			File file = new File(filePath);
			//截取字符串名称
			//String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
			//System.out.println(fileName);
			thesisForChineseService.updateThiesis(file, filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void cleanRepateArea(){
		try {

			thesisForChineseService.cleanRepateArea();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*@Test
	public void test9() throws Exception {
		String filePath = "E:\\专利数据（张老师）.xlsx";
		File file = new File(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportAndBuildService.importPatentExcel(file, fileName);
		System.out.println(message);
	}*/
	/*@Test
	public void test8() throws Exception {
		Integer a = null;
		if(a!=null){
		System.out.println("不为null");
		}else{
		System.out.println("null");
		}
	}*/

	@Test
	public void repeatCompany() throws Exception {
		String filePath = "E:\\healthybigdata\\项目数据替换单位.xlsx";
		File file = new File(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		projectDataService.repeatCompany(file, fileName);
	}
	@Test
	public void insertCompanyAndArea() throws Exception {
		projectDataService.insertCompanyAndArea();
	}

	@Test
	public void getData() throws Exception {
		thesisForEnglishService.getThesisForEnglishFromSolr();
	}
	@Test
	public void insertAuthorNetwork() {
		try {
			thesisForChineseService.insertAuthorNetwork();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void selectAuthorNetwork() {
		try {
			long l = System.currentTimeMillis();
			thesisForChineseService.selectAuthorNetwork();
			long n = System.currentTimeMillis();
			System.out.println(n-l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void insertCompanyNetwork() {
		try {
			thesisForChineseService.insertCompanyNetwork();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test1() {
		System.out.println(1);
	}@Test
	public void cleanJcr() {
		thesisForEnglishService.cleanJcr();
		System.out.println(1);
	}

}
