package com.app.springbootmicroservices.classes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.app.springbootmicroservices.interfaces.Coach;

@Primary
@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Performing with Tennis Coach";
	}

}
