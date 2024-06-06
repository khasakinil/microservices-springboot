package com.app.springbootmicroservices.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springbootmicroservices.rest.entity.Student;
import com.app.springbootmicroservices.rest.entity.StudentErrorResponse;
import com.app.springbootmicroservices.rest.entity.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	private List<Student> studentList;

	@PostConstruct
	public void loadStudentData() {
		studentList = new ArrayList<>();
		studentList.add(new Student("Satish", "Sherikar"));
		studentList.add(new Student("Mahadeo", "Waghadari"));
		studentList.add(new Student("Madan", "Magar"));
		studentList.add(new Student("Manoj", "Panke"));
		System.out.println("Loaded Student List Successfully");
	}

	@GetMapping("/fetchall")
	public List<Student> getAllStudents() {
		return studentList;
	}

	@GetMapping("/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		if (studentId >= studentList.size() || studentId < 0) {
			throw new StudentNotFoundException("Student with id : " + studentId + " not found");
		}
		return studentList.get(studentId);
	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleStudentException(StudentNotFoundException exception) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleGenericException(Exception exception) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
