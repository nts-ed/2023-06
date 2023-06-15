package com.example.demo;

public class EmployeeDto {
    private String inTime;
    private String outTime;
    private String employeeId;
    private String department;

    public EmployeeDto(String inTime, String outTime, String employeeId, String department) {
        this.inTime = inTime;
        this.outTime = outTime;
        this.employeeId = employeeId;
        this.department = department;
    }

    public String getInTime() {
        return inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }
}
