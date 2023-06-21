/*package com.EmployeeSystem.controller;

import java.util.List;
import com.EmployeeSystem.dto.T_EMPLOYEES;

@PutMapping("/employees/{id}")
public T_EMPLOYEES updateEmployee(@PathVariable Long id, @RequestBody UpdateParam updateParam) {
    Employee existingEmployee = employeeRepository.findById(id).orElse(null);

    if (existingEmployee != null) {
        existingEmployee.setFirstName(updateParam.getFirstName());
        existingEmployee.setLastName(updateParam.getLastName());
        existingEmployee.setPosition(updateParam.getPosition());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        EmployeeDto responseDto = new EmployeeDto();
        responseDto.setFirstName(updatedEmployee.getFirstName());
        responseDto.setLastName(updatedEmployee.getLastName());
        responseDto.setPosition(updatedEmployee.getPosition());

        return responseDto;
    }

    return null;
    
	}
}*/