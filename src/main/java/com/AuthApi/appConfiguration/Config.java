package com.AuthApi.appConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
	 @Autowired
	    private FilterRequest filterRequest;

	    @Bean
	    public FilterRegistrationBean<FilterRequest> filterRegistrationBean() {
	        FilterRegistrationBean < FilterRequest > registrationBean = new FilterRegistrationBean();
	        registrationBean.setFilter(filterRequest);
	        registrationBean.addUrlPatterns("/api/*");
	        return registrationBean;
	    }
}
