package com.app.springbootmicroservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.springbootmicroservices.classes.SwimCoach;
import com.app.springbootmicroservices.interfaces.Coach;

@Configuration
public class SportConfig {

	@Bean("customBeanId")
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
