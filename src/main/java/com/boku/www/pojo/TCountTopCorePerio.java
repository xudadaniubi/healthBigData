package com.boku.www.pojo;

import lombok.Data;

@Data
public class TCountTopCorePerio {
    private Integer id;

    private String company;

    private Integer count;

    private String subject;
	//1代表核心期刊单位前20,2代表核心期刊学科前20
    private String type;

}