package com.boku.www.Enum;

public enum Area {
	HANGZHOU("1","杭州市"),
	NINGBO("2","宁波市"),
	WENZHOU("3","温州市"),
	SHAOXING("4","绍兴市"),
	HUZHOU("5","湖州市"),
	JIAXING("6","嘉兴市"),
	JINHUA("7","金华市"),
	QUZHOU("8","衢州市"),
	TAIZHOU("9","台州市"),
	LISHUI("10","丽水市"),
	ZHOUSHAN("11","舟山市"),
	WEIZHISHU("12","委直属"),
	ZHEDA("13","浙大及其附属"),
	ZHEZHONGDA("14","浙中大及其附属"),
	HANGSHIDA("15","杭师大"),
	QITAGAOXIAO("16","其他高校"),
	WENYIDA("17","温医大及其附属");
	private String code;
	private String msg;

	Area(String code,String msg){
		this.code = code;
		this.msg = msg;
	}
	public String getCode(){return code;}
	public String getMsg(){return msg;}

}
