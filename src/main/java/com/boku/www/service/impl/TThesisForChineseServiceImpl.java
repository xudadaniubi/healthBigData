package com.boku.www.service.impl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import com.boku.www.Enum.Area;
import com.boku.www.mapper.*;
import com.boku.www.pojo.*;
import com.boku.www.pojo.system.URole;
import com.boku.www.pojo.system.UUser;
import com.boku.www.service.ThesisForChineseService;
import com.boku.www.service.system.RoleService;
import com.boku.www.utils.*;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

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
public class TThesisForChineseServiceImpl implements ThesisForChineseService {

	@Autowired
	private TThesisForChineseMapper thesisForChineseMapper;

	@Autowired
	private TThesisForEnglishMapper thesisForEnglishMapper;

	@Autowired
	private RoleService roleService;

	@Autowired
	private TAreaAndCompanyMapper areaAndCompanyMapper;

	@Autowired
	private TbCnkiJournalMapper cnkiJournalMapper;

	@Autowired
	private TbWanfangJournalMapper wanfangJournalMapper;

	@Autowired
	private TCountAuthorNetworkMapper countAuthorNetworkMapper;

	@Autowired
	private TCountCompanyNetworkMapper countCompanyNetworkMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<TThesisForChinese> findAll() {
		TThesisForChineseExample example=new TThesisForChineseExample();
		TThesisForChineseExample.Criteria criteria = example.createCriteria();
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		return thesisForChineseMapper.selectByExample(example);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		TThesisForChineseExample example=new TThesisForChineseExample();
		TThesisForChineseExample.Criteria criteria = example.createCriteria();
		//根据角色添加查询条件，每个用户只能查询本自己权限范围内的数据
		String roleGrade = addCriteriaByRoles(criteria);
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		//分页插件中分页只对下一个查询分页，所以需要紧跟想要转换的查询语句
		PageHelper.startPage(pageNum, pageSize);
		Page<TThesisForChinese> page= (Page<TThesisForChinese>) thesisForChineseMapper.selectByExample(example);
		//将查询到的角色和已确认/未确认的信息保存到PageResult里面，然后返回给前端
		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
		pageResult.setRoleGrade(roleGrade);
		return pageResult;
	}

