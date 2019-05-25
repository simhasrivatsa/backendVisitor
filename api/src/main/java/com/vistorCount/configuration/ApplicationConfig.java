package com.vistorCount.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter {
    @Value("${visitor.ui}")
    private String UI_PATH;


    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //System.out.println("adding resources");
        registry.addResourceHandler("/**").addResourceLocations("file:" + UI_PATH + "/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
    }
}

