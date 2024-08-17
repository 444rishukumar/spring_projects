package com.employee.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
		try {
			System.out.println("started");
			EmployeeDto dto = employeeService.createEmployee(employeeDto);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getEmail())
					.toUri();
			return ResponseEntity.created(location).body(dto);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"An error occured while creating the employee");
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,
			@Valid @RequestBody EmployeeDto employeeDto) {

		System.out.println("started");
		EmployeeDto dto = employeeService.updateEmployee(id, employeeDto);

		return ResponseEntity.ok(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {

		System.out.println("started");
		employeeService.deleteEmployee(id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {

		System.out.println("started");

		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}

	@GetMapping()
	public ResponseEntity<List<EmployeeDto>> getAllEmployee() {

		System.out.println("started");

		return ResponseEntity.ok(employeeService.getAllEmployee());
	}

}
