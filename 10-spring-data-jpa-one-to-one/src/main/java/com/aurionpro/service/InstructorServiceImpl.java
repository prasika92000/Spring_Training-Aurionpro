package com.aurionpro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aurionpro.entity.Instructor;
import com.aurionpro.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {
	private InstructorRepository repository;

	public InstructorServiceImpl(InstructorRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Instructor> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Instructor> findInstructorById(int instructorId) {
		return repository.findById(instructorId);	}

	@Override
	public Instructor save(Instructor instructor) {
		return repository.save(instructor);
	}

	@Override
	public void deleteInstructorById(int instructorId) {
		if(repository.existsById(instructorId)) 
		{
			repository.deleteById(instructorId);			
		}
	}
}
