package com.sym.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttendanceAL implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

@TableId(type = IdType.AUTO)
	private Integer employeesId;
	private String attendanceYm;
	private String employeesName;
	private String deptName;
	private Integer workingHoursMonth;
	private Integer restHoursMonth;
	private Integer overtimeHoursMonth;
	private Integer absenceHoursMonth;
	private Integer applyId;
}
