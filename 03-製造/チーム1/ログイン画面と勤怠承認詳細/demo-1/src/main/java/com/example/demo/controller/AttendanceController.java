package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AttendanceDTO;
import com.example.demo.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

	    @Autowired
	    private AttendanceService attendanceService;

	    @GetMapping
	    public List<AttendanceDTO> getAttendanceData() {
	        // 在此处调用AttendanceService中的方法，从数据库中查询2023年6月的出勤数据
	        List<AttendanceDTO> attendanceData = attendanceService.getAttendanceDataForJune2023();
	        return attendanceData;
	    }
	}

