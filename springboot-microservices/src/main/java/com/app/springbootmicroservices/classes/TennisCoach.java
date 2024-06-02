package com.app.springbootmicroservices.classes;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.app.springbootmicroservices.interfaces.Coach;

@Primary
@Component
@Lazy
public class TennisCoach implements Coach {

	public TennisCoach() {
		System.out.println("TennisCoach initialized");
	}

	@Override
	public String getDailyWorkout() {
		return "Performing with Tennis Coach";
	}

}
