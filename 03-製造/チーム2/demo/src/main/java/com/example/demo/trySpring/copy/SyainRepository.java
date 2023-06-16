package com.example.demo.trySpring.copy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Syain;
import com.example.demo.trySpring.copy.SyainDto;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.security.SecureRandom;

@Repository
@RequiredArgsConstructor
public class SyainRepository {
	@Autowired Syain syain;
	private final JdbcTemplate jdbcTemplate;
	LocalDateTime dateTimeNow = LocalDateTime.now();
	public void insertSyain(SyainDto syainDto) {
		String date_conversion="";
			try {
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
//			jdbcTemplate.update(
//					"INSERT INTO group2.T_EMPLOYEE"
//					+ "(USER＿ID,NAME) "
//					+ "Values(?,?)",
//					syain.getEmployee_id(), syain.getEmployee_name());
			jdbcTemplate.update(
					"INSERT INTO group2.T_EMPLOYEE"
					+ "(ADMIN_FLG,DEL_FLG,GENDER,TELEPHONE_NUMBER,ENTRY_DATE,AGE,MAIL_ADD,DEPT_ID,EMPLOYEE_NAME,CREATE_DATE,CREATE_USER,UPDATE_DATE,UPDATE_USER,PASSWORD) "
					+ "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					0,0,syainDto.getGender(), syainDto.getTelephone_number(),date_conversion,syainDto.getAge(),syainDto.getMail_add(),
					syainDto.getDept_id(),syainDto.getEmployee_name(),dateTimeNow,syain.getName(),dateTimeNow,syain.getName(),generateRandomPassword(8));
		
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
		int num = Integer.parseInt(syainDto.getEmployee_id());
		jdbcTemplate.update(
				"UPDATE group2.T_EMPLOYEE SET "
				+ "GENDER='"+syainDto.getGender()+"',"
				+ "TELEPHONE_NUMBER='"+syainDto.getTelephone_number()+"',"
				+ "ENTRY_DATE='"+date_conversion+"',"
				+ "AGE='"+syainDto.getAge()+"',"
				+ "MAIL_ADD='"+syainDto.getMail_add()+"',"
				+ "DEPT_ID='"+syainDto.getDept_id()+"',"
				+ "EMPLOYEE_NAME='"+syainDto.getEmployee_name()+"',"
				+ "UPDATE_DATE='"+dateTimeNow+"'," 
				+ "UPDATE_USER='"+syain.getName()+"'" 
				+ "where EMPLOYEE_ID="+num);
	}

	public void deleteSyain(SyainDto syainList) {
		jdbcTemplate.update("DELETE FROM syain where id = ?" ,
				syainList.getEmployee_id());
	}
	//パスワードの生成
	 public static String generateRandomPassword(int len)
	    {
	        // ASCII範囲–英数字(0-9、a-z、A-Z)
	        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	 
	        SecureRandom random = new SecureRandom();
	        StringBuilder sb = new StringBuilder();
	 
	        //ループの各反復は、指定された文字からランダムに文字を選択します
	        //ASCII範囲とそれを`StringBuilder`インスタンスに追加します
	 
	        for (int i = 0; i < len; i++)
	        {
	            int randomIndex = random.nextInt(chars.length());
	            sb.append(chars.charAt(randomIndex));
	        }
	 
	        return sb.toString();
	    }

}
