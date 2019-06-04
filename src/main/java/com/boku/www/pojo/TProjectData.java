package com.boku.www.pojo;

import lombok.Data;

@Data
public class TProjectData {
    private Integer id;
	//项目管理单位
    private String managementCompany;
	//项目分类级别
    private String projectCategoryGrade;
	//项目类别
    private String projectCategory;
	//一级学科分类名称
    private String subjectName1;
	//二级学科分类名称
    private String subjectName2;
	//项目名称
    private String projectName;
	//项目子类
    private String projectKidcat;
	//类目
    private String category;
	//立项时间
    private String projectStartTime;
	//结题时间
    private String projectEndTime;
	//所在地区
    private String area;
	//所有的承担单位
    private String organizer;
	//其他承担单位
    private String otherOrganizerCompany;
	//第一承担单位
    private String firstOrganizerCompany;
	//所有的承担单位
    private String projectLeader;
	//团队成员
    private String teamMembers;
	//状态
    private String status;
	//奖项确认状态
    private String confirmStatus;
	//(前端传递的查询开始时间)
	private String searchStartTime;
	//前端传递的查询结束时间
	private String searchEndTime;

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

    public String getManagementCompany() {
        return managementCompany;
    }

    public void setManagementCompany(String managementCompany) {
        this.managementCompany = managementCompany == null ? null : managementCompany.trim();
    }

    public String getProjectCategoryGrade() {
        return projectCategoryGrade;
    }

    public void setProjectCategoryGrade(String projectCategoryGrade) {
        this.projectCategoryGrade = projectCategoryGrade == null ? null : projectCategoryGrade.trim();
    }

    public String getProjectCategory() {
        return projectCategory;
    }

    public void setProjectCategory(String projectCategory) {
        this.projectCategory = projectCategory == null ? null : projectCategory.trim();
    }

    public String getSubjectName1() {
        return subjectName1;
    }

    public void setSubjectName1(String subjectName1) {
        this.subjectName1 = subjectName1 == null ? null : subjectName1.trim();
    }

    public String getSubjectName2() {
        return subjectName2;
    }

    public void setSubjectName2(String subjectName2) {
        this.subjectName2 = subjectName2 == null ? null : subjectName2.trim();
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

    public String getProjectStartTime() {
        return projectStartTime;
    }

    public void setProjectStartTime(String projectStartTime) {
        this.projectStartTime = projectStartTime == null ? null : projectStartTime.trim();
    }

    public String getProjectEndTime() {
        return projectEndTime;
    }

    public void setProjectEndTime(String projectEndTime) {
        this.projectEndTime = projectEndTime == null ? null : projectEndTime.trim();
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

    public String getOtherOrganizerCompany() {
        return otherOrganizerCompany;
    }

    public void setOtherOrganizerCompany(String otherOrganizerCompany) {
        this.otherOrganizerCompany = otherOrganizerCompany == null ? null : otherOrganizerCompany.trim();
    }

    public String getFirstOrganizerCompany() {
        return firstOrganizerCompany;
    }

    public void setFirstOrganizerCompany(String firstOrganizerCompany) {
        this.firstOrganizerCompany = firstOrganizerCompany == null ? null : firstOrganizerCompany.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(String confirmStatus) {
        this.confirmStatus = confirmStatus == null ? null : confirmStatus.trim();
    }
}