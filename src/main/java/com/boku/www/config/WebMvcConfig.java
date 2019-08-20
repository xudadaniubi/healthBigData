package com.boku.www.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * Created by DELL on 2019/6/26.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Value("${web.upload-path}")
	private String path;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file/**").addResourceLocations("file:"+path+"/");
        super.addResourceHandlers(registry);
    }


}
