package com.boku.www.service.impl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.boku.www.Enum.Area;
import com.boku.www.config.SolrConfig;
import com.boku.www.mapper.*;
import com.boku.www.pojo.*;
import com.boku.www.pojo.system.URole;
import com.boku.www.pojo.system.UUser;
import com.boku.www.service.system.RoleService;
import com.boku.www.utils.*;
import org.apache.commons.lang3.StringUtils;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.CursorMarkParams;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.boku.www.service.ThesisForEnglishService;

import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
@Transactional
public class ThesisForEnglishServiceImpl implements ThesisForEnglishService {

	@Autowired
	private TThesisForEnglishMapper thesisForEnglishMapper;

	@Autowired
	private RoleService roleService;

	@Autowired
	private TAreaAndCompanyMapper areaAndCompanyMapper;

	@Autowired
	private TCountAuthorNetworkMapper countAuthorNetworkMapper;

	@Autowired
	private TCountCompanyNetworkMapper countCompanyNetworkMapper;

	@Autowired
	private TCountIfMapper countIfMapper;

	@Autowired
	private SolrClient solrClient;

	@Autowired
	private TThesisForEnglishFromSolrMapper thesisForEnglishFromSolrMapper;
	/**
	 * 查询全部
	 */
	@Override
	public List<TThesisForEnglish> findAll() {
		TThesisForEnglishExample example=new TThesisForEnglishExample();
		TThesisForEnglishExample.Criteria criteria = example.createCriteria();
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		return thesisForEnglishMapper.selectByExample(example);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {

		TThesisForEnglishExample example=new TThesisForEnglishExample();
		TThesisForEnglishExample.Criteria criteria = example.createCriteria();
		//根据角色添加查询条件，每个用户只能查询本自己权限范围内的数据
		String roleGrade = addCriteriaByRoles(criteria);
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		//分页插件中分页只对下一个查询分页，所以需要紧跟想要转换的查询语句
		PageHelper.startPage(pageNum, pageSize);
		Page<TThesisForEnglish> page=   (Page<TThesisForEnglish>) thesisForEnglishMapper.selectByExample(example);
		//将查询到的角色和已确认/未确认的信息保存到PageResult里面，然后返回给前端
		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
		pageResult.setRoleGrade(roleGrade);
		return pageResult;
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TThesisForEnglish thesisForEnglish) {
		thesisForEnglishMapper.insert(thesisForEnglish);
	}


	/**
	 * 修改
	 */
	@Override
	public void update(TThesisForEnglish thesisForEnglish){
		thesisForEnglishMapper.updateByPrimaryKey(thesisForEnglish);
		//thesisForEnglishExampleMapper.updateByPrimaryKey(thesisForEnglish);
	}

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TThesisForEnglish findOne(Integer id){
		return thesisForEnglishMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(@RequestBody Integer[] ids) {
		for(Integer id:ids){
			TThesisForEnglish thesisForEnglish = thesisForEnglishMapper.selectByPrimaryKey(id);
			thesisForEnglish.setStatus("2");
			thesisForEnglishMapper.updateByPrimaryKey(thesisForEnglish);
		}
	}

	/**
	 * 分页条件查询
	 * @param thesisForEnglish
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	@Override
	public ResultUtils findPage(TThesisForEnglish thesisForEnglish, int pageNum, int pageSize) {
		UUser currentUser = CurrentUser.returnCurrentUser();
		if (currentUser == null){
			return ResultUtils.build(400,"登录失效,请重新登录");
		}
		TThesisForEnglishExample example=new TThesisForEnglishExample();
		example.setOrderByClause("`confirm_status` DESC,id ASC");
		TThesisForEnglishExample.Criteria criteria = example.createCriteria();
		String roleGrade = null;
		if(thesisForEnglish!=null){
			roleGrade = addThesisForChineseCriteria(thesisForEnglish, criteria);
		}
		PageHelper.startPage(pageNum, pageSize);
		Page<TThesisForEnglish> page= (Page<TThesisForEnglish>)thesisForEnglishMapper.selectByExample(example);
		//查询已确认和未确认的数量
		//将查询到的角色和已确认/未确认的信息保存到PageResult里面，然后返回给前端
		PageResult pageResult = getPageResult(page);

		pageResult.setRoleGrade(roleGrade);
		return ResultUtils.ok(pageResult);
	}

	/**
	 * 统计论文的已确认和为确认的数据信息
	 * @param page
	 * @return
	 */
	private PageResult getPageResult(Page page) {
		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
		//统计查询所有未确认的论文信息
		TThesisForEnglishExample unconfirmedCountExample=new TThesisForEnglishExample();
		TThesisForEnglishExample.Criteria unconfirmedCountCriteria = unconfirmedCountExample.createCriteria();
		addCriteriaByRoles(unconfirmedCountCriteria);
		//统计未确认的论文信息
		unconfirmedCountCriteria.andConfirmStatusEqualTo("2");
		unconfirmedCountCriteria.andStatusEqualTo("1");
		int unconfirmedCount = thesisForEnglishMapper.countByExample(unconfirmedCountExample);
		pageResult.setUnconfirmedCount(unconfirmedCount);
		//统计查询所有已确认的论文信息
		TThesisForEnglishExample confirmedCountExample=new TThesisForEnglishExample();
		TThesisForEnglishExample.Criteria confirmedCountCriteria = confirmedCountExample.createCriteria();
		addCriteriaByRoles(confirmedCountCriteria);
		//分别统计已确认的论文信息
		confirmedCountCriteria.andConfirmStatusEqualTo("1");
		confirmedCountCriteria.andStatusEqualTo("1");
		int confirmedCount = thesisForEnglishMapper.countByExample(confirmedCountExample);
		pageResult.setConfirmedCount(confirmedCount);
		return pageResult;
	}

	/**
	 * 添加查询论文数据的条件
	 * @param thesisForEnglish
	 * @param criteria
	 */
	private String addThesisForChineseCriteria(TThesisForEnglish thesisForEnglish, TThesisForEnglishExample.Criteria criteria) {
		//标题
		if(thesisForEnglish.getTitle()!=null && thesisForEnglish.getTitle().length()>0){
			criteria.andTitleLike("%"+thesisForEnglish.getTitle()+"%");
		}
		//作者
		if(thesisForEnglish.getAuthor()!=null && thesisForEnglish.getAuthor().length()>0){
			criteria.andAuthorLike("%"+thesisForEnglish.getAuthor()+"%");
		}
		//卷
		if(thesisForEnglish.getRoll()!=null && thesisForEnglish.getRoll().length()>0){
			criteria.andRollEqualTo(thesisForEnglish.getRoll());
		}
		//期
		if(thesisForEnglish.getJournal()!=null && thesisForEnglish.getJournal().length()>0){
			criteria.andJournalEqualTo(thesisForEnglish.getJournal());
		}
		//ISSN
		if(thesisForEnglish.getIssn()!=null && thesisForEnglish.getIssn().length()>0){
			criteria.andIssnEqualTo(thesisForEnglish.getIssn());
		}
		//页码
		if(thesisForEnglish.getPage()!=null && thesisForEnglish.getPage().length()>0){
			criteria.andPageEqualTo(thesisForEnglish.getPage());
		}
		//根据时间段查询
		if(thesisForEnglish.getSearchStartTime() != null && thesisForEnglish.getSearchEndTime()!= null){
			if (thesisForEnglish.getSearchStartTime().toString() != null && thesisForEnglish.getSearchStartTime().toString().length()>0
					&& thesisForEnglish.getSearchEndTime().toString() != null && thesisForEnglish.getSearchEndTime().toString().length()>0) {
				criteria.andYearBetween(thesisForEnglish.getSearchStartTime(),thesisForEnglish.getSearchEndTime());
			}
		}
		//单位
		if(thesisForEnglish.getAuthorCompany()!=null && thesisForEnglish.getAuthorCompany().length()>0){
			criteria.andAuthorCompanyLike("%"+thesisForEnglish.getAuthorCompany()+"%");
		}
		//地区
		if(thesisForEnglish.getArea()!=null && thesisForEnglish.getArea().length()>0){
			criteria.andAreaEqualTo(thesisForEnglish.getArea());
		}
		//确认状态
		if(thesisForEnglish.getConfirmStatus()!=null && thesisForEnglish.getConfirmStatus().length()>0){
			criteria.andConfirmStatusEqualTo(thesisForEnglish.getConfirmStatus());
		}
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		//根据用户角色添加本角色的限制条件，及该用户的权限范围内的数据查询
		String roleGrade = addCriteriaByRoles(criteria);
		return roleGrade;
	}

	/**
	 根据角色添加查询条件
	 * 设置省、市、医院、个人四级权限，根据不同的权限，修改服务层代码，查询不同的数据，
	 *不同的权限返回不同的数据，同时返回权限级别，不同的权限显示不同的按钮（级别给前端进行判断，根据级别的不同，显示不同的按钮。
	 *如专家按钮，在个人级别的时候不现实，单位查询按钮在单位级别以下的不显示，地区选择按钮省级可选择地级市以下的地区和单位，
	 *地级市只能查询本市以下的地区和单位）
	 */
	private String addCriteriaByRoles(TThesisForEnglishExample.Criteria criteria) {
		UUser currentUser = CurrentUser.returnCurrentUser();
		if (currentUser != null) {
			String roleGrade = null;
			//获取用户角色
			List<URole> rlist = roleService.findRoleByUid(currentUser.getId());
			//根据角色的获取不同的数据，如果是admin或省级角色，查询所有的数据，如果是市级权限，查询本市的数据，
			// 如果是单位权限，查询本单位的数据，如果是个人的角色，查询个人的数据
			for (URole role : rlist) {
				if("admin".equals(role.getName())){
					//不添加任何限制条件
				}else if("省级".equals(role.getName())){
					//不添加任何限制条件
				}else if("地市级".equals(role.getName())){
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本市的名称
						criteria.andAreaEqualTo(currentUser.getArea());
					}
				}else if("个人".equals(role.getName())){
					if(currentUser.getCompanyId()!=null && currentUser.getCompanyId().length()>0){
						//添加本单位的名称
						criteria.andAuthorCompanyIdEqualTo(currentUser.getCompanyId());
					}
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本人所属地区
						criteria.andAreaEqualTo(currentUser.getArea());
					}
					if(currentUser.getUsername()!=null && currentUser.getUsername().length()>0){
						//添加本人的名称
						//criteria.andAuthor
						criteria.andAuthorEqualTo(currentUser.getUsername());
					}
				}else if("医院".equals(role.getName())){
					if(currentUser.getCompanyId()!=null && currentUser.getCompanyId().length()>0){
						//添加本单位的名称
						criteria.andAuthorCompanyIdEqualTo(currentUser.getCompanyId());
					}
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本人所属地区
						criteria.andAreaEqualTo(currentUser.getArea());
					}
				}
				roleGrade = role.getName();
			}
			return roleGrade;
		}
		return "该用户角色非法";
	}

	/**
	 * 根据条件查询出条件范围内的所有数据（不分页，与分页条件查询的区别），然后控制层将集合所有的数据转存储为excel的方式进行下载
	 * @param thesisForEnglish
	 * @return
	 */
	@Override
	public List<TThesisForEnglish> findThesisForEnglishToExcel(TThesisForEnglish thesisForEnglish) {
		TThesisForEnglishExample example = new TThesisForEnglishExample();
		TThesisForEnglishExample.Criteria criteria = example.createCriteria();
		if (thesisForEnglish != null) {
			addThesisForChineseCriteria(thesisForEnglish, criteria);
			//只查询状态为1的数据
			criteria.andStatusEqualTo("1");
		}
		//条件查询
		List<TThesisForEnglish> list = thesisForEnglishMapper.selectByExample(example);
		return list;
	}

	/**
	 * 批量确认
	 * @param ids
	 */
	@Override
	public void confirmThesisForEnglishStatus(Integer[] ids) {
		for(Integer id:ids){
			TThesisForEnglish thesisForEnglish = thesisForEnglishMapper.selectByPrimaryKey(id);
			//已确认 确认状态修改为“1”
			thesisForEnglish.setConfirmStatus("1");
			thesisForEnglishMapper.updateByPrimaryKey(thesisForEnglish);
		}
	}

	/**
	 *sci论文
	 *	地区
	 区域统计比较
	 */
	@Override
	public List<Count> countTheNumberOfThesisForEnglishInEachArea(){
		return thesisForEnglishMapper.countTheNumberOfThesisForEnglishInEachArea();
	}

	@Override
	public void cleanThesisForEnglish() throws Exception{
		Set<String> set = new HashSet();
		Set<String> setNew = new HashSet();
		//查询不同的单位
		List<String> organizerList = thesisForEnglishMapper.selectDistinctOrganizer();
		for (String organizer:organizerList) {
			if(StringUtils.isNotBlank(organizer)){
				String[] split = organizer.split(";");
				for (String s:split) {
					set.add(s);
				}
			}
		}
		for (String organizer:set) {
			TAreaAndCompanyExample example = new TAreaAndCompanyExample();
			TAreaAndCompanyExample.Criteria criteria = example.createCriteria();
			criteria.andCompanyEqualTo(organizer);
			List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectByExample(example);
			if(areaAndCompanyList.isEmpty()){
				setNew.add(organizer);
			}
		}
		for (String organizer:setNew) {
			System.out.println(organizer);
		}
		System.out.println(setNew.size());
	}




	/*//根据省卫计委多有单位id去统计外文发表数量
	@Override
	public  void getThesisForEnglish(){
		HashMap<String ,Integer> map = new HashMap<>();
		List<String> allCompanyId = areaAndCompanyMapper.selectAllCompanyId();
		for(String companyId:allCompanyId){
			TThesisForEnglishExample example = new TThesisForEnglishExample();
			example.createCriteria().andAuthorCompanyIdEqualTo(companyId);
			List<TThesisForEnglish> thesisForEnglishList = thesisForEnglishMapper.selectByExample(example);

			for (TThesisForEnglish thesisForEnglish:thesisForEnglishList) {
				String company = thesisForEnglish.getAuthorCompany();

					if(StringUtils.isNotBlank(company)){
						if(map.get(company)==null){
							map.put(company,1);
						}else{
							map.put(company,map.get(company)+1);
						}
					}
			}
		}

		RW2FileUtil.writeHashMap2File(map,"E:\\healthybigdata\\recordHashMap2File2.txt");
	}*/

	/**
	 * 获取外文solr中的数据
	 * 	传入省卫计委所有单位id
	 */
	HashMap map = new HashMap();
	@Override
	public  void getThesisForEnglishFromSolr() throws Exception{
		List<String> allCompanyId = areaAndCompanyMapper.selectAllCompanyId();
		//String queryStr = "tatistics_abstracts_blong_to_hospital_name:(\"12330100470116614F\")";
		//String queryStr = "tatistics_abstracts_blong_to_hospital_name:(\"12330100470116614F\",\"12330000470051734A\")";
		String queryStr = "";
		for (String companyId:allCompanyId) {
			queryStr += "\"" +companyId +"\",";
		}
		queryStr = "tatistics_abstracts_blong_to_hospital_name:(" + queryStr.substring(0,queryStr.length()-1) +")";
		//System.out.println(queryStr);
		//solr游标数据
		Map<String,String> markMap = new HashMap();
		markMap.put("mark","*");
		int pageSize = 1000;
		while (true){
			//获取StatisticsAbstractSolr数据
			String nextMark = getSimpleStatisticsAbstractSolrFromAbstractSolr(queryStr,markMap.get("mark"),pageSize);
			if(StringUtils.isBlank(nextMark)){
				break;
			}else{
				markMap.put("mark",nextMark);
			}
		}
		RW2FileUtil.writeHashMap2File(map,"E:\\healthybigdata\\recordHashMap2File2.txt");
	}

	public String getSimpleStatisticsAbstractSolrFromAbstractSolr(String queryStr,String mark,int pageSize)  throws Exception{
		SolrQuery sq = new SolrQuery(queryStr);
		//查询超时时间
		//sq.setTimeAllowed(3*1*1000);
		//分页设置
		sq.setStart(0);
		sq.setRows(pageSize);
		sq.setSort("abstract_id",SolrQuery.ORDER.asc);
		sq.set(CursorMarkParams.CURSOR_MARK_PARAM,mark);
		QueryResponse queryResponse = SafeSolrClientUtil.query(SolrConfig.SOLR_USER, SolrConfig.SOLR_PASSWORD, solrClient, sq, SolrConfig.ABSTRACT_STATISTICS);
		SolrDocumentList results = queryResponse.getResults();
		//System.out.println(results.getNumFound());
		List<AbstractSolr> list = queryResponse.getBeans(AbstractSolr.class);
		//List<AbstractMysql> insertList = new ArrayList();

		for (AbstractSolr abstractSolr:list) {
			AbstractMysql abstractMysql = new AbstractMysql();
			if(abstractSolr.getAbstractAuthors()!=null && abstractSolr.getAbstractAuthors().size()>0){
				abstractMysql.setAbstractAuthors(abstractSolr.getAbstractAuthors().toString());
			}
			abstractMysql.setAbstractId(abstractSolr.getAbstractId());
			abstractMysql.setAbstractText(abstractSolr.getAbstractText());
			abstractMysql.setAffiliationStr(abstractSolr.getAffiliationStr());
			abstractMysql.setArticleTitle(abstractSolr.getArticleTitle());
			abstractMysql.setAuthorsStr(abstractSolr.getAuthorsStr());
			abstractMysql.setCountry(abstractSolr.getCountry());
			abstractMysql.setElocationIdDOI(abstractSolr.getElocationIdDOI());
			abstractMysql.setHadFreeFullText(abstractSolr.getHadFreeFullText());
			abstractMysql.setHadFullText(abstractSolr.getHadFullText());
			abstractMysql.setIsoAbbreviation(abstractSolr.getIsoAbbreviation());
			abstractMysql.setIssn(abstractSolr.getIssn());
			abstractMysql.setIssue(abstractSolr.getIssue());
			abstractMysql.setJournalId(abstractSolr.getJournalId());
			if(abstractSolr.getJournalIndexes()!=null && abstractSolr.getJournalIndexes().size()>0){
				abstractMysql.setJournalIndexes(abstractSolr.getJournalIndexes().toString());
			}
			abstractMysql.setJournalTitleMain(abstractSolr.getJournalTitleMain());
			abstractMysql.setKeyWords(abstractSolr.getKeyWords());
			abstractMysql.setLanguage(abstractSolr.getLanguage());
			abstractMysql.setMedlineDate(abstractSolr.getMedlineDate());
			abstractMysql.setMedlinePage(abstractSolr.getMedlinePage());
			abstractMysql.setMedlineTA(abstractSolr.getMedlineTA());
			abstractMysql.setMeshHeads(abstractSolr.getMeshHeads());
			abstractMysql.setMeshHeadsUI(abstractSolr.getMeshHeadsUI());
			abstractMysql.setNlmUniqueID(abstractSolr.getNlmUniqueID());
			abstractMysql.setOriginalURL(abstractSolr.getOriginalURL());
			abstractMysql.setPmid(abstractSolr.getPmid());
			if(abstractSolr.getPublicationTypes()!=null && abstractSolr.getPublicationTypes().size()>0){
				abstractMysql.setPublicationTypes(abstractSolr.getPublicationTypes().toString());
			}
			if(abstractSolr.getQualifier()!=null && abstractSolr.getQualifier().size()>0){
				abstractMysql.setQualifier(abstractSolr.getQualifier().toString());
			}
			if(abstractSolr.getTatisticsAbstractsBlongToHospitalName()!=null && abstractSolr.getTatisticsAbstractsBlongToHospitalName().size()>0){
				abstractMysql.setTatisticsAbstractsBlongToHospitalName(abstractSolr.getTatisticsAbstractsBlongToHospitalName().toString());
			}
			abstractMysql.setTranslateTest(abstractSolr.getTranslateTest());
			abstractMysql.setVolume(abstractSolr.getVolume());
			try{
				thesisForEnglishMapper.insertOne(abstractMysql);
			}catch (UncategorizedSQLException u){
				map.put(abstractMysql.getAbstractId(),abstractMysql);
				u.printStackTrace();
			}

			//System.out.println("标题："+abstractSolr.getArticleTitle());
			//insertList.add(abstractMysql);
		}
		//thesisForEnglishMapper.insertBatch(insertList);

		if(list.isEmpty()){
			return null;
		}else {
			System.out.println(list.get(0).getAbstractId());
			return queryResponse.getNextCursorMark();
		}
	}

	/**
	 * 将solr的数据添加到外文表中
	 * 	1.查询外文文献的数据
	 * 	2.查询外文期刊的数据
	 * 	3.查询外文jcr分区的数据
	 * 	4.将这些数据封装到外文实体同，并存入数据库
	 */
	@Override
	public void insertDataFromSolr(){
		String regEx="[\\[\\] ]";
		List<AbstractMysql> abstractMysqlList = thesisForEnglishMapper.selectThesisForEnglishFromSolr();
		for (AbstractMysql abstractMysql:abstractMysqlList) {
			TThesisForEnglish thesisForEnglish = new TThesisForEnglish();
			String journalId = abstractMysql.getJournalId();
			thesisForEnglish.setAuthorCompany(abstractMysql.getAffiliationStr());
			thesisForEnglish.setAuthor(abstractMysql.getAuthorsStr());
			//thesisForEnglish.setAuthorsAddress();
			//thesisForEnglish.setAbstracts();
			thesisForEnglish.setDoi(abstractMysql.getElocationIdDOI());
			thesisForEnglish.setIssn(abstractMysql.getIssn());
			thesisForEnglish.setJournalName(abstractMysql.getJournalTitleMain());
			thesisForEnglish.setJournal(abstractMysql.getIssue());
			thesisForEnglish.setKeywords(abstractMysql.getKeyWords());
			thesisForEnglish.setPage(abstractMysql.getMedlinePage());
			thesisForEnglish.setRoll(abstractMysql.getVolume());
			thesisForEnglish.setTitle(abstractMysql.getArticleTitle());
			DateFormat df = new SimpleDateFormat("yyyy");
			if(abstractMysql.getMedlineDate()!=null){
				String formatYear = df.format(abstractMysql.getMedlineDate());
				thesisForEnglish.setYear(formatYear);
				//查询文献当年的影响因子
				List<String> allIf = thesisForEnglishMapper.selectIfByJournalId(journalId);
				if(allIf!=null && allIf.size()>0){
					String[] split1 = allIf.toString().split(";");
					for (String ifAndYear:split1) {
						if(ifAndYear.contains(formatYear)){
							thesisForEnglish.setImpactFactor(ifAndYear.substring(ifAndYear.indexOf(":")+1));
						}
					}
				}
			}
			//根据期刊id查询jcr分区
			List<String> jcrList = thesisForEnglishMapper.selectJcrByJournalId(journalId);
			if(jcrList!=null && jcrList.size()>0){
				String jcr = CleanSpecialSymbolUtil.cleanSpecialSymbol(jcrList.toString(),regEx);
				thesisForEnglish.setJcrPartition(jcr);
			}
			//根据期刊id查询学科
			List<String> subjectList = thesisForEnglishMapper.selectSubjectByJournalId(journalId);
			if(subjectList!=null && subjectList.size()>0){
				String subject = CleanSpecialSymbolUtil.cleanSpecialSymbol(subjectList.toString(),regEx);
				thesisForEnglish.setSubject(subject);
			}
			//根据单位id查询所属地区
			String companyIds = abstractMysql.getTatisticsAbstractsBlongToHospitalName();
			if(StringUtils.isNotBlank(companyIds)){
				companyIds = CleanSpecialSymbolUtil.cleanSpecialSymbol(companyIds,regEx);
				thesisForEnglish.setAuthorCompanyId(companyIds);
				String[] split = companyIds.split(",");
				String area = "";
				for (String companyId:split) {
					List<String> areaList = thesisForEnglishMapper.selectAreaByCompanyId(companyId);
					if(areaList!=null && areaList.size()>0){
						area += areaList.get(0)+";";
					}
				}
				if(StringUtils.isNotBlank(area)){
					thesisForEnglish.setArea(area.substring(0,area.length()-1));
				}

			}
			thesisForEnglish.setAuthorsAddress(abstractMysql.getAbstractId());
			thesisForEnglish.setConfirmStatus("2");
			thesisForEnglish.setStatus("1");
			thesisForEnglishMapper.insert(thesisForEnglish);
		}
	}

	/**
	 *sci论文
	 	数量
	 		插入单位top20
	 */
	@Override
	public void insertCompanyBeforeTwentieth(){
		TAreaAndCompanyExample example = new TAreaAndCompanyExample();
		List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectByExample(example);
		for (TAreaAndCompany areaAndCompany:areaAndCompanyList) {
			TThesisForEnglishExample thesisForEnglishExample = new TThesisForEnglishExample();
			thesisForEnglishExample.createCriteria().andAuthorCompanyIdLike("%"+areaAndCompany.getCompanyId()+"%");
			int count = thesisForEnglishMapper.countByExample(thesisForEnglishExample);
			areaAndCompany.setThesisForEnglishNum(count);
			System.out.println(areaAndCompany);
			areaAndCompanyMapper.updateByPrimaryKey(areaAndCompany);
		}
	}
	/**
	 *sci论文
		 数量
	 		查询各地区单位top5
	 */
	@Override
	public List<TAreaAndCompany> selectBeforeTwentieth(){
		List  allList = new ArrayList();
		for (Area area:Area.values()) {
			List<TAreaAndCompany> list = areaAndCompanyMapper.selectEnglishBeforeX(area.getMsg(), 5);
			for (TAreaAndCompany areaAndCompany:list) {
				allList.add(areaAndCompany);
			}
		}
		return allList;
	}


	/**
	 * 插入学科前20的数据
	 */
	@Override
	public void insertSujectBeforeTwentieth(){
	/*	List<Count> list = thesisForEnglishMapper.selectSujectBeforeTwentieth();
		int i = 1;
		for (Count count:list) {
			TCountTopSubject countTopSubject = new TCountTopSubject();
			countTopSubject.setCount(count.getCount());
			countTopSubject.setSubject(count.getArea());
			countTopSubject.setTopNum(i);
			countTopSubject.setType("外文");
			thesisForEnglishMapper.insertSujectBeforeTwentieth(countTopSubject);
			i++;
		}*/

		Map<String ,Integer> map = new HashMap<>();
		TThesisForEnglishExample example = new TThesisForEnglishExample();
		example.createCriteria().andSubjectIsNotNull().andSubjectNotEqualTo("未知");
		List<TThesisForEnglish> thesisForEnglishList = thesisForEnglishMapper.selectByExample(example);

		for (TThesisForEnglish thesisForEnglish:thesisForEnglishList) {
			String[] split = thesisForEnglish.getSubject().split(",");
			for (String subject : split ) {
				if(StringUtils.isNotBlank(subject)){
					if(map.get(subject)==null){
						map.put(subject,1);
					}else{
						map.put(subject,map.get(subject)+1);
					}
				}


			}
		}

		Map<String, Integer> stringIntegerMap = sortDescend(map,20);
		int i = 1;
		for(Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()){
			TCountTopSubject countTopSubject = new TCountTopSubject();
			countTopSubject.setCount(entry.getValue());
			countTopSubject.setSubject(entry.getKey());
			countTopSubject.setTopNum(i);
			countTopSubject.setType("外文");
			thesisForEnglishMapper.insertSujectBeforeTwentieth(countTopSubject);
			i++;
		}

	}
	/**
	 *sci论文
	 数量
	 学科top20
	 */
	@Override
	public List<TCountTopSubject>  selectSujectBeforeTwentieth(){
		return thesisForEnglishMapper.selectSujectTopTwentieth();
	}

	/**
	 *sci论文
	 	数量
	 		关键词、热词研究top20
	 */
	@Override
	public void insertKeywordsBeforeTwentieth(){
		Map<String ,Integer> map = new HashMap<>();
		/*TThesisForEnglishExample example = new TThesisForEnglishExample();
		example.createCriteria().andKeywordsIsNotNull();
		List<TThesisForEnglish> thesisForEnglishList = thesisForEnglishMapper.selectByExample(example);*/

		//去重版
		TThesisForEnglishFromSolrExample example = new TThesisForEnglishFromSolrExample();
		example.createCriteria().andKeywordsIsNotNull();
		List<TThesisForEnglishFromSolr> tThesisForEnglishFromSolrList = thesisForEnglishFromSolrMapper.selectByExample(example);
		for (TThesisForEnglishFromSolr thesisForEnglish:tThesisForEnglishFromSolrList) {
			String[] split = thesisForEnglish.getKeywords().split(",");
			for (String keyword: split ) {

				if(StringUtils.isNotBlank(keyword) && keyword.length()>1){
					String first = keyword.substring(0, 1);
					first = first.toUpperCase();
					String after = keyword.substring(1);
					keyword = first + after;
				}
				if(!"China".equals(keyword)){
					if(map.get(keyword)==null){
						map.put(keyword,1);
					}else{
						map.put(keyword,map.get(keyword)+1);
					}
				}

			}
		}

		Map<String, Integer> stringIntegerMap = sortDescend(map,20);
		//导入热词
		//Map<String, Integer> stringIntegerMap = sortDescend(map,200);
		int i = 1;
		for(Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()){
			TCountTopKeywords countTopKeywords = new TCountTopKeywords();
			countTopKeywords.setKeywords(entry.getKey());
			countTopKeywords.setCount(entry.getValue());
			countTopKeywords.setTopNum(i);
			countTopKeywords.setType("外文");
			countTopKeywords.setArea("浙江省");
			thesisForEnglishMapper.insertKeywordsBeforeTwentieth(countTopKeywords);
			i++;
		}
	}
	/**
	 *sci论文
	 数量
	 关键词、热词研究top20
	 */
	@Override
	public List<TCountTopKeywords> selectKeywordsBeforeTwentieth(){
		return thesisForEnglishMapper.selectKeywordsBeforeTwentieth("外文","浙江省");
	}
	/**
	 * 排序
	 * @param map
	 * @param <K>
	 * @param <V>
	 * @return
	 */
	public static <K,V extends Comparable<? super V>> Map<K,V> sortDescend(Map<K,V> map ,int top){
		List<Map.Entry<K,V>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				int compare = (o1.getValue()).compareTo(o2.getValue());
				return -compare;
			}
		});
		//返回前20的
		int i = 0;
		Map<K,V> returnMap = new LinkedHashMap<K,V>();
		for(Map.Entry<K,V> entry :list){
			if(i==top){
				break;
			}
			returnMap.put(entry.getKey(),entry.getValue());
			i++;
		}

		return returnMap;
	}

	/**
	 *sci论文
	 *	if（影响因子总和）
	 *		单位top20
	 */
	@Override
	public void insertIfCompanyBeforeTwentieth() {
		Map<String ,Double> map = new HashMap<String ,Double>();
		TAreaAndCompanyExample example = new TAreaAndCompanyExample();
		List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectByExample(example);
		for (TAreaAndCompany areaAndCompany : areaAndCompanyList) {
			Object ifSum = thesisForEnglishMapper.selectIfByCompanyId("%" + areaAndCompany.getCompanyId() + "%");
			if(ifSum!=null){
				System.out.println(ifSum);
				map.put(areaAndCompany.getCompany(),Double.parseDouble(ifSum.toString()));
			}

		}
		Map<String, Double> stringDoubleMap = sortDescend(map,20);
		for (Map.Entry<String, Double> entry : stringDoubleMap.entrySet()){
			TCountTopIf countTopIf = new TCountTopIf();
			countTopIf.setCompany(entry.getKey());
			countTopIf.setImpactFactorSum(entry.getValue());
			countTopIf.setType("1");
			thesisForEnglishMapper.insertCountImpactFactor(countTopIf);
		}
	}
	@Override
	public List<TCountTopIf> selectIfCompanyBeforeTwentieth(){
		return thesisForEnglishMapper.selectCountImpactFactor("1");
	}

	/**
	 *sci论文
	 *	if（影响因子总和）
	 *		插入学科top20
	 */
	@Override
	public void insertIfSubjectBeforeTwentieth(){
		List<TCountTopIf> countList = thesisForEnglishMapper.selectIfSubjectBeforeTwentieth();
		for (TCountTopIf count:countList) {
			TCountTopIf countTopIf = new TCountTopIf();
			double avgIfBySubject = thesisForEnglishMapper.selectAvgIfBySubject(count.getSubject());
			countTopIf.setImpactFactorSum(count.getImpactFactorSum());
			countTopIf.setSubject(count.getSubject());
			countTopIf.setSubjectAvgIf(avgIfBySubject);
			countTopIf.setType("2");
			thesisForEnglishMapper.insertCountImpactFactor(countTopIf);
		}
	}
	/**
	 *sci论文
	 *	if（影响因子总和和平均影响因子）
	 *		查询学科top20
	 */
	@Override
	public List<TCountTopIf> selectIfSubjectBeforeTwentieth(){
		return thesisForEnglishMapper.selectCountImpactFactor("2");
	}
	/**
	 *sci论文
	 *	论文top20（影响因子最高的、单个、附带这篇文章的单位）
	 */
	@Override
	public List<TCountTopIf> selectIfThesisBeforeTwentieth(){
		return thesisForEnglishMapper.selectIfThesisBeforeTwentieth();
	}

	/**
	 *sci论文
	 *	地区
	 *		区域研究热词（top20，每个地区的）
	 */
	@Override
	public void insertKeywordsBeforeTwentiethInEachArea(){
		Map<String,Map> returnAreaMap = new HashMap();
		for (Area area:Area.values()) {
			Map<String ,Integer> map = new HashMap<String ,Integer>();
			TThesisForEnglishExample example = new TThesisForEnglishExample();
			TThesisForEnglishExample.Criteria criteria = example.createCriteria();
			criteria.andKeywordsIsNotNull();
			criteria.andAreaLike("%"+area.getMsg()+"%");
			List<TThesisForEnglish> thesisForEnglishList = thesisForEnglishMapper.selectByExample(example);
			for (TThesisForEnglish thesisForEnglish:thesisForEnglishList) {
				String[] split = thesisForEnglish.getKeywords().split(",");
				for (String keyword: split ) {
					if(map.get(keyword)==null){
						map.put(keyword,1);
					}else{
						map.put(keyword,map.get(keyword)+1);
					}
				}
			}
			Map<String, Integer> areaMap = sortDescend(map,20);
			int i = 1;
			for(Map.Entry<String, Integer> entry : areaMap.entrySet()){
				TCountTopKeywords countTopKeywords = new TCountTopKeywords();
				countTopKeywords.setKeywords(entry.getKey());
				countTopKeywords.setCount(entry.getValue());
				countTopKeywords.setTopNum(i);
				countTopKeywords.setType("外文");
				countTopKeywords.setArea(area.getMsg());
				thesisForEnglishMapper.insertKeywordsBeforeTwentieth(countTopKeywords);
				i++;
			}
		}
	}
	@Override
	public List selectKeywordsBeforeTwentiethInEachArea(){
	     //按地区查
		/*List list = new ArrayList();
		for (Area area:Area.values()) {
			Count count = new Count();
			List<TCountTopKeywords> keywordsList = thesisForEnglishMapper.selectKeywordsBeforeTwentieth("外文", area.getMsg());
			//map.put(area.getMsg(),keywordsList);
			count.setArea(area.getMsg());
			count.setCountList(keywordsList);
			list.add(count);
		}*/


		//查200个热词
		List<TCountTopKeywords> keywordsList = thesisForEnglishMapper.selectKeywordsBeforeTwentiethHot("外文");
		return keywordsList;
	}
	/**
	 *sci论文
	 *	地区
	 *		区域单位排名
	 */
	@Override
	public List selectBeforeTwentiethInEachArea(){
		List rlist = new ArrayList();
		List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectEnglishBeforeTwentiethInEachArea();
		for (Area area:Area.values()) {
			Count count = new Count();
			List list = new ArrayList();
			for (TAreaAndCompany areaAndCompany:areaAndCompanyList) {
				if(area.getMsg().equals(areaAndCompany.getCity())){
					list.add(areaAndCompany);
				}
			}
			count.setArea(area.getMsg());
			count.setCountList(list);
			rlist.add(count);
		}
		return rlist;
	}
	/**
	 * 清理jcr分区数据
	 */
	@Override
	public void cleanJcr(){
		String regEx="[\\[\\] ]";
		TThesisForEnglishExample example = new TThesisForEnglishExample();
		TThesisForEnglishExample.Criteria criteria = example.createCriteria();
		criteria.andJcrPartitionIsNotNull();
		List<TThesisForEnglish> thesisForEnglishList = thesisForEnglishMapper.selectByExample(example);
		for (TThesisForEnglish thesisForEnglish:thesisForEnglishList) {
			String[] split = thesisForEnglish.getJcrPartition().split(",");
			Set<String> set = new HashSet();
			if(split != null && split.length>0){
				for (String jcrp:split) {
					set.add(jcrp);
				}
			}
			String jcr = CleanSpecialSymbolUtil.cleanSpecialSymbol(set.toString(), regEx);
			thesisForEnglish.setJcrPartition(jcr);
			thesisForEnglishMapper.updateByPrimaryKey(thesisForEnglish);
			//System.out.println(thesisForEnglish);
		}
	}

	/**
	 * ci论文
	 *	jcr分区 插入
	 *		浙江省论文jcr分区分布(饼状图，各分区的数量)
	 */
	@Override
	public void insertJcrDistribution(){
		String jcrArray[] = {"Q1","Q2","Q3","Q4"};
		for (String jcr:jcrArray) {
			int countJcrNum = thesisForEnglishMapper.countJcrNum("%" + jcr + "%");
			thesisForEnglishMapper.insertJcrDistribution(jcr, countJcrNum,"1");
		}

	}

	/**
	 *sci论文
	 *	jcr分区
	 *		浙江省论文jcr分区分布(饼状图，各分区的数量)
	 */
	@Override
	public List<TCountTopJcr> selectJcrDistribution(){
		return thesisForEnglishMapper.selectJcrDistribution("1");
	}

	/**
	 *sci论文
	 *	jcr分区
	 *		各地区jcr分区分布(饼状图，杭州市各分区的数量)
	 */
	@Override
	public void insertJcrAndArea(){
		String jcrArray[] = {"Q1","Q2","Q3","Q4"};
		for (Area area:Area.values()) {
			for (String jcr:jcrArray) {
				TCountTopJcr countTopJcr = new TCountTopJcr();
				int countJcrByArea = thesisForEnglishMapper.countJcrByArea("%" + jcr + "%", "%" + area.getMsg() + "%");
				countTopJcr.setArea(area.getMsg());
				countTopJcr.setCount(countJcrByArea);
				countTopJcr.setJcr(jcr);
				countTopJcr.setType("2");
				thesisForEnglishMapper.insertJcr(countTopJcr);
			}
		}

	}
	@Override
	public List<TCountTopJcr> selectJcrAndAreaDistribution(){
		return thesisForEnglishMapper.selectJcrDistribution("2");
	}

	/**
	 * 插入jcr分区单位top10
	 */
	@Override
	public void insertJcrTopTenCompany(){
		TAreaAndCompanyExample example = new TAreaAndCompanyExample();
		List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectByExample(example);
		String jcrArray[] = {"Q1","Q2","Q3","Q4"};

		for (String jcr:jcrArray) {
			Map<String ,Integer> map = new HashMap<String ,Integer>();
			for (TAreaAndCompany areaAndCompany:areaAndCompanyList) {
				TThesisForEnglishExample englishExample = new TThesisForEnglishExample();
				TThesisForEnglishExample.Criteria criteria = englishExample.createCriteria();
				criteria.andAuthorCompanyIdLike("%" + areaAndCompany.getCompanyId() + "%");
				criteria.andJcrPartitionLike("%" + jcr + "%");
				List<TThesisForEnglish> thesisForEnglishList = thesisForEnglishMapper.selectByExample(englishExample);
				map.put(areaAndCompany.getCompany(),thesisForEnglishList.size());
			}
			Map<String, Integer> stringIntegerMap = sortDescend(map,20);
			for(Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()){
				TCountTopJcr countTopJcr = new TCountTopJcr();
				countTopJcr.setType("3");
				countTopJcr.setJcr(jcr);
				countTopJcr.setCompany(entry.getKey());
				countTopJcr.setCount(entry.getValue());
				System.out.println(countTopJcr);
				thesisForEnglishMapper.insertJcr(countTopJcr);
			}

		}

	}
	/**
	 *sci论文
	 *	jcr分区
	 *		一区单位top10
	 */
	@Override
	public List<TCountTopJcr> oneAreaTopTenCompany(){
		return thesisForEnglishMapper.selectJcrDistributionByJcr("3","Q1");
	}

	/**
	 *sci论文
	 *	jcr分区
	 *		二区单位top10
	 */
	@Override
	public List<TCountTopJcr> twoAreaTopTenCompany(){
		return thesisForEnglishMapper.selectJcrDistributionByJcr("3","Q2");
	}
	/**
	 *sci论文
	 *	jcr分区
	 *		三区单位top10
	 */
	@Override
	public List<TCountTopJcr> threeAreaTopTenCompany(){
		return thesisForEnglishMapper.selectJcrDistributionByJcr("3","Q3");
	}
	/**
	 *sci论文
	 *	jcr分区
	 *		四区单位top10
	 */
	@Override
	public List<TCountTopJcr> foreAreaTopTenCompany(){
		return thesisForEnglishMapper.selectJcrDistributionByJcr("3","Q4");
	}
	/**
	 *sci论文
	 	期刊发文排名top20（期刊发表文献数量前20）
	 */
	@Override
	public void insertJournalTopTwentieth(){
		/*List<Count> countList = thesisForEnglishMapper.selectJournalTopTwentieth();
		for (Count count:countList) {
			TCountTopJournal countTopJournal = new TCountTopJournal();
			countTopJournal.setJournalName(count.getArea());
			countTopJournal.setCount(count.getCount());
			countTopJournal.setType("2");
			thesisForEnglishMapper.insertJournalTopTwentieth(countTopJournal);
		}*/

		Map<String ,Integer> map = new HashMap<>();
		List<TThesisForEnglish> thesisForEnglishList = thesisForEnglishMapper.selectByExample(null);
		for (TThesisForEnglish thesisForEnglish:thesisForEnglishList) {
			String journalName = thesisForEnglish.getJournalName();
			if(map.get(journalName)==null){
						map.put(journalName,1);
					}else{
						map.put(journalName,map.get(journalName)+1);
					}
			}
		Map<String, Integer> stringIntegerMap = sortDescend(map,50);
		for(Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()){
				TCountTopJournal countTopJournal = new TCountTopJournal();
				countTopJournal.setJournalName(entry.getKey());
				countTopJournal.setCount(entry.getValue());
				countTopJournal.setType("2");
				thesisForEnglishMapper.insertJournalTopTwentieth(countTopJournal);
		}
	}
	@Override
	public List<TCountTopJournal> selectJournalTopTwentieth(){
		return thesisForEnglishMapper.selectJournalTopTwentiethByTable("2");
	}

	/**
	 *sci论文
	 *	top10作者合作关系网
	 *	1.查询出所有的作者
	 *	2.统计每个作者出现的次数，取出top10
	 *	3.根据top10第一次查询和他们有合作关系的作者
	 *	4.统计和做次数，取出合作次数大于2次的
	 *	5.根据合作人1，查询与	他们有合作关系的合作人2
	 *	6.统计合作人2的次数，取出	合作次数大于2次的
	 */
	@Override
	public void insertAuthorNetwork(){
		int top = 10;
		int i = 1;
		for (Area area:Area.values()) {
			//查询出第一作者发文量top10的作者及发文次数
			List<String> authorList1 = thesisForEnglishMapper.selectAllAuthorInEachArea("%" + area.getMsg() + "%");
			List<String> list1 = new ArrayList() ;
			for (String authors:authorList1) {
				if(StringUtils.isNotBlank(authors)){
					//2.统计每个作者出现的次数，取出top10
					String[] split1 = authors.split(";");
					for (String author:split1) {
						list1.add(author);
					}
				}
			}
			Map<String, Long> map1 = list1.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
			Map<String, Long> authorTopMap = sortDescend(map1, top);
			for (Map.Entry<String, Long> entry : authorTopMap.entrySet()) {
				//3.根据top10第一次查询和他们有合作关系的作者
				List<String> authorList2 = thesisForEnglishMapper.selectAuthorByExample("%" + entry.getKey() + "%");
				List<String> list2 = new ArrayList() ;
				if(authorList2!=null && authorList2.size()>0){
					for (String authors:authorList2) {
						if(StringUtils.isNotBlank(authors)){
							String[] split2 = authors.split(";");
							for (String author:split2) {
								list2.add(author);
							}
						}
					}
				}
				//统计作者出现的次数，并封装到map集合里面
				Map<String, Long> map2 = list2.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
				//遍历集合
				for (Map.Entry<String, Long> entry2 : map2.entrySet()) {
					//获取合作次数大于4的
					if(entry2.getValue()>4){
						TCountEnglishAuthorNetwork1 countEnglishAuthorNetwork1 = new TCountEnglishAuthorNetwork1();
						countEnglishAuthorNetwork1.setId(i);
						countEnglishAuthorNetwork1.setArea(area.getMsg());
						countEnglishAuthorNetwork1.setAuthor(entry.getKey());
						countEnglishAuthorNetwork1.setAuthorPostNum(entry.getValue().intValue());
						countEnglishAuthorNetwork1.setCooperator(entry2.getKey());
						countEnglishAuthorNetwork1.setCooperationNum(entry2.getValue().intValue());
						countAuthorNetworkMapper.insertEnglish1(countEnglishAuthorNetwork1);
						//System.out.println(countEnglishAuthorNetwork1);
						List<String> authorList3 = thesisForEnglishMapper.selectAuthorByExample("%" + entry2.getKey() + "%");
						List<String> list3 = new ArrayList() ;
						if(authorList3!=null && authorList3.size()>0){
							for (String authors:authorList3) {
								if(StringUtils.isNotBlank(authors)){
									String[] split3 = authors.split(";");
									for (String author:split3) {
										list3.add(author);
									}
								}
							}
						}

						Map<String, Long> map3 = list3.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
						//遍历集合
						for (Map.Entry<String, Long> entry3 : map3.entrySet()) {
							//获取合作次数大于4的
							if(entry3.getValue()>4){
								TCountEnglishAuthorNetwork2 countEnglishAuthorNetwork2 = new TCountEnglishAuthorNetwork2();
								countEnglishAuthorNetwork2.setCooperatorId(countEnglishAuthorNetwork1.getId());
								countEnglishAuthorNetwork2.setAuthor(countEnglishAuthorNetwork1.getCooperator());
								countEnglishAuthorNetwork2.setCooperator(entry3.getKey());
								countEnglishAuthorNetwork2.setCooperationNum(entry3.getValue().intValue());
								countAuthorNetworkMapper.insertEnglish2(countEnglishAuthorNetwork2);
								//System.out.println(countEnglishAuthorNetwork2);
							}
						}
						i++;
					}
				}
			}
		}
	}

	/**
	 * 查询作者关系网
	 * @return
	 */
	@Override
	public CountAuthorNetwork selectAuthorNetwork(){

		CountAuthorNetwork countAuthorNetwork = new CountAuthorNetwork();
		List<String> allCompany = countAuthorNetworkMapper.selectEnglishAllAuthor();
		List<TCountEnglishAuthorNetwork1> authorPostNum = countAuthorNetworkMapper.selectEnglishAuthorPostNum();
		List<Relation> list1 = countAuthorNetworkMapper.selectEnglishAllCooperator1();
		List<Relation> list2 = countAuthorNetworkMapper.selectEnglishAllCooperator2();
		Set set = new HashSet();
		for (Relation relation:list1) {
			set.add(relation);
		}
		for (Relation relation:list2) {
			set.add(relation);
		}
		countAuthorNetwork.setEnglishAuthorPostNum(authorPostNum);
		countAuthorNetwork.setAllAuthor(allCompany);
		countAuthorNetwork.setSet(set);

		return countAuthorNetwork;
	}

	/**
	 * 插入top10单位合作关系网

	 * 	2.查询出单位发文量top10
	 * 	3.查询所有包含top10单位的合作单位
	 * 	4.统计合作单位出现的次数
	 * 	5.查询所有包含合作单位的下级合作单位
	 * 	6.统计下级合作单位的次数
	 * 	7.将数据插入数据库
	 */
	@Override
	public void insertCompanyNetwork(){
		List<TAreaAndCompany> companyList = areaAndCompanyMapper.selectChineseBeforeX(10);
		int i = 1;
		for (TAreaAndCompany areaAndCompany:companyList) {
			//查询所有包含top10单位的合作单位
			List<String> listCompany = thesisForEnglishMapper.selectCompanyByCompanyId("%" + areaAndCompany.getCompanyId() + "%");
			//将这些单位全部添加到list集合中
			List<String> list = new ArrayList() ;
			for (String cooperator:listCompany) {
				String[] split = cooperator.split(";");
				for (String company:split) {
					list.add(company);
				}
			}
			//统计单位出现的次数，并封装到map集合里面
			Map<String, Long> map = list.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
			//遍历集合
			for (Map.Entry<String, Long> entry : map.entrySet()) {
				//插入合作次数大于4的
				if((entry.getValue().intValue()>4)){
					//排除自己和自己的合作关系
					if(!areaAndCompany.getCompany().equals(entry.getKey())){
						TCountEnglishCompanyNetwork1 countEnglishCompanyNetwork1 = new TCountEnglishCompanyNetwork1();
						countEnglishCompanyNetwork1.setId(i);
						countEnglishCompanyNetwork1.setCompany(areaAndCompany.getCompany());
						countEnglishCompanyNetwork1.setCompanyPostNum(areaAndCompany.getThesisForEnglishNum());
						countEnglishCompanyNetwork1.setCooperator(entry.getKey());
						countEnglishCompanyNetwork1.setCooperationNum(entry.getValue().intValue());
						//System.out.println(countEnglishCompanyNetwork1);
						countCompanyNetworkMapper.insertEnglish1(countEnglishCompanyNetwork1);
						//根据当前的合作单位，查询与当前合作单位合作的单位
						List<String> listCompany1 = thesisForEnglishMapper.selectCompanyByCompany("%" + entry.getKey() + "%");
						List<String> list1 = new ArrayList() ;
						//将所有单位添加到集合中
						for (String cooperator1:listCompany1) {
							String[] split = cooperator1.split(", ");
							for (String company:split) {
								list1.add(company);
							}

						}
						//统计单位出现的次数，并封装到map集合里面
						Map<String, Long> map1 = list1.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
						for (Map.Entry<String, Long> entry1 : map1.entrySet()) {
							//获取合作大于4次的单位，并排除和自己合作的单位
							if(!entry.getKey().equals(entry1.getKey()) && entry1.getValue().intValue()>4){
								TCountEnglishCompanyNetwork2 countEnglishCompanyNetwork2 = new TCountEnglishCompanyNetwork2();
								countEnglishCompanyNetwork2.setCooperatorId(countEnglishCompanyNetwork1.getId());
								countEnglishCompanyNetwork2.setCompany(countEnglishCompanyNetwork1.getCooperator());
								countEnglishCompanyNetwork2.setCooperator(entry1.getKey());
								countEnglishCompanyNetwork2.setCooperationNum(entry1.getValue().intValue());
								//System.out.println(countEnglishCompanyNetwork2);
								countCompanyNetworkMapper.insertEnglish2(countEnglishCompanyNetwork2);
							}
						}
						i++;
					}
				}
			}
		}
	}
	/**
	 *sci论文
	 *	top10单位合作关系网
	 */
	@Override
	public CountCompanyNetwork selectCompanyNetwork(){
		CountCompanyNetwork countCompanyNetwork = new CountCompanyNetwork();
		List<String> allCompany = countCompanyNetworkMapper.selectAllEnglishCompany();
		List<TCountEnglishCompanyNetwork1> companyPostNum = countCompanyNetworkMapper.selectEnglishCompanyPostNum();

		List<Relation> list1 = countCompanyNetworkMapper.selectEnglishAllCooperator1();
		List<Relation> list2 = countCompanyNetworkMapper.selectEnglishAllCooperator2();
		Set set = new HashSet();
		for (Relation relation:list1) {
			set.add(relation);
		}
		for (Relation relation:list2) {
			set.add(relation);
		}
		countCompanyNetwork.setEnglishCompanyPostNum(companyPostNum);
		countCompanyNetwork.setAllCompany(allCompany);
		countCompanyNetwork.setSet(set);
		return countCompanyNetwork;
	}


	/**
	 * 插入各个单位的影响因子平均值
	 */
	@Override
	public void insertIfAvgInEachCompany(){
		TAreaAndCompanyExample example = new TAreaAndCompanyExample();
		List<TAreaAndCompany> list = areaAndCompanyMapper.selectByExample(example);
		for (TAreaAndCompany areaAndCompany:list) {
			TCountIf countIf = new TCountIf();
			Object avgIf = thesisForEnglishMapper.selectAvgIf("%" + areaAndCompany.getCompanyId() + "%");
			if(avgIf!=null){
				countIf.setAvgIf(Double.valueOf(avgIf.toString()));
			}
			Object sumIf = thesisForEnglishMapper.selectSumIf("%" + areaAndCompany.getCompanyId() + "%");
			if(sumIf!=null){
				countIf.setSumIf(Double.valueOf(sumIf.toString()));
			}
			countIf.setCompany(areaAndCompany.getCompany());
			countIfMapper.insert(countIf);
		}
	}

	/**
	 * 查询平均影响因子top20
	 */
	@Override
	public List<TCountIf> selectAvgIfTopTwentieth(){
		return countIfMapper.selectAvgIfTopTwentieth();
	}

	/**
	 * 查询作者发文量top10
	 */
	@Override
	public List selectAuthorPostNumTopTen(){
		return countAuthorNetworkMapper.selectEnglishAuthorPostNumTopTen();
	}

	@Override
	public List<String> thesisForEnglishTitle(String title) {
		if(StringUtils.isNotBlank(title)){
			title = "%"+title+"%";
			return thesisForEnglishMapper.selectThesisForEnglishTitle(title);
		}
		return null;
	}
}
