package com.EmployeeSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empl/Info")
public class EmployeeSystemListController {
	
	@GetMapping
	public String displayList() {
		
		return "employeeUpdate/employeeInfoList";
	}
	

}
