package com.boku.www.pojo;

public class TStudies {
    private String studyId;

    private String studyStartTime;

    private String studyOffTime;

    private String studyGraduateShool;

    private String studyProfessional;

    private String studyUserid;

    public String getStudyId() {
        return studyId;
    }

    public void setStudyId(String studyId) {
        this.studyId = studyId == null ? null : studyId.trim();
    }

    public String getStudyStartTime() {
        return studyStartTime;
    }

    public void setStudyStartTime(String studyStartTime) {
        this.studyStartTime = studyStartTime == null ? null : studyStartTime.trim();
    }

    public String getStudyOffTime() {
        return studyOffTime;
    }

    public void setStudyOffTime(String studyOffTime) {
        this.studyOffTime = studyOffTime == null ? null : studyOffTime.trim();
    }

    public String getStudyGraduateShool() {
        return studyGraduateShool;
    }

    public void setStudyGraduateShool(String studyGraduateShool) {
        this.studyGraduateShool = studyGraduateShool == null ? null : studyGraduateShool.trim();
    }

    public String getStudyProfessional() {
        return studyProfessional;
    }

    public void setStudyProfessional(String studyProfessional) {
        this.studyProfessional = studyProfessional == null ? null : studyProfessional.trim();
    }

    public String getStudyUserid() {
        return studyUserid;
    }

    public void setStudyUserid(String studyUserid) {
        this.studyUserid = studyUserid == null ? null : studyUserid.trim();
    }
}