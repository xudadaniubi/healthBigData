package com.boku.www.pojo;

public class TJobs {
    private String jobsId;

    private String jobsStartTime;

    private String jobsOffTime;

    private String jobsCompany;

    private String jobsPositionName;

    private String jobsDescription;

    private String jobsUserid;

    public String getJobsId() {
        return jobsId;
    }

    public void setJobsId(String jobsId) {
        this.jobsId = jobsId == null ? null : jobsId.trim();
    }

    public String getJobsStartTime() {
        return jobsStartTime;
    }

    public void setJobsStartTime(String jobsStartTime) {
        this.jobsStartTime = jobsStartTime == null ? null : jobsStartTime.trim();
    }

    public String getJobsOffTime() {
        return jobsOffTime;
    }

    public void setJobsOffTime(String jobsOffTime) {
        this.jobsOffTime = jobsOffTime == null ? null : jobsOffTime.trim();
    }

    public String getJobsCompany() {
        return jobsCompany;
    }

    public void setJobsCompany(String jobsCompany) {
        this.jobsCompany = jobsCompany == null ? null : jobsCompany.trim();
    }

    public String getJobsPositionName() {
        return jobsPositionName;
    }

    public void setJobsPositionName(String jobsPositionName) {
        this.jobsPositionName = jobsPositionName == null ? null : jobsPositionName.trim();
    }

    public String getJobsDescription() {
        return jobsDescription;
    }

    public void setJobsDescription(String jobsDescription) {
        this.jobsDescription = jobsDescription == null ? null : jobsDescription.trim();
    }

    public String getJobsUserid() {
        return jobsUserid;
    }

    public void setJobsUserid(String jobsUserid) {
        this.jobsUserid = jobsUserid == null ? null : jobsUserid.trim();
    }
}