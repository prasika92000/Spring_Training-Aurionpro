package com.aurionpro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.InstructorTechDetail;
import com.aurionpro.service.InstructorService;

@RestController
@RequestMapping("/app")
public class InstructorTechDetailController {

	private InstructorService service;
	
	public InstructorTechDetailController(InstructorService service)
	{
		super();
		this.service = service;
	}
	
	

	@GetMapping("/detail")
	public ResponseEntity<List<InstructorTechDetail>> getAllStudents()
	{	
		List<InstructorTechDetail> detailsAll=service.findAll();
		return new ResponseEntity<>(detailsAll,HttpStatus.OK) ;
	}

	
	@PostMapping("/detail")
	public ResponseEntity<InstructorTechDetail> addNewStudent(@RequestBody  InstructorTechDetail instructorDetails){
		InstructorTechDetail newInstructor=service.save(instructorDetails);
		return  new ResponseEntity<>(newInstructor,HttpStatus.CREATED);
	}
	
	@PutMapping("/detail")
	public ResponseEntity<InstructorTechDetail> UpdateStudent(@RequestBody  InstructorTechDetail instructorDetails) {
		InstructorTechDetail updateInstructor=service.save(instructorDetails);
		return new ResponseEntity<>(updateInstructor,HttpStatus.OK);
	}
	
	@DeleteMapping	("/detail/{instructorDetailsId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int instructorDetailsId) {
		service.deleteInstructorById(instructorDetailsId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
