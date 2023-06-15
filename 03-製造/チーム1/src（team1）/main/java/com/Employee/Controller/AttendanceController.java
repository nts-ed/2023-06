package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.dto.AttendanceDTO;
import com.example.demo.service.AttendanceService;

import java.util.List;

    @Controller
	@RequestMapping("/api/attendance")
	public class AttendanceController {

	    @Autowired
	    private AttendanceService attendanceService;

	    @GetMapping
	    public String getAttendanceDataForDate(@RequestParam("date") String date, Model model) {
	        List<AttendanceDTO> attendanceData = attendanceService.getAttendanceDataForDate(date);
	        for (AttendanceDTO attendance : attendanceData) {
	            System.out.println(attendance.toString());
	        }
	    model.addAttribute("attendanceData",attendanceData);
       return "aa/text";	   
       }
	
}
	    