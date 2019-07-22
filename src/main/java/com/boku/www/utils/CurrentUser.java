/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ReturnCurrentUser
 * Author:   dell
 * Date:     2018/12/18 9:01
 * Description: 返回当前登录用户
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.utils;

import com.boku.www.mapper.system.URoleDao;
import com.boku.www.pojo.system.URole;
import com.boku.www.pojo.system.UUser;
import com.boku.www.pojo.system.UUserExample;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈返回当前登录用户〉
 *
 * @author dell
 * @create 2018/12/18
 * @since 1.0.0
 */
public class CurrentUser {
	public static UUser returnCurrentUser(){
		//获取subject
		Subject subject = SecurityUtils.getSubject();
		UUser currentUser = (UUser)subject.getPrincipal();
		return currentUser;
	}
	public static URole returnRole(URoleDao roleDao){
		UUser currentUser = CurrentUser.returnCurrentUser();
		//查询当前用户的角色是否为单位管理员
		List<URole> roleList = roleDao.findRoleByUid(currentUser.getId());
		if(roleList!=null && roleList.size()>0){
			//一个账号只有一个角色
			URole role = roleList.get(0);
			return role;
		}else {
			return null;
		}
	}
}