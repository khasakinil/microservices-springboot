package com.app.springbootmicroservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springbootmicroservices.interfaces.Coach;

@RestController
public class CoachController {
	private Coach myCoach;

	@Autowired
	public CoachController(Coach myCoach) {
		this.myCoach = myCoach;
	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}

}
