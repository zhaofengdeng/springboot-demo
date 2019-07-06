package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.run(Application.class, args);
	}
	/**
	 * 过滤器使用
	 */
	// @Bean
	// public FilterRegistrationBean testFilterRegistration() {
	// FilterRegistrationBean registration = new FilterRegistrationBean();
	// registration.setFilter(new SystemFilter());
	// registration.addUrlPatterns("/*");
	// registration.setName("systemFilter");
	// registration.setOrder(1);
	// return registration;
	// }
}
