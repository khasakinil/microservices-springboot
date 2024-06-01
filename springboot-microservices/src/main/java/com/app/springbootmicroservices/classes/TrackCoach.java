package com.app.springbootmicroservices.classes;

import org.springframework.stereotype.Component;

import com.app.springbootmicroservices.interfaces.Coach;
@Component
public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Performing with Track Coach";
	}

}
