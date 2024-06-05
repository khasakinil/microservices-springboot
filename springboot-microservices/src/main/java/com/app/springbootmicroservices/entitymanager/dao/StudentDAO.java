package com.app.springbootmicroservices.entitymanager.dao;

import java.util.List;

import com.app.springbootmicroservices.entitymanager.entity.Student;

public interface StudentDAO {

	void save(Student student);

	Student findById(int id);

	List<Student> findAll();

	List<Student> findAllByLastName(String lastName);

	void update(Student student);

	void delete(Integer studentId);
	
	int deleteAll();

}
