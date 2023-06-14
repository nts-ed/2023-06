package com.Employee.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Register_Update_dao {
	String Driver_Name = "com.mysql.jdbc.Driver";
	String USER_NAME = "root";
	String PASSWORD = "root";
	String URL = "jdbc:mysql://localhost:8080/chino_test_db";
	
	public boolean doSomething(Register_Update_dto dto)
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		boolean isSuccess = true;
		
		try
		{
			Class.forName(Driver_Name);
		}
		catch(ClassNotFoundException exception)
		{
			exception.printStackTrace();
		}
		
		try
		{
			con = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
			
			con.setAutoCommit(false);
			
			StringBuilder builder = new StringBuilder();
			builder.append(" INSERT INTO T_ATTENDANCE ( ");
			builder.append(" EMPLOYEES_ID, ");
			builder.append(" ATTENDANCE_DATE, ");
			builder.append(" START_TIME, ");
			builder.append(" END_TIME, ");
			builder.append(" REST_HOURS_DAY, ");
			builder.append(" OVER_HOURS_DAY, ");
			builder.append(" STATUS_ID, ");
			builder.append(" WORK_CONTENT ) ");
			builder.append(" VALUES ( ");
			builder.append("  ?, ");
			builder.append("  ?,  ");
			builder.append("  ?, ");
			builder.append("  ?, ");
			builder.append("  ?, ");
			builder.append("  ?, ");
			builder.append("  ?, ");
			builder.append("  ?  ) ");
			
			ps = con.prepareStatement(builder.toString());
			ps.setInt(1, dto.getEmployees_id());
			ps.setTimestamp(2,dto.getAttendanceDate());
			ps.setString(3, dto.getStartTime());
			ps.setString(4, dto.getEndtime());
			ps.setDouble(5, dto.getRestHoursDay());
			ps.setDouble(6, dto.getOverHoursDay());
			ps.setInt(7, dto.getStatusId());
			ps.setString(8, dto.getWorkContent());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			isSuccess = false;
		}
		finally 
		{
			if(isSuccess)
			{
				try
				{
					con.commit();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				try
				{
					con.rollback();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				
				if(con != null)
				{
					try
					{
						con.close();
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
				
				if(ps != null)
				{
					try
					{
						ps.close();
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		return isSuccess;
	}
	
	public ArrayList<Register_Update_dto> doSelect()
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<Register_Update_dto> dto_list = new ArrayList<Register_Update_dto>();
		
		try
		{
			Class.forName(Driver_Name);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			con = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
			
			StringBuilder builder = new StringBuilder();
			builder.append(" SELECT ");
			builder.append(" * ");
			builder.append(" FROM ");
			builder.append(" T_ATTENDANCE ");
			builder.append(" ORDER BY ");
			builder.append(" EMPLOYEES_ID ");
			
			ps = con.prepareStatement(builder.toString());
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				Register_Update_dto dto = new Register_Update_dto();
				dto.setEmployees_id(rs.getInt(" EMPLOYEES_ID "));
				dto.setAttendanceDate(rs.getTimestamp(" ATTENDANCE_DATE "));
				dto.setStartTime(rs.getString(" START_TIME "));
				dto.setEndtime(rs.getString(" END_TIME "));
				dto.setRestHoursDay(rs.getDouble(" REST_HOURS_DAY "));
				dto.setOverHoursDay(rs.getDouble(" REST_OVER_DAY "));
				dto.setStatusId(rs.getInt(" STATUS_ID "));
				dto.setWorkContent(rs.getString(" WORK_CONTENT "));
				dto_list.add(dto);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(con != null)
			{
				try
				{
					con.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			if(ps != null)
			{
				try
				{
					ps.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			if(rs != null)
			{
				try
				{
					rs.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return dto_list;
	}
}
