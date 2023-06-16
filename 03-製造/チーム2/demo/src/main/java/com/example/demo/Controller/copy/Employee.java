package com.example.demo.Controller.copy;

import java.io.Serializable;

import com.example.demo.trySpring.TEST.copy.Prefectures;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "group2.T_EMPLOYEE")
public class Employee {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private String employeeID;
    private String password;
    private int del_flg;
    private int admin_flg;
    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;
    
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
    
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(int del_flg) {
		this.del_flg = del_flg;
	}
	public int getAdmin_flg() {
		return admin_flg;
	}
	public void setAdmin_flg(int admin_flg) {
		this.admin_flg = admin_flg;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
}