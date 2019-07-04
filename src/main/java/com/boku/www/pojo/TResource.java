package com.boku.www.pojo;

import lombok.Data;

@Data
public class TResource {
    private Integer id;

    private String title;

	private String skipUrl;

    private String category;

    private String picUrl;

    private String status;

    private String abstracts;

}