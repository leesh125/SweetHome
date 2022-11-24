package com.ssafy.whereismyhome;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("http://127.0.0.1:9000")
		.allowedMethods("GET","POST","DELETE","PUT")
		.allowCredentials(true);
	}
}
