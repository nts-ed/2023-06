package com.example.demo.trySpring.copy;

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

import com.example.demo.trySpring.TEST.copy.TestService;
import com.example.demo.trySpring.TEST.copy.Prefectures;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.trySpring.copy.SyainDto;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
public class HelloController {
	
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	@Autowired
	private TestService testService;
    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }
	@GetMapping("/hello")
	public String getHello() {
		
		return "test";//HTMLファイル名
	}
	@GetMapping("/Basic_information_registration")
	public String getHello2() {
		return "Basic_information_registration";//HTMLファイル名
	}
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";//HTMLファイル名
	}
// 	public HelloController(JdbcTemplate jdbcTemplate) {
// 		this.jdbcTemplate = jdbcTemplate;
// 	}
 	private final SyainService syainService;
 	//以下更新
 	@GetMapping("/test") // "/sample"以降のURL(GET)
	public String test(Model model) {
 		//SQL取得にに仕様する
		String sql = "SELECT * "
				+ "FROM group2.T_EMPLOYEE where EMPLOYEE_ID = '00001'";
		//取得したDBを格納する
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
		model.addAttribute("employee_id", map.get("EMPLOYEE_ID"));//社員ID
		model.addAttribute("employee_name", map.get("EMPLOYEE_NAME"));//氏名
		model.addAttribute("age", map.get("age"));//年齢
		//性別
		if("男".equals(map.get("GENDER"))) {
			model.addAttribute("Man", "checked");
		}else if("女".equals(map.get("GENDER"))) {
			model.addAttribute("woman", "checked");
		}
		model.addAttribute("MAIL_ADDRESS", map.get("MAIL_ADD"));//メールアドレス
		model.addAttribute("telephone_number", map.get("TELEPHONE_NUMBER"));//電話番号
		String dateString = map.get("ENTRY_DATE").toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        System.out.print(date);
		model.addAttribute("calendar_date", date);//入社年月日          
		model.addAttribute("title", "Inquiry Form");
		model.addAttribute("hidden", "hidden");//サーバーがからボタン表示非表示制御
		//ドロップダウンリスト
		List<Prefectures> prefecturesList = testService.getPrefecturesAll();
        model.addAttribute("prefecturesList", prefecturesList);
        // プルダウンの初期値を設定する場合は指定
        model.addAttribute("selectedValue", map.get("DEPT_ID"));//所属ID

		return "test"; //HTMLファイル名
	}
 	private final SyainRepository syainRepository;
 	@RequestMapping(value="/user/create", method=RequestMethod.POST)
 	public String create(SyainDto syainDto) {
 	// userRequestに入力フォームの内容が格納されている
 		System.out.print(syainDto.getEmployee_id());
 		syainRepository.updateSyain(syainDto); // 更新
 		System.out.print(syainDto);
 		return "test";
 	}
 	
 	
}
