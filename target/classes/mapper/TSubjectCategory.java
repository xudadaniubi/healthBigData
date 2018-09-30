package com.boku.www.pojo;

public class TSubjectCategory {
    private String id;

    private String subjectId;

    private String parentSubjectId;

    private String subjectName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
}