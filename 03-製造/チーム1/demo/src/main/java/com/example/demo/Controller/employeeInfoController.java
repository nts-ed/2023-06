package com.example.demo.Controller;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee-info-list")
public class employeeInfoController {
	
	private final JdbcTemplate jdbcTemplate;
	public employeeInfoController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@GetMapping("/getInfo")
	private String getEmployeeInfo(Model model) {
		String sql ="SELECT EMPLOYEES_ID,ENTRY_DATE,EMPLOYEES_NAME,GENDER,AGE,DEPT_ID,EMAIL"
				+"FROM t_employees";
		Map<String,Object> map = jdbcTemplate.queryForMap(sql);
		
		model.addAttribute("title","社員情報一覧");
		model.addAttribute("id",map.get("EMPLOYEES_ID"));
		model.addAttribute("entry_date",map.get("ENTRY_DATE"));
		model.addAttribute("name",map.get("EMPLOYEES_NAME"));
		model.addAttribute("gender",map.get("GENDER"));
		model.addAttribute("age",map.get("AGE"));
		model.addAttribute("belong",map.get("DEPT_ID"));
		model.addAttribute("email",map.get("EMAIL"));
		
		return "getInfo";
	}
}
