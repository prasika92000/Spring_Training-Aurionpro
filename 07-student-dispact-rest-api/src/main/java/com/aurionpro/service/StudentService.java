package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Student;

public interface StudentService {
	List<Student> findAll();

	Student findById(int studentId);

	Student save(Student student);

	void deleteById(int studentId);
     
}
