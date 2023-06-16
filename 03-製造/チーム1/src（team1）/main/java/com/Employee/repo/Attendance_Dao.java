package Employees.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import Employees.dto.Register_Update_Dto;
import Employees.form.Get_Form;
import Employees.form.Post_Form;
import Employees.form.Put_Form;

@Repository
public class Attendance_Dao implements Register_Update_Repository{
	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	public Attendance_Dao(NamedParameterJdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int update(Put_Form form)
	{
		int count = 0;
		StringBuilder builder = new StringBuilder();
		builder.append(" UPDATE ");
		builder.append(" T_ATTENDANCE ");
		builder.append(" SET ");
		builder.append(" START_TIME = ?, ");
		builder.append(" END_TIME = ?, ");
		builder.append(" REST_HOURS_DAY = ?, ");
		builder.append(" OVER_HOURS_DAY = ?, ");
		builder.append(" STATUS_ID = ?, ");
		builder.append(" WORK_CONTENT = ?, ");
		builder.append(" WHERE ");
		builder.append(" EMPLOYEES_ID = ? ");
		builder.append(" AND ");
		builder.append(" ATTENDANCE_DATE = ? ");
		
		String sql = builder.toString();
		
		Map<String, Object> param = new HashMap<>();
		param.put("EMPLOYEES_ID",form.getEmployees_id());
		param.put("ATTENDANCE_DATE", form.getAttendance_date());
		param.put("START_TIME", form.getStart_time());
		param.put("END_TIME", form.getEnd_time());
		param.put("REST_HOURS_DAY", form.getRest_hours_day());
		param.put("OVER_HOURS_DAY", form.getOver_hours_day());
		param.put("STATUS_ID", form.getStatusForm());
		param.put("WORK_CONTENT", form.getContentForm());
		count = jdbcTemplate.update(sql, param);
		return count;
	}
	
	@Override
	public int insert(Post_Form form)
	{
		int count = 0;
		
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
		
		String sql = builder.toString();
		
		Map<String, Object> param = new HashMap<>();
		param.put("ATTENDANCE_DATE", form.getAttendance_date());
		param.put("START_TIME", form.getStart_time());
		param.put("END_TIME", form.getEnd_time());
		param.put("REST_HOURS_DAY", form.getRest_hours_day());
		param.put("OVER_HOURS_DAY", form.getOver_hours_day());
		param.put("STATUS_ID",form.getStatusForm());
		param.put("WORK_CONTENT",form.getContentForm());
		count = jdbcTemplate.update(sql, param);
		
		return count;
	}
	
	@Override
	public List<Register_Update_Dto> findList(Get_Form form)
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append(" SELECT ");
		builder.append(" * ");
		builder.append(" FROM ");
		builder.append(" T_ATTENDANCE ");
		builder.append(" ORDER BY ");
		builder.append(" EMPLOYEES_ID ");
		
		Map<String, String> param = new HashMap<>();
		
		String sql = builder.toString();
		
		//タスク一覧をMapのListで取得
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql, param);
		List<Register_Update_Dto> list = new ArrayList<Register_Update_Dto>();
		
		for(Map<String, Object> result : resultList)
		{
			Register_Update_Dto dto = new Register_Update_Dto();
			dto.setEmployees_id((int)result.get("EMPLOYEES_ID"));
			dto.setAttendanceDate((Timestamp)result.get("ATTENDANCE_DATE"));
			dto.setStartTime((String)result.get("START_TIME"));
			dto.setEndtime((String)result.get("END_TIME"));
			dto.setRestHoursDay((double)result.get("REST_HOURS_DAY"));
			dto.setOverHoursDay((int)result.get("OVER_HOURS_DAY"));
			dto.setStatusId((int)result.get("STATUS_ID"));
			dto.setWorkContent((String)result.get("WORK_CONTENT"));
			list.add(dto);
		}
		return list;
	}
	
	@Override
	public Register_Update_Dto findById(int employees_id) throws IncorrectResultSizeDataAccessException
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append(" SELECT ");
		builder.append(" * ");
		builder.append(" FROM ");
		builder.append(" T_ATTENDANCE ");
		builder.append(" ORDER BY ");
		builder.append(" EMPLOYEES_ID ");
		
		Map<String, Object> param = new HashMap<>();
		
		String sql = builder.toString();
		param.put("EMPLOYEES_ID", employees_id);
		
		Map<String, Object> result = jdbcTemplate.queryForMap(sql, param);
		Register_Update_Dto dto = new Register_Update_Dto();
		dto.setEmployees_id((int)result.get("EMPLOYEES_ID"));
		dto.setAttendanceDate((Timestamp)result.get("ATTENDANCE_DATE"));
		dto.setStartTime((String)result.get("START_TIME"));
		dto.setEndtime((String)result.get("END_TIME"));
		dto.setRestHoursDay((double)result.get("REST_HOURS_DAY"));
		dto.setOverHoursDay((double)result.get("OVER_HOURS_DAY"));
		dto.setStatusId((int)result.get("STATUS_ID"));
		dto.setWorkContent((String)result.get("WORK_CONTENT"));
		return dto;
	}
}
