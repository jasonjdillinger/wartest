package com.itsy.controller.filter;

import java.util.Date;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegistrar {

//	@Bean
//	public FilterRegistrationBean<SellerLoginFilter> sellerLoginFilter() {
//		FilterRegistrationBean<SellerLoginFilter> bean = new FilterRegistrationBean<>();
//
//		bean.setFilter(new SellerLoginFilter());
//		bean.addUrlPatterns("/seller/login");
//		bean.setName("registrationFilter");
//		bean.setOrder(2);
//		System.out.println("Added Seller Filter.");
//
//		return bean;
//	}
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>();
		
		bean.setFilter(new CorsFilter());
		bean.addUrlPatterns("/*");
		bean.setName("corsFilterName");
		bean.setOrder(1);
		System.out.println("Added Cors Filter.");
		
		return bean;
	}
}
