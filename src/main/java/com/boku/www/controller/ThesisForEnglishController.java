package com.boku.www.controller;
import java.util.HashMap;
import java.util.List;

import com.boku.www.pojo.*;
import com.boku.www.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import com.boku.www.service.ThesisForEnglishService;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/thesisForEnglish")
@CrossOrigin//解决跨域问题
@EnableScheduling
public class ThesisForEnglishController {
	private static Logger logger = LoggerFactory.getLogger(ThesisForEnglishController.class);
	@Autowired
	private ThesisForEnglishService thesisForEnglishService;

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TThesisForEnglish> findAll(){
		try {
			return thesisForEnglishService.findAll();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询所有英文论文失败,Exception:"+e);
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
			return thesisForEnglishService.findPage(page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"分页查询英文论文失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 增加
	 * @param thesisForEnglish
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TThesisForEnglish thesisForEnglish){
		try {
			thesisForEnglishService.add(thesisForEnglish);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"增加英文论文失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}

	/**
	 * 修改
	 * @param thesisForEnglish
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TThesisForEnglish thesisForEnglish){
		try {
			thesisForEnglishService.update(thesisForEnglish);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"修改英文论文失败,Exception:"+e);
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
	public TThesisForEnglish findOne(Integer id){
		try {
			return thesisForEnglishService.findOne(id);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"根据id获取英文论文实体失败,Exception:"+e);
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
			thesisForEnglishService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"删除英文论文失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}

	/**
	 * 查询+分页
	 * @param thesisForEnglish
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ResultUtils search(@RequestBody TThesisForEnglish thesisForEnglish, int page, int rows  ){
		try {
			return thesisForEnglishService.findPage(thesisForEnglish, page, rows);
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"分页条件查询英文论文失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * 批量确认论文（英文）数据
	 * @param ids
	 * @return
	 */
	@RequestMapping("/confirmThesisForEnglishStatus")
	public Result confirmThesisForEnglishStatus(@RequestBody Integer [] ids){
		try {
			thesisForEnglishService.confirmThesisForEnglishStatus(ids);
			return new Result(true, "确认成功");
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"确认英文论文失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "确认失败");
		}
	}
	/**
	 * 统计各地区论文的数量
	 */
	@RequestMapping("/countTheNumberOfThesisForEnglishInEachArea")
	public List<Count> countTheNumberOfThesisForEnglishInEachArea(){
		try {
			return thesisForEnglishService.countTheNumberOfThesisForEnglishInEachArea();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"统计各地区英文论文的数量失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 插入论文的数据
	 */
	@RequestMapping("/insertDataFromSolr")
	public void insertDataFromSolr(){
		try {
			thesisForEnglishService.insertDataFromSolr();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"插入英文论文的数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}

	/**
	 *sci论文
	 数量
	 插入单位top20
	 */
	@RequestMapping("/insertCompanyBeforeTwentieth")
	public void insertCompanyBeforeTwentieth(){
		try {
			thesisForEnglishService.insertCompanyBeforeTwentieth();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"插入英文论文单位top20的数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}
	/**
	 *sci论文
	 数量
	 查询单位top20
	 */
	@RequestMapping("/selectBeforeTwentieth")
	public List<TAreaAndCompany> selectBeforeTwentieth(){
		try {
			return thesisForEnglishService.selectBeforeTwentieth();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询英文论文单位top20的数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 *sci论文
	 数量
	 插入学科top20
	 */
	@RequestMapping("/insertSujectBeforeTwentieth")
	public void insertSujectBeforeTwentieth(){
		try {
			thesisForEnglishService.insertSujectBeforeTwentieth();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"插入英文论文学科top20的数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}
	/**
	 *sci论文
	 数量
	 查询学科top20
	 */
	@RequestMapping("/selectSujectBeforeTwentieth")
	public List<TCountTopSubject>  selectSujectBeforeTwentieth(){
		try {
			return thesisForEnglishService.selectSujectBeforeTwentieth();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询英文论文学科top20的数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 *sci论文
	 数量
	 插入关键词top20
	 */
	@RequestMapping("/insertKeywordsBeforeTwentieth")
	//@Scheduled(cron="0/5 * * * * ?")
	public void  insertKeywordsBeforeTwentieth(){
		try {
			thesisForEnglishService.insertKeywordsBeforeTwentieth();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"插入英文论文关键词top20的数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}
	/**
	 *sci论文
	 数量
	 查询关键词top20
	 */
	@RequestMapping("/selectKeywordsBeforeTwentieth")
	public List<TCountTopKeywords>  selectKeywordsBeforeTwentieth(){
		try {
			return thesisForEnglishService.selectKeywordsBeforeTwentieth();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询英文论文关键词top20的数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 *sci论文
	 *	if（影响因子总和）
	 *		插入单位top20
	 */
	@RequestMapping("/insertIfCompanyBeforeTwentieth")
	public void insertIfCompanyBeforeTwentieth(){
		try {
			thesisForEnglishService.insertIfCompanyBeforeTwentieth();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"插入英文论文单位影响因子top20的数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}
	/**
	 *sci论文
	 *	if（影响因子总和）
	 *		查询单位top20
	 */
	@RequestMapping("/selectIfCompanyBeforeTwentieth")
	public List<TCountTopIf> selectIfCompanyBeforeTwentieth(){
		try {
			return thesisForEnglishService.selectIfCompanyBeforeTwentieth();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询英文论文单位影响因子top20的数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 *sci论文
	 *	if（影响因子总和）
	 *		学科top20
	 */
	@RequestMapping("/insertIfSubjectBeforeTwentieth")
	public void insertIfSubjectBeforeTwentieth(){
		try {
			thesisForEnglishService.insertIfSubjectBeforeTwentieth();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"插入英文论文学科影响因子top20的数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}
	@RequestMapping("/selectIfSubjectBeforeTwentieth")
	public List<TCountTopIf> selectIfSubjectBeforeTwentieth(){
		try {
			return thesisForEnglishService.selectIfSubjectBeforeTwentieth();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询英文论文影响学科因子top20的数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 *sci论文
	 *	论文top20（影响因子最高的、单个、附带这篇文章的单位）
	 */
	@RequestMapping("/selectIfThesisBeforeTwentieth")
	public List<TCountTopIf> selectIfThesisBeforeTwentieth() {
		try {
			return thesisForEnglishService.selectIfThesisBeforeTwentieth();
		} catch (Exception e) {
			logger.info("用户" + CurrentUser.returnCurrentUser() + "查询英文单篇论文影响因子top20的数据失败,Exception:" + e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 *sci论文
	 *	地区
	 *		区域研究热词（top20，每个地区的）
	 */
	@RequestMapping("/insertKeywordsBeforeTwentiethInEachArea")
	public void insertKeywordsBeforeTwentiethInEachArea(){
		try {
			thesisForEnglishService.insertKeywordsBeforeTwentiethInEachArea();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"插入英文区域研究热词top20的数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}

	@RequestMapping("/selectKeywordsBeforeTwentiethInEachArea")
	public List selectKeywordsBeforeTwentiethInEachArea(){
		try {
			return thesisForEnglishService.selectKeywordsBeforeTwentiethInEachArea();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询英文单篇论文影响因子top20的数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 *sci论文
	 *	地区
	 *		区域单位排名
	 */
	@RequestMapping("/selectBeforeTwentiethInEachArea")
	public List selectBeforeTwentiethInEachArea(){
		try {
			return thesisForEnglishService.selectBeforeTwentiethInEachArea();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询英文区域单位排名top20的数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 *sci论文
	 *	jcr分区
	 *		浙江省论文jcr分区分布(饼状图，各分区的数量)
	 */
	@RequestMapping("/insertJcrDistribution")
	public void insertJcrDistribution(){
		try {
			thesisForEnglishService.insertJcrDistribution();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询英文jcr分区分布的数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}
	/**
	 *sci论文
	 *	jcr分区
	 *		浙江省论文jcr分区分布(饼状图，各分区的数量)
	 */
	@RequestMapping("/selectJcrDistribution")
	public List<TCountTopJcr> selectJcrDistribution(){
		try {
			return thesisForEnglishService.selectJcrDistribution();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询英文jcr分区分布的数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 *sci论文
	 *	jcr分区
	 *		各地区jcr分区分布(饼状图，杭州市各分区的数量)
	 */
	@RequestMapping("/insertJcrAndArea")
	public void insertJcrAndArea(){
		try {
			thesisForEnglishService.insertJcrAndArea();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"插入英文jcr各地区分区分布的数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}
	@RequestMapping("/selectJcrAndAreaDistribution")
	public List<TCountTopJcr> selectJcrAndAreaDistribution(){
		try {
			return thesisForEnglishService.selectJcrAndAreaDistribution();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询英文jcr各地区分区分布的数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/insertJcrTopTenCompany")
	public void insertJcrTopTenCompany(){
		try {
			thesisForEnglishService.insertJcrTopTenCompany();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"插入英文jcr分区topten的数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}
	/**
	 *sci论文
	 *	jcr分区
	 *		一区单位top10
	 */
	@RequestMapping("/oneAreaTopTenCompany")
	public List<TCountTopJcr> oneAreaTopTenCompany(){
		try {
			return thesisForEnglishService.oneAreaTopTenCompany();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询英文jcr各一区top10的数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 *sci论文
	 *	jcr分区
	 *		二区单位top10
	 */
	@RequestMapping("/twoAreaTopTenCompany")
	public List<TCountTopJcr> twoAreaTopTenCompany(){
		try {
			return thesisForEnglishService.twoAreaTopTenCompany();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询英文jcr各二区top10的数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 *sci论文
	 *	jcr分区
	 *		三区单位top10
	 */
	@RequestMapping("/threeAreaTopTenCompany")
	public List<TCountTopJcr> threeAreaTopTenCompany(){
		try {
			return thesisForEnglishService.threeAreaTopTenCompany();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询英文jcr各三区top10的数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 *sci论文
	 *	jcr分区
	 *		四区单位top10
	 */
	@RequestMapping("/foreAreaTopTenCompany")
	public List<TCountTopJcr> foreAreaTopTenCompany(){
		try {
			return thesisForEnglishService.foreAreaTopTenCompany();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询英文jcr各四区top10的数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 *sci论文
	 期刊发文排名top20（期刊发表文献数量前20）
	 */
	@RequestMapping("/insertJournalTopTwentieth")
	public void insertJournalTopTwentieth(){
		try {
			thesisForEnglishService.insertJournalTopTwentieth();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"插入期刊发文排名top20（期刊发表文献数量前20)数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}
	@RequestMapping("/selectJournalTopTwentieth")
	public List<TCountTopJournal> selectJournalTopTwentieth(){
		try {
			return thesisForEnglishService.selectJournalTopTwentieth();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询期刊发文排名top20（期刊发表文献数量前20）数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 *sci论文
	 *	top10作者合作关系网
	 */
	@RequestMapping("/insertAuthorNetwork")
	public void insertAuthorNetwork(){
		try {
			thesisForEnglishService.insertAuthorNetwork();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"插入top10作者合作关系网数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}
	@RequestMapping("/selectAuthorNetwork")
	public CountAuthorNetwork selectAuthorNetwork(){
		try {
			return thesisForEnglishService.selectAuthorNetwork();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"插入top10作者合作关系网数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 *sci论文
	 *	top10单位合作关系网
	 */
	@RequestMapping("/insertCompanyNetwork")
	public void insertCompanyNetwork(){
		try {
			thesisForEnglishService.insertCompanyNetwork();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"插入top10单位合作关系网数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}
	@RequestMapping("/selectCompanyNetwork")
	public CountCompanyNetwork selectCompanyNetwork(){
		try {
			return thesisForEnglishService.selectCompanyNetwork();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"插入top10单位合作关系网数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 插入各单位平均影响因子和影响影子总和数据
	 */
	@RequestMapping("/insertIfAvgInEachCompany")
	public void insertIfAvgInEachCompany(){
		try {
			thesisForEnglishService.insertIfAvgInEachCompany();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"插入各单位平均影响因子和影响影子总和数据失败,Exception:"+e);
			e.printStackTrace();
		}
	}

	/**
	 * 查询top20平均影响因子
	 */
	@RequestMapping("/selectAvgIfTopTwentieth")
	public List<TCountIf> selectAvgIfTopTwentieth(){
		try {
			return thesisForEnglishService.selectAvgIfTopTwentieth();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询top20平均影响因子数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 查询top20平均影响因子
	 */
	@RequestMapping("/selectAuthorPostNumTopTen")
	public List selectAuthorPostNumTopTen(){
		try {
			return thesisForEnglishService.selectAuthorPostNumTopTen();
		} catch (Exception e) {
			logger.info("用户"+ CurrentUser.returnCurrentUser()+"查询top10作者发文量数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	//按标题查询提示
	@RequestMapping("/thesisForEnglishTitle")
	public ResultUtils thesisForEnglishTitle(String title){
		try{
			return ResultUtils.ok(thesisForEnglishService.thesisForEnglishTitle(title));
		} catch (Exception e){
			e.printStackTrace();
			return ResultUtils.build(400,"出现错误");
		}
	}
}
