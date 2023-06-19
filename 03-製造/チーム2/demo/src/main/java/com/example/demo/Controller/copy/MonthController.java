package com.example.demo.Controller.copy;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.DTO.copy.Prefectures_Month;
import com.example.demo.DTO.copy.Service_Month;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MonthController {
	
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
//		List<SyainDto> list = syainRepository.getAll();
//		model.addAttribute("SyainList",list);
		
		//繝峨Ο繝�繝励ム繧ｦ繝ｳ繝ｪ繧ｹ繝�
		List<Prefectures_Month> prefecturesList = testService.getPrefecturesAll(year);
        model.addAttribute("prefecturesList", prefecturesList);
        model.addAttribute("year",year);
        // 繝励Ν繝�繧ｦ繝ｳ縺ｮ蛻晄悄蛟､繧定ｨｭ螳壹☆繧句�ｴ蜷医�ｯ謖�螳�
        model.addAttribute("selectedValue","");//謇�螻曵D

		return "Basic_information_registration"; //HTML繝輔ぃ繧､繝ｫ蜷�
	}
}



