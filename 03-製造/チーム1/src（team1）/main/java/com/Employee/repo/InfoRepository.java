package com.Employee.repo;



import com.Employee.Servie.Info;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends CrudRepository<Info,Integer> {
	
	@Query(value = "SELECT MAX(employees_Id) FROM t_employees",nativeQuery = true)
	Integer getEmployeesId();

}

