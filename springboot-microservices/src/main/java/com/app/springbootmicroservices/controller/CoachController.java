package com.app.springbootmicroservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springbootmicroservices.interfaces.Coach;

@RestController
public class CoachController {
	private Coach myCoach;

	@Autowired
//	public CoachController(@Qualifier("trackCoach") Coach myCoach) {
	public CoachController(@Qualifier("baseballCoach") Coach myCoach) {
	System.out.println("Constructor level Dependency Injection");
		this.myCoach = myCoach;
	}

//	@Autowired
//	public void setCoachController(Coach myCoach) {
//		System.out.println("Method level Dependency Injection");
//		this.myCoach = myCoach;
//	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}

}
