package com.boku.www.pojo;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

@Data
public class TbCnkiDocumentCommon {
	@Field("id")
	private String id;
	@Field("title")
	private String title;
	@Field("subject_class_codes")
	private String cat;
	@Field("year")
	private String year;
	@Field("roll")
	private String roll;
	@Field("perioId")
	private String perioid;
	@Field("perioName")
	private String perioname;
	@Field("perioNum")
	private String perionum;

	private Integer isCnki;
	@Field("special_name")
	private String specialName;
	@Field("issn")
	private String issn;
	@Field("cn")
	private String cn;
	@Field("doi")
	private String doi;

	private String specialNameNum;

	private String unit;
	//<!--核心期刊-->
	@Field("core_perio")
    private String corePerio;
	//<!--中科院分区-->
	@Field("subarea")
    private String subarea;
	//<!--影响因子-->
	@Field("affectoi")
	private String affectoi;
	//<!--被清洗后的作者-->
	@Field("author_cleaned")
	private String authorCleaned;
	//<!--作者单位的id，每个单位是唯一的，需要通过社会信用代码统一标识-->
	@Field("unit_id")
	private String unitId;
	//<!--是否被清洗，0代表未清洗，1代表已清洗-->
	@Field("is_cleaned")
	private String isCleaned;
	//<!--是否被去重,0代表还未比较去重，1代表万方中有该数据，2代表万方中没有该数据-->
	@Field("is_equals")
	private String isEquals;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat == null ? null : cat.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll == null ? null : roll.trim();
    }

    public String getPerioid() {
        return perioid;
    }

    public void setPerioid(String perioid) {
        this.perioid = perioid == null ? null : perioid.trim();
    }

    public String getPerioname() {
        return perioname;
    }

    public void setPerioname(String perioname) {
        this.perioname = perioname == null ? null : perioname.trim();
    }

    public String getPerionum() {
        return perionum;
    }

    public void setPerionum(String perionum) {
        this.perionum = perionum == null ? null : perionum.trim();
    }

    public Integer getIsCnki() {
        return isCnki;
    }

    public void setIsCnki(Integer isCnki) {
        this.isCnki = isCnki;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName == null ? null : specialName.trim();
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn == null ? null : issn.trim();
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn == null ? null : cn.trim();
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi == null ? null : doi.trim();
    }

    public String getSpecialNameNum() {
        return specialNameNum;
    }

    public void setSpecialNameNum(String specialNameNum) {
        this.specialNameNum = specialNameNum == null ? null : specialNameNum.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getAffectoi() {
        return affectoi;
    }

    public void setAffectoi(String affectoi) {
        this.affectoi = affectoi == null ? null : affectoi.trim();
    }

    public String getCorePerio() {
        return corePerio;
    }

    public void setCorePerio(String corePerio) {
        this.corePerio = corePerio == null ? null : corePerio.trim();
    }

    public String getSubarea() {
        return subarea;
    }

    public void setSubarea(String subarea) {
        this.subarea = subarea == null ? null : subarea.trim();
    }
}