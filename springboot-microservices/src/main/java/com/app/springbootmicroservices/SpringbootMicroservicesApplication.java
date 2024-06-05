package com.app.springbootmicroservices;

import java.util.List;

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
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);
//			readStudents(studentDAO);
//			readStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllRows(studentDAO);
		};
	}

	private void deleteAllRows(StudentDAO studentDAO) {
		System.out.println("Deleting all the rows from Student Table");
		System.out.println("Number Of Deleted : " + studentDAO.deleteAll());
		System.out.println("All rows deleted");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("Deleting student : ");
		studentDAO.delete(3003);
		System.out.println("Deleted student : ");
	}

	private void updateStudent(StudentDAO studentDAO) {
		System.out.println("getting student by id :");
		Student studById = studentDAO.findById(3002);
		System.out.println("findById : " + studById);
		System.out.println("Updating student : ");
		studById.setFirstName("Basha");
		studentDAO.update(studById);
		System.out.println("studById : " + studById);
	}

	private void readStudentsByLastName(StudentDAO studentDAO) {
		System.out.println("Reading all students from Database Table by lastName: ");
		List<Student> allStudents = studentDAO.findAllByLastName("Tarange");
		for (Student std : allStudents) {
			System.out.println(std);
		}
	}

	private void readStudents(StudentDAO studentDAO) {
		System.out.println("Reading all students from Database Table: ");
		List<Student> allStudents = studentDAO.findAll();
		for (Student std : allStudents) {
			System.out.println(std);
		}
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		Student stud1 = new Student("Amit", "Sawalagi", "amitsawalagi@gmail.com");
		Student stud2 = new Student("Raj", "Sawalagi", "rajsawalagi@gmail.com");
		Student stud3 = new Student("Suraj", "Tarange", "surajtarange@gmail.com");
		Student stud4 = new Student("Ramesh", "Thite", "rameshthite@gmail.com");
		Student stud5 = new Student("Manoj", "panke", "manojpanke@gmail.com");
		Student stud6 = new Student("Satish", "Sherikar", "satishsherikar@gmail.com");
		studentDAO.save(stud1);
		studentDAO.save(stud2);
		studentDAO.save(stud3);
		studentDAO.save(stud4);
		studentDAO.save(stud5);
		studentDAO.save(stud6);

		readStudent(studentDAO);
	}

	private void readStudent(StudentDAO studentDAO) {
		Student stud = new Student("Mahadeo", "Waghadari", "mahadeowaghadari@gmail.com");
		studentDAO.save(stud);

		int studId = stud.getId();

		Student findById = studentDAO.findById(studId);
		System.out.println("findById : " + findById);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating Student Object");
		Student stud = new Student("Amit", "Sawalagi", "amitsawalagi@gmail.com");
		studentDAO.save(stud);
		System.out.println(stud.getId());
	}
}
