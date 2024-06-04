package com.app.springbootmicroservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMicroservicesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			System.out.println("Executed after the Spring Beans have been loaded..");
		};
	}
}
