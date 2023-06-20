package com.example.demo.Controller.copy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.RequiredArgsConstructor;
import java.util.Map;
import javax.sql.DataSource;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.Service.copy.SyainService;
import com.example.demo.Service.copy.TestService;
import com.example.demo.Syain;
import com.example.demo.DTO.copy.Prefectures;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.DTO.copy.SyainDto;
import com.example.demo.Repository.copy.SyainRepository;

import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.SequenceGenerators;
import jakarta.servlet.http.HttpSession;

import org.springframework.validation.BindingResult;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.validation.ObjectError;
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class HelloController {
	@Autowired Syain syain;
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	@Autowired
	private TestService testService;
	@SequenceGenerator(name = "account_id_seq")
	private String employeeId;
    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }
	@GetMapping("/hello")
	public String getHello(Model model) {
		//ドロップダウンリスト
		List<Prefectures> prefecturesList = testService.getPrefecturesAll();
        model.addAttribute("prefecturesList", prefecturesList);
        // プルダウンの初期値を設定する場合は指定
        model.addAttribute("selectedValue", "00");
		model.addAttribute("update", "hidden");//サーバーがからボタン表示非表示制御
		model.addAttribute("title", "基本情報新規登録");//画面名
		return syain.getScreenid();//HTMLファイル名
	}
//	@GetMapping("/Basic_information_registration")
//	public String getHello2() {
//		return "Basic_information_registration";//HTMLファイル名
//	}
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";//HTMLファイル名
	}
 	private final SyainService syainService;
 	//以下登録・更新
 	@GetMapping("/test") // "/sample"以降のURL(GET)
	public String test(Model model) {
        syainService.search(model);
		return "test"; //HTMLファイル名
	}
 	private final SyainRepository syainRepository;
 	@RequestMapping(value="/basic_information", method=RequestMethod.POST)
 	public String create(@Validated @ModelAttribute SyainDto syainDto, BindingResult result,HttpSession session,Model model) {
        //エラーメッセージ
 		if (result.hasErrors()) {
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            syainService.search(model);
            return "test";
        }
 	//SQLでデータを検索する
 		try {
			int count = jdbc.queryForObject("SELECT COUNT(*) FROM group2.T_EMPLOYEE where EMPLOYEE_ID = '"+syainDto.getEmployee_id()+"'", Integer.class);
			System.out.println(count);
			if(count==1) {
				syainRepository.updateSyain(syainDto); // 更新
				System.out.print(syainDto);
			}else {
				System.err.println("何もない");
				System.out.println(employeeId);
				syainRepository.insertSyain(syainDto); // 登録
				System.out.println(syainDto);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("新規登録時");
		}
 		session.setAttribute("employeeName", syainDto.getEmployee_name());
 		return syain.getScreenid();
 	}
 	
 	
}