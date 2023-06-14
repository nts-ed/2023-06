package com.Employee.service.impl;


import com.sym.entity.AttendanceAL;
import com.sym.mapper.AttendanceALMapper;
import com.sym.service.AttendanceALService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceALServiceImpl implements AttendanceALService {

	@Autowired
	private AttendanceALMapper attendanceALMapper;

	@Override
	public List<AttendanceAL> attendanceALList(Integer employeeId, Integer deptId, String employeeName, Integer applyId, String start, String end) {
		return attendanceALMapper.attendanceALList(employeeId, deptId, employeeName, applyId, start, end);
	}
}




