package com.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.mapper.EmployeeMapper;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeMapper employeeMapper;

	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		Employee employee = employeeMapper.toEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);

		return employeeMapper.toDto(savedEmployee);

	}

}
