package com.example.demo.DTO.copy;

//import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "group2.T_EMPLOYEE")
public class Employee_Summary {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private int employeesId;

//    @Column(name = "ENTRY_DATE")
//    private Date entryDate;

    @Column(name = "EMPLOYEE_NAME")
    private String employeesName;
//
//    @Column(name = "GENDER")
//    private String gender;
//
//    @Column(name = "AGE")
//    private int age;
//
//    @Column(name = "DEPT_NAME")
//    private String deptName;
//
//    @Column(name = "MAIL_ADD")
//    private String mailAdd;

//     Getters and Setters
}

