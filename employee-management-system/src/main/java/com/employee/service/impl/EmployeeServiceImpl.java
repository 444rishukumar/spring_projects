package com.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.exception.EmployeeNotFoundException;
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
		System.out.println("employee enity received");
		Employee savedEmployee = employeeRepository.save(employee);
		System.out.println("saving employee in DB");
		return employeeMapper.toDto(savedEmployee);

	}

	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
		Optional<Employee> optEmployee = employeeRepository.findById(id);
		if (optEmployee.isPresent()) {
			Employee employee = optEmployee.get();
			employee.setEmail(employeeDto.getEmail());
			employee.setFirstName(employeeDto.getFirstName());
			employee.setLastName(employeeDto.getLastName());
			employee = employeeRepository.save(employee);

			return employeeMapper.toDto(employee);
		} else {
			throw new EmployeeNotFoundException(id);
		}
	}

	public void deleteEmployee(Long id) {
		employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
		employeeRepository.deleteById(id);
	}

	public EmployeeDto getEmployeeById(Long id) {
		Employee emp = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
		return employeeMapper.toDto(emp);
	}

	public List<EmployeeDto> getAllEmployee() {
		List<Employee> empList = employeeRepository.findAll();
		return employeeMapper.toDtoList(empList);
	}
}
