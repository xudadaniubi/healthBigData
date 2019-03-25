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
import org.springframework.beans.factory.annotation.Configurable;
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
@Configurable
//开启计划任务支持
@EnableScheduling
//多个任务同时运行是需要添加这个类注解
@EnableAsync
public class ScheduledUtils {

}