package com.aurionpro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aurionpro.entity.InstructorTechDetail;
import com.aurionpro.repository.InstructorTechDetailRepository;

@Service
public class InstructorTechDetailServiceImpl implements InstructorTechDetailService {

	private InstructorTechDetailRepository repository;
	
	public InstructorTechDetailServiceImpl(InstructorTechDetailRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public List<InstructorTechDetail> findAll() {
		return repository.findAll();
	}

	@Override
	public InstructorTechDetail save(InstructorTechDetail instructorDetails) {
		return repository.save(instructorDetails);

	}

	@Override
	public void deleteInstructorDetailsById(int instructorDetailsId) {
		if(repository.existsById(instructorDetailsId)) 
		{
			repository.deleteById(instructorDetailsId);			
		}		
	}


}
