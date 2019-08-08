package com.boku.www.controller;
import java.util.List;
import java.util.Map;

import com.boku.www.pojo.*;
import com.boku.www.service.ThesisForChineseService;
import com.boku.www.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/thesisForChinese")
@CrossOrigin//解决跨域问题
@Configurable
//开启计划任务支持
@EnableScheduling
//多个任务同时运行是需要添加这个类注解
@EnableAsync
public class ThesisForChineseController {
	private static Logger logger = LoggerFactory.getLogger(ThesisForChineseController.class);
	@Autowired
	private ThesisForChineseService thesisForChineseService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TThesisForChinese> findAll(){
		try {
			return thesisForChineseService.findAll();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询所有中文论文失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		try {
			return thesisForChineseService.findPage(page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"分页查询中文论文失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 增加
	 * @param thesisForChinese
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TThesisForChinese thesisForChinese){
		try {
			thesisForChineseService.add(thesisForChinese);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"增加中文论文失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param thesisForChinese
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TThesisForChinese thesisForChinese){
		try {
			thesisForChineseService.update(thesisForChinese);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"修改中文论文失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TThesisForChinese findOne(Integer id){
		try {
			return thesisForChineseService.findOne(id);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"增根据id获取中文论文实体失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer [] ids){
		try {
			thesisForChineseService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"删除中文论文失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public PageResult search(@RequestBody TThesisForChinese thesisForChinese, int page, int rows  ){
		try {
			return thesisForChineseService.findPage(thesisForChinese, page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"分页条件查询中文论文失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}


	/**
	 *
	 * 论文（中文）数据使用的批量确认
	 * @param ids
	 * @return
	 */
	@RequestMapping("/confirmThesisForChineseStatus")
	public Result confirmThesisForChineseStatus(@RequestBody Integer [] ids){
		try {
			thesisForChineseService.confirmThesisForChineseStatus(ids);
			return new Result(true, "确认成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"确认中文论文失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "确认失败");
		}
	}

	/**
	 * 统计各地区论文的数量
	 */
	@RequestMapping("/countTheNumberOfThesisForChineseInEachArea")
	public List<Count> countTheNumberOfThesisForChineseInEachArea(){
		try {
			return thesisForChineseService.countTheNumberOfThesisForChineseInEachArea();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"统计各地区论文的数量失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 添加单位id
	 */
	@RequestMapping("/addCommpanyId")
	public void addCommpanyId(){
		try {
			thesisForChineseService.addCommpanyId();
		} catch (Exception e) {
			logger.info("添加失败");
			e.printStackTrace();
		}
	}
	/**
	 * 插入各单位中文文献的数量
	 * 	做定时更新
	 * 	当文献数据新增和删除时，相应的加减，详见add和delete方法
	 */
	@RequestMapping("/insertCompanyChesisNum")
	@Async
	//计划任务声明
	@Scheduled(cron="0 0 3 ? * SUN") //每周日凌晨3点执行一次
	public void insertCompanyChesisNum(){
		try {
			thesisForChineseService.insertCompanyChesisNum();
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
		}
	}
	/**
	 * 查询浙江省内文献数量排名前20的单位
	 */
	@RequestMapping("/selectBeforeTwentieth")
	public List<TAreaAndCompany> selectBeforeTwentieth(){
		try {
			return thesisForChineseService.selectBeforeTwentieth();
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
			return null;
		}
	}
	/**
	 *
	 *查询各市单位文献量前20的
	 */
	@RequestMapping("/selectBeforeTwentiethInEachArea")
	public List<TAreaAndCompany> selectBeforeTwentiethInEachArea(){
		try {
			return thesisForChineseService.selectBeforeTwentiethInEachArea();
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
			return null;
		}
	}
	/**
	 *查询关键词出现在前20的热词
	 */
	@RequestMapping("/selectKeywordsBeforeTwentieth")
	public List<TCountTopKeywords>selectKeywordsBeforeTwentieth(){
		try {
			return thesisForChineseService.selectKeywordsBeforeTwentieth();
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/insertKeywordsBeforeTwentieth")
	public void insertKeywordsBeforeTwentieth(){
		try {
			thesisForChineseService.insertKeywordsBeforeTwentieth();
		} catch (Exception e) {
			logger.info("插入失败");
			e.printStackTrace();
		}
	}
	/**
	 * 查询各地级市关键词出现前20的
	 */
	@RequestMapping("/insertKeywordsBeforeTwentiethInEachArea")
	public void insertKeywordsBeforeTwentiethInEachArea() {
		try {
			thesisForChineseService.insertKeywordsBeforeTwentiethInEachArea();
		} catch (Exception e) {
			logger.info("插入失败");
			e.printStackTrace();
		}
	}
	/**
	 * 查询各地级市关键词出现前20的
	 */
	@RequestMapping("/selectKeywordsBeforeTwentiethInEachArea")
	public List selectKeywordsBeforeTwentiethInEachArea() {
		try {
			return thesisForChineseService.selectKeywordsBeforeTwentiethInEachArea();
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 第一作者top20（如杭州市内单位排名）
	 */
	@RequestMapping("/insertFirstAuthorBeforeTwentiethInEachArea")
	public Map<String,List> insertFirstAuthorBeforeTwentiethInEachArea() {
		try {
			return thesisForChineseService.insertFirstAuthorBeforeTwentiethInEachArea();
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/selectFirstAuthorBeforeTwentiethInEachArea")
	public List selectFirstAuthorBeforeTwentiethInEachArea() {
		try {
			return thesisForChineseService.selectFirstAuthorBeforeTwentiethInEachArea();
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 学科top20（R6）
	 */
	@RequestMapping("/insertSujectBeforeTwentieth")
	public void insertSujectBeforeTwentieth() {
		try {
			thesisForChineseService.insertSujectBeforeTwentieth();
		} catch (Exception e) {
			logger.info("插入失败");
			e.printStackTrace();
		}
	}
	/**
	 * 学科top20（R6）
	 */
	@RequestMapping("/selectSujectBeforeTwentieth")
	public List<TCountTopSubject> selectSujectBeforeTwentieth() {
		try {
			return thesisForChineseService.selectSujectBeforeTwentieth();
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 核心期刊学科top20（R6）
	 */
	@RequestMapping("/insertSujectBeforeTwentiethInCorePerio")
	public void insertSujectBeforeTwentiethInCorePerio() {
		try {
			thesisForChineseService.insertSujectBeforeTwentiethInCorePerio();
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
		}
	}
	@RequestMapping("/selectSujectBeforeTwentiethInCorePerio")
	public List<TCountTopCorePerio> selectSujectBeforeTwentiethInCorePerio() {
		try {
			return thesisForChineseService.selectSujectBeforeTwentiethInCorePerio();
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 插入核心期刊top20（）
	 */
	@RequestMapping("/insertJournalTopTwentieth")
	public void insertJournalTopTwentieth() {
		try {
			thesisForChineseService.insertJournalTopTwentieth();
		} catch (Exception e) {
			logger.info("插入失败");
			e.printStackTrace();
		}
	}
	/**
	 * 查询核心期刊top20（）
	 */
	@RequestMapping("/selectBeforeTwentiethInCorePerio")
	public List<TCountTopJournal> selectBeforeTwentiethInCorePerio() {
		try {
			return thesisForChineseService.selectBeforeTwentiethInCorePerio();
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 插入和查询核心期刊单位top20
	 */
	@RequestMapping("/insertCompanyBeforeTwentiethInCorePerio")
	public void  insertCompanyBeforeTwentiethInCorePerio() {
		try {
			thesisForChineseService.insertCompanyBeforeTwentiethInCorePerio();
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
		}
	}
	@RequestMapping("/selectCompanyBeforeTwentiethInCorePerio")
	public List<TCountTopCorePerio>  selectCompanyBeforeTwentiethInCorePerio() {
		try {
			return thesisForChineseService.selectCompanyBeforeTwentiethInCorePerio();
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 插入作者合作关系网
	 */
	@RequestMapping("/insertAuthorNetwork")
	public void insertAuthorNetwork() {
		try {
			thesisForChineseService.insertAuthorNetwork();
		} catch (Exception e) {
			logger.info("插入失败");
			e.printStackTrace();
		}
	}
	/**
	 * 查询作者合作关系网
	 */
	@RequestMapping("/selectAuthorNetwork")
	public CountAuthorNetwork selectAuthorNetwork() {
		try {
			return thesisForChineseService.selectAuthorNetwork();
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 插入单位合作关系网
	 */
	@RequestMapping("/insertCompanyNetwork")
	public void insertCompanyNetwork() {
		try {
			thesisForChineseService.insertCompanyNetwork();
		} catch (Exception e) {
			logger.info("插入失败");
			e.printStackTrace();
		}
	}
	/**
	 * 查询单位合作关系网
	 */
	@RequestMapping("/selectCompanyNetwork")
	public CountCompanyNetwork selectCompanyNetwork() {
		try {
			return thesisForChineseService.selectCompanyNetwork();
		} catch (Exception e) {
			logger.info("查询失败");
			e.printStackTrace();
			return null;
		}
	}


}
