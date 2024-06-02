package com.app.springbootmicroservices.classes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.app.springbootmicroservices.interfaces.Coach;

@Component
@Lazy
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("CricketCoach initialized");
	}
	@Override
	public String getDailyWorkout() {
		return "Practice cricket daily for 1 hr..";
	}

}
