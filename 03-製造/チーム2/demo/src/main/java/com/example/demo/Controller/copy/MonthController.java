package com.example.demo.Controller.copy;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Syain;
import com.example.demo.DTO.copy.Prefectures;
import com.example.demo.DTO.copy.Prefectures_Month;
import com.example.demo.DTO.copy.Service_Month;
import com.example.demo.Service.copy.SyainService;
import com.example.demo.Service.copy.TestService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MonthController {
	@Autowired Syain syain;
	//private final SyainService syainService;
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	@Autowired
	private Service_Month testService;
    public static void main(String[] args) {
        SpringApplication.run(MonthController.class, args);
    }
//	private final SyainService syainService;
	@GetMapping("/Basic_information_registration")
	public String getHello2(String year,Model model) {
		System.out.print(year);
		//SQL取得にに仕様する
		String sql = "SELECT * "
				+ "FROM group2.T_EMPLOYEE where EMPLOYEE_ID = '"+syain.getiD()+"'";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
		String sql2 = "select * "
				+ "from group2.M_DEPT where DEPT_ID = '"+map.get("DEPT_ID")+"'";
		Map<String, Object> map2 = jdbcTemplate.queryForMap(sql2);
		model.addAttribute("employee_id", map.get("EMPLOYEE_ID"));//社員ID
		model.addAttribute("employee_name", map.get("EMPLOYEE_NAME"));//氏名
        model.addAttribute("dept_name", map2.get("DEPT_NAME"));//所属
		List<Prefectures_Month> prefecturesList = testService.getPrefecturesAll(year);
        model.addAttribute("prefecturesList", prefecturesList);
        model.addAttribute("year",year);
        model.addAttribute("selectedValue","");
		model.addAttribute("year",year);
		
		
		
		return "Basic_information_registration"; //HTML
	}
}



