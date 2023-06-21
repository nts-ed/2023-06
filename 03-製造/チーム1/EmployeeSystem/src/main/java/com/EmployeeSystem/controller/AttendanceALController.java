package com.EmployeeSystem.controller;


import com.EmployeeSystem.entity.AttendanceAL;
import com.EmployeeSystem.service.AttendanceALService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttendanceALController {

	@Autowired
	private AttendanceALService attendanceALService;

	@GetMapping("/attendanceAL")
	public List<AttendanceAL> attendanceALList(@RequestParam(defaultValue = "") Integer employeesId,
	                                            @RequestParam(defaultValue = "") Integer deptId,
	                                            @RequestParam(defaultValue = "") String employeesName,
	                                            @RequestParam(defaultValue = "") Integer applyId,
	                                            @RequestParam(defaultValue = "") String start,
	                                            @RequestParam(defaultValue = "") String end
	) {


		return attendanceALService.attendanceALList(
				employeesId,deptId,employeesName,applyId,start,end);
	}

}
