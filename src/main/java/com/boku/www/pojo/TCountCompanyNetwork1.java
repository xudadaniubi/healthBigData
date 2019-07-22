package com.boku.www.pojo;

import lombok.Data;

@Data
public class TCountCompanyNetwork1 {
    private Integer id;

    private String company;

    private Integer companyPostNum;

    private String cooperator;

    private Integer cooperationNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Integer getCompanyPostNum() {
        return companyPostNum;
    }

    public void setCompanyPostNum(Integer companyPostNum) {
        this.companyPostNum = companyPostNum;
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