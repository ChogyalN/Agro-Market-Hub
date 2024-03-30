package com.AgroMarketHub.config;

import com.AgroMarketHub.serviceImpl.FarmOwnerImpl;
import com.AgroMarketHub.serviceRequester.FarmOwnerRequester;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public FarmOwnerRequester farmOwnerRequester() {
		return new FarmOwnerImpl();
	}
}
