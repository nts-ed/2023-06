package com.EmployeeSystem.repo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.EmployeeSystem.dto.User;

public interface UserMapper {
	 @Select("SELECT * FROM t_employees WHERE EMPLOYEES_ID = #{id} and PASSWORD = #{password}")
	 User getUserByIdAndPassword(@Param("id") Integer id, @Param("password") String password);
	 @Select("SELECT * FROM t_employees WHERE EMPLOYEES_ID = #{id}")
	User getUserById(Integer id);
}
