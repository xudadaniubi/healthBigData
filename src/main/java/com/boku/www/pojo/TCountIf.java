package com.boku.www.pojo;

public class TCountIf {
    private Integer id;

    private String company;

    private Double avgIf;

    private Double sumIf;

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

    public Double getAvgIf() {
        return avgIf;
    }

    public void setAvgIf(Double avgIf) {
        this.avgIf = avgIf;
    }

    public Double getSumIf() {
        return sumIf;
    }

    public void setSumIf(Double sumIf) {
        this.sumIf = sumIf;
    }
}