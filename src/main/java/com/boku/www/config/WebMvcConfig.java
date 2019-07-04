package com.boku.www.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * Created by DELL on 2019/6/26.
 */
@Configuration
//public class WebMvcConfig implements WebMvcConfigurer{
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry){
//
//        registry.addRedirectViewController("/file").
//
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {


        registry.addResourceHandler("/file/**").addResourceLocations("file:D:/image/");

        super.addResourceHandlers(registry);
    }


}
