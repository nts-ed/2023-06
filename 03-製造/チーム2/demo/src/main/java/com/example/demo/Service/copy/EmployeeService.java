package com.example.demo.Service.copy;

import com.example.demo.DTO.copy.Employee_Summary;
import com.example.demo.Repository.copy.Employee_Summary_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
	
	@Autowired
    private  Employee_Summary_Repository employeeRepository;

    
    public EmployeeService(Employee_Summary_Repository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee_Summary> listEmployees() {
        return employeeRepository.findByEmployee();
    }

    public Employee_Summary getEmployeeById(String employeesId) {
        return employeeRepository.findById(employeesId).orElse(null);
    }

    public Employee_Summary addEmployee(Employee_Summary employee) {
        return employeeRepository.save(employee);
    }

    public Employee_Summary updateEmployee(Employee_Summary employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(String employeesId) {
        employeeRepository.deleteById(employeesId);
    }
}
