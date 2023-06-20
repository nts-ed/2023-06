package com.example.demo.DTO.copy;
import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Data
@Entity
//@AllArgsConstructor
public class SyainDto implements Serializable{
//	@Id
//	//@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
//	@SequenceGenerator(name = "user_id_generator", sequenceName = "user_id_seq", allocationSize = 1)
//	@Id
//    @GeneratedValue(
//        strategy = GenerationType.SEQUENCE,
//        generator = "employee_id_seq")
//    @SequenceGenerator(
//        name = "employee_id_seq",
//        sequenceName = "employee_id_seq",
//        initialValue = 1,
//        allocationSize = 6)
    /**
    * 社員ID
    */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_gen")
	@SequenceGenerator(name = "account_id_gen", sequenceName = "account_id_seq", allocationSize = 1)
	@Column(name="employee_id")
    private String employee_id;
    /**
    * 社員名称
    */
    @NotEmpty(message = "名前を入力してください")
    @Size(max = 100, message = "名前は100桁以内で入力してください")
    private String employee_name;
    /**
    * 所属部門ID
    */
    @NotEmpty(message = "所属部門を選択してください")
    private String dept_id;
    /**
    * 性別
    */
    private String gender;
    /**
    * 電話番号
    */
    @NotEmpty(message = "電話番号を選択してください")
    private String telephone_number;
    /**
    * 入社年月日
    */
    @NotEmpty(message = "日付を選択してください")
    private String entry_date;
    /**
    * 年齢
    */
    @NotNull(message = "15歳から90歳の年齢を入力してください")
    @Range(min=15, max=90 , message = "15歳から90歳の年齢を入力してください")
    //@Positive
    private Integer age;
    /**
    * メールアドレス
    */
    @NotEmpty(message = "メールアドレスを入力してください")
    @Email
    private String mail_add;
    /**
    * 削除フラグ
    */
    private int del_flg;
    /**
    * 管理部フラグ
    */
    private int admin_flg;
//    private String create_date;//作成日時
//    private String create_user;//作成者
//    private String update_date;//更新日時
//    private String update_user;//更新者
//    private String romaji;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
	
    
}
