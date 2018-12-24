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


/**
 * 〈一句话功能简述〉<br> 
 * 〈excel表格下载〉
 *
 * @author dell
 * @create 2018/9/28
 * @since 1.0.0
 */

import com.boku.www.pojo.*;
import com.boku.www.service.*;
import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.DownloadExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/file")
@CrossOrigin//解决跨域问题
public class ExcelDownloadController {

	private static Logger logger = LoggerFactory.getLogger(ExcelDownloadController.class);

	@Autowired
	private BooksService booksService;

	@Autowired
	private ProjectDataService projectDataService;

	@Autowired
	private ThesisForChineseService thesisForChineseService;

	@Autowired
	private ThesisForEnglishService thesisForEnglishService;

	@Autowired
	private PatentService patentService;

	/**
	 * 1.下载项目分析表
	 */
	@RequestMapping(value = "/downloadProjectDataOrPrizeDataExcel", method = RequestMethod.GET)
	public void downloadProjectDataOrPrizeDataExcel(HttpServletRequest request, HttpServletResponse response,String subject,String subject1Id,String subject2Id
		,String area,String organizer,String projectLeader,String prizeCategory,String searchStartTime,String searchEndTime,String code,
													String projectCategoryGrade,String prizeCategoryGrade)throws IOException {
		TProjectData projectData = new TProjectData();
		projectData.setProjectCategoryGrade(projectCategoryGrade);
		projectData.setSubject(subject);
		projectData.setSubject1Id(subject1Id);
		projectData.setSubject2Id(subject2Id);
		projectData.setArea(area);
		projectData.setOrganizer(organizer);
		projectData.setProjectLeader(projectLeader);
		projectData.setSearchStartTime(searchStartTime);
		projectData.setSearchEndTime(searchEndTime);
		projectData.setPrizeCategoryGrade(prizeCategoryGrade);
		projectData.setPrizeCategory(prizeCategory);
		//判断查询条件
		//无条件，查询所有数据，将所有数据下载下来
		try {
			//1、查询奖励统计数据
			if(code!=null && code.length()>0){
				if(code.equals("1")){
					//根据前端传来的projectData作为条件来查询数据库里的数据
					//导出的Excel头部，这个要根据自己项目改一下
					//String[] headers = { "序号", "奖项管理单位","级别", "奖项名称","拟奖等级","项目名称","获奖时间","所属地区","承担单位","项目负责人","团队成员"};
					String[] header= { "序号", "奖项管理单位", "奖项名称","拟奖等级","项目名称","所属地区","承担单位","项目负责人","团队成员"};
					String excelName = "科研奖励统计表";
					List<TProjectData> list = projectDataService.findTProjectDataToExcel(projectData);//查询出来的数据
					DownloadExcelUtils.downProjectDataExcel(request,response,list,header,excelName);
				}else if(code.equals("2")){
					//2、查询项目统计数据
					//根据前端传来的projectData作为条件来查询数据库里的数据
					//导出的Excel头部，这个要根据自己项目改一下
					//String[] headers = { "序号", "项目管理单位","级别", "项目类别", "学科分类","项目名称","立项时间","结题时间","承担单位","所属地区","项目负责人"};
					String[] header = { "序号", "项目管理单位", "项目类别", "学科分类","项目名称","立项时间","承担单位","项目负责人","级别"};
					String excelName = "科研项目统计表";
					List<TProjectData> list = projectDataService.findTProjectDataToExcel(projectData);//查询出来的数据
					DownloadExcelUtils.downProjectDataExcel(request,response,list,header,excelName);
				}
			}else {
				System.out.println("状态码为空");
			}
		} catch (IOException e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"项目分析表数据下载失败,Exception:"+e);
			e.printStackTrace();
		}

	}

	/**
	 * 2、下载项目数据模板表
	 */
	@RequestMapping(value = "/downloadTemplateProjectDataExcel" , method = RequestMethod.GET)
	public void downloadTemplateProjectDataExcel(HttpServletRequest request, HttpServletResponse response)throws IOException {
		String message =  "请注意：立项时间、结题时间必须要有固定的格式，如：‘2018’，项目管理单位、" +
				"“项目类别、项目名称、项目子类、类目、所在地区、项目负责人、”不能为纯数字，" +
				"“一级学科分类、二级学科分类、”必须根据“国家标准学科分类表”进行填写" +
				"“项目级别”如果是市、区、院级必须填写所在的地区或单位的名称，括号必须是中文状态下的，" +
				"“承担单位、团队成员”有多个必须用英文状态下的“,”隔开。请不要更改表头的名称和各列的顺序，请把所有的模板信息删除。";

		//项目管理单位	级别	项目类别	一级学科分类	二级学科分类	项目名称	项目子类	类目	立项时间	结题时间	所在地区	承担单位	项目负责人	团队成员
		String[] headers = { "项目管理单位","项目级别", "项目类别", "一级学科分类","二级学科分类","项目名称","项目子类","类目","立项时间","结题时间","所在地区","承担单位","项目负责人","团队成员","特别说明"};
		String[] data1 = { "杭州科技局","国家级", "2017年杭州市重大科技创新项目", "基础医学","医学史","抗癌新药克美纳治疗非小细胞肺癌的Ⅱ,Ⅲ期临床研究","重点项目","重大科技创新项目","2018","2019","杭州市","浙江肿瘤医院,浙江贝达药业有限公司","王印祥","徐伟明,章鹏飞,顾海宁,边界,沈超,常雨薇,何红强",message};
		String[] data2 = { "杭州科技局","省级", "2017年杭州市重大科技创新项目", "临床医学","临床诊断学","抗癌新药克美纳治疗非小细胞肺癌的Ⅱ,Ⅲ期临床研究","重点项目","科技发展项目","2018","2019","杭州市","浙江肿瘤医院,浙江贝达药业有限公司","王印祥","徐伟明,章鹏飞,顾海宁,边界,沈超,常雨薇,何红强",message};
		String[] data3 = { "杭州科技局","地市级（杭州市）", "2017年杭州市重大科技创新项目", "预防医学与卫生学","消毒学","抗癌新药克美纳治疗非小细胞肺癌的Ⅱ,Ⅲ期临床研究","重点项目","科技发展项目","2018","2019","杭州市","浙江肿瘤医院,浙江贝达药业有限公司","王印祥","徐伟明,章鹏飞,顾海宁,边界,沈超,常雨薇,何红强",message};
		String[] data4 = { "杭州科技局","区/县/院级（宁波市江东区）", "2017年杭州市重大科技创新项目", "军事医学与特种医学","军事医学","抗癌新药克美纳治疗非小细胞肺癌的Ⅱ,Ⅲ期临床研究","重点项目","重大科技创新项目","2018","2019","宁波市","宁波市中医院","XXX","徐伟明,章鹏飞,顾海宁,边界,沈超,常雨薇,何红强",message};
		String[] data5 = { "杭州科技局","区/县/院级（宁波市江东区妇幼保健院）", "2017年杭州市重大科技创新项目", "药学","生物药物学","抗癌新药克美纳治疗非小细胞肺癌的Ⅱ,Ⅲ期临床研究","重点项目","重大科技创新项目","2018","2019","宁波市","宁波市江东区妇幼保健院","XXX","徐伟明,章鹏飞,顾海宁,边界,沈超,常雨薇,何红强",message};
		String excelName = "项目数据统计模板表";
		try {
			DownloadExcelUtils.downTemplateExcel(request,response,headers,data1,data2,data3,data4,data5,excelName);
		} catch (IOException e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"下载项目数据模板表失败,Exception:"+e);
			e.printStackTrace();
		}
	}

	/**
	 * 3、下载奖励数据模板表
	 */
	@RequestMapping(value = "/downloadTemplatePrizeDataExcel" , method = RequestMethod.GET)
	public void downloadTemplatePrizeDataExcel(HttpServletRequest request, HttpServletResponse response)throws IOException {
		//导出的Excel头部，这个要根据自己项目改一下

		String message =  "请注意：获奖时间必须要有固定的格式，如：‘2018’，" +
				"“项目类别、项目名称、所在地区、项目负责人、奖项类别、奖项名称、所获奖项、奖项等级”不能为纯数字，" +
				"“一级学科分类、二级学科分类”必须根据“国家标准学科分类表”进行填写" +
				"“奖励级别”如果是市、区、院级必须填写所在的地区或单位的名称，括号必须是中文状态下的，" +
				"“承担单位、团队成员”有多个必须用英文状态下的“,”隔开。请不要更改表头的名称和各列的顺序，请把所有的模板信息删除。";

		//项目名称	项目类别	一级学科分类	二级学科分类	承担单位	所在地区	项目负责人	团队成员	奖励级别	所获奖项	奖项等级	获奖时间
		String[] headers = { "项目名称","项目类别", "一级学科分类","二级学科分类","承担单位","所在地区","项目负责人","团队成员","获奖级别","所获奖项","奖项等级","获奖时间","特别说明"};
		String[] data1 = { "抗癌新药克美纳治疗非小细胞肺癌的Ⅱ,Ⅲ期临床研究","2017年杭州市重大科技创新项目", "基础医学","医学史","浙江肿瘤医院,浙江贝达药业有限公司","杭州市","王印祥","徐伟明,章鹏飞,顾海宁,边界,沈超,常雨薇,何红强","国家级","2019年杭州市科技进步奖","三等奖","2019",message};
		String[] data2 = { "抗癌新药克美纳治疗非小细胞肺癌的Ⅱ,Ⅲ期临床研究","2017年杭州市重大科技创新项目", "临床医学","临床诊断学","浙江肿瘤医院,浙江贝达药业有限公司","杭州市","王印祥","徐伟明,章鹏飞,顾海宁,边界,沈超,常雨薇,何红强","省级","2019年杭州市科技进步奖","一等奖","2019",message};
		String[] data3 = { "抗癌新药克美纳治疗非小细胞肺癌的Ⅱ,Ⅲ期临床研究","2017年杭州市重大科技创新项目", "预防医学与卫生学","临床诊断学","浙江肿瘤医院,浙江贝达药业有限公司","杭州市","王印祥","徐伟明,章鹏飞,顾海宁,边界,沈超,常雨薇,何红强","地市级（杭州市）","2019年杭州市科技进步奖","三等奖","2019",message};
		String[] data4 = { "抗癌新药克美纳治疗非小细胞肺癌的Ⅱ,Ⅲ期临床研究","2017年杭州市重大科技创新项目", "军事医学与特种医学","军事医学","宁波市中医院","宁波市","XXX","徐伟明,章鹏飞,顾海宁,边界,沈超,常雨薇,何红强","地市级（宁波市江东区）","2019年宁波市科技进步奖","三等奖","2019",message};
		String[] data5 = { "抗癌新药克美纳治疗非小细胞肺癌的Ⅱ,Ⅲ期临床研究","2017年杭州市重大科技创新项目", "药学","生物药物学","宁波市江东区妇幼保健院","宁波市","XXX","徐伟明,章鹏飞,顾海宁,边界,沈超,常雨薇,何红强","区/县/院级（宁波市江东区妇幼保健院）","2019年宁波市科技进步奖","三等奖","2019",message};
		String excelName = "奖励数据统计模板表";
		try {
			DownloadExcelUtils.downTemplateExcel(request,response,headers,data1,data2,data3,data4,data5,excelName);
		} catch (IOException e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"下载奖励数据模板表失败,Exception:"+e);
			e.printStackTrace();
		}
	}

	/**
	 *4、下载论文（中文）模板表
	 */
	@RequestMapping(value = "/downloadTemplateThesisForChineseExcel" , method = RequestMethod.GET)
	public void downloadTemplateThesisForChineseExcel(HttpServletRequest request, HttpServletResponse response)throws IOException {
		//导出的Excel头部，这个要根据自己项目改一下
		String message =  "请注意：“年”必须要有固定的格式，如：‘2018’，“作者、题名、文献来源、机构、所属地区”不能为纯数字，" +
				"“卷、期、页码、ISSN、DOI”可以为数字，“作者、机构”有多个必须用英文状态下的“;”隔开。请不要更改表头的名称和各列的顺序，请把所有的模板信息删除。";

		//作者	题名	文献来源	年	卷	期	页码	ISSN	机构	所属地区	DOI;
		String[] headers = { "作者","题名", "文献来源", "年","卷","期","页码","ISSN","机构","所属地区","DOI","特别说明"};
		String[] data1 = { "李涛;孙才兴;","肿瘤血管形成的分子调控机制", "中国肿瘤", "2014","23","1","44-48","1004-0242","浙江省肿瘤医院","杭州市","10.1155/2017/6242103",message};
		String[] data2 = { "吴迪炯;叶宝东;季聪华;陈丹;陈健;张颖;沈一平;胡致平;周郁鸿;曹毅;","再生障碍性贫血临床实践指南研究现状及中医指南的修订与思考", "中医杂志", "2014","55","4","274-278","1001-1668","浙江省中医院国家中医临床血液病研究基地","杭州市","10.1155/2017/6242103",message};
		String[] data3 = { "梅瑾;王小华;王昊;杨晓楠;方锴;韩渭;","无创产前基因检测在胎儿染色体非整倍体筛查中的应用", "中国预防医学杂志", "2014","23","1","44-48","1004-0242","浙江省中医院针灸科;浙江中医药大学第三附属医院;","杭州市","10.1155/2017/6242104",message};
		String[] data4 = { "殷光磊;汪凡;林坚;褚春华;曹靓;","温针灸结合等长收缩后放松肌肉能量技术治疗梨状肌综合征的临床研究", "中国康复医学杂志", "2014","23","1","44-48","1004-0242","杭州市第一人民医院集团-杭州市妇幼保健院产前诊断中心;上海华大基因科技有限公司;深圳华大临床检验中心有限公司;","杭州市","10.1155/2017/6242105",message};
		String[] data5 = { "杨迪;邵海宇;张骏;李晓林;金永明;陈锦平;黄亚增;","零切迹颈椎前路椎间融合固定系统治疗单节段颈椎间盘突出症", "中国骨伤", "2014","23","1","44-48","1004-0242","浙江省肿瘤医院","杭州市","10.1155/2017/6242106",message};
		String excelName = "论文（中文）模板表";
		try {
			DownloadExcelUtils.downTemplateExcel(request,response,headers,data1,data2,data3,data4,data5,excelName);
		} catch (IOException e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"下载论文（中文）模板表失败,Exception:"+e);
			e.printStackTrace();
		}
	}

	/**
	 *5、下载论文（外文）模板表
	 */
	@RequestMapping(value = "/downloadTemplateThesisForEnglishExcel" , method = RequestMethod.GET)
	public void downloadTemplateThesisForEnglishExcel(HttpServletRequest request, HttpServletResponse response)throws IOException {
		//导出的Excel头部，这个要根据自己项目改一下
		String message =  "请注意：“年”必须要有固定的格式，如：‘2018’，“作者、文献、期刊名称、作者单位、机构、所属地区、作者地址、文摘”不能为纯数字，" +
				"“卷、期、页、ISSN、DOI”可以为数字，“作者、作者单位”有多个必须用英文状态下的“;”隔开。请不要更改表头的名称和各列的顺序，请把所有的模板信息删除。";

		//文献	作者	DOI	期刊名称	ISSN	年	卷	期	页	作者单位	所属地区	作者地址	文摘
		String[] headers = { "文献","作者", "DOI", "期刊名称","ISSN","年","卷","期","页","作者单位","所属地区","作者地址","文摘","特别说明"};
		String[] data1 = { "Repression of miR156 by miR159 Regulates the Timing of the Juvenile-to-Adult Transition in Arabidopsis.","Gao J;Wang H;Qu J;Wang H;Wang X", "10.1016/j.foodchem.2016.07.138", "Food chemistry","0308-8146","2017","215","1","138-48","温州医科大学;湖北医药学院武汉大学人民医院","杭州市","Key Laboratory of Watershed Sciences and Health of Zhejiang Province， Wenzhou Medical University","In traditional ionic liquids (ILs)-based microextraction， ILs are often used as extraction and dispersive solvents",message};
		String[] data2 = { "Repression of miR156 by miR159 Regulates the Timing of the Juvenile-to-Adult Transition in Arabidopsis.","Gao J;Wang H;Qu J;Wang H;Wang X", "10.1016/j.foodchem.2016.07.138", "Food chemistry","0308-8146","2017","215","1","138-48","温州医科大学;湖北医药学院武汉大学人民医院","杭州市","Key Laboratory of Watershed Sciences and Health of Zhejiang Province， Wenzhou Medical University","In traditional ionic liquids (ILs)-based microextraction， ILs are often used as extraction and dispersive solvents",message};
		String[] data3 = { "Repression of miR156 by miR159 Regulates the Timing of the Juvenile-to-Adult Transition in Arabidopsis.","Gao J;Wang H;Qu J;Wang H;Wang X", "10.1016/j.foodchem.2016.07.138", "Food chemistry","0308-8146","2017","215","1","138-48","温州医科大学;湖北医药学院武汉大学人民医院","杭州市","Key Laboratory of Watershed Sciences and Health of Zhejiang Province， Wenzhou Medical University","In traditional ionic liquids (ILs)-based microextraction， ILs are often used as extraction and dispersive solvents",message};
		String[] data4 = { "Repression of miR156 by miR159 Regulates the Timing of the Juvenile-to-Adult Transition in Arabidopsis.","Gao J;Wang H;Qu J;Wang H;Wang X", "10.1016/j.foodchem.2016.07.138", "Food chemistry","0308-8146","2017","215","1","138-48","温州医科大学;湖北医药学院武汉大学人民医院","杭州市","Key Laboratory of Watershed Sciences and Health of Zhejiang Province， Wenzhou Medical University","In traditional ionic liquids (ILs)-based microextraction， ILs are often used as extraction and dispersive solvents",message};
		String[] data5 = { "Repression of miR156 by miR159 Regulates the Timing of the Juvenile-to-Adult Transition in Arabidopsis.","Gao J;Wang H;Qu J;Wang H;Wang X", "10.1016/j.foodchem.2016.07.138", "Food chemistry","0308-8146","2017","215","1","138-48","温州医科大学;湖北医药学院武汉大学人民医院","杭州市","Key Laboratory of Watershed Sciences and Health of Zhejiang Province， Wenzhou Medical University","In traditional ionic liquids (ILs)-based microextraction， ILs are often used as extraction and dispersive solvents",message};
		String excelName = "论文（外文）模板表";
		try {
			DownloadExcelUtils.downTemplateExcel(request,response,headers,data1,data2,data3,data4,data5,excelName);
		} catch (IOException e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"下载论文（外文）模板表失败,Exception:"+e);
			e.printStackTrace();
		}
	}

	/**
	 *6、下载专利模板表
	 */
	@RequestMapping(value = "/downloadTemplatePatentExcel" , method = RequestMethod.GET)
	public void downloadTemplatePatentExcel(HttpServletRequest request, HttpServletResponse response)throws IOException {
		//导出的Excel头部，这个要根据自己项目改一下
		String message =  "请注意：“专利申请日,授权公告日,登记时间”必须要有固定的格式，如：‘2016-02-12’，“第一发明人、其他发明人、第一发明人单位、专利名称、专利权人、专利类别、专利代理机构名称、所属地区”不能为纯数字，" +
				"“证书号、CN106137336A”可以为数字，“其他发明人”有多个必须用英文状态下的“,”隔开。请不要更改表头的名称和各列的顺序，请把所有的模板信息删除。";

		//第一发明人	其他发明人	第一发明人单位	专利名称	专利权人	专利申请日	授权公告日	专利类别	证书号	专利号	专利代理机构名称	登记时间	所属地区
		String[] headers = { "第一发明人","其他发明人", "第一发明人单位", "专利名称","专利权人","专利申请日","授权公告日","专利类别","证书号","专利号","专利代理机构名称","登记时间","所属地区","特别说明"};
		String[] data1 = { "宣桂琪","陈健,蒋剑平", "浙江省中医院", "一种中药组合物及其制备方法与应用","浙江省中医院","2016-02-12","2017-02-13","实用新型","4021867","CN106137336A","AAA","2012-02-04","杭州市",message};
		String[] data2 = { "程向东","徐志远,吕航,郑国淀", "浙江省中医院", "一种胃癌血清学检测鉴定试剂盒及方法","浙江省中医院","2013-02-04","2013-02-05","实用新型","3528423","CN106177949A","BBB","2012-02-04","杭州市",message};
		String[] data3 = { "宣桂琪","陈健,蒋剑平", "浙江省中医院", "一种中药组合物及其制备方法与应用","浙江省中医院","2016-02-12","2017-02-13","实用新型","4021867","CN106137336A","AAA","2012-02-04","杭州市",message};
		String[] data4 = { "程向东","徐志远,吕航,郑国淀", "浙江省中医院", "一种胃癌血清学检测鉴定试剂盒及方法","浙江省中医院","2013-02-04","2013-02-05","实用新型","3528423","CN106177949A","BBB","2012-02-04","杭州市",message};
		String[] data5 = { "宣桂琪","陈健,蒋剑平", "浙江省中医院", "一种中药组合物及其制备方法与应用","浙江省中医院","2016-02-12","2017-02-13","实用新型","4021867","CN106137336A","AAA","2012-02-04","杭州市",message};
		String excelName = "论文（外文）模板表";
		try {
			DownloadExcelUtils.downTemplateExcel(request,response,headers,data1,data2,data3,data4,data5,excelName);
		} catch (IOException e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"下载专利模板表失败,Exception:"+e);
			e.printStackTrace();
		}
	}

	/**
	 * 7.下载论文（中文）表数据
	 */
	@RequestMapping(value = "/downloadThesisForChineseExcel", method = RequestMethod.GET)
	public void downloadThesisForChineseExcel(HttpServletRequest request, HttpServletResponse response,String title,String author,String authorCompany
			,String area,String searchStartTime,String searchEndTime)throws IOException {
		TThesisForChinese thesisForChinese = new TThesisForChinese();
		thesisForChinese.setTitle(title);
		thesisForChinese.setAuthor(author);
		thesisForChinese.setAuthorCompany(authorCompany);
		thesisForChinese.setArea(area);
		thesisForChinese.setSearchStartTime(searchStartTime);
		thesisForChinese.setSearchEndTime(searchEndTime);
		try {
			//判断查询条件
			//无条件，查询所有数据，将所有数据下载下来
			//根据前端传来的thesisForChinese作为条件来查询数据库里的数据
			//导出的Excel头部，这个要根据自己项目改一下
			String[] headers = {  "序号","作者","题名", "文献来源", "年","卷","期","页码","机构（作者单位）","所属地区"};
			//查询出来的数据
			List<TThesisForChinese> list = thesisForChineseService.findThesisForChineseToExcel(thesisForChinese);
			DownloadExcelUtils.downThesisForChineseExcel(request,response,list,headers);
		} catch (IOException e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"下载论文（中文）表数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}

	/**
	 * 8.下载论文（外文）表
	 */
	@RequestMapping(value = "/downloadThesisForEnglishExcel", method = RequestMethod.GET)
	public void downloadThesisForEnglishExcel(HttpServletRequest request, HttpServletResponse response,String title,String author,String authorCompany
			,String area,String searchStartTime,String searchEndTime)throws IOException {
		TThesisForEnglish thesisForEnglish = new TThesisForEnglish();
		thesisForEnglish.setTitle(title);
		thesisForEnglish.setAuthor(author);
		thesisForEnglish.setAuthorCompany(authorCompany);
		thesisForEnglish.setArea(area);
		thesisForEnglish.setSearchStartTime(searchStartTime);
		thesisForEnglish.setSearchEndTime(searchEndTime);
		try {
			//判断查询条件
			//导出的Excel头部，这个要根据自己项目改一下
			String[] headers = {  "序号","作者","题名", "文献来源", "年","卷","期","页码","机构（作者单位）","所属地区"};
			//查询出来的数据
			List<TThesisForEnglish> list = thesisForEnglishService.findThesisForEnglishToExcel(thesisForEnglish);
			DownloadExcelUtils.downThesisForEnglishExcel(request,response,list,headers);
		} catch (IOException e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"下载论文（外文）表数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}

	/**
	 * 9.下载专利表数据
	 */
	@RequestMapping(value = "/downloadPatentExcel", method = RequestMethod.GET)
	public void downloadPatentExcel(HttpServletRequest request, HttpServletResponse response,String patentName,String firstInvento,String patentNum
			,String patentee,String area,String searchStartTime,String searchEndTime)throws IOException {
		TPatent patent = new TPatent();
		//专利名称
		patent.setPatentName(patentName);
		//第一发明人
		patent.setFirstInvento(firstInvento);
		patent.setPatentNum(patentNum);
		//专利权人
		patent.setPatentee(patentee);
		patent.setArea(area);
		patent.setSearchStartTime(searchStartTime);
		patent.setSearchEndTime(searchEndTime);
		try {
			//判断查询条件
			//导出的Excel头部，这个要根据自己项目改一下
			//第一发明人	其他发明人	第一发明人单位	专利名称	专利权人	专利申请日	授权公告日	专利类别	登记时间	专利号	所属地区
			String[] headers = { "序号", "第一发明人","其他发明人", "第一发明人单位", "专利名称","专利权人","专利申请日","授权公告日","专利类别","登记时间","专利号","所属地区"};
			//查询出来的数据
			List<TPatent> list = patentService.findPatentToExcel(patent);
			DownloadExcelUtils.downPatentExcel(request,response,list,headers);
		} catch (IOException e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"下载专利表失败,Exception:"+e);
			e.printStackTrace();
		}
	}
}
