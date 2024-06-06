package com.app.springbootmicroservices.entitymanager.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.springbootmicroservices.entitymanager.entity.StudentEntity;

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
	public void save(StudentEntity student) {
		entityManager.persist(student);
	}

	@Override
	public StudentEntity findById(int id) {
		return entityManager.find(StudentEntity.class, id);
	}

	@Override
	public List<StudentEntity> findAll() {
		TypedQuery<StudentEntity> query = entityManager.createQuery(" FROM Student ORDER BY lastName", StudentEntity.class);
		return query.getResultList();
	}

	@Override
	public List<StudentEntity> findAllByLastName(String lastName) {
		TypedQuery<StudentEntity> query = entityManager.createQuery(" FROM Student WHERE lastName=:lastName", StudentEntity.class);
		query.setParameter("lastName", lastName);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(StudentEntity student) {
		entityManager.merge(student);
	}

	@Override
	@Transactional
	public void delete(Integer studentId) {
		StudentEntity student = entityManager.find(StudentEntity.class, studentId);
		entityManager.remove(student);
	}

	@Override
	@Transactional
	public int deleteAll() {
		return entityManager.createQuery("DELETE FROM Student").executeUpdate();
	}

}
