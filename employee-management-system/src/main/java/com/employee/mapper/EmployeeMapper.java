package com.employee.mapper;

import org.mapstruct.Mapper;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;

@Mapper
public interface EmployeeMapper {

	EmployeeDto toDto(Employee employee);

	Employee toEmployee(EmployeeDto employeeDto);

}
