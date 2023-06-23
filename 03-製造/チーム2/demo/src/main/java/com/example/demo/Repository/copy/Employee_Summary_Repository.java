package com.example.demo.Repository.copy;

import com.example.demo.DTO.copy.Employee;
import com.example.demo.DTO.copy.Employee_Summary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee_Summary_Repository extends JpaRepository<Employee_Summary, String> {
	@Query(value = "select * from group2.T_EMPLOYEE ", nativeQuery = true)
	List<Employee_Summary>  findByEmployee();
}