	/**
	 * 增加
	 * 	增加数据后，该单位相应的文献数量+1
	 */
	@Override
	public void add(TThesisForChinese thesisForChinese) {
		thesisForChineseMapper.insert(thesisForChinese);
		String[] split = thesisForChinese.getAuthorCompanyId().split(";");
		for (String companyId:split) {
			TAreaAndCompanyExample example = new TAreaAndCompanyExample();
			example.createCriteria().andCompanyIdEqualTo(companyId);
			List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectByExample(example);
			if(areaAndCompanyList!=null && areaAndCompanyList.size()>0){
				TAreaAndCompany areaAndCompany = areaAndCompanyList.get(0);
				areaAndCompany.setThesisForChineseNum(areaAndCompany.getThesisForChineseNum()+1);
				areaAndCompanyMapper.updateByPrimaryKey(areaAndCompany);
			}
		}
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TThesisForChinese thesisForChinese){
		thesisForChineseMapper.updateByPrimaryKeySelective(thesisForChinese);
		//thesisForChineseMapper.updateByPrimaryKey(TThesisForChinese);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TThesisForChinese findOne(Integer id){
		return thesisForChineseMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 * 	删除数据后，该单位相应的文献数量-1
	 */
	@Override
	public void delete(@RequestBody Integer[] ids) {
		for(Integer id:ids){
			TThesisForChinese thesis = thesisForChineseMapper.selectByPrimaryKey(id);
			thesis.setStatus("2");
			thesisForChineseMapper.updateByPrimaryKey(thesis);
			String[] split = thesis.getAuthorCompanyId().split(";");
			for (String companyId:split) {
				TAreaAndCompanyExample example = new TAreaAndCompanyExample();
				example.createCriteria().andCompanyIdEqualTo(companyId);
				List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectByExample(example);
				if(areaAndCompanyList!=null && areaAndCompanyList.size()>0){
					TAreaAndCompany areaAndCompany = areaAndCompanyList.get(0);
					areaAndCompany.setThesisForChineseNum(areaAndCompany.getThesisForChineseNum()-1);
					areaAndCompanyMapper.updateByPrimaryKey(areaAndCompany);
				}
			}

		}
	}

	/**
	 * 分页条件查询
	 * @param thesisForChinese
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	@Override
	public PageResult findPage(TThesisForChinese thesisForChinese, int pageNum, int pageSize) {

		TThesisForChineseExample example=new TThesisForChineseExample();
		example.setOrderByClause("`confirm_status` DESC,id ASC");
		TThesisForChineseExample.Criteria criteria = example.createCriteria();
		String roleGrade = null;
		if(thesisForChinese!=null){
			//添加查询论文数据的条件
			roleGrade = addThesisForChineseCriteria(thesisForChinese, criteria);
		}
		PageHelper.startPage(pageNum, pageSize);
		Page<TThesisForChinese> page= (Page<TThesisForChinese>)thesisForChineseMapper.selectByExample(example);
		//查询已确认和未确认的数量
		//将查询到的角色和已确认/未确认的信息保存到PageResult里面，然后返回给前端
		PageResult pageResult = getPageResult(page);

		pageResult.setRoleGrade(roleGrade);
		return pageResult;
	}

	/**
	 * 统计论文的已确认和为确认的数据信息
	 * @param page
	 * @return
	 */
	private PageResult getPageResult(Page page) {
		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
		//统计查询所有未确认的论文信息
		TThesisForChineseExample unconfirmedCountExample=new TThesisForChineseExample();
		TThesisForChineseExample.Criteria unconfirmedCountCriteria = unconfirmedCountExample.createCriteria();
		addCriteriaByRoles(unconfirmedCountCriteria);
		//统计未确认的论文信息
		unconfirmedCountCriteria.andConfirmStatusEqualTo("2");
		unconfirmedCountCriteria.andStatusEqualTo("1");
		int unconfirmedCount = thesisForChineseMapper.countByExample(unconfirmedCountExample);
		pageResult.setUnconfirmedCount(unconfirmedCount);
		//统计查询所有已确认的论文信息
		TThesisForChineseExample confirmedCountExample=new TThesisForChineseExample();
		TThesisForChineseExample.Criteria confirmedCountCriteria = confirmedCountExample.createCriteria();
		addCriteriaByRoles(confirmedCountCriteria);
		//分别统计已确认的论文信息
		confirmedCountCriteria.andConfirmStatusEqualTo("1");
		confirmedCountCriteria.andStatusEqualTo("1");
		int confirmedCount = thesisForChineseMapper.countByExample(confirmedCountExample);
		pageResult.setConfirmedCount(confirmedCount);
		return pageResult;
	}

	/**
	 * 添加查询论文数据的条件
	 * @param thesisForChinese
	 * @param criteria
	 */
	private String addThesisForChineseCriteria(TThesisForChinese thesisForChinese, TThesisForChineseExample.Criteria criteria) {
		//题名
		if(thesisForChinese.getTitle()!=null && thesisForChinese.getTitle().length()>0){
			criteria.andTitleLike("%"+thesisForChinese.getTitle()+"%");
		}
		//作者
		if(thesisForChinese.getAuthor()!=null && thesisForChinese.getAuthor().length()>0){
			criteria.andAuthorLike("%"+thesisForChinese.getAuthor()+"%");
		}
		//DOI
		if(thesisForChinese.getDoi()!=null && thesisForChinese.getDoi().length()>0){
			criteria.andDoiEqualTo(thesisForChinese.getDoi());
		}
		//文献来源
		if(thesisForChinese.getLiteratureResources()!=null && thesisForChinese.getLiteratureResources().length()>0){
			criteria.andLiteratureResourcesEqualTo(thesisForChinese.getLiteratureResources());
		}
		//卷
		if(thesisForChinese.getRoll()!=null && thesisForChinese.getRoll().length()>0){
			criteria.andRollEqualTo(thesisForChinese.getRoll());
		}
		//期
		if(thesisForChinese.getJournal()!=null && thesisForChinese.getJournal().length()>0){
			criteria.andJournalEqualTo(thesisForChinese.getJournal());
		}
		//ISSN
		if(thesisForChinese.getIssn()!=null && thesisForChinese.getIssn().length()>0){
			criteria.andIssnEqualTo(thesisForChinese.getIssn());
		}
		//页码
		if(thesisForChinese.getPage()!=null && thesisForChinese.getPage().length()>0){
			criteria.andPageEqualTo(thesisForChinese.getPage());
		}
		//机构(单位)
		if(thesisForChinese.getAuthorCompany()!=null && thesisForChinese.getAuthorCompany().length()>0){
			criteria.andAuthorCompanyLike("%"+thesisForChinese.getAuthorCompany()+"%");
		}
		//根据时间段查询
		if(thesisForChinese.getSearchStartTime() != null && thesisForChinese.getSearchEndTime()!= null){
			if (thesisForChinese.getSearchStartTime().toString() != null && thesisForChinese.getSearchStartTime().toString().length()>0
					&& thesisForChinese.getSearchEndTime().toString() != null && thesisForChinese.getSearchEndTime().toString().length()>0) {
				criteria.andYearBetween(thesisForChinese.getSearchStartTime(),thesisForChinese.getSearchEndTime());
			}
		}
		//所属地区
		if(thesisForChinese.getArea()!=null && thesisForChinese.getArea().length()>0){
			criteria.andAreaLike("%"+thesisForChinese.getArea()+"%");
		}

		//确认状态
		if(thesisForChinese.getConfirmStatus()!=null && thesisForChinese.getConfirmStatus().length()>0){
			criteria.andConfirmStatusEqualTo(thesisForChinese.getConfirmStatus());
		}
		//根据用户角色添加本角色的限制条件，及该用户的权限范围内的数据查询
		String roleGrade = addCriteriaByRoles(criteria);
		//只查询状态为1的数据
		criteria.andStatusEqualTo("1");
		return roleGrade;
	}

	/**
	 根据角色添加查询条件
	 * 设置省、市、医院、个人四级权限，根据不同的权限，修改服务层代码，查询不同的数据，
	 *不同的权限返回不同的数据，同时返回权限级别，不同的权限显示不同的按钮（级别给前端进行判断，根据级别的不同，显示不同的按钮。
	 *如专家按钮，在个人级别的时候不现实，单位查询按钮在单位级别以下的不显示，地区选择按钮省级可选择地级市以下的地区和单位，
	 *地级市只能查询本市以下的地区和单位）
	 */
	private String addCriteriaByRoles(TThesisForChineseExample.Criteria criteria) {
		UUser currentUser = CurrentUser.returnCurrentUser();
		if (currentUser != null) {
			String roleGrade = null;
			List<URole> rlist = roleService.findRoleByUid(currentUser.getId());//获取用户角色
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
						criteria.andAreaLike("%"+currentUser.getArea()+"%");
					}
				}else if("医院".equals(role.getName())){
					if(currentUser.getCompanyId()!=null && currentUser.getCompanyId().length()>0){
						//添加本单位的名称,由于一篇文献有多个单位，所以单位查询条件只能用模糊查询
						criteria.andAuthorCompanyIdLike("%"+currentUser.getCompanyId()+"%");
					}
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本人所属地区
						criteria.andAreaLike("%"+currentUser.getArea()+"%");
					}
				}else if("个人".equals(role.getName())){
					if(currentUser.getCompanyId()!=null && currentUser.getCompanyId().length()>0){
						//添加本单位的名称,由于一篇文献有多个单位，所以单位查询条件只能用模糊查询
						criteria.andAuthorCompanyIdLike("%"+currentUser.getCompanyId()+"%");
					}
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本人所属地区
						criteria.andAreaLike("%"+currentUser.getArea()+"%");
					}
					if(currentUser.getUsername()!=null && currentUser.getUsername().length()>0){
						//添加本人的名称
						criteria.andAuthorEqualTo("%"+currentUser.getUsername()+"%");
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
	 * @param thesisForChinese
	 * @return
	 */
	@Override
	public List<TThesisForChinese> findThesisForChineseToExcel(TThesisForChinese thesisForChinese) {
		TThesisForChineseExample example = new TThesisForChineseExample();
		TThesisForChineseExample.Criteria criteria = example.createCriteria();
		if (thesisForChinese != null) {
			addThesisForChineseCriteria(thesisForChinese, criteria);
			//只查询状态为1的数据
			criteria.andStatusEqualTo("1");
		}
		//条件查询
		List<TThesisForChinese> list = thesisForChineseMapper.selectByExample(example);
		return list;
	}
	/**
	 * 批量确认
	 * @param ids
	 */
	@Override
	public void confirmThesisForChineseStatus(Integer[] ids) {
		for(Integer id:ids){
			TThesisForChinese thesisForChinese = thesisForChineseMapper.selectByPrimaryKey(id);
			//已确认 确认状态修改为“1”
			thesisForChinese.setConfirmStatus("1");
			thesisForChineseMapper.updateByPrimaryKey(thesisForChinese);
		}
	}

	/**
	 * 统计各地区论文的数量
	 */
	@Override
	public List<Count> countTheNumberOfThesisForChineseInEachArea(){
		return thesisForChineseMapper.countTheNumberOfThesisForChineseInEachArea();
	}
	/**
	 * 给论文添加单位标识
	 */
	@Override
	public void addCommpanyId(){

		int index=1;
		int pageSize = 2000;
		while (true){
			List<TThesisForChinese> list = thesisForChineseMapper.findByPage(index*pageSize, pageSize);;
			System.out.println(list.size());
			for (TThesisForChinese thesisForChinese:list) {
				if(StringUtils.isNotBlank(thesisForChinese.getAuthorCompany())){
					String companyId = "";
					String[] splitCompany = thesisForChinese.getAuthorCompany().split(";");
					for (int i =0; i<splitCompany.length;i++) {
						TAreaAndCompanyExample areaAndCompanyExample = new TAreaAndCompanyExample();
						TAreaAndCompanyExample.Criteria criteria = areaAndCompanyExample.createCriteria();
						criteria.andCompanyEqualTo(splitCompany[i]);
						List<TAreaAndCompany> andCompanyList = areaAndCompanyMapper.selectByExample(areaAndCompanyExample);
						if(andCompanyList != null && andCompanyList.size() >0){
							if(i==splitCompany.length-1){
								companyId += andCompanyList.get(0).getCompanyId();
							}else{
								companyId += andCompanyList.get(0).getCompanyId()+";";
							}
						}
					}
					thesisForChinese.setAuthorCompanyId(companyId);
					thesisForChineseMapper.updateByPrimaryKey(thesisForChinese);

				}
			}
			if(list.isEmpty()){
				break;
			}
			index++;
		}
	}


	public static void main(String[] args) {
		//countTheNumberOfThesisForChineseInEachCompany();
		Map map = new HashMap();
		map.put("d",1);
		map.put("g",626);
		map.put("w",2634);
		map.put("a",35);
		map.put("b",743);
		map.put("c",876);
		map.put("t",6);
		System.out.println("排序前："+map);
		map = sortDescend(map);
		System.out.println("排序后："+map);
		//System.out.println(map);
		/*for (Area area:Area.values()) {
			System.out.println(area+"--"+area.getMsg());
		}*/
	}

	/**
	 * 插入各单位中文文献的数量
	 * 	做定时更新
	 * 	当文献数据新增和删除时，相应的加减，详见add和delete方法
	 */
	@Override
	public void insertCompanyChesisNum(){
		TAreaAndCompanyExample example = new TAreaAndCompanyExample();
		List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectByExample(example);
		for (TAreaAndCompany areaAndCompany:areaAndCompanyList) {
			TThesisForChineseExample thesisForChineseExample = new TThesisForChineseExample();
			thesisForChineseExample.createCriteria().andAuthorCompanyIdLike("%"+areaAndCompany.getCompanyId()+"%");
			int count = thesisForChineseMapper.countByExample(thesisForChineseExample);
			areaAndCompany.setThesisForChineseNum(count);
			areaAndCompanyMapper.updateByPrimaryKey(areaAndCompany);
		}
	}
	/**
	 * 查询浙江省各单位中文文献的数量
	 * 单位top20
	 */
	@Override
	public List<TAreaAndCompany> selectBeforeTwentieth(){
		return areaAndCompanyMapper.selectChineseBeforeX(20);
	}

	/**
	 *查询各市单位文献量前20的
	 */
	@Override
	public List<TAreaAndCompany> selectBeforeTwentiethInEachArea(){
		return areaAndCompanyMapper.selectChineseBeforeTwentiethInEachArea();
	}

	/**
	 *查询关键词出现在前20的热词
	 */
	@Override
	public void insertKeywordsBeforeTwentieth(){
		Map<String ,Integer> map = new HashMap<String ,Integer>();
		TThesisForChineseExample example = new TThesisForChineseExample();
		example.createCriteria().andKeywordsIsNotNull();
		List<TThesisForChinese> thesisForChineseList = thesisForChineseMapper.selectByExample(example);
		for (TThesisForChinese thesisForChinese:thesisForChineseList) {
			String[] split = thesisForChinese.getKeywords().split(";");
			for (String keyword: split ) {
				if(map.get(keyword)==null){
					map.put(keyword,1);
				}else{
					map.put(keyword,map.get(keyword)+1);
				}
			}
		}
		Map<String, Integer> stringIntegerMap = sortDescend(map);
		int i = 1;
		for(Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()){
			TCountTopKeywords countTopKeywords = new TCountTopKeywords();
			countTopKeywords.setKeywords(entry.getKey());
			countTopKeywords.setCount(entry.getValue());
			countTopKeywords.setTopNum(i);
			countTopKeywords.setType("中文");
			thesisForChineseMapper.insertKeywordsBeforeTwentieth(countTopKeywords);
			i++;
		}
	}
	@Override
	public List<TCountTopKeywords> selectKeywordsBeforeTwentieth(){
		return thesisForChineseMapper.selectKeywordsBeforeTwentieth("中文","浙江省");
	}
	/**
	 * 查询各地级市关键词出现前20的
	 */
	@Override
	public void insertKeywordsBeforeTwentiethInEachArea(){
		for (Area area:Area.values()) {
			Map<String ,Integer> map = new HashMap<String ,Integer>();
			TThesisForChineseExample example = new TThesisForChineseExample();
			TThesisForChineseExample.Criteria criteria = example.createCriteria();
			criteria.andKeywordsIsNotNull();
			criteria.andAreaLike("%"+area.getMsg()+"%");
			List<TThesisForChinese> thesisForChineseList = thesisForChineseMapper.selectByExample(example);
			for (TThesisForChinese thesisForChinese:thesisForChineseList) {
				String[] split = thesisForChinese.getKeywords().split(";");
				for (String keyword: split ) {
					if(map.get(keyword)==null){
						map.put(keyword,1);
					}else{
						map.put(keyword,map.get(keyword)+1);
					}
				}
			}
			Map<String, Integer> areaMap = sortDescend(map);
			int i = 1;
			for(Map.Entry<String, Integer> entry : areaMap.entrySet()){
				TCountTopKeywords countTopKeywords = new TCountTopKeywords();
				countTopKeywords.setKeywords(entry.getKey());
				countTopKeywords.setCount(entry.getValue());
				countTopKeywords.setTopNum(i);
				countTopKeywords.setType("中文");
				countTopKeywords.setArea(area.getMsg());
				thesisForChineseMapper.insertKeywordsBeforeTwentieth(countTopKeywords);
				i++;
			}
		}

	}
	@Override
	public List selectKeywordsBeforeTwentiethInEachArea(){
		List list = new ArrayList();
		for (Area area:Area.values()) {
			List<TCountTopKeywords> keywordsList = thesisForChineseMapper.selectKeywordsBeforeTwentieth("中文", area.getMsg());
			Count count = new Count();
			count.setArea(area.getMsg());
			count.setCountList(keywordsList);
			list.add(count);
		}
		return list;
	}


	/**
	 * 排序
	 * @param map
	 * @param <K>
	 * @param <V>
	 * @return
	 */
	public static <K,V extends Comparable<? super V>> Map<K,V> sortDescend(Map<K,V> map){
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
			if(i==20){
				break;
			}
			returnMap.put(entry.getKey(),entry.getValue());
			i++;
		}

		return returnMap;
	}

