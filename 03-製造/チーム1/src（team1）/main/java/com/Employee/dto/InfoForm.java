package com.EmployeeSystem.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.Data;


@Data
public class InfoForm implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	

	private int id;
	
	@NotEmpty(message="名前を入力してください")
	@Size(max=100,message="名前は100桁以内で入力してください")
	private String name;
	
	@NotNull(message="年齢を入力してください")
	@Min(value = 18, message = "Age must be a positive number")
	@Max(value = 99, message = "Age must not exceed 99")
	private Integer age;
	
	@NotEmpty(message="性別を入力してください")
	private String gender;
	
	@NotEmpty(message="電話番号を入力してください")
	@Pattern(regexp="^(070|080|090)-\\d{4}-\\d{4}$",message="電話番号の形式が正しくありません")
	private String phone_Number;
	
	@Email(message="メールアドレスの形式が正しくありません")
	@NotEmpty(message="メールアドレスを入力してください")
	private String email;
	
	@NotEmpty(message="所属を選択してください")
	private String dept;
	
	@PastOrPresent(message="入社日は正しくありません")
	@DateTimeFormat(pattern = "yyyy/MM/dd", message="日付の形式が正しくありません")
	@NotNull(message ="入社日を入力してください")
	private Date entry_Date;
	

}
