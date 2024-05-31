package com.app.springbootmicroservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/rest")
public class MyRestController {

	@GetMapping("/message")
	public String getMessage() {
		return "Hi Everyone, Good morning";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is lucky day..!!";
	}
}