	/**
	 * 第一作者top20（如杭州市内单位排名）
	 */
	@Override
	public Map<String,List> insertFirstAuthorBeforeTwentiethInEachArea(){
		Map<String,List> returnAreaMap = new HashMap();
		int top = 20;
		for (Area area:Area.values()) {
			List<Count> countList = thesisForChineseMapper.selectFirstAuthorBeforeTwentiethInEachArea("%" + area.getMsg() + "%" ,top);
			for (Count count:countList) {
				TCountTopFirstAuthor countTopFirstAuthor = new TCountTopFirstAuthor();
				countTopFirstAuthor.setArea(area.getMsg());
				countTopFirstAuthor.setCount(count.getCount());
				countTopFirstAuthor.setFirstAuthor(count.getArea());
				thesisForChineseMapper.insertFirstAuthorBeforeTwentiethInEachArea(countTopFirstAuthor);
			}
			returnAreaMap.put(area.getMsg(),countList);
		}

		return returnAreaMap;
	}
	@Override
	public List selectFirstAuthorBeforeTwentiethInEachArea(){
		List list = new ArrayList();
		for (Area area:Area.values()) {
			List<TCountTopFirstAuthor> areaAuthorList = thesisForChineseMapper.selectFirstAuthorBeforeTwentiethInEachAreaByTable(area.getMsg());
			list.add(areaAuthorList);
		}
		return list;
	}

