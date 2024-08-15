package com.employee.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class EmployeeDto {

	private Long id;

	@NotNull(message = "First Name cannot be null")
	private String firstName;

	@NotNull(message = "Last Name cannot be null")
	private String lastName;

	@Email
	@NotNull(message = "Email Id cannot be null")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
