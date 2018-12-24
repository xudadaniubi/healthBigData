package com.boku.www.pojo;

import java.io.Serializable;
import java.util.Date;

public class TPatent implements Serializable {
    private Integer id;

    private String firstInvento;//第一发明人

    private String otherInventors;//其他发明人

    private String patentName;//专利名称

    private String patentee;//专利权人

    private String patentApplicationDate;//专利申请日

    private String authorizedAnnouncementDate;//授权公告日

    private String patentCategory;//专利类别

    private String certificateNum;//证书号

    private String patentNum;//专利号

    private String patentAgencyName;//专利代理机构名称

    private String registTime;//登记时间

	private String area;//所属地区

	private String firstInventoCompany;//第一发明人单位

	private String status;//状态

	private String confirmStatus;//确认状态

	//(前端传递的查询开始时间)
	private String searchStartTime;
	//前端传递的查询结束时间
	private String searchEndTime;

	/*private  String subjectName;//学科分类，用于excel文件导出数据

	private String resultCategory;//成果类别，用于excel文件导出数据*/

	public String getSearchStartTime() {
		return searchStartTime;
	}

	public void setSearchStartTime(String searchStartTime) {
		this.searchStartTime = searchStartTime;
	}

	public String getSearchEndTime() {
		return searchEndTime;
	}

	public void setSearchEndTime(String searchEndTime) {
		this.searchEndTime = searchEndTime;
	}

	public String getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	public String getFirstInventoCompany() {
		return firstInventoCompany;
	}

	public void setFirstInventoCompany(String firstInventoCompany) {
		this.firstInventoCompany = firstInventoCompany;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstInvento() {
        return firstInvento;
    }

    public void setFirstInvento(String firstInvento) {
        this.firstInvento = firstInvento == null ? null : firstInvento.trim();
    }

    public String getOtherInventors() {
        return otherInventors;
    }

    public void setOtherInventors(String otherInventors) {
        this.otherInventors = otherInventors == null ? null : otherInventors.trim();
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName == null ? null : patentName.trim();
    }

    public String getPatentee() {
        return patentee;
    }

    public void setPatentee(String patentee) {
        this.patentee = patentee == null ? null : patentee.trim();
    }

    public String getPatentCategory() {
        return patentCategory;
    }

    public void setPatentCategory(String patentCategory) {
        this.patentCategory = patentCategory == null ? null : patentCategory.trim();
    }

    public String getCertificateNum() {
        return certificateNum;
    }

    public void setCertificateNum(String certificateNum) {
        this.certificateNum = certificateNum == null ? null : certificateNum.trim();
    }

    public String getPatentNum() {
        return patentNum;
    }

    public void setPatentNum(String patentNum) {
        this.patentNum = patentNum == null ? null : patentNum.trim();
    }

    public String getPatentAgencyName() {
        return patentAgencyName;
    }

    public void setPatentAgencyName(String patentAgencyName) {
        this.patentAgencyName = patentAgencyName == null ? null : patentAgencyName.trim();
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

	public String getPatentApplicationDate() {
		return patentApplicationDate;
	}

	public void setPatentApplicationDate(String patentApplicationDate) {
		this.patentApplicationDate = patentApplicationDate;
	}

	public String getAuthorizedAnnouncementDate() {
		return authorizedAnnouncementDate;
	}

	public void setAuthorizedAnnouncementDate(String authorizedAnnouncementDate) {
		this.authorizedAnnouncementDate = authorizedAnnouncementDate;
	}
}