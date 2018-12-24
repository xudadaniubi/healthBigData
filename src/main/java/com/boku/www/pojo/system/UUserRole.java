package com.boku.www.pojo.system;
import java.io.Serializable;


/**
 * @Title: UUserRole.java 
 * @Package com.xm.shiro.admin.entity
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author bamboo  <a href=
 *         "mailto:zjcjava@163.com?subject=hello,bamboo&body=Dear Bamboo:%0d%0a描述你的问题："
 *         Bamboo</a>   
 * @date 2017-5-10 0:13:30
 * @version V1.0   
 */
public class UUserRole  implements Serializable {
	 /** serialVersionUID. */
 	private static final long serialVersionUID =1493049839167L;
 	
	private Integer uid;//用户ID
	private Integer rid;//角色ID
	
	
	/**
    * getting setting auto  generate
    */
	public void setUid (Integer uid){
		this.uid=uid;
	}
	
	public Integer getUid(){
		return uid;
	}
	
	
	
	public void setRid (Integer rid){
		this.rid=rid;
	}
	
	public Integer getRid(){
		return rid;
	}
	
	
	
	//generate toString method
	@Override
	public String toString (){
		return "UUserRole[uid="+uid
		+",rid="+rid+"]";
	}
	
	
}
