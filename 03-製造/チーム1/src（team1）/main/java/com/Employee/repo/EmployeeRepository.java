package com.nts._ed.ks.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nts._ed.ks.controller.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}