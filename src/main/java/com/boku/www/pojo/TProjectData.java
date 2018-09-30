package com.boku.www.pojo;

import java.util.Date;

public class TProjectData {
    private Integer id;

    private String managementCompany;

    private String subject;

    private String projectNum;

    private String projectName;

    private String projectKidcat;

    private String category;

    private String subject1Id;

    private String subject2Id;

    private String subject3Id;

    private Date projectSatrtTime;

    private String area;

    private String organizer;

    private String projectLeader;

    private String teamMembers;

    private String prizeCategory;

    private String prizeName;

    private String resultCategory;

    private String resultCategoryId;

    private String resultName;

    private Date resultTime;

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

    public String getResultCategory() {
        return resultCategory;
    }

    public void setResultCategory(String resultCategory) {
        this.resultCategory = resultCategory == null ? null : resultCategory.trim();
    }

    public String getResultCategoryId() {
        return resultCategoryId;
    }

    public void setResultCategoryId(String resultCategoryId) {
        this.resultCategoryId = resultCategoryId == null ? null : resultCategoryId.trim();
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName == null ? null : resultName.trim();
    }

    public Date getResultTime() {
        return resultTime;
    }

    public void setResultTime(Date resultTime) {
        this.resultTime = resultTime;
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
				", area='" + area + '\'' +
				", organizer='" + organizer + '\'' +
				", projectLeader='" + projectLeader + '\'' +
				", teamMembers='" + teamMembers + '\'' +
				", prizeCategory='" + prizeCategory + '\'' +
				", prizeName='" + prizeName + '\'' +
				", resultCategory='" + resultCategory + '\'' +
				", resultCategoryId='" + resultCategoryId + '\'' +
				", resultName='" + resultName + '\'' +
				", resultTime=" + resultTime +
				'}';
	}
}