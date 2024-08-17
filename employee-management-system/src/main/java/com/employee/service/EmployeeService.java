package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);

	EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

	void deleteEmployee(Long id);

	EmployeeDto getEmployeeById(Long id);

	List<EmployeeDto> getAllEmployee();

}
