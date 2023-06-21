package com.EmployeeSystem.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Data
@Table(name = "t_employees")
public class Info implements Serializable{
	
	private static final long serialVersionUID = 1L;


	

	@Id
	@Column(name="EMPLOYEES_ID")
	private int employees_Id;
	
	@Column(name="EMPLOYEES_NAME")
	private String name;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="GENDER")
	private int gender;
	
	@Column(name="PHONE_NUMBER")
	private String phone_Number;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ENTRY_DATE")
	private Date entry_Date;
	
	@Column(name="POSITION_FLG")
	private int position_Flg;
	
	@Column(name="DEPT_ID")
	private int dept_Id;
	
	@Column(name="DEL_FLG")
	private int del_Flg;
	
	@Column(name="CREATE_DATE")
	private Date create_Date;
	
	@Column(name="CREATE_USERID")
	private int create_UserId;
	
	@Column(name="UPDATE_DATE")
	private Date update_Date;
	
	@Column(name="UPDATE_USERID")
	private int update_userId;
	
	
	

	public Info() {
		
	}

	public Info(int employees_Id, String password, String name, int age, int gender, String phone_Number, String email,
			Date entry_Date, int position_Flg, int dept_Id, int del_Flg, Date create_Date, int create_UserId,
			Date update_Date, int update_userId) {
		this.employees_Id = employees_Id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone_Number = phone_Number;
		this.email = email;
		this.entry_Date = entry_Date;
		this.position_Flg = position_Flg;
		this.dept_Id = dept_Id;
		this.del_Flg = del_Flg;
		this.create_Date = create_Date;
		this.create_UserId = create_UserId;
		this.update_Date = update_Date;
		this.update_userId = update_userId;
	}


}
