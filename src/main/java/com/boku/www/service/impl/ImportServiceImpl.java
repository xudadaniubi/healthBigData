/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ImportServiceImpl
 * Author:   dell
 * Date:     2019/8/13 9:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.service.impl;

import com.boku.www.mapper.TAreaAndCompanyMapper;
import com.boku.www.mapper.TThesisForEnglishMapper;
import com.boku.www.pojo.TAreaAndCompany;
import com.boku.www.pojo.TAreaAndCompanyExample;
import com.boku.www.pojo.TThesisForEnglish;
import com.boku.www.pojo.TThesisForEnglishExample;
import com.boku.www.service.ImportService;
import com.boku.www.utils.CleanSpecialSymbolUtil;
import com.boku.www.utils.RW2FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author dell
 * @create 2019/8/13
 * @since 1.0.0
 */
@Service
@Transactional
public class ImportServiceImpl implements ImportService {
	@Autowired
	private TThesisForEnglishMapper thesisForEnglishMapper;

	@Autowired
	private TAreaAndCompanyMapper areaAndCompanyMapper;

	@Override
	public void readCiwFilesToList(String ciwDirPath) throws Exception{
		long start = System.currentTimeMillis();
		File file=new File(ciwDirPath);
		File[] files=file.listFiles();
		String fileAbsolutePath = null;
		for(File a:files) {
			fileAbsolutePath = a.getAbsolutePath();
			System.out.println("文件绝对路径为：" + fileAbsolutePath);
			if (fileAbsolutePath.endsWith(".ciw")) {
				// 读取文件数据
				File myFile = new File(fileAbsolutePath);
				if (!myFile.exists()) {
					System.err.println("Can't Find " + fileAbsolutePath);
				}
				FileInputStream fis = new FileInputStream(fileAbsolutePath);
				if(fis.available()>0) {
					InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
					BufferedReader in = new BufferedReader(inputStreamReader);
					String str;
					TThesisForEnglish thesisForEnglish = new TThesisForEnglish();
					//根据单位查询单位信息
					String company = a.getName().substring(0, a.getName().lastIndexOf(".ciw"));
					TAreaAndCompanyExample example = new TAreaAndCompanyExample();
					example.createCriteria().andCompanyEqualTo(company);
					List<TAreaAndCompany> companyList = areaAndCompanyMapper.selectByExample(example);
					List<String> strList = new ArrayList<String>();
					List<String> strList1 = new ArrayList<String>();
					List<String> strList2 = new ArrayList<String>();
					List<String> strList3 = new ArrayList<String>();
					while ((str = in.readLine()) != null) {
						if (StringUtils.isNotBlank(str)) {
							//作者
							if ("AU".equals(str.substring(0, 2))) {
								strList = new ArrayList<String>();
								strList.add(str.substring(str.indexOf(" ") + 1).trim());
							}
							if (StringUtils.isBlank(str.substring(0, 1))) {
								strList.add(str.trim());
							} else {
								if ("TI".equals(str.substring(0, 2))) {
									String authors = StringUtils.join(strList.toArray(), ";");
									thesisForEnglish.setAuthor(authors);
									strList = new ArrayList<String>();
								}
							}
							//标题
							if ("TI".equals(str.substring(0, 2))) {
								strList1 = new ArrayList<String>();
								strList1.add(str.substring(str.indexOf(" ") + 1).trim());
							}
							if (StringUtils.isBlank(str.substring(0, 1))) {
								strList1.add(str.trim());
							} else {
								if ("SO".equals(str.substring(0, 2))) {
									String title = StringUtils.join(strList1.toArray(), " ");
									thesisForEnglish.setTitle(title);
									strList1 = new ArrayList<String>();
								}
							}
							//刊名
							if ("SO".equals(str.substring(0, 2))) {
								strList2 = new ArrayList<String>();
								strList2.add(str.substring(str.indexOf(" ") + 1).trim());
							}
							if (StringUtils.isBlank(str.substring(0, 1))) {
								strList2.add(str.trim());
							} else {
								if ("PY".equals(str.substring(0, 2))) {
									String journalName = StringUtils.join(strList2.toArray(), " ");
									thesisForEnglish.setJournalName(journalName);
									strList2 = new ArrayList<String>();
								}
							}
							//摘要
							if ("AB".equals(str.substring(0, 2))) {
								strList3 = new ArrayList<String>();
								strList3.add(str.substring(str.indexOf(" ") + 1).trim());
							}
							if (StringUtils.isBlank(str.substring(0, 1))) {
								strList3.add(str.trim());
							} else {
								if ("ER".equals(str.substring(0, 2))) {
								}
								String abstracts = StringUtils.join(strList3.toArray(), " ");
								thesisForEnglish.setAbstracts(abstracts);
								strList3 = new ArrayList<String>();
							}
							//卷
							if ("VL".equals(str.substring(0, 2))) {
								thesisForEnglish.setRoll(str.substring(str.indexOf(" ") + 1).trim());
							}
							//期
							if ("IS".equals(str.substring(0, 2))) {
								thesisForEnglish.setJournal(str.substring(str.indexOf(" ") + 1).trim());
							}
							//doi
							if ("DI".equals(str.substring(0, 2))) {
								thesisForEnglish.setDoi(str.substring(str.indexOf(" ") + 1).trim());
							}
							//起始页码
							if ("BP".equals(str.substring(0, 2))) {
								thesisForEnglish.setPage(str.substring(str.indexOf(" ") + 1).trim());
							}
							//终止页码
							if ("EP".equals(str.substring(0, 2))) {
								thesisForEnglish.setPage(thesisForEnglish.getPage() + "-" + str.substring(str.indexOf(" ") + 1).trim());
							}
							//出版年份
							if ("PY".equals(str.substring(0, 2))) {
								thesisForEnglish.setYear(str.substring(str.indexOf(" ") + 1).trim());
							}
							//ISSN号
							if ("SN".equals(str.substring(0, 2))) {
								thesisForEnglish.setIssn(str.substring(str.indexOf(" ") + 1).trim());
							}

							if ("ER".equals(str)) {
								TThesisForEnglishExample e = new TThesisForEnglishExample();
								e.createCriteria().andTitleEqualTo(thesisForEnglish.getTitle());
								List<TThesisForEnglish> thesisForEnglishList = thesisForEnglishMapper.selectByExample(e);
								//如果这条数据之前没有被存入数据库
								if (thesisForEnglishList.isEmpty()) {
									thesisForEnglish.setAuthorCompany(company);
									if (companyList != null && companyList.size() > 0) {
										thesisForEnglish.setAuthorCompanyId(companyList.get(0).getCompanyId());
										thesisForEnglish.setArea(companyList.get(0).getCity());
									}
									thesisForEnglish.setConfirmStatus("2");
									thesisForEnglish.setStatus("1");
									thesisForEnglishMapper.insert(thesisForEnglish);
								} else {
									//这条数据之前已经被存入数据库了，将作者单位、单位id、所属区域更新一下
									TThesisForEnglish tThesisForEnglish = thesisForEnglishList.get(0);
									if (companyList != null && companyList.size() > 0) {
										if (StringUtils.isNotBlank(tThesisForEnglish.getAuthorCompanyId())) {
											if (!tThesisForEnglish.getAuthorCompanyId().contains(companyList.get(0).getCompanyId())) {
												tThesisForEnglish.setAuthorCompanyId(tThesisForEnglish.getAuthorCompanyId() + ";" + companyList.get(0).getCompanyId());
											}
										}
										if (StringUtils.isNotBlank(tThesisForEnglish.getArea())) {
											if (!tThesisForEnglish.getArea().contains(companyList.get(0).getCity())) {
												tThesisForEnglish.setArea(tThesisForEnglish.getArea() + ";" + companyList.get(0).getCity());
											}
										}
									}
									tThesisForEnglish.setAuthorCompany(tThesisForEnglish.getAuthorCompany() + ";" + company);
									thesisForEnglishMapper.updateByPrimaryKey(tThesisForEnglish);
								}
								thesisForEnglish = new TThesisForEnglish();
							}
						}
					}
					in.close();
				}else{
					System.out.println("文件大小为0KB");
				}
			}

		}
		long end = System.currentTimeMillis();
		System.out.println("数据插入完毕，用时"+(start-end)+"毫秒");
	}

