package com.EmployeeSystem.repo;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;


import com.EmployeeSystem.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}