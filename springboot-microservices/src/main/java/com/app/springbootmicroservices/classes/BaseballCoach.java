package com.app.springbootmicroservices.classes;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.app.springbootmicroservices.interfaces.Coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Lazy
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach {

	public BaseballCoach() {
		System.out.println("BaseballCoach initialized");
	}

	@Override
	public String getDailyWorkout() {
		return "Performing with Baseball Coach";
	}

	@PostConstruct
	public void doApplicationStartupStuff() {
		System.out.println("doApplicationStartupStuff");
	}

	@PreDestroy
	public void doApplicationCleanupStuff() {
		System.out.println("doApplicationCleanupStuff");
	}
}
