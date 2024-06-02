package com.app.springbootmicroservices.classes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.app.springbootmicroservices.interfaces.Coach;

@Component
@Lazy
public class BaseballCoach implements Coach {

	public BaseballCoach() {
		System.out.println("BaseballCoach initialized");
	}
	@Override
	public String getDailyWorkout() {
		return "Performing with Baseball Coach";
	}

}
