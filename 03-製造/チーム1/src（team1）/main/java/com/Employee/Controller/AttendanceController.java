package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AttendanceDTO;
import com.example.demo.service.AttendanceService;

import java.util.List;

	@RestController
	@RequestMapping("/api/attendance")
	public class AttendanceController {

	    @Autowired
	    private AttendanceService attendanceService;

	    @GetMapping
	    public AttendanceDTO[] getAttendanceDataForDate(@RequestParam("date") String date) {
	        List<AttendanceDTO> attendanceData = attendanceService.getAttendanceDataForDate(date);
	        AttendanceDTO[] attendanceArray = new AttendanceDTO[attendanceData.size()];
	        attendanceData.toArray(attendanceArray);
	        for (AttendanceDTO attendance : attendanceData) {
	            System.out.println(attendance.toString());
	        }
	        return attendanceArray;
	    }
	
	}