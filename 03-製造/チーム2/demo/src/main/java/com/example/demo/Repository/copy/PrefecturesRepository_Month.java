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
	@Query(value = "select substr(CALENDAR_DATE, 5,2) AS CALENDAR_DATE, BUSINESS_DAY,START_DAY,ABSENCE_DAY,ACTUAL_WORKING_HOURS,OVERTIME_HOURS,COMMENT"
			+ " from dev8.month_Work_information where  CALENDAR_DATE  like :year% ORDER BY CALENDAR_DATE ASC;", nativeQuery = true)
	List<Prefectures_Month> findAllByYear(@Param("year") String year);

}