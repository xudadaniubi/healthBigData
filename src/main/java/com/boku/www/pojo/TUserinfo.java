package com.boku.www.pojo;

public class TUserinfo {
    private String userinfoId;

    private String userinfoPic;

    private String userinfoCompany;

    private String userinfoPositionName;

    private String userinfoDepartment;

    private String userinfoIsStaffDoctor;

    private String userinfoSubject;

    private String userinfoDoctorNum;

    private String userinfoJobids;

    private String userinfoStudyids;

    public String getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(String userinfoId) {
        this.userinfoId = userinfoId == null ? null : userinfoId.trim();
    }

    public String getUserinfoPic() {
        return userinfoPic;
    }

    public void setUserinfoPic(String userinfoPic) {
        this.userinfoPic = userinfoPic == null ? null : userinfoPic.trim();
    }

    public String getUserinfoCompany() {
        return userinfoCompany;
    }

    public void setUserinfoCompany(String userinfoCompany) {
        this.userinfoCompany = userinfoCompany == null ? null : userinfoCompany.trim();
    }

    public String getUserinfoPositionName() {
        return userinfoPositionName;
    }

    public void setUserinfoPositionName(String userinfoPositionName) {
        this.userinfoPositionName = userinfoPositionName == null ? null : userinfoPositionName.trim();
    }

    public String getUserinfoDepartment() {
        return userinfoDepartment;
    }

    public void setUserinfoDepartment(String userinfoDepartment) {
        this.userinfoDepartment = userinfoDepartment == null ? null : userinfoDepartment.trim();
    }

    public String getUserinfoIsStaffDoctor() {
        return userinfoIsStaffDoctor;
    }

    public void setUserinfoIsStaffDoctor(String userinfoIsStaffDoctor) {
        this.userinfoIsStaffDoctor = userinfoIsStaffDoctor == null ? null : userinfoIsStaffDoctor.trim();
    }

    public String getUserinfoSubject() {
        return userinfoSubject;
    }

    public void setUserinfoSubject(String userinfoSubject) {
        this.userinfoSubject = userinfoSubject == null ? null : userinfoSubject.trim();
    }

    public String getUserinfoDoctorNum() {
        return userinfoDoctorNum;
    }

    public void setUserinfoDoctorNum(String userinfoDoctorNum) {
        this.userinfoDoctorNum = userinfoDoctorNum == null ? null : userinfoDoctorNum.trim();
    }

    public String getUserinfoJobids() {
        return userinfoJobids;
    }

    public void setUserinfoJobids(String userinfoJobids) {
        this.userinfoJobids = userinfoJobids == null ? null : userinfoJobids.trim();
    }

    public String getUserinfoStudyids() {
        return userinfoStudyids;
    }

    public void setUserinfoStudyids(String userinfoStudyids) {
        this.userinfoStudyids = userinfoStudyids == null ? null : userinfoStudyids.trim();
    }
}