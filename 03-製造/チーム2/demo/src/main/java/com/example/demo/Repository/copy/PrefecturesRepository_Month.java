package com.example.demo.Repository.copy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.DTO.copy.Prefectures_Month;

import java.util.Iterator;
import java.util.List;
@Repository
public interface  PrefecturesRepository_Month extends JpaRepository<Prefectures_Month, Long>{
	@Query(value = "select substr( A.CALENDAR_DATE, 5,2) AS CALENDAR_DATE,B.BUSINESS_DAY,B.START_DAY,B.ABSENCE_DAY,B.ACTUAL_WORKING_HOURS,C.OVERTIME_HOURS,B.COMMENT"
			+ " from group2.M_CALENDAR AS A LEFT JOIN group2.M_ATTENDANCE_YM AS B on A.ATTENDANCE_DATE = B.ATTENDANCE_DATE LEFT JOIN group2.T_ATTENDANCE AS C "
			+" on A.ATTENDANCE_DATE =C.ATTENDANCE_DATE where  A.CALENDAR_DATE  like :year% ORDER BY A.CALENDAR_DATE ASC;", nativeQuery = true)
	List<Prefectures_Month> findAllByYear(@Param("year") String year);

}


//public interface  PrefecturesRepository_Month extends JpaRepository<Prefectures_Month, Long>{
//	@Query(value = "select substr(CALENDAR_DATE, 5,2) AS CALENDAR_DATE, BUSINESS_DAY,START_DAY,ABSENCE_DAY,ACTUAL_WORKING_HOURS,OVERTIME_HOURS,COMMENT"
//			+ " from dev8.month_Work_information where  CALENDAR_DATE  like :year% ORDER BY CALENDAR_DATE ASC;", nativeQuery = true)
//	List<Prefectures_Month> findAllByYear(@Param("year") String year);
//
//}