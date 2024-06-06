package com.app.springbootmicroservices.entitymanager.dao;

import java.util.List;

import com.app.springbootmicroservices.entitymanager.entity.StudentEntity;

public interface StudentDAO {

	void save(StudentEntity student);

	StudentEntity findById(int id);

	List<StudentEntity> findAll();

	List<StudentEntity> findAllByLastName(String lastName);

	void update(StudentEntity student);

	void delete(Integer studentId);
	
	int deleteAll();

}
