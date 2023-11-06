package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Student;
import com.aurionpro.exception.StudentNotFoundException;

public interface StudentService {
	List<Student> findAll();

	Student findById(int studentId) throws StudentNotFoundException;

	Student save(Student student);

	void deleteById(int studentId);
     
}
