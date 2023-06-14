package com.example.demo.trySpring.copy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.trySpring.copy.SyainDto;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SyainRepository {
	private final JdbcTemplate jdbcTemplate;

	public void insertSyain(List<SyainDto> syainList) {
		for (SyainDto syain : syainList) {
			jdbcTemplate.update(
					"INSERT INTO TEST01.T_USERS"
					+ "(USER＿ID,NAME) "
					+ "Values(?,?)",
					syain.getUser_Id(), syain.getName());
		}
	}

	public void updateSyain(SyainDto syainDto) {
		String date_conversion="";
		try {
			//String dateStringsss = "2022-12-22";
			String dateStringsss = syainDto.getCalendar_date();
			//Dateに変換
	        SimpleDateFormat exDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date sssss = exDateFormat.parse(dateStringsss);
	        //日付の間にある物を削除
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	        System.out.println(sdf.format(sssss)); 
	        date_conversion=sdf.format(sssss);
		}catch(Exception e) {
			System.out.println(e);
		}
		jdbcTemplate.update(
				"UPDATE TEST01.T_USERS SET "
				+ "SEX='"+syainDto.getSex()+"'"
				+ "TELEPHONE_NUMBER='"+syainDto.getTelephone_number()+"'"
				+ "CALENDAR_DATE='"+date_conversion+"'"
				+ "AGE='"+syainDto.getAge()+"'"
				+ "MAIL_ADDRESS='"+syainDto.getMail_address()+"'"
				+ "AFFILIATION='"+syainDto.getAffiliation()+"'"
				+ "NAME='"+syainDto.getName()+"'" 
				+ "where USER＿ID='"+syainDto.getUser_Id()+"'");
	}

	public void deleteSyain(SyainDto syainList) {
		jdbcTemplate.update("DELETE FROM syain where id = ?" ,
				syainList.getUser_Id());
	}
}
