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

    private String organizerCompanyId;
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

}