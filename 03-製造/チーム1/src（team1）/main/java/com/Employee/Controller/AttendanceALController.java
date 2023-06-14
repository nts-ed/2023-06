package com.Employee.controller;

import com.sym.entity.AttendanceAL;
import com.sym.service.AttendanceALService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttendanceALController {

	@Autowired
	private AttendanceALService attendanceALService;

	@PostMapping("/attendanceAL")
	public List<AttendanceAL> attendanceALList(@RequestBody Integer employeeId, Integer deptId,
	                                           String employeeName, Integer applyId, String start,
	                                           String end) {
		return attendanceALService.attendanceALList(employeeId, deptId, employeeName, applyId, start, end);

	}

}
