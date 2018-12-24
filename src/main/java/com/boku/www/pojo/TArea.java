package com.boku.www.pojo;

public class TArea {
    private Integer id;

    private String areaId;

    private String parentAreaId;

    private String areaOrCompany;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getParentAreaId() {
        return parentAreaId;
    }

    public void setParentAreaId(String parentAreaId) {
        this.parentAreaId = parentAreaId == null ? null : parentAreaId.trim();
    }

    public String getAreaOrCompany() {
        return areaOrCompany;
    }

    public void setAreaOrCompany(String areaOrCompany) {
        this.areaOrCompany = areaOrCompany == null ? null : areaOrCompany.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}