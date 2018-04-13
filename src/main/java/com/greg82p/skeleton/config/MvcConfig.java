package com.greg82p.skeleton.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySources({
        @PropertySource("classpath:properties/default.properties"),
        @PropertySource(value = "classpath:properties/${spring.profiles.active}.properties", ignoreResourceNotFound = true)})
public class MvcConfig implements WebMvcConfigurer {

    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/robots.txt").addResourceLocations("/WEB-INF/robots.txt");
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}
}
