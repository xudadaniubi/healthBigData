package com.boku.www.pojo;

public class TPrizeData {
    private Integer id;
		//项目名称
		private String projectName;
		//项目类别
		private String projectCategory;
		//一级学科分类名称
		private String subjectName1;
		//二级学科分类名称
		private String subjectName2;
		//第一承担单位
		private String firstOrganizerCompany;
		//其他承担单位
		private String otherOrganizerCompany;
		//所在地区
		private String area;
		//项目负责人
		private String projectLeader;
		//团队成员
		private String teamMembers;
		//奖励级别
		private String prizeCategoryGrade;
		//所获奖项
		private String prizeCategory;
		//奖项等级（一等奖）
		private String awardGrade;
		//获奖时间
		private String prizeTime;
		//状态
		private String status;
		//确认状态
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
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

    public String getFirstOrganizerCompany() {
        return firstOrganizerCompany;
    }

    public void setFirstOrganizerCompany(String firstOrganizerCompany) {
        this.firstOrganizerCompany = firstOrganizerCompany == null ? null : firstOrganizerCompany.trim();
    }

    public String getOtherOrganizerCompany() {
        return otherOrganizerCompany;
    }

    public void setOtherOrganizerCompany(String otherOrganizerCompany) {
        this.otherOrganizerCompany = otherOrganizerCompany == null ? null : otherOrganizerCompany.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
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

    public String getPrizeCategoryGrade() {
        return prizeCategoryGrade;
    }

    public void setPrizeCategoryGrade(String prizeCategoryGrade) {
        this.prizeCategoryGrade = prizeCategoryGrade == null ? null : prizeCategoryGrade.trim();
    }

    public String getPrizeCategory() {
        return prizeCategory;
    }

    public void setPrizeCategory(String prizeCategory) {
        this.prizeCategory = prizeCategory == null ? null : prizeCategory.trim();
    }

    public String getAwardGrade() {
        return awardGrade;
    }

    public void setAwardGrade(String awardGrade) {
        this.awardGrade = awardGrade == null ? null : awardGrade.trim();
    }

    public String getPrizeTime() {
        return prizeTime;
    }

    public void setPrizeTime(String prizeTime) {
        this.prizeTime = prizeTime == null ? null : prizeTime.trim();
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