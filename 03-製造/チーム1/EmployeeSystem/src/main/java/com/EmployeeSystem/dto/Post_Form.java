package com.EmployeeSystem.dto;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Post_Form {
	private int employees_id;
	Timestamp attendance_date;
	String start_time;
	String end_time;
	double rest_hours_day;
	double over_hours_day;
	
	private String statusForm;
	
	@NotNull(message = "日付を入力してください。")
	private Date dateForm;
	
	@Size(min = 1, max = 250, message = "250文字以内で入力してください。")
	private String contentForm;

	public Timestamp getAttendance_date() { return attendance_date; }

	public void setAttendance_date(Timestamp attendance_date) { this.attendance_date = attendance_date; }

	public String getStart_time() { return start_time; }

	public void setStart_time(String start_time) { this.start_time = start_time; }

	public String getEnd_time() { return end_time; }

	public void setEnd_time(String end_time) { this.end_time = end_time; }

	public double getRest_hours_day() { return rest_hours_day; }

	public void setRest_hours_day(double rest_hours_day) { this.rest_hours_day = rest_hours_day; }

	public double getOver_hours_day() { return over_hours_day; }

	public void setOver_hours_day(double over_hours_day) { this.over_hours_day = over_hours_day; }

	public int getEmployees_id() { return employees_id; }

	public void setEmployees_id(int employees_id) { this.employees_id = employees_id; }

	public String getStatusForm() { return statusForm; }

	public void setStatusForm(String statusForm) { this.statusForm = statusForm; }

	public Date getDateForm() { return dateForm; }

	public void setDateForm(Date dateForm) { this.dateForm = dateForm; }

	public String getContentForm() { return contentForm; }

	public void setContentForm(String contentForm) { this.contentForm = contentForm; }
}