	@Override
	public void insertJcrAndJournal() throws Exception{
		String regEx="[\\[\\] ]";
		TThesisForEnglishExample example = new TThesisForEnglishExample();
		List<TThesisForEnglish> thesisForEnglishList = thesisForEnglishMapper.selectByExample(example);
		for (TThesisForEnglish thesisForEnglish:thesisForEnglishList) {
			//这里面封装了期刊id，期刊名和影响因子
			List<TThesisForEnglish> englishList = thesisForEnglishMapper.selectJournalByIssn(thesisForEnglish.getIssn());
			System.out.println("englishList.size():"+englishList.size());
			if(englishList!=null && englishList.size()>0){
				for (TThesisForEnglish t:englishList) {
					String allIf = t.getImpactFactor();
					//查询文献当年的影响因子
					if(StringUtils.isNotBlank(allIf)){
						String[] split1 = allIf.split(";");
						for (String ifAndYear:split1) {
							if(ifAndYear.contains(thesisForEnglish.getYear())){
								thesisForEnglish.setImpactFactor(ifAndYear.substring(ifAndYear.indexOf(":")+1));
							}
						}
					}
					if(StringUtils.isNotBlank(t.getJournalName())){
						thesisForEnglish.setJournalName(t.getJournalName());
					}
					//根据期刊id查询jcr分区
					List<String> jcrList = thesisForEnglishMapper.selectJcrByJournalId(t.getTitle());
					if(jcrList!=null && jcrList.size()>0){
						String jcr = CleanSpecialSymbolUtil.cleanSpecialSymbol(jcrList.toString(),regEx);
						thesisForEnglish.setJcrPartition(jcr);
					}
					//根据期刊id查询学科
					List<String> subjectList = thesisForEnglishMapper.selectSubjectByJournalId(t.getTitle());
					if(subjectList!=null && subjectList.size()>0){
						String subject = CleanSpecialSymbolUtil.cleanSpecialSymbol(subjectList.toString(),regEx);
						thesisForEnglish.setSubject(subject);
					}
					thesisForEnglishMapper.updateByPrimaryKey(thesisForEnglish);
				}
			}
		}
	}
	/**
	 * 根据单位查询单位id、所属区域
	 */
	@Override
		public void insertAreaCompanyId() throws Exception{
		HashMap map = new HashMap();
		TThesisForEnglishExample example = new TThesisForEnglishExample();
		List<TThesisForEnglish> thesisForEnglishList = thesisForEnglishMapper.selectByExample(example);
		for (TThesisForEnglish thesisForEnglish:thesisForEnglishList) {
			String[] split = thesisForEnglish.getAuthorCompany().split(";");
			for (String company:split) {
				TAreaAndCompanyExample e = new TAreaAndCompanyExample();
				e.createCriteria().andCompanyEqualTo(company);
				List<TAreaAndCompany> companyList = areaAndCompanyMapper.selectByExample(e);
				if(companyList.isEmpty()){
					//记录当前单位
					map.put(company,"单位有问题");
				}else{
					//添加所属区域和单位id信息
					if (StringUtils.isNotBlank(thesisForEnglish.getAuthorCompanyId())) {
						if (!thesisForEnglish.getAuthorCompanyId().contains(companyList.get(0).getCompanyId())) {
							thesisForEnglish.setAuthorCompanyId(thesisForEnglish.getAuthorCompanyId() + ";" + companyList.get(0).getCompanyId());
						}
					}else{
						thesisForEnglish.setAuthorCompanyId(companyList.get(0).getCompanyId());
					}
					if (StringUtils.isNotBlank(thesisForEnglish.getArea())) {
						if (!thesisForEnglish.getArea().contains(companyList.get(0).getCity())) {
							thesisForEnglish.setArea(thesisForEnglish.getArea() + ";" + companyList.get(0).getCity());
						}
					}else{
						thesisForEnglish.setArea(companyList.get(0).getCity());
					}
					thesisForEnglishMapper.updateByPrimaryKey(thesisForEnglish);
				}
			}
		}
		RW2FileUtil.writeHashMap2File(map,"E:\\healthybigdata\\recordHashMap2File3.txt");
	}

}