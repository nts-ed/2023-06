package com.Employee;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.nts._ed.ks.controller.Employee;
import com.nts._ed.ks.repository.EmployeeRepository;

public class EmployeeUpdateApplication {

		public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
		    Employee existingEmployee = employeeRepository.findById(id).orElse(null);

		    if (existingEmployee != null) {
		        existingEmployee.setFirstName(updatedEmployee.getFirstName());
		        existingEmployee.setLastName(updatedEmployee.getLastName());
		        existingEmployee.setPosition(updatedEmployee.getPosition());

		        return EmployeeRepository.save(existingEmployee);
		    }

		    return null;
		}
	}
