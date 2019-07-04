package com.boku.www.utils;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable{
	private long total;//总记录数
	private List rows;//当前页结果
	private String roleGrade;//角色等级
	private Integer confirmedCount;//已确认状态的数量
	private Integer unconfirmedCount;//未确认状态的数量
	public PageResult(long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public PageResult() {
		super();
	}

	public Integer getConfirmedCount() {
		return confirmedCount;
	}

	public void setConfirmedCount(Integer confirmedCount) {
		this.confirmedCount = confirmedCount;
	}

	public Integer getUnconfirmedCount() {
		return unconfirmedCount;
	}

	public void setUnconfirmedCount(Integer unconfirmedCount) {
		this.unconfirmedCount = unconfirmedCount;
	}

	public String getRoleGrade() {
		return roleGrade;
	}

	public void setRoleGrade(String roleGrade) {
		this.roleGrade = roleGrade;
	}

	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
}
