package com.app.springbootmicroservices.classes;

import com.app.springbootmicroservices.interfaces.Coach;

public class SwimCoach implements Coach {

	public SwimCoach() {
		System.out.println("SwimCoach initialized");
	}

	@Override
	public String getDailyWorkout() {
		return "Performing with Swim Coach..!";
	}

}
