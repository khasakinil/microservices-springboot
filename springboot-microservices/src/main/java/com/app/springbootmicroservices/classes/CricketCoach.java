package com.app.springbootmicroservices.classes;

import org.springframework.stereotype.Component;

import com.app.springbootmicroservices.interfaces.Coach;

@Component
public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice cricket daily for 1 hr.";
	}

}
