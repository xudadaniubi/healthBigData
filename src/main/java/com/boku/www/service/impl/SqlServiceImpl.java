/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ScheduledServiceImpl
 * Author:   dell
 * Date:     2019/3/22 16:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.service.impl;

import com.boku.www.service.SqlService;
import com.boku.www.utils.ScheduledUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author dell
 * @create 2019/3/22
 * @since 1.0.0
 */
@Service
@Transactional
public class SqlServiceImpl implements SqlService {
	/**
	 *返回已保存的sql文件
	 * @return
	 * @throws Exception
	 */
	@Override
	public List returnSqlList(){
		ScheduledUtils scheduledUtils = new ScheduledUtils();
		return scheduledUtils.getSqlUrlList();
	}
}