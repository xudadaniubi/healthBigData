package com.boku.www.pojo.system;
import java.io.Serializable;


/**
 * @Title: URole.java 
 * @Package com.xm.shiro.admin.entity
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author bamboo  <a href=
 *         "mailto:zjcjava@163.com?subject=hello,bamboo&body=Dear Bamboo:%0d%0a描述你的问题："
 *         Bamboo</a>   
 * @date 2017-5-10 0:12:26
 * @version V1.0   
 */
public class URole  implements Serializable {
	 /** serialVersionUID. */
 	private static final long serialVersionUID =1493049839167L;
 	
	private Integer id;//
	private String name;//角色名称
	private String  type;//角色类型
	
	
	/**
    * getting setting auto  generate
    */
	public void setId (Integer id){
		this.id=id;
	}
	
	public Integer getId(){
		return id;
	}
	
	
	
	public void setName (String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	
	
	public void setType (String type){
		this.type=type;
	}
	
	public String getType(){
		return type;
	}
	
	
	
	//generate toString method
	@Override
	public String toString (){
		return "URole[id="+id
		+",name="+name
		+",type="+type+"]";
	}
	
	
}
