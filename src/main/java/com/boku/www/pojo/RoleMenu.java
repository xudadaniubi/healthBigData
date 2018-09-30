package com.boku.www.pojo;

public class RoleMenu {
    private String roleMenuId;

    private String roleMenuRoleid;

    private String roleMenuMenuid;

    public String getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(String roleMenuId) {
        this.roleMenuId = roleMenuId == null ? null : roleMenuId.trim();
    }

    public String getRoleMenuRoleid() {
        return roleMenuRoleid;
    }

    public void setRoleMenuRoleid(String roleMenuRoleid) {
        this.roleMenuRoleid = roleMenuRoleid == null ? null : roleMenuRoleid.trim();
    }

    public String getRoleMenuMenuid() {
        return roleMenuMenuid;
    }

    public void setRoleMenuMenuid(String roleMenuMenuid) {
        this.roleMenuMenuid = roleMenuMenuid == null ? null : roleMenuMenuid.trim();
    }
}