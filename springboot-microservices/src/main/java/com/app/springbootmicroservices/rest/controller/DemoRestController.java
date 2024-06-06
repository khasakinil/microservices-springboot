package com.app.springbootmicroservices.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class DemoRestController {

	@GetMapping("/hello")
	public String helloWorld() {
		System.out.println("invoking /hello endpoint");
		return "Hello World";
	}
}
