package com.boku.www.pojo.system;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @Title: UUser.java 
 * @Package com.xm.shiro.admin.entity
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author bamboo  <a href=
 *         "mailto:zjcjava@163.com?subject=hello,bamboo&body=Dear Bamboo:%0d%0a描述你的问题："
 *         Bamboo</a>   
 * @date 2017-5-10 0:13:08
 * @version V1.0   
 */
@Data
//@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
public class UUser  implements Serializable {
	 /** serialVersionUID. */
 	private static final long serialVersionUID =1493049839167L;
 	
	private Integer id;//
	private String username;//用户昵称
	private String email;//邮箱|登录帐号
	private String pswd;//密码
	private Date createTime;//创建时间
	private Date lastLoginTime;//最后登录时间
	private String status;//1:有效，0:禁止登录
	private String company;//所属单位
	private String companyId;//所属单位id
	private String area;//所属地区
	private String district;//所属区县
	//验证码
	private String captcha;

	private List<String> roleStrlist;
	private List<String> perminsStrlist;
	
	/**
    * getting setting auto  generate
    */
	public void setId (Integer id){
		this.id=id;
	}
	
	public Integer getId(){
		return id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail (String email){
		this.email=email;
	}
	
	public String getEmail(){
		return email;
	}
	
	
	
	public void setPswd (String pswd){
		this.pswd=pswd;
	}
	
	public String getPswd(){
		return pswd;
	}
	
	
	
	public void setCreateTime (Date createTime){
		this.createTime=createTime;
	}
	
	public Date getCreateTime(){
		return createTime;
	}
	
	
	
	public void setLastLoginTime (Date lastLoginTime){
		this.lastLoginTime=lastLoginTime;
	}
	
	public Date getLastLoginTime(){
		return lastLoginTime;
	}
	
	
	
	public void setStatus (String status){
		this.status=status;
	}
	
	public String getStatus(){
		return status;
	}


	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	//generate toString method


	public List<String> getRoleStrlist() {
		return roleStrlist;
	}

	public void setRoleStrlist(List<String> roleStrlist) {
		this.roleStrlist = roleStrlist;
	}

	public List<String> getPerminsStrlist() {
		return perminsStrlist;
	}

	public void setPerminsStrlist(List<String> perminsStrlist) {
		this.perminsStrlist = perminsStrlist;
	}

	

	
	
	
}
