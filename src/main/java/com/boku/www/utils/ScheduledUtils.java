/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ScheduledUtils
 * Author:   dell
 * Date:     2019/3/22 18:03
 * Description: 定时备份数据和删除数据
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.utils;

import com.boku.www.controller.AreaController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈定时备份数据和删除数据〉
 *
 * @author dell
 * @create 2019/3/22
 * @since 1.0.0
 */
//@Configurable
//开启计划任务支持
@EnableScheduling
//多个任务同时运行是需要添加这个类注解
@EnableAsync
public class ScheduledUtils {
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
	 * 生成备份文件
	 * @throws Exception
	 */
	//异步调用方法注解
	@Async
	//计划任务声明
	@Scheduled(cron="0 0 1 ? * SUN") //每周日凌晨1点执行一次
	//@Scheduled(cron="0/10 * *  * * ?") //每五秒执行一次
	//@Scheduled(cron="0 */10 * * * ?") //每十分钟执行一次
	public void backup() throws  Exception{
		logger.info("start push data scheduled!");
		//参数依次是IP、账号、密码、数据库名
		String command1 = "mysqldump -h"+ip+" -u"+username+" -p"+password+" "+database;
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String sdfDate = sdf.format(currentDate);
		// 备份的路径地址
		String savePath1 = fileDir + "\\health_big_data_backup_time_" + sdfDate + ".sql";
		boolean b1 = new DatabaseUtil().backup(command1, savePath1 ,fileDir);
		if(b1){
			logger.info("备份成功");
		}else {
			logger.info("备份失败");
		}
		logger.info("end push data scheduled!");
	}

	/**
	 * 删除三个月以上的备份文件
	 * @throws Exception
	 */
	@Async
	@Scheduled(cron="0 0 1 ? * SUN") //每周日凌晨1点执行一次
	//@Scheduled(cron="0 */10 * * * ?") //每十分钟执行一次
	//@Scheduled(cron="0/5 * *  * * ?") //每五秒执行一次
	public void deleteBackup() throws  Exception{
		logger.info("start delete data scheduled!");
		ArrayList<String> sqlUrlList = getSqlUrlList();
		for (String sqlUrl:sqlUrlList) {
			String time_ = sqlUrl.substring(sqlUrl.indexOf("time_")+5, sqlUrl.indexOf("."));
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = sdf.parse(time_);
			long fileTime = date.getTime();
			long currentTime = System.currentTimeMillis();
			//如果两个时间相减超过三个月则删除该文件  1000*60*60*24*90 = 86400000*90 = 7776000000
			long threeMonth = 7776000000L;
			//long threeMonth = 600000L;
			if((currentTime-fileTime)>threeMonth){
				DeleteFileUtil.deleteFile(sqlUrl);
				logger.info(time_+":"+date.getTime()+"删除的文件为："+sqlUrl);
			}
		}
		logger.info("end delete data scheduled!");
	}

	public ArrayList<String> getSqlUrlList() {
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