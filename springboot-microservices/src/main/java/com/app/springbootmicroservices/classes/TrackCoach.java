package com.app.springbootmicroservices.classes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.app.springbootmicroservices.interfaces.Coach;

@Component
@Lazy
public class TrackCoach implements Coach {

	public TrackCoach() {
		System.out.println("TrackCoach initialized");
	}

	@Override
	public String getDailyWorkout() {
		return "Performing with Track Coach";
	}

}
