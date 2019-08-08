package com.boku.www.pojo;

import lombok.Data;

@Data
public class TCountTopJournal {
    private Integer id;

    private String journalName;

    private Integer count;
	//1代表中文2代表外文
    private String type;

}