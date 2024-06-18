package com.example.appDemo.fullStackAppDemo;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.
		addMapping("/**").allowedMethods("*").allowedOrigins("http://sumanshop-demo-application.s3-website.ap-south-1.amazonaws.com");
	}

}
