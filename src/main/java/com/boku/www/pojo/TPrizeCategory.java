package com.boku.www.pojo;

public class TPrizeCategory {
    private Integer id;

    private String grade;

    private String prizeCategory;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getPrizeCategory() {
        return prizeCategory;
    }

    public void setPrizeCategory(String prizeCategory) {
        this.prizeCategory = prizeCategory == null ? null : prizeCategory.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}