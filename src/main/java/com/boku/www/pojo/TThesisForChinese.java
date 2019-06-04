package com.boku.www.pojo;

import lombok.Data;

@Data
public class TThesisForChinese {
    private Integer id;
	//成果名称,标题
    private String title;
	//作者
    private String author;

    private String doi;
	//文献来源
    private String literatureResources;
	//年
    private String year;
	//卷
    private String roll;
	//期
    private String journal;
	//期
    private String issn;
	//页码
    private String page;
	//作者单位
    private String authorCompany;
    //作者id
    private String authorCompanyId;
	//状态
    private String status;

	private String confirmStatus;//确认状态

	//所属地区
    private String area;
	//(前端传递的查询开始时间)
	private String searchStartTime;
	//前端传递的查询结束时间
	private String searchEndTime;
}