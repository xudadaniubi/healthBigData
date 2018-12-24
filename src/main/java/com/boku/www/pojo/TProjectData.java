package com.boku.www.pojo;

import java.io.Serializable;
import java.util.Date;

public class TProjectData implements Serializable {
    private Integer id;

    private String managementCompany;//项目管理单位

    private String subject;//项目类别

    private String projectNum;//项目编号

    private String projectName;//项目名称

    private String projectKidcat;//项目子类

    private String category;//类目

    private String subject1Id;//一级学科分类ID

    private String subject2Id;//二级学科分类ID

    private String subject3Id;//三级学科分类ID

    private Date projectSatrtTime;//立项时间

	private Date projectEndTime;//结题时间

	private String area;//所在地区

    private String organizer;//第一承办单位

	private String organizerCompany;//所有承办单位

    private String projectLeader;//项目负责人

    private String teamMembers;//团队成员

    private String prizeCategory;//奖项类别

    private String prizeName;//奖项名称

    private String status;//状态，1为可用，2为不可用

	private Date prizeTime;//获奖时间

    private  Integer count;//成果数量

    private String subjectName;//学科名称

	private String projectCategoryGrade;//项目级别

	private String prizeCategoryGrade;//奖励级别
	//确认状态（excel数据导入后是未确认的  设置状态为“2”  确认后设置状态为“1”）  前端传递确认状态  如果状态的值为null，表示是查询所有，去过状态为，表示查询已确认信息，如果状态为2表示查询未确认信息
	//奖项确认状态
	private String confirmPrizeStatus;
	//项目确认状态
	private String confirmProjectStatus;

	//(前端传递的查询开始时间)
	private String searchStartTime;
	//前端传递的查询结束时间
	private String searchEndTime;

	//成果名称，根据成果名称查询所有成果信息
	private String resultName;

	//立项时间(前端显示的立项时间)
	private String projectBeginTime;

	//获奖时间(前端显示的获奖时间)
	private String prizeEchoTime;

	//下载的状态  1代表下载奖励数据/2代表下载项目数据
	private String code;

	public String getPrizeEchoTime() {
		return prizeEchoTime;
	}

	public void setPrizeEchoTime(String prizeEchoTime) {
		this.prizeEchoTime = prizeEchoTime;
	}

	public String getConfirmPrizeStatus() {
		return confirmPrizeStatus;
	}

	public void setConfirmPrizeStatus(String confirmPrizeStatus) {
		this.confirmPrizeStatus = confirmPrizeStatus;
	}

	public String getConfirmProjectStatus() {
		return confirmProjectStatus;
	}

	public void setConfirmProjectStatus(String confirmProjectStatus) {
		this.confirmProjectStatus = confirmProjectStatus;
	}

	public String getOrganizerCompany() {
		return organizerCompany;
	}

