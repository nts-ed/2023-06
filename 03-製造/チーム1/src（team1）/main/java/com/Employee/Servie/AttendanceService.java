package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AttendanceDTO;
import com.example.demo.mapper.AttendanceMapper;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;

    public List<AttendanceDTO> getAttendanceDataForDate(String date) {
        return attendanceMapper.getAttendanceDataForDate(date);
    }
}