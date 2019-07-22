package com.boku.www.pojo;

import lombok.Data;

@Data
public class TCountAuthorNetwork2 {
    private Integer id;

    private Integer cooperatorId;

    private String author;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
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