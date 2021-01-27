package com.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class WebMvcConfig {

	private final long MAX_AGE_SECS = 3600;
	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("HEAD", "OPTIONS",  "PATCH", "GET", "PUT", "POST", "DELETE")
			.maxAge(MAX_AGE_SECS);
	}
	
}
