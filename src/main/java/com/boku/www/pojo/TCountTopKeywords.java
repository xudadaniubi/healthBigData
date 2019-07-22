package com.boku.www.pojo;

import lombok.Data;

@Data
public class TCountTopKeywords {
    private Integer id;

    private String keywords;

    private Integer count;

    private Integer topNum;

    private String type;

    private String area;

}