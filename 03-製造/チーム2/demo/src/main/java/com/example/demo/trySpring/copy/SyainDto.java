package com.example.demo.trySpring.copy;
import java.io.Serializable;
import java.time.LocalDateTime;

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

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_gen")
	@SequenceGenerator(name = "account_id_gen", sequenceName = "account_id_seq", allocationSize = 1)
	@Column(name="employee_id")
    private String employee_id;//社員ID
    private String employee_name;//社員名称
    private String dept_id;//所属部門ID 
    private String gender;//性別
    private String telephone_number;//電話番号
    private String entry_date;//入社年月日
    private int age;//年齢
    private String mail_add;//メールアドレス
    private int del_flg;//削除フラグ
    private int admin_flg;//管理部フラグ
//    private String create_date;//作成日時
//    private String create_user;//作成者
//    private String update_date;//更新日時
//    private String update_user;//更新者
//    private String romaji;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
	
    
}
