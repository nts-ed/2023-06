package com.Employee.mapper;



import com.sym.entity.AttendanceAL;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttendanceALMapper {
	public List<AttendanceAL> attendanceALList(Integer employeeId, Integer deptId, String employeeName, Integer applyId, String start, String end);
}





