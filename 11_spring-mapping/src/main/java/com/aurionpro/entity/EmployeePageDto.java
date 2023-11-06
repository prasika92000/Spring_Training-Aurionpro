package com.aurionpro.entity;

import java.util.List;

import com.aurionpro.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class EmployeePageDto {
	private List<Employee> content;
	private int pageNumber;
	private int numberOfElements;
	private long totalElements;
	private int totalPages;
	private boolean hasNext;
	private boolean hasPrevious;
	private boolean isFirst;
	private boolean isLast;
}