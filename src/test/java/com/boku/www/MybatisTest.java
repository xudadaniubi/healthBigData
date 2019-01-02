package com.boku.www;

import com.boku.www.mapper.TAreaAndCompanyMapper;
import com.boku.www.mapper.system.UUserDao;
import com.boku.www.mapper.system.UUserRoleDao;
import com.boku.www.pojo.TThesisForEnglish;
import com.boku.www.pojo.system.UUserRole;
import com.boku.www.service.ExcelImportAndBuildService;
import com.boku.www.service.ProjectDataService;
import com.boku.www.service.ThesisForEnglishService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.HashSet;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class MybatisTest {

	/*@Autowired
	private ImportTThesisForChineseExcel importTThesisForChineseExcel;*/

	@Autowired
	private ProjectDataService projectDataService;

	@Autowired
	private ExcelImportAndBuildService excelImportAndBuildService;

	@Autowired
	private ThesisForEnglishService thesisForEnglishService;

	@Autowired
	private TAreaAndCompanyMapper areaAndCompanyMapper;

	@Autowired
	private UUserRoleDao userRoleDao;
	/*@Test
	public void test2() throws Exception {
		//String filePath = "E:\\模板.xls";
		String filePath = "E:\\项目数据表.xlsx";
		File file = new File(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportAndBuildService.importProjectDataExcel(file, fileName);
		System.out.println(message);
	}*/
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
	/*@Test
	public void test10() throws Exception {
		String filePath = "E:\\地区表.xlsx";
		File file = new File(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportAndBuildService.importAreaAndCompanyExcel(file, fileName);
		System.out.println(message);
	}*/
	/*@Test
	public void test11() throws Exception {
		String filePath = "E:\\地区表.xlsx";
		File file = new File(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportAndBuildService.importAreaAndCompanyExcelToUser(file, fileName);
		System.out.println(message);
	}*/
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
}