	/**
	 * 插入学科前20的数据
	 */
	@Override
	public void insertSujectBeforeTwentieth(){
		List<Count> list = thesisForChineseMapper.selectSujectBeforeTwentieth();
		int i = 1;
		for (Count count:list) {
			TCountTopSubject countTopSubject = new TCountTopSubject();
			countTopSubject.setCount(count.getCount());
			countTopSubject.setSubject(count.getArea());
			countTopSubject.setTopNum(i);
			countTopSubject.setType("中文");
			thesisForChineseMapper.insertSujectBeforeTwentieth(countTopSubject);
			i++;
		}
	}

	/**
	 * 查询学科前20的数据
	 */
	@Override
	public List<TCountTopSubject>  selectSujectBeforeTwentieth(){
		return thesisForChineseMapper.selectSujectTopTwentieth();
	}

	/**
	 * 查询核心期刊，学科top20的数据
	 */
	@Override
	public void insertSujectBeforeTwentiethInCorePerio(){
		List<Count> list = thesisForChineseMapper.selectSujectBeforeTwentiethInCorePerio();
		for (Count count:list) {
			TCountTopCorePerio countTopCorePerio = new TCountTopCorePerio();
			countTopCorePerio.setSubject(count.getArea());
			countTopCorePerio.setCount(count.getCount());
			countTopCorePerio.setType("2");
			thesisForChineseMapper.insertCountTopCorePerio(countTopCorePerio);
		}

	}
	@Override
	public List<TCountTopCorePerio> selectSujectBeforeTwentiethInCorePerio(){
		return thesisForChineseMapper.selectBeforeTwentiethInCorePerioByType("2");
	}
	/**
	 * 查询核心期刊单位top20
	 */
	@Override
	public void insertCompanyBeforeTwentiethInCorePerio(){
		HashMap map = new HashMap();
		TAreaAndCompanyExample example = new TAreaAndCompanyExample();
		List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectByExample(example);
		for (TAreaAndCompany areaAndCompany:areaAndCompanyList) {
			TThesisForChineseExample thesisForChineseExample = new TThesisForChineseExample();
			TThesisForChineseExample.Criteria criteria = thesisForChineseExample.createCriteria();
			criteria.andAuthorCompanyIdLike("%"+areaAndCompany.getCompanyId()+"%");
			criteria.andCorePerioIsNotNull();
			int count = thesisForChineseMapper.countByExample(thesisForChineseExample);
			map.put(areaAndCompany.getCompany(),count);
		}
		Map<String, Integer> stringIntegerMap = sortDescend(map);
		for(Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()){
			TCountTopCorePerio countTopCorePerio = new TCountTopCorePerio();
			countTopCorePerio.setCompany(entry.getKey());
			countTopCorePerio.setCount(entry.getValue());
			countTopCorePerio.setType("1");
			thesisForChineseMapper.insertCountTopCorePerio(countTopCorePerio);
		}
	}
	@Override
	public List<TCountTopCorePerio> selectCompanyBeforeTwentiethInCorePerio(){
		return thesisForChineseMapper.selectBeforeTwentiethInCorePerioByType("1");
	}

