package com.example.demo.DTO.copy;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "dev8.month_Work_information")
@AllArgsConstructor
@NoArgsConstructor
//@NamedQuery(name = "myFindByAge", query = "select * from TEST01.M_DEPT")
public class Prefectures_Month implements Serializable{
	
	/**
     * 譛�
     */
	@Id
    @Column(name = "CALENDAR_DATE")
    private int calendarDate;
	
    /**
     * 蝟ｶ讌ｭ譌･謨ｰ
     */
    @Column(name = "BUSINESS_DAY")
    private int businessDay;
    
    /**
     * 蜃ｺ蜍､譌･謨ｰ
     */
    @Column(name = "START_DAY")
    private int startDay;
    
    /**
     * 谺�蜍､譌･謨ｰ
     */
    @Column(name = "ABSENCE_DAY")
    private int absenceDay;
    
    /**
     * 螳溷ロ譎る俣(H)
     */
    @Column(name = "ACTUAL_WORKING_HOURS")
    private int actualWorkingHours;
    
    /**
     * 谿区･ｭ譎る俣(H)
     */
    @Column(name = "OVERTIME_HOURS")
    private double overtimeHours;
    
    /**
     * 繧ｳ繝｡繝ｳ繝�
     */
    @Column(name = "COMMENT")
    private String comment;
}
