package com.boku.www.pojo;

public class TThesisForEnglish {
	private Integer id;
	//成果名称,标题
	private String title;
	//作者
	private String author;

	private String doi;
	//期刊名称
	private String journalName;

	private String issn;
	//年
	private String year;
	//卷
	private String roll;
	//期
	private String journal;
	//页码
	private String page;
	//作者单位
	private String authorCompany;
	//状态
	private String status;
	//所属地区
	private String area;
	//作者地址
	private String authorsAddress;
	//文摘
	private String abstracts;

	public String getAuthorsAddress() {
		return authorsAddress;
	}

	public void setAuthorsAddress(String authorsAddress) {
		this.authorsAddress = authorsAddress;
	}

	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	private String confirmStatus;//确认状态

	//(前端传递的查询开始时间)
	private String searchStartTime;
	//前端传递的查询结束时间
	private String searchEndTime;

	public String getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	public String getSearchStartTime() {
		return searchStartTime;
	}

	public void setSearchStartTime(String searchStartTime) {
		this.searchStartTime = searchStartTime;
	}

	public String getSearchEndTime() {
		return searchEndTime;
	}

	public void setSearchEndTime(String searchEndTime) {
		this.searchEndTime = searchEndTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi == null ? null : doi.trim();
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName == null ? null : journalName.trim();
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn == null ? null : issn.trim();
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year == null ? null : year.trim();
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll == null ? null : roll.trim();
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal == null ? null : journal.trim();
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page == null ? null : page.trim();
	}

	public String getAuthorCompany() {
		return authorCompany;
	}

	public void setAuthorCompany(String authorCompany) {
		this.authorCompany = authorCompany == null ? null : authorCompany.trim();
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area == null ? null : area.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	@Override
	public String toString() {
		return "TThesisForEnglish{" +
				"id=" + id +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", doi='" + doi + '\'' +
				", journalName='" + journalName + '\'' +
				", issn='" + issn + '\'' +
				", year='" + year + '\'' +
				", roll='" + roll + '\'' +
				", journal='" + journal + '\'' +
				", page='" + page + '\'' +
				", authorCompany='" + authorCompany + '\'' +
				", status='" + status + '\'' +
				", area='" + area + '\'' +
				", authorsAddress='" + authorsAddress + '\'' +
				", abstracts='" + abstracts + '\'' +
				", confirmStatus='" + confirmStatus + '\'' +
				", searchStartTime='" + searchStartTime + '\'' +
				", searchEndTime='" + searchEndTime + '\'' +
				'}';
	}
}