package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.AttendanceDTO;

public interface AttendanceMapper {

    @Select("SELECT T_CALENDAR.CALENDAR_DATE, T_CALENDAR.WEEKDAY, T_ATTENDANCE.START_TIME, T_ATTENDANCE.END_TIME, "
            + "T_ATTENDANCE.REST_HOURS_DAY, T_ATTENDANCE.WORKING_HOURS_DAY, T_ATTENDANCE.OVERTIME_HOURS_DAY, "
            + "T_ATTENDANCE.WORK_CONTENT, T_STATUS.STATUS_NAME, T_ATTENDANCE.UPDATE_USERID, "
            + "T_ATTENDANCE.PLUS_CONTENT " 
            + "FROM T_CALENDAR "
            + "LEFT JOIN T_ATTENDANCE ON T_CALENDAR.CALENDAR_DATE = T_ATTENDANCE.ATTENDANCE_DATE "
            + "LEFT JOIN T_STATUS ON T_ATTENDANCE.STATUS_ID = T_STATUS.STATUS_ID "
            + "WHERE T_CALENDAR.CALENDAR_DATE LIKE CONCAT(#{date}, '%') "
            + "AND (T_ATTENDANCE.EMPLOYEES_ID = #{id} OR T_ATTENDANCE.EMPLOYEES_ID IS NULL) "
            + "AND T_CALENDAR.DEL_FLG = 0;")
    List<AttendanceDTO> getAttendanceDataForIdAndDate(@Param("id") Integer id, @Param("date") String date);
    @Update({
        "<script>",
        "UPDATE t_attendance_ym",
        "SET APPLY_ID =",
        "<choose>",
        "<when test=\"action.equals('approve')\">2</when>",
        "<when test=\"action.equals('reject')\">3</when>",
        "<otherwise>0</otherwise>", // 添加一个默认值，如果都不匹配，默认为0
        "</choose>",
        "WHERE EMPLOYEES_ID = #{id} AND ATTENDANCE_YM = #{date}",
        "</script>"
    })
    void updateAttendanceStatus(@Param("id") Integer id, @Param("date") String date, @Param("action") String action);
}