package com.aurionpro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Employee;
import com.aurionpro.entity.EmployeePageDto;
import com.aurionpro.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public Employee save(Employee employee) {
		System.out.println(employee);
		if (employee.getId() != 0) {
			if (!repository.existsById(employee.getId())) {
				return null;
			}
		}
		return repository.save(employee);
	}

	@Override
	public Optional<Employee> findById(int id) {
		Optional<Employee> optionalEmployee = repository.findById(id);
		return optionalEmployee;
	}

	@Override
	public boolean deleteById(int id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public EmployeePageDto findAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Employee> page = repository.findAll(pageable);
		
		List<Employee> employees = page.getContent();
		
		EmployeePageDto employeeDto = new EmployeePageDto();
		
		employeeDto.setContent(employees);
		employeeDto.setFirst(page.isFirst());
		employeeDto.setLast(page.isLast());
		employeeDto.setHasNext(page.hasNext());
		employeeDto.setHasPrevious(page.hasPrevious());
		employeeDto.setNumberOfElements(page.getNumberOfElements());
		employeeDto.setPageNumber(page.getNumber());
		employeeDto.setTotalElements(page.getTotalElements());
		employeeDto.setTotalPages(page.getTotalPages());
		
		return employeeDto;
	}

	@Override
	public EmployeePageDto findAll(int pageNo, int pageSize, String sortField, String sortDirection) {
	    Sort.Direction direction = Sort.Direction.ASC;

	    if ("desc".equalsIgnoreCase(sortDirection)) {
	        direction = Sort.Direction.DESC;
	    }

	    Sort sort = Sort.by(direction, sortField);
	    Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
	    Page<Employee> page = repository.findAll(pageable);

	    List<Employee> employees = page.getContent();

	    EmployeePageDto employeeDto = new EmployeePageDto();

	    employeeDto.setContent(employees);
	    employeeDto.setFirst(page.isFirst());
	    employeeDto.setLast(page.isLast());
	    employeeDto.setHasNext(page.hasNext());
	    employeeDto.setHasPrevious(page.hasPrevious());
	    employeeDto.setNumberOfElements(page.getNumberOfElements());
	    employeeDto.setPageNumber(page.getNumber());
	    employeeDto.setTotalElements(page.getTotalElements());
	    employeeDto.setTotalPages(page.getTotalPages());

	    return employeeDto;
	}
//
//	@Override
//	public List<Employee> findByEmail(String email) {
//		return repository.findByEmail(email);
//	}

	@Override
	public List<Employee> findByFirstName(String firstName) {
		return repository.findByFirstName(firstName);
	}

	@Override
	public List<Employee> findByEmail(String email) {
		 return repository.findByEmail(email);
	}

}
