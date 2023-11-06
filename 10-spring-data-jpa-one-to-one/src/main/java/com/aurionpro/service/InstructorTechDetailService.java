package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.InstructorTechDetail;

public interface InstructorTechDetailService {

	List<InstructorTechDetail> findAll();

	InstructorTechDetail save(InstructorTechDetail instructorDetails);

	void deleteInstructorDetailsById(int instructorDetailsId);
}
