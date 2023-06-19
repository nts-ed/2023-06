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

    public List<AttendanceDTO> getAttendanceDataForIdAndDate(Integer id, String date) {
        return attendanceMapper.getAttendanceDataForIdAndDate(id, date);
    }

    public void updateAttendanceStatus(Integer id, String date, String action) {
        // 调用相应的更新方法来更新申请状态
        attendanceMapper.updateAttendanceStatus(id, date, action);
    }
}