	public void setOrganizerCompany(String organizerCompany) {
		this.organizerCompany = organizerCompany;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProjectBeginTime() {
		return projectBeginTime;
	}

	public void setProjectBeginTime(String projectBeginTime) {
		this.projectBeginTime = projectBeginTime;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getProjectCategoryGrade() {
		return projectCategoryGrade;
	}

	public void setProjectCategoryGrade(String projectCategoryGrade) {
		this.projectCategoryGrade = projectCategoryGrade;
	}

	public String getPrizeCategoryGrade() {
		return prizeCategoryGrade;
	}

	public void setPrizeCategoryGrade(String prizeCategoryGrade) {
		this.prizeCategoryGrade = prizeCategoryGrade;
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

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getManagementCompany() {
		return managementCompany;
	}

	public void setManagementCompany(String managementCompany) {
		this.managementCompany = managementCompany == null ? null : managementCompany.trim();
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject == null ? null : subject.trim();
	}

	public String getProjectNum() {
		return projectNum;
	}

	public void setProjectNum(String projectNum) {
		this.projectNum = projectNum == null ? null : projectNum.trim();
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName == null ? null : projectName.trim();
	}

	public String getProjectKidcat() {
		return projectKidcat;
	}

	public void setProjectKidcat(String projectKidcat) {
		this.projectKidcat = projectKidcat == null ? null : projectKidcat.trim();
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category == null ? null : category.trim();
	}

	public String getSubject1Id() {
		return subject1Id;
	}

	public void setSubject1Id(String subject1Id) {
		this.subject1Id = subject1Id == null ? null : subject1Id.trim();
	}

	public String getSubject2Id() {
		return subject2Id;
	}

	public void setSubject2Id(String subject2Id) {
		this.subject2Id = subject2Id == null ? null : subject2Id.trim();
	}

	public String getSubject3Id() {
		return subject3Id;
	}

	public void setSubject3Id(String subject3Id) {
		this.subject3Id = subject3Id == null ? null : subject3Id.trim();
	}

	public Date getProjectSatrtTime() {
		return projectSatrtTime;
	}

	public void setProjectSatrtTime(Date projectSatrtTime) {
		this.projectSatrtTime = projectSatrtTime;
	}

	public Date getProjectEndTime() {
		return projectEndTime;
	}

	public void setProjectEndTime(Date projectEndTime) {
		this.projectEndTime = projectEndTime;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area == null ? null : area.trim();
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer == null ? null : organizer.trim();
	}

	public String getProjectLeader() {
		return projectLeader;
	}

	public void setProjectLeader(String projectLeader) {
		this.projectLeader = projectLeader == null ? null : projectLeader.trim();
	}

	public String getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(String teamMembers) {
		this.teamMembers = teamMembers == null ? null : teamMembers.trim();
	}

	public String getPrizeCategory() {
		return prizeCategory;
	}

	public void setPrizeCategory(String prizeCategory) {
		this.prizeCategory = prizeCategory == null ? null : prizeCategory.trim();
	}

	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName == null ? null : prizeName.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public Date getPrizeTime() {
		return prizeTime;
	}

	public void setPrizeTime(Date prizeTime) {
		this.prizeTime = prizeTime;
	}

	@Override
	public String toString() {
		return "TProjectData{" +
				"id=" + id +
				", managementCompany='" + managementCompany + '\'' +
				", subject='" + subject + '\'' +
				", projectNum='" + projectNum + '\'' +
				", projectName='" + projectName + '\'' +
				", projectKidcat='" + projectKidcat + '\'' +
				", category='" + category + '\'' +
				", subject1Id='" + subject1Id + '\'' +
				", subject2Id='" + subject2Id + '\'' +
				", subject3Id='" + subject3Id + '\'' +
				", projectSatrtTime=" + projectSatrtTime +
				", projectEndTime=" + projectEndTime +
				", area='" + area + '\'' +
				", organizer='" + organizer + '\'' +
				", organizerCompany='" + organizerCompany + '\'' +
				", projectLeader='" + projectLeader + '\'' +
				", teamMembers='" + teamMembers + '\'' +
				", prizeCategory='" + prizeCategory + '\'' +
				", prizeName='" + prizeName + '\'' +
				", status='" + status + '\'' +
				", prizeTime=" + prizeTime +
				", count=" + count +
				", subjectName='" + subjectName + '\'' +
				", projectCategoryGrade='" + projectCategoryGrade + '\'' +
				", prizeCategoryGrade='" + prizeCategoryGrade + '\'' +
				", confirmPrizeStatus='" + confirmPrizeStatus + '\'' +
				", confirmProjectStatus='" + confirmProjectStatus + '\'' +
				", searchStartTime='" + searchStartTime + '\'' +
				", searchEndTime='" + searchEndTime + '\'' +
				", resultName='" + resultName + '\'' +
				", projectBeginTime='" + projectBeginTime + '\'' +
				", prizeEchoTime='" + prizeEchoTime + '\'' +
				", code='" + code + '\'' +
				'}';
	}
}