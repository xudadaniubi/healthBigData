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

import com.boku.www.controller.AreaController;
import com.boku.www.service.ScheduledSqlService;
import com.boku.www.utils.DatabaseUtil;
import com.boku.www.utils.DeleteFileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ScheduledSqlServiceImpl implements ScheduledSqlService {
	private static Logger logger = LoggerFactory.getLogger(AreaController.class);

	@Value("${spring.datasource.ip}")
	private String ip;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.database}")
	private String database;
	@Value("${com.sqlfile.dir.url}")
	private String fileDir;

	/**
	 *返回已保存的sql文件
	 * @return
	 * @throws Exception
	 */
	@Override
	public List returnSqlList(){
		return getSqlUrlList();
	}

	private ArrayList<String> getSqlUrlList() {
		ArrayList<String> sqlUrlList = new ArrayList<>();
		File file=new File(fileDir);
		File[] files=file.listFiles();
		String fileAbsolutePath = null;
		for(File a:files) {
			fileAbsolutePath = a.getAbsolutePath();
			if (fileAbsolutePath.endsWith(".sql")) {
				sqlUrlList.add(fileAbsolutePath);
			}
		}
		return sqlUrlList;
	}




}