	/**
	 * 核心期刊中期刊文献量top20
	 */
	@Override
	public void insertJournalTopTwentieth(){
		List<Count> countList = thesisForChineseMapper.selectBeforeTwentiethInCorePerio();
		for (Count count:countList) {
			TCountTopJournal countTopJournal = new TCountTopJournal();
			countTopJournal.setJournalName(count.getArea());
			countTopJournal.setCount(count.getCount());
			countTopJournal.setType("1");
			thesisForEnglishMapper.insertJournalTopTwentieth(countTopJournal);
		}
	}
	@Override
	public  List<TCountTopJournal> selectBeforeTwentiethInCorePerio(){
		return thesisForEnglishMapper.selectJournalTopTwentiethByTable("1");
	}

	/**
	 * top10作者合作关系网
	 * 每个地区拿10个作者出来分析，构成1张图，每个作者辐射2次
		 业务逻辑
		 1.查询杭州市（为例）第一作者文献量top10
		 2.遍历10个作者，查询每个作者和其他作者的合作人和合作次数
		 3.查询二级作者和其他作者的合作人和合作次数
	 	 4.将合作关系存入数据库
	 */
	@Override
	public void insertAuthorNetwork(){
		//Map<String,List> returnAreaMap = new HashMap();
		CountAuthorNetwork countAuthorNetwork = new CountAuthorNetwork();
		int top = 10;
		int i = 1;
		for (Area area:Area.values()) {
			//查询出第一作者发文量top10的作者及发文次数
			List<Count> countList = thesisForChineseMapper.selectFirstAuthorBeforeTwentiethInEachArea("%" + area.getMsg() + "%" ,top);
			for (Count count:countList) {
				//查询包含这个作者的所有作者
				List<String> authorList = thesisForChineseMapper.selectAuthorByExample("%" + count.getArea() + "%");
				List<String> list = new ArrayList() ;
				for (String authors:authorList) {
					String[] split = authors.split(" ");
					for (String author:split) {
						list.add(author);
					}

				}

				//统计作者出现的次数，并封装到map集合里面
				Map<String, Long> map = list.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
				//map.forEach((k, v) -> System.out.println(k + "1:" + v));

				//遍历集合
				for (Map.Entry<String, Long> entry : map.entrySet()) {
					TCountAuthorNetwork1 countAuthorNetwork1 = new TCountAuthorNetwork1();
					countAuthorNetwork1.setId(i);
					countAuthorNetwork1.setArea(area.getMsg());
					countAuthorNetwork1.setFirstAuthor(count.getArea());
					countAuthorNetwork1.setFirstAuthorPostNum(count.getCount());
					countAuthorNetwork1.setCooperator(entry.getKey());
					countAuthorNetwork1.setCooperationNum(entry.getValue().intValue());
					countAuthorNetworkMapper.insert1(countAuthorNetwork1);
					//System.out.println(countAuthorNetwork1);

					List<String> authorList1 = thesisForChineseMapper.selectAuthorByExample("%" + entry.getKey() + "%");
					List<String> list1 = new ArrayList() ;
					for (String authors:authorList1) {
						String[] split = authors.split(" ");
						for (String author:split) {
							list1.add(author);
						}

					}
					Map<String, Long> map1 = list1.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
					//map1.forEach((k, v) -> System.out.println(k + "2:" + v));
					//遍历集合
					for (Map.Entry<String, Long> entry1 : map1.entrySet()) {
						TCountAuthorNetwork2 countAuthorNetwork2 = new TCountAuthorNetwork2();
						countAuthorNetwork2.setCooperatorId(countAuthorNetwork1.getId());
						countAuthorNetwork2.setAuthor(countAuthorNetwork1.getCooperator());
						countAuthorNetwork2.setCooperator(entry1.getKey());
						countAuthorNetwork2.setCooperationNum(entry1.getValue().intValue());
						countAuthorNetworkMapper.insert2(countAuthorNetwork2);
						//System.out.println(countAuthorNetwork2);
					}
					i++;
				}
			}
			//returnAreaMap.put(area.getMsg(),countList);
		}
	}

