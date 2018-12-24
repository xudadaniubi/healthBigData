package com.boku.www.pojo;

import java.io.Serializable;
import java.util.Date;

public class TBooks implements Serializable {
    private Integer id;

    private String author;//作者

    private String publisher;//出版社

    private Date time;//时间

    private String projectNum;//项目编号

    private String title;//题名

    private String status;//状态

    private String area;//所属地区

	private String authorCompany;//作者单位

	private  String subjectName;//学科分类，用于excel文件导出数据

	private String resultCategory;//成果类别，用于excel文件导出数据

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getResultCategory() {
		return resultCategory;
	}

	public void setResultCategory(String resultCategory) {
		this.resultCategory = resultCategory;
	}

	public String getAuthorCompany() {
		return authorCompany;
	}

	public void setAuthorCompany(String authorCompany) {
		this.authorCompany = authorCompany;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(String projectNum) {
        this.projectNum = projectNum == null ? null : projectNum.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }
}