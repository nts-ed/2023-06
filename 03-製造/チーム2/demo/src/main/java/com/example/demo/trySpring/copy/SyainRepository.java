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
					syain.getEmployee_id(), syain.getEmployee_name());
		}
	}

	public void updateSyain(SyainDto syainDto) {
		String date_conversion="";
		try {
			//String dateStringsss = "2022-12-22";
			String dateStringsss = syainDto.getEntry_date();
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
				"UPDATE group2.T_EMPLOYEE SET "
				+ "GENDER='"+syainDto.getGender()+"',"
				+ "TELEPHONE_NUMBER='"+syainDto.getTelephone_number()+"',"
				+ "ENTRY_DATE='"+date_conversion+"',"
				+ "AGE='"+syainDto.getAge()+"',"
				+ "MAIL_ADD='"+syainDto.getMail_add()+"',"
				+ "DEPT_ID='"+syainDto.getDept_id()+"',"
				+ "EMPLOYEE_NAME='"+syainDto.getEmployee_name()+"'" 
				+ "where EMPLOYEE_ID='"+syainDto.getEmployee_id()+"'");
	}

	public void deleteSyain(SyainDto syainList) {
		jdbcTemplate.update("DELETE FROM syain where id = ?" ,
				syainList.getEmployee_id());
	}
}
