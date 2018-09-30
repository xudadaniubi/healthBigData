package com.boku.www.pojo;

public class TUserRole {
    private String userRoleId;

    private String userRoleUserid;

    private String userRoleRoleid;

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId == null ? null : userRoleId.trim();
    }

    public String getUserRoleUserid() {
        return userRoleUserid;
    }

    public void setUserRoleUserid(String userRoleUserid) {
        this.userRoleUserid = userRoleUserid == null ? null : userRoleUserid.trim();
    }

    public String getUserRoleRoleid() {
        return userRoleRoleid;
    }

    public void setUserRoleRoleid(String userRoleRoleid) {
        this.userRoleRoleid = userRoleRoleid == null ? null : userRoleRoleid.trim();
    }
}