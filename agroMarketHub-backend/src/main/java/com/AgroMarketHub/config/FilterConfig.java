package com.AgroMarketHub.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.AgroMarketHub.classes.JwtFilter;
import com.AgroMarketHub.serviceImpl.JwtServiceImpl;

@Configuration
public class FilterConfig {

	@Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter(JwtServiceImpl jwtUtil) {
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtFilter(jwtUtil));
        registrationBean.addUrlPatterns("/api/*"); // Specify the URL patterns to filter
        return registrationBean;
    }
	
}
