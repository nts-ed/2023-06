package com.EmployeeSystem.repo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.EmployeeSystem.dto.AttendanceDTO;

public interface AttendanceMapper {

    @Select("SELECT T_CALENDAR.CALENDAR_DATE, T_CALENDAR.WEEKDAY, T_ATTENDANCE.START_TIME, T_ATTENDANCE.END_TIME, "
            + "T_ATTENDANCE.REST_HOURS_DAY, T_ATTENDANCE.WORKING_HOURS_DAY, T_ATTENDANCE.OVERTIME_HOURS_DAY, "
            + "T_ATTENDANCE.WORK_CONTENT, T_STATUS.STATUS_NAME, T_ATTENDANCE.UPDATE_USERID, "
            + "CASE WHEN T_STATUS.STATUS_ID = 2 THEN T_ATTENDANCE.PLUS_CONTENT ELSE NULL END AS PLUS_CONTENT "
            + "FROM T_CALENDAR "
            + "LEFT JOIN T_ATTENDANCE ON T_CALENDAR.CALENDAR_DATE = T_ATTENDANCE.ATTENDANCE_DATE "
            + "LEFT JOIN T_STATUS ON T_ATTENDANCE.STATUS_ID = T_STATUS.STATUS_ID "
            + "WHERE T_CALENDAR.CALENDAR_DATE LIKE CONCAT(#{date}, '%') AND T_CALENDAR.DEL_FLG = 0;")
    List<AttendanceDTO> getAttendanceDataForDate(@Param("date") String date);
}