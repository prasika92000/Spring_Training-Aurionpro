package com.aurionpro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aurionpro.entity.Student;
import com.aurionpro.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
  
	private StudentRepository repository;
  
	public StudentServiceImpl(StudentRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Student> findAll() {
		return repository.findAll();
	}

	@Override
	public Student findById(int studentId) {
	
		return repository.findById(studentId);
	}

	@Override
	public Student save(Student student) {
		return repository.save(student);
	}

	@Override
	public void deleteById(int studentId) {
		repository.deleteById(studentId);
	}

}
