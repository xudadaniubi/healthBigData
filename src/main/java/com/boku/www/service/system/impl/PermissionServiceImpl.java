/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: PermissionServiceImpl
 * Author:   dell
 * Date:     2018/10/31 15:59
 * Description: 权限
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.service.system.impl;

import com.boku.www.mapper.system.UPermissionDao;
import com.boku.www.pojo.system.UPermission;
import com.boku.www.service.system.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈权限〉
 *
 * @author dell
 * @create 2018/10/31
 * @since 1.0.0
 */
@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private UPermissionDao permissionDao;
	@Override
	public List<UPermission> findPermissionByUid(Integer id) {
		return permissionDao.findPermissionByUid(id);
	}
}