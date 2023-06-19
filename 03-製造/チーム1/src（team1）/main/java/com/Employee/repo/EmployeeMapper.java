package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;

@Component
@Mapper
public interface EmployeeMapper {

	
	@Select("select * from t_attendance_ym")
	List<Employee> list();
	
}

