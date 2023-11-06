package com.aurionpro.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aurionpro.entity.Student;
import jakarta.persistence.Query;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
	
	private EntityManager manager;

	
	public StudentRepositoryImpl(EntityManager manager) {
		super();
		this.manager = manager;
	}


	@Override
	public List<Student> findAll() {
//		TypedQuery<Student> query = manager.createQuery("from Student", Student.class);
		Query query = manager.createNativeQuery("select * from student");
		return query.getResultList();
	}


	@Override
	public Student findById(int studentId) {
//		return manager.find(Student.class, studentId);
		Query query = manager.createNativeQuery("findStudent");
        query.setParameter(1, studentId);
        return(Student) query.getSingleResult();
	}


	@Override
	public Student save(Student student) {
		return manager.merge(student);
	}

	@Transactional
	@Override
	public void deleteById(int studentId) {
	Student student = manager.find(Student.class,studentId);
	if(student!=null) {
		manager.remove(student);
		System.out.println("Student deleted Successfully!");
	}else {
		System.out.println("Could not find student ith id" +studentId);
	}
		
	}

}
