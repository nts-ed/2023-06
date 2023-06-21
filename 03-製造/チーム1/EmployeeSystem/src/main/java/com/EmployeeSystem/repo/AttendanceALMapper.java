package com.EmployeeSystem.repo;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.EmployeeSystem.entity.AttendanceAL;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttendanceALMapper extends BaseMapper<AttendanceAL> {

	List<AttendanceAL> attendanceALList(Integer employeesId, Integer deptId, String employeesName, Integer applyId, String start, String end);
}
