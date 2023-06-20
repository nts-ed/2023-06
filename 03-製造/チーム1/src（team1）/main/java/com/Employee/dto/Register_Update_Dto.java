package Employees.dto;

import java.util.Date;

public class Register_Update_Dto {
	int employees_id;
	Date attendance_date;
	String start_time;
	String end_time;
	double rest_hours_day;
	double over_hours_day;
	int status_id;
	String work_content;
	
	public Register_Update_Dto() { super();}
	public Register_Update_Dto(int employees_id,Date attendance_date, String start_time, 
			String end_time, double rest_hours_day, double over_hours_day,int status_id) 
	{
		super();
		this.employees_id = employees_id;
		this.attendance_date = attendance_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.rest_hours_day = rest_hours_day;
		this.over_hours_day = over_hours_day;
		this.status_id = status_id;
	}
	
	
	public int getEmployees_id() { return employees_id; }
	public void setEmployees_id(int employees_id) { this.employees_id = employees_id; }
	
	public Date getAttendanceDate() { return attendance_date; }
	public void setAttendanceDate(Date attendance_date) { this.attendance_date = attendance_date; }
	
	public String getStartTime() { return start_time; }
	public void setStartTime(String start_time) { this.start_time = start_time; }
	
	public String getEndtime() { return end_time; }
	public void setEndtime(String end_time) { this.end_time = end_time; }
	
	public double getRestHoursDay() { return rest_hours_day; }
	public void setRestHoursDay(double rest_hours_day) { this.rest_hours_day = rest_hours_day; }
	
	public double getOverHoursDay() { return over_hours_day; }
	public void setOverHoursDay(double over_hours_day) { this.over_hours_day = over_hours_day; }
	
	public int getStatusId() { return status_id; }
	public void setStatusId(int status_id) { this.status_id = status_id; }
	
	public String getWorkContent() { return work_content; }
	public void setWorkContent(String work_content) { this.work_content = work_content; }
}
