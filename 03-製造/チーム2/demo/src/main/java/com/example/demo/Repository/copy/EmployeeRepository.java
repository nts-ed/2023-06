package com.example.demo.Repository.copy;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.DTO.copy.Employee;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository <Employee, String> {
	@Query(value = "select * from group2.T_EMPLOYEE where EMPLOYEE_ID= :employeeID ", nativeQuery = true)
  Employee findByEmployee(String employeeID);
}
