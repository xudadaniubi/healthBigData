package com.boku.www.pojo;

import java.util.Date;

public class TThesis {
    private String id;

    private String title;

    private String author;

    private String doi;

    private String literatureResources;

    private Date year;

    private String roll;

    private String journal;

    private String issn;

    private String page;

    private String organization;

    private String resultId;

    private String projectNum;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi == null ? null : doi.trim();
    }

    public String getLiteratureResources() {
        return literatureResources;
    }

    public void setLiteratureResources(String literatureResources) {
        this.literatureResources = literatureResources == null ? null : literatureResources.trim();
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll == null ? null : roll.trim();
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal == null ? null : journal.trim();
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn == null ? null : issn.trim();
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page == null ? null : page.trim();
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId == null ? null : resultId.trim();
    }

    public String getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(String projectNum) {
        this.projectNum = projectNum == null ? null : projectNum.trim();
    }
}