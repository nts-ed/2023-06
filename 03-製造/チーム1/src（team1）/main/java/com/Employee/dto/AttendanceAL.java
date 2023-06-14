package com.Employee.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttendanceAL {
	private Integer employeeId;
	private String attendanceYm;
	private String employeeName;
	private Integer deptId;
	private Integer workHoursMonth;
	private Integer restHoursMonth;
	private Integer overtimeHoursMonth;
	private Integer absenceHoursMonth;
	private Integer applyId;
}
