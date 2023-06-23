package com.EmployeeSystem.controller;


import com.EmployeeSystem.entity.AttendanceAL;
import com.EmployeeSystem.service.AttendanceALService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class AttendanceALController {

	@Autowired private AttendanceALService attendanceALService;


	@GetMapping("/attendanceAL")
	public String attendanceALList(
			@RequestParam(value = "employeesId", required = false, defaultValue = "") Integer employeesId,
			@RequestParam(value = "deptId", required = false, defaultValue = "") Integer deptId,
			@RequestParam(value = "employeesName", required = false, defaultValue = "") String employeesName,
			@RequestParam(value = "applyId", required = false, defaultValue = "") Integer applyId,
			@RequestParam(value = "start", required = false, defaultValue = "") String start,
			@RequestParam(value = "end", required = false, defaultValue = "") String end,
			Model model) {

		List<AttendanceAL> attendanceALList =
				attendanceALService.attendanceALList(
						employeesId, deptId, employeesName, applyId, start, end);
		model.addAttribute("attendanceALList", attendanceALList);

		return "employeeUpdate/attendanceAL";
	}
}
