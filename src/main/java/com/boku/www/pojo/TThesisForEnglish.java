package com.boku.www.pojo;

import lombok.Data;

@Data
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
	//状态
	private String status;
	//单位id
	private String authorCompanyId;
	//所属地区
	private String area;
	//JCR分区
	private String jcrPartition;
	//影响因子
	private String impactFactor;
	//学科
	private String subject;
	//作者单位
	private String authorCompany;

	//作者地址
	private String authorsAddress;

	//文摘
	private String abstracts;

	private String keywords;

	//确认状态
	private String confirmStatus;
	//(前端传递的查询开始时间)
	private String searchStartTime;
	//前端传递的查询结束时间
	private String searchEndTime;

}