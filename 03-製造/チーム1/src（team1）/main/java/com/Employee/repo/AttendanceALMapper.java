package com.sym.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sym.entity.AttendanceAL;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AttendanceALMapper extends BaseMapper<AttendanceAL> {

	List<AttendanceAL> attendanceALList(Integer employeesId, Integer deptId, String employeesName, Integer applyId, String start, String end);
}
