package com.EmployeeSystem.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.EmployeeSystem.entity.AttendanceAL;
import com.EmployeeSystem.repo.AttendanceALMapper;
import com.EmployeeSystem.service.AttendanceALService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceALServiceImpl extends ServiceImpl<AttendanceALMapper, AttendanceAL> implements AttendanceALService {

	@Autowired
	private AttendanceALMapper attendanceALMapper;

	@Override
	public List<AttendanceAL> attendanceALList(Integer employeesId, Integer deptId, String employeesName, Integer applyId, String start, String end) {
		return attendanceALMapper.attendanceALList(employeesId, deptId, employeesName, applyId, start, end);
	}
}