	/**
	 * 查询作者关系网
	 */
	@Override
	public CountAuthorNetwork selectAuthorNetwork(){

		CountAuthorNetwork countAuthorNetwork = new CountAuthorNetwork();
		List<String> allCompany = countAuthorNetworkMapper.selectAllAuthor();
		List<TCountAuthorNetwork1> authorPostNum = countAuthorNetworkMapper.selectAuthorPostNum();
		List<Relation> list1 = countAuthorNetworkMapper.selectAllCooperator1();
		List<Relation> list2 = countAuthorNetworkMapper.selectAllCooperator2();
		Set set = new HashSet();
		for (Relation relation:list1) {
			set.add(relation);
		}
		for (Relation relation:list2) {
			set.add(relation);
		}
		countAuthorNetwork.setAuthorPostNum(authorPostNum);
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
			List<String> listCompany = thesisForChineseMapper.selectCompanyByExample("%" + areaAndCompany.getCompany() + "%");
			//将这些单位全部添加到list集合中
			List<String> list = new ArrayList() ;
			for (String cooperator:listCompany) {
				String[] split = cooperator.split(";");
				for (String author:split) {
					list.add(author);
				}
			}
			//统计作者出现的次数，并封装到map集合里面
			Map<String, Long> map = list.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
			//遍历集合
			for (Map.Entry<String, Long> entry : map.entrySet()) {
				//排除自己和自己的合作关系
				if(!areaAndCompany.getCompany().equals(entry.getKey())){
					TCountCompanyNetwork1 countCompanyNetwork1 = new TCountCompanyNetwork1();
					countCompanyNetwork1.setId(i);
					countCompanyNetwork1.setCompany(areaAndCompany.getCompany());
					countCompanyNetwork1.setCompanyPostNum(areaAndCompany.getThesisForChineseNum());
					countCompanyNetwork1.setCooperator(entry.getKey());
					countCompanyNetwork1.setCooperationNum(entry.getValue().intValue());
					//System.out.println(countCompanyNetwork1);
					countCompanyNetworkMapper.insert1(countCompanyNetwork1);
					List<String> listCompany1 = thesisForChineseMapper.selectCompanyByExample("%" + entry.getKey() + "%");
					List<String> list1 = new ArrayList() ;
					for (String cooperator2:listCompany1) {
						String[] split = cooperator2.split(";");
						for (String company:split) {
							list1.add(company);
						}

					}
					//统计作者出现的次数，并封装到map集合里面
					Map<String, Long> map1 = list1.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
					for (Map.Entry<String, Long> entry1 : map1.entrySet()) {
						if(!entry.getKey().equals(entry1.getKey())){
							TCountCompanyNetwork2 countCompanyNetwork2 = new TCountCompanyNetwork2();
							countCompanyNetwork2.setCooperatorId(countCompanyNetwork1.getId());
							countCompanyNetwork2.setCompany(countCompanyNetwork1.getCooperator());
							countCompanyNetwork2.setCooperator(entry1.getKey());
							countCompanyNetwork2.setCooperationNum(entry1.getValue().intValue());
							System.out.println(countCompanyNetwork2);
							countCompanyNetworkMapper.insert2(countCompanyNetwork2);
						}

					}
				}

				i++;
			}

		}
	}

	/**
	 * 查询top10单位合作关系网
	 * 	1.查询所有出现过的单位
	 * 	2.查询他们的合作关系
	 */
	@Override
	public CountCompanyNetwork selectCompanyNetwork(){
		CountCompanyNetwork countCompanyNetwork = new CountCompanyNetwork();
		List<String> allCompany = countCompanyNetworkMapper.selectAllCompany();
		List<TCountCompanyNetwork1> companyPostNum = countCompanyNetworkMapper.selectCompanyPostNum();
		List<Relation> list1 = countCompanyNetworkMapper.selectAllCooperator1();
		List<Relation> list2 = countCompanyNetworkMapper.selectAllCooperator2();
		Set set = new HashSet();
		for (Relation relation:list1) {
			set.add(relation);
		}
		for (Relation relation:list2) {
			set.add(relation);
		}
		countCompanyNetwork.setCompanyPostNum(companyPostNum);
		countCompanyNetwork.setAllCompany(allCompany);
		countCompanyNetwork.setSet(set);
		return countCompanyNetwork;
	}


	/**
	 * 补充论文期刊信息和第一作者信息
	 *补充学科和关键字信息
	 */
	@Override
	public void updateThiesis(File file, String fileName) throws Exception{
		if (fileName.endsWith("txt")) {
			File myFile = new File(fileName);
			if (!myFile.exists()) {
				System.err.println("Can't Find " + fileName);
			}
			FileInputStream fis = new FileInputStream(fileName);
			if(fis.available()>0){
				//InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
				InputStreamReader inputStreamReader = new InputStreamReader(fis, "GBK");
				BufferedReader in  = new BufferedReader(inputStreamReader);
				String str;
				TbCnkiJournal journal = new TbCnkiJournal();
				while ((str = in.readLine()) != null) {
					//一行一行的读取，将不同的行分别封装到不同的对象当中
					if(str!=null && str.length()>0){
						String[] split = str.split(",");
						for(String s :split){
							String[] split1 = s.split("=");
							int a = 1;
							if(StringUtils.isNotBlank(split1[0])){
								TThesisForChineseExample thesisForChineseExample = new TThesisForChineseExample();
								thesisForChineseExample.createCriteria().andTitleEqualTo(split1[0].substring(1));
								List<TThesisForChinese> thesisForChineseList = thesisForChineseMapper.selectByExample(thesisForChineseExample);

								if(thesisForChineseList!=null && thesisForChineseList.size()>0){
									TThesisForChinese thesisForChinese = thesisForChineseList.get(0);
									List<TbWanfangDocumentCommonWithBLOBs> wanfangDocumentCommonWithBLOBsList = thesisForChineseMapper.selectDataByTitle(thesisForChinese.getTitle());
									if(wanfangDocumentCommonWithBLOBsList!=null && wanfangDocumentCommonWithBLOBsList.size()>0){
										thesisForChinese.setKeywords(wanfangDocumentCommonWithBLOBsList.get(0).getKeywords());
										thesisForChinese.setSubject(wanfangDocumentCommonWithBLOBsList.get(0).getSubjectClassCodes());
										System.out.println(thesisForChinese.getKeywords());
										System.out.println(thesisForChinese.getSubject());
										thesisForChineseMapper.updateByPrimaryKey(thesisForChinese);
									}
								}
							}
							System.out.println(split1[0].substring(1)+ a++);
						}

					}
				}
				in.close();
			}else{
				System.out.println("文件大小为0KB");
			}
		}
	}


	/**
	 * 清理论文中重复的地级市
	 */
	@Override
	public void  cleanRepateArea(){
		TThesisForChineseExample example = new TThesisForChineseExample();
		example.createCriteria().andAreaIsNotNull();
		List<TThesisForChinese> thesisForChineseList = thesisForChineseMapper.selectByExample(example);
		for (TThesisForChinese thesisForChinese:thesisForChineseList) {
			Set<String> set = new HashSet();
			String area = thesisForChinese.getArea();
			String areaNew = "";
			if(area.contains(";")){
				System.out.println("处理前的区域："+area);
				String[] split = area.split(";");
				for (String s:split) {
					set.add(s);
				}
				for (String s: set) {
					System.out.println(s);
					areaNew += s+";";
				}
				System.out.println("areaNew:"+areaNew.substring(0,areaNew.length()-1));
				thesisForChinese.setArea(areaNew.substring(0,areaNew.length()-1));
				thesisForChineseMapper.updateByPrimaryKey(thesisForChinese);
			}

		}
	}

	/**
	 * 查询作者发文量top10
	 */
	@Override
	public List selectAuthorPostNumTopTen(){
		return countAuthorNetworkMapper.selectAuthorPostNumTopTen();
	}

}
