package com.example.doctor.config;

import javax.websocket.server.PathParam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPattern;

/*@Configuration
public class ConfigClass {
	
	@Bean
	public WebMvcConfigurer getCorsConfiguration() {
		return new WebMvcConfigurer() {
			
			 @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                        .allowedOrigins("http://localhost:4200")
	                        .allowedMethods("GET", "POST", "PUT", "DELETE")
	                        .allowedHeaders("*");
	            }
		};
	}

}*/
