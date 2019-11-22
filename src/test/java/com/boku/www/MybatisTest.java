package com.boku.www;

import com.boku.www.controller.ThesisForChineseController;
import com.boku.www.mapper.*;
import com.boku.www.mapper.system.UUserDao;
import com.boku.www.mapper.system.UUserRoleDao;
import com.boku.www.pojo.*;
import com.boku.www.pojo.system.UUserRole;
import com.boku.www.service.*;
import com.boku.www.service.system.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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

	@Autowired
	private ImportService importService;
	@Test
	public void test2() throws Exception {
		//String filePath = "E:\\模板.xls";
		String filePath = "E:\\healthybigdata\\省卫计委数据库导出项目数据（2019年8月19日飞蝶修改后的数据）.xlsx";
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

	@Test
	public void test(){
		//String txtDirPath = "E:\\opt\\cnki\\tb_parse_cnki_document8\\documents";
		String ciwDirPath = "E:\\healthybigdata\\浙江省医疗单位wos数据\\新建文件夹";
		try{
			importService.readCiwFilesToList(ciwDirPath);
			System.out.println("插入成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("插入失败");
		}

	}
	@Test
	public void insertJcrAndJournal(){
		try{
			importService.insertJcrAndJournal();
			System.out.println("插入成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("插入失败");
		}
	}
	@Test
	public void insertAreaCompanyId(){
		try{
			importService.insertAreaCompanyId();
			System.out.println("插入成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("插入失败");
		}

	}

	//添加中外文关键词更新
	@Test
	public void insert(){

		//thesisForEnglishService.insertKeywordsBeforeTwentieth();
		thesisForChineseService.insertKeywordsBeforeTwentieth();
	}
    //添加外文学科论文数量展示更新
	@Test
	public void insertThesisForEnglish(){

		thesisForEnglishService.insertSujectBeforeTwentieth();
	}

    @Autowired
	ThesisForChineseController thesisForChineseController;
	//查询
	@Test
	public void testSelect(){
		List<TCountTopKeywords> list = thesisForEnglishService.selectKeywordsBeforeTwentiethInEachArea();
        for(TCountTopKeywords tCountTopKeyword:list){
			System.out.println(tCountTopKeyword);
		}

		System.out.println(thesisForChineseService.selectKeywordsBeforeTwentiethInEachArea().size());
		System.out.println(thesisForChineseController.selectKeywordsBeforeTwentiethInEachArea());
	}

   //添加外文期刊发表排行
	@Test
	public void insertJournalTopTwentieth()throws Exception{
		//thesisForEnglishService.insertJournalTopTwentieth();
		thesisForChineseService.insertKeywordsBeforeTwentiethInEachArea();
		//期刊前二十
		//thesisForChineseService.insertJournalTopTwentieth();
	}
	@Autowired
	private TUserForPersonageMapper tUserForPersonageMapper;
	@Test
	public void updateUserPersonage()throws Exception{
		List<TUserForPersonage> select = tUserForPersonageMapper.select();
		for (TUserForPersonage tUserForPersonage:select){
			//String username = tUserForPersonage.getUsername().replaceAll("[(a-zA-Z0-9)]", "");
			String username = tUserForPersonage.getUsername().replaceAll(" ", "");
			tUserForPersonage.setUsername(username);
			tUserForPersonageMapper.update(tUserForPersonage);
		}
	}
	@Autowired
	private TProjectDataMapper tProjectDataMapper;


	@Test
	public void insertUserPersonage()throws Exception{
		List<TProjectData> tProjectData = tProjectDataMapper.selectByExample(null);

		for (TProjectData projectData:tProjectData){
			List<TUserForPersonage> tUserForPersonages = tUserForPersonageMapper.selectByName(projectData.getProjectLeader());
			if(tUserForPersonages.size() == 1){
				projectData.setLeaderOmpany(tUserForPersonages.get(0).getCompany());
				tProjectDataMapper.updateByPrimaryKeySelective(projectData);
			}else if(tUserForPersonages.size() > 1){
				projectData.setLeaderOmpany("1");
				tProjectDataMapper.updateByPrimaryKeySelective(projectData);
			}else if(tUserForPersonages.isEmpty() || tUserForPersonages == null){
				projectData.setLeaderOmpany("0");
				tProjectDataMapper.updateByPrimaryKeySelective(projectData);
			}
		}
	}

	@Test
	public void updateEaraPersonge()throws Exception{
		TProjectDataExample tProjectDataExample = new TProjectDataExample();
		TProjectDataExample.Criteria criteria = tProjectDataExample.createCriteria();
		criteria.andProjectCategoryGradeNotEqualTo("国家级").andProjectCategoryGradeNotEqualTo("省级");
		List<TProjectData> tProjectData = tProjectDataMapper.selectByExample(tProjectDataExample);
		tProjectData.stream().map(tProjectData1 -> {
			String projectCategory = tProjectData1.getProjectCategory();
			if(StringUtils.isBlank(tProjectData1.getProjectStartTime()) && StringUtils.isNotBlank(projectCategory)){
				String year = projectCategory.replaceAll("[^Z0-9]", "");
				tProjectData1.setProjectStartTime(year);
			}
			return tProjectData1;
		}).collect(Collectors.toList());
		tProjectData.stream().forEach(
				tb -> tProjectDataMapper.updateByPrimaryKeySelective(tb)

		);
	}
	@Test
	public void updateEaraPersonge01()throws Exception{
		TProjectDataExample tProjectDataExample = new TProjectDataExample();
		TProjectDataExample.Criteria criteria = tProjectDataExample.createCriteria();
		criteria.andProjectCategoryGradeNotEqualTo("国家级").andProjectCategoryGradeNotEqualTo("省级");
		List<TProjectData> tProjectData = tProjectDataMapper.selectByExample(tProjectDataExample);
		tProjectData.stream().map(tProjectData1 -> {
			String projectCategory = tProjectData1.getProjectStartTime();
			if(StringUtils.isNotBlank(tProjectData1.getProjectStartTime())){
				String year = projectCategory.replaceAll("[^Z0-9]", "");
				tProjectData1.setProjectStartTime(year);
			}
			return tProjectData1;
		}).collect(Collectors.toList());
		tProjectData.stream().forEach(
				tb -> tProjectDataMapper.updateByPrimaryKeySelective(tb)

		);
	}
	@Test
	public void test01()throws Exception{
		ByteSource salt = ByteSource.Util.bytes("未登录");
		//如果修改密码，将密码根据加密方式存储
		String newPs = new SimpleHash("MD5", "123456", salt, 1024).toHex();
		System.out.println(newPs);
	}
	@Autowired
	private TAreaAndCompanyMapper tAreaAndCompanyMapper;
	@Test
	public void test02()throws Exception{
		List<TProjectData> tProjectData = tProjectDataMapper.selectByExample(null);
		tProjectData.stream().forEach(
				tb ->
				{
					if(StringUtils.isNotBlank(tb.getFirstOrganizerCompany())){
						TAreaAndCompanyExample tAreaAndCompanyExample = new TAreaAndCompanyExample();
						tAreaAndCompanyExample.createCriteria().andCompanyEqualTo(tb.getFirstOrganizerCompany());
						List<TAreaAndCompany> tAreaAndCompanies = tAreaAndCompanyMapper.selectByExample(tAreaAndCompanyExample);
						if(tAreaAndCompanies != null && !tAreaAndCompanies.isEmpty()){
							tb.setArea(tAreaAndCompanies.get(0).getCity());
							tProjectDataMapper.updateByPrimaryKeySelective(tb);
						}
					}
				}
		);
	}
	@Test
	public void test03()throws Exception{

		List<TProjectData> tProjectData = tProjectDataMapper.selectByExample(null);

		for (TProjectData projectData:tProjectData){
			projectData.setArea(null);
			tProjectDataMapper.updateByPrimaryKey(projectData);
		}
	}
	@Autowired
    private TPrizeDataMapper tPrizeDataMapper;
	@Test
	public void test04()throws Exception{
		List<TPrizeData> tProjectData = tPrizeDataMapper.selectByExample(null);
		tProjectData.stream().forEach(
				tb ->
				{
					if(StringUtils.isNotBlank(tb.getFirstOrganizerCompany())){
						TAreaAndCompanyExample tAreaAndCompanyExample = new TAreaAndCompanyExample();
						tAreaAndCompanyExample.createCriteria().andCompanyEqualTo(tb.getFirstOrganizerCompany());
						List<TAreaAndCompany> tAreaAndCompanies = tAreaAndCompanyMapper.selectByExample(tAreaAndCompanyExample);
						if(tAreaAndCompanies != null && !tAreaAndCompanies.isEmpty()){
							tb.setArea(tAreaAndCompanies.get(0).getCity());
							tPrizeDataMapper.updateByPrimaryKeySelective(tb);
						}
					}
				}
		);
	}
	@Test
	public void test05(){
		List<TPrizeData> list = tPrizeDataMapper.selectByExample(null);
		list.stream().map(li -> {
			String organizerCompany = li.getOtherOrganizerCompany();
			if(StringUtils.isNotBlank(organizerCompany)){
				li.setFirstOrganizerCompany(li.getFirstOrganizerCompany()+","+organizerCompany);
			}
			return li;
		}).collect(Collectors.toList());

		list.stream().forEach(li-> System.out.println(li.getFirstOrganizerCompany())
		);
	}

}
