package com.EmployeeSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Employee {
	

	@Id
    private int employeeId;
    private int workHours;
    private int overtimeHours;


    public Employee(int employeeId, int workHours, int overtimeHours) {
        this.employeeId = employeeId;
        this.workHours = workHours;
        this.overtimeHours = overtimeHours;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getWorkHours() {
        return workHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }
}
