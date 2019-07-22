package com.boku.www.pojo;

import lombok.Data;

@Data
public class TCountTopJcr {
    private Integer id;

    private String jcr;

    private String area;

    private String company;

    private Integer count;
	//1代表浙江省论文jcr分区分布，2代表各地区jcr分区分布，3代表一、二、三、四区单位top10
    private String type;
}