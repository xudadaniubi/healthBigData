package com.boku.www.pojo;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;
import java.util.List;

/**
 * 摘要
 * @author dell
 *
 */
public class AbstractSolr {
	//表唯一标识字段(PMID +Nlm+DOI)
	@Field("abstract_id")
	private String abstractId;
	//对应杂志唯一标识字段
	@Field("journal_id")
	private String journalId;
	//杂志期刊名
	@Field("journal_title_main")
	private String journalTitleMain;
	//pubmed唯一标识码
	@Field("PMID")
	private String pmid;
	//国际标准期刊编号
	@Field("ISSN")
	private String issn;
	//卷
	@Field("volume")
	private String volume;
	//期
	@Field("issue")
	private String issue;
	//日期
	@Field("medline_date")
	private Date medlineDate;
	//来源描述
	@Field("medline_TA")
	private String medlineTA;
	//摘要标题
	@Field("article_title")
	private String articleTitle;
	//页码
	@Field("medline_page")
	private String medlinePage;
	//数字对象唯一标识符(作用等同于PMID)
	@Field("elocation_id_DOI")
	private String elocationIdDOI;
	//摘要内容
	@Field("abstract_text")
	private String abstractText;
	//摘要翻译内容
	private String translateTest;
	//作者
	@Field("abstract_authors")
	private List<String> abstractAuthors;
	//语言
	@Field("language")
	private String language;
	//文献出版类型
	@Field("publication_types")
	private List<String> publicationTypes;
	//国籍
	@Field("country")
	private String country;
	//国立医学图书馆唯一id
	@Field("NlmUnique_ID")
	private String nlmUniqueID;
	//国际标准化组织标题缩写
	@Field("ISO_abbreviation")
	private String isoAbbreviation;
	//主题词对应mesh中的ui，即mesh中的id
	@Field("mesh_heads_UI")
	private String meshHeadsUI;
	//英语主题词
	@Field("mesh_heads")
	private String meshHeads;
	//限定词
	@Field("qualifier")
	private List<String> qualifier;
	//关键词
	@Field("key_words")
	private String keyWords;
	//有免费全文(此值需要管理员设置)
	@Field("had_free_full_text")
	private int hadFreeFullText;
	//有全文(根据originalURL是否存在，标记该字段1存在-1不存在)
	@Field("had_full_text")
	private int hadFullText;
	//原文路径
	@Field("original_URL")
	private String originalURL;
	//作者字符串
	@Field("authors_str")
	private String authorsStr;
	//单位字符串
	@Field("affiliation_str")
	private String affiliationStr;
	//期刊收录单位
	@Field("journal_indexes")
	private List<String> journalIndexes;

	//统计文献所属医院名称
	@Field("tatistics_abstracts_blong_to_hospital_name")
	private List<String> tatisticsAbstractsBlongToHospitalName;

	public List<String> getTatisticsAbstractsBlongToHospitalName() {
		return tatisticsAbstractsBlongToHospitalName;
	}

	public void setTatisticsAbstractsBlongToHospitalName(List<String> tatisticsAbstractsBlongToHospitalName) {
		this.tatisticsAbstractsBlongToHospitalName = tatisticsAbstractsBlongToHospitalName;
	}

	public String getAbstractId() {
		return abstractId;
	}

	public void setAbstractId(String abstractId) {
		this.abstractId = abstractId;
	}

	public String getJournalId() {
		return journalId;
	}

	public void setJournalId(String journalId) {
		this.journalId = journalId;
	}

	public String getJournalTitleMain() {
		return journalTitleMain;
	}

	public void setJournalTitleMain(String journalTitleMain) {
		this.journalTitleMain = journalTitleMain;
	}

	public String getPmid() {
		return pmid;
	}

	public void setPmid(String pmid) {
		this.pmid = pmid;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public Date getMedlineDate() {
		return medlineDate;
	}

	public void setMedlineDate(Date medlineDate) {
		this.medlineDate = medlineDate;
	}

	public String getMedlineTA() {
		return medlineTA;
	}

	public void setMedlineTA(String medlineTA) {
		this.medlineTA = medlineTA;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getMedlinePage() {
		return medlinePage;
	}

	public void setMedlinePage(String medlinePage) {
		this.medlinePage = medlinePage;
	}

	public String getElocationIdDOI() {
		return elocationIdDOI;
	}

	public void setElocationIdDOI(String elocationIdDOI) {
		this.elocationIdDOI = elocationIdDOI;
	}

	public String getAbstractText() {
		return abstractText;
	}

	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
	}

	public String getTranslateTest() {
		return translateTest;
	}

	public void setTranslateTest(String translateTest) {
		this.translateTest = translateTest;
	}

	public List<String> getAbstractAuthors() {
		return abstractAuthors;
	}

	public void setAbstractAuthors(List<String> abstractAuthors) {
		this.abstractAuthors = abstractAuthors;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<String> getPublicationTypes() {
		return publicationTypes;
	}

	public void setPublicationTypes(List<String> publicationTypes) {
		this.publicationTypes = publicationTypes;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNlmUniqueID() {
		return nlmUniqueID;
	}

	public void setNlmUniqueID(String nlmUniqueID) {
		this.nlmUniqueID = nlmUniqueID;
	}

	public String getIsoAbbreviation() {
		return isoAbbreviation;
	}

	public void setIsoAbbreviation(String isoAbbreviation) {
		this.isoAbbreviation = isoAbbreviation;
	}

	public String getMeshHeadsUI() {
		return meshHeadsUI;
	}

	public void setMeshHeadsUI(String meshHeadsUI) {
		this.meshHeadsUI = meshHeadsUI;
	}

	public String getMeshHeads() {
		return meshHeads;
	}

	public void setMeshHeads(String meshHeads) {
		this.meshHeads = meshHeads;
	}

	public List<String> getQualifier() {
		return qualifier;
	}

	public void setQualifier(List<String> qualifier) {
		this.qualifier = qualifier;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public int getHadFreeFullText() {
		return hadFreeFullText;
	}

	public void setHadFreeFullText(int hadFreeFullText) {
		this.hadFreeFullText = hadFreeFullText;
	}

	public int getHadFullText() {
		return hadFullText;
	}

	public void setHadFullText(int hadFullText) {
		this.hadFullText = hadFullText;
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

	public String getAuthorsStr() {
		return authorsStr;
	}

	public void setAuthorsStr(String authorsStr) {
		this.authorsStr = authorsStr;
	}

	public String getAffiliationStr() {
		return affiliationStr;
	}

	public void setAffiliationStr(String affiliationStr) {
		this.affiliationStr = affiliationStr;
	}

	public List<String> getJournalIndexes() {
		return journalIndexes;
	}

	public void setJournalIndexes(List<String> journalIndexes) {
		this.journalIndexes = journalIndexes;
	}

	/*@Override
	public String toString() {
		return JSON.toJSONString(this);
	}*/
}
