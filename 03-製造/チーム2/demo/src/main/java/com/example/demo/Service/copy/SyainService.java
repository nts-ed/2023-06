package com.example.demo.Service.copy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.example.demo.Syain;
import com.example.demo.DTO.copy.Prefectures;
import com.example.demo.Service.copy.TestService;

import io.micrometer.common.util.StringUtils;

import com.example.demo.DTO.copy.SyainDto;
import com.example.demo.Repository.copy.SyainRepository;
import lombok.RequiredArgsConstructor;
import com.example.demo.DTO.copy.MonthDto;
@Service
@RequiredArgsConstructor
public class SyainService {
	@Autowired Syain syain;
	@Autowired
	private TestService testService;
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	private final SyainRepository syainRepository;
	@Autowired
	JdbcTemplate jdbc;
	@Transactional
	public void updateData() {

		List<MonthDto> syainList = new ArrayList<>();
		LocalDateTime dateTimeNow = LocalDateTime.now();

	}


	public void search(Model model) {
		if(StringUtils.isBlank(syain.getiD())) {
			return;
		}
		//SQL取得にに仕様する
				String sql = "SELECT * "
						+ "FROM group2.T_EMPLOYEE where EMPLOYEE_ID = '"+syain.getiD()+"'";
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
				model.addAttribute("title", "基本情報更新");//画面名
				model.addAttribute("register", "hidden");//サーバーがからボタン表示非表示制御
				//ドロップダウンリスト
				List<Prefectures> prefecturesList = testService.getPrefecturesAll();
		        model.addAttribute("prefecturesList", prefecturesList);
		        // プルダウンの初期値を設定する場合は指定
		        model.addAttribute("selectedValue", map.get("DEPT_ID"));//所属ID		        
	}
	
	public int New_update_decision(String Employee_id) {
		int count = jdbc.queryForObject("SELECT COUNT(*) FROM group2.T_EMPLOYEE where EMPLOYEE_ID = '"+Employee_id+"'", Integer.class);
		System.out.println(count);
		return count;
	}
	
}
