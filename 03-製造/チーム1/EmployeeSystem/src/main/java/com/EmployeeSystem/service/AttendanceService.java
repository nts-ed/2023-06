package com.EmployeeSystem.service;
/*
 * 機能：勤怠承認詳細画面のService
 * 作成者：高菁雨
 */
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeSystem.dto.AttendanceDTO;
import com.EmployeeSystem.repo.AttendanceMapperGao;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceMapperGao attendanceMapper;

    public List<AttendanceDTO> getAttendanceDataForIdAndDate(Integer id, String date) {
        return attendanceMapper.getAttendanceDataForIdAndDate(id, date);
    }

    public void updateAttendanceStatus(Integer id, String date, String action) {
        // 调用相应的更新方法来更新申请状态
        attendanceMapper.updateAttendanceStatus(id, date, action);
    }
}






