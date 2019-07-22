package com.boku.www.pojo;

import lombok.Data;

@Data
public class TCountCompanyNetwork2 {
    private Integer id;

    private Integer cooperatorId;

    private String company;

    private String cooperator;

    private Integer cooperationNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCooperatorId() {
        return cooperatorId;
    }

    public void setCooperatorId(Integer cooperatorId) {
        this.cooperatorId = cooperatorId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getCooperator() {
        return cooperator;
    }

    public void setCooperator(String cooperator) {
        this.cooperator = cooperator == null ? null : cooperator.trim();
    }

    public Integer getCooperationNum() {
        return cooperationNum;
    }

    public void setCooperationNum(Integer cooperationNum) {
        this.cooperationNum = cooperationNum;
    }
}