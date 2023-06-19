package com.example.demo.DTO.copy;


import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
//@Entity
@AllArgsConstructor
public class MonthDto implements Serializable{
    private String user_Id;//繝ｦ繝ｼ繧ｶ繝ｼ
    private String name;//豌丞錐
    private String affiliation;//謇�螻�
    
    private int CALENDAR_DATE;//譛�
    private int BUSINESS_DAY;//蝟ｶ讌ｭ譌･謨ｰ
    private int START_DAY;//蜃ｺ蜍､譌･謨ｰ
    private int ABSENCE_DAY;//谺�蜍､譌･謨ｰ
//    @Column(name = "ACTUAL_WORKING_HOURS") 蠕後〒遒ｺ隱阪＠縺ｦ蜑企勁縺吶ｋ縺薙→
    private int actualWorkingHours;//螳溷ロ譎る俣(H)
    private double OVERTIME_HOURS;//谿区･ｭ譎る俣(H)
    private String COMMENT;//繧ｳ繝｡繝ｳ繝�
    
    private String romaji;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
	
    
}