package com.boku.www.pojo;

import java.io.Serializable;

public class TSubjectCategory implements Serializable {
    private Integer id;

    private String subjectId;

    private String parentSubjectId;

    private String subjectName;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId == null ? null : subjectId.trim();
    }

    public String getParentSubjectId() {
        return parentSubjectId;
    }

    public void setParentSubjectId(String parentSubjectId) {
        this.parentSubjectId = parentSubjectId == null ? null : parentSubjectId.trim();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}