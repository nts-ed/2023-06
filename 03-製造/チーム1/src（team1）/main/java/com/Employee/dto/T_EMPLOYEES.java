package com.nts._ed.ks.dto;

	import org.springframework.stereotype.Component;

import com.nts._ed.ks.controller.Employee;

	@Component
	public class T_EMPLOYEES {

	    public <EmployeeDTO> EmployeeDTO toDto(Employee employee) {
	        EmployeeDTO dto = new EmployeeDTO();
	        dto.setFirstName(employee.getFirstName());
	        dto.setLastName(employee.getLastName());
	        dto.setPosition(employee.getPosition());
	        return dto;
	    }

	    public Employee toEntity(EmployeeDTO dto) {
	        Employee employee = new Employee();
	        employee.setFirstName(dto.getFirstName());
	        employee.setLastName(dto.getLastName());
	        employee.setPosition(dto.getPosition());
	        return employee;
	    }

	}