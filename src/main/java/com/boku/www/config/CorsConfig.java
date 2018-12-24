/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CorsConfig
 * Author:   dell
 * Date:     2018/11/14 8:27
 * Description: 跨域问题
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 〈一句话功能简述〉<br> 
 * 〈跨域问题〉
 *
 * @author dell
 * @create 2018/11/14
 * @since 1.0.0
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {
	protected final static Logger logger = LoggerFactory.getLogger(CorsConfig.class);

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowCredentials(true)
				.allowedMethods("*")
				.allowedHeaders("*")
				.maxAge(3600);
		logger.info("*********************************跨域过滤器**************************");
	}
}