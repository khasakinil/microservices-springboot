package com.app.springbootmicroservices.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/rest")
public class MyRestController {

	@Value("${team.name}")
	private String teamName;

	@GetMapping("/message")
	public String getMessage() {
		return "Hi Everyone, Good morning";
	}

	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is lucky day..!!";
	}

	@GetMapping("/teamname")
	public String getTeamName() {
		return "Team : " + teamName;
	}
}
