package com.Employee.service;


import com.sym.entity.AttendanceAL;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AttendanceALService {
	List<AttendanceAL> attendanceALList(Integer employeeId, Integer deptId, String employeeName, Integer applyId, String start, String end);
}

