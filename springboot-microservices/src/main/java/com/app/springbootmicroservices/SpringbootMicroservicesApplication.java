package com.app.springbootmicroservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.springbootmicroservices.entitymanager.dao.StudentDAO;
import com.app.springbootmicroservices.entitymanager.entity.Student;

@SpringBootApplication
public class SpringbootMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMicroservicesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating Student Object");
		Student stud = new Student("Amit", "Sawalagi", "amitsawalagi@gmail.com");
		studentDAO.save(stud);
		System.out.println(stud.getId());
	}
}
