package com.app.springbootmicroservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springbootmicroservices.interfaces.Coach;

@RestController
public class CoachController {
	private Coach myCoach;
	private Coach myCoachAnother;

	@Autowired
//	public CoachController(@Qualifier("trackCoach") Coach myCoach) {
	public CoachController(@Qualifier("customBeanId") Coach myCoach,
			@Qualifier("baseballCoach") Coach myCoachAnother) {
		System.out.println("Constructor level Dependency Injection");
		this.myCoach = myCoach;
		this.myCoachAnother = myCoachAnother;
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

	@GetMapping("/checkscope")
	public String checkBeanScope() {
		return "Comparing Beans : " + (myCoachAnother == myCoach);
	}

}
