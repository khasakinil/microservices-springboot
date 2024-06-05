package com.app.springbootmicroservices.entitymanager.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.springbootmicroservices.entitymanager.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImplementation implements StudentDAO {

	private EntityManager entityManager;

	@Autowired
	public StudentDAOImplementation(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student findById(int id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = entityManager.createQuery(" FROM Student ORDER BY lastName", Student.class);
		return query.getResultList();
	}

	@Override
	public List<Student> findAllByLastName(String lastName) {
		TypedQuery<Student> query = entityManager.createQuery(" FROM Student WHERE lastName=:lastName", Student.class);
		query.setParameter("lastName", lastName);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
	}

	@Override
	@Transactional
	public void delete(Integer studentId) {
		Student student = entityManager.find(Student.class, studentId);
		entityManager.remove(student);
	}

	@Override
	@Transactional
	public int deleteAll() {
		return entityManager.createQuery("DELETE FROM Student").executeUpdate();
	}

}
