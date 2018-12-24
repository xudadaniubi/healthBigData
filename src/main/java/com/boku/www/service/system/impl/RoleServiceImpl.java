/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: RoleServiceImpl
 * Author:   dell
 * Date:     2018/10/31 16:01
 * Description: 角色
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.service.system.impl;

import com.boku.www.mapper.system.URoleDao;
import com.boku.www.pojo.system.URole;
import com.boku.www.pojo.system.UUser;
import com.boku.www.service.system.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈角色〉
 *
 * @author dell
 * @create 2018/10/31
 * @since 1.0.0
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private URoleDao roleDao;
	@Override
	public List<URole> findRoleByUid(Integer id) {
		return roleDao.findRoleByUid(id);
	}
	/**
	 * 查询用户级别
	 * @return
	 */
	@Override
	public String getRoleGrade() {
		//获取subject
		Subject subject = SecurityUtils.getSubject();
		UUser currentUser = (UUser)subject.getPrincipal();
		String roleGrade = "该角色不存在";
		if (currentUser != null) {
			//获取用户角色
			List<URole> rlist = roleDao.findRoleByUid(currentUser.getId());
			for (URole role : rlist) {
				roleGrade = role.getName();
			}
			return roleGrade ;
		}
		return roleGrade;
	}
}