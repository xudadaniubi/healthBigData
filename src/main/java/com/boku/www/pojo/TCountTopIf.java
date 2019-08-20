package com.boku.www.pojo;

import lombok.Data;

@Data
public class TCountTopIf {
    private Integer id;
	//影响因子总和
    private Double impactFactorSum;
	//单位
    private String company;
	//学科
    private String subject;
    //学科影响因子
	private Double subjectAvgIf;
	//论文标题
    private String thesisTitle;
	//单个影响因子
    private String impactFactor;

	//1代表单位top20，2代表学科top20，3代表论文top20
    private String type;



}