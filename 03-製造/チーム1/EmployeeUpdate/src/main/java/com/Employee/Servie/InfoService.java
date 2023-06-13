package com.Employee.Servie;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.dto.InfoForm;
import com.Employee.repo.InfoRepository;


@Service
public class InfoService {
	
	@Autowired
	private InfoRepository infoRepository;
	
	
	//登録モードgetNewId
	public Integer getNewId() {
		if(infoRepository.getEmployeesId()==null) {
			return 1;
		}else
		return infoRepository.getEmployeesId()+1;
	}
	//登録モード（add）
	public void addInfo(InfoForm infoForm) {
		
		Info info = new Info();
		info.setEmployees_Id(infoForm.getId());
		//名前設定
		info.setName(infoForm.getName());
		//年齢設定
		info.setAge(infoForm.getAge());
		//性別設定
		
		if(infoForm.getGender().equals("男")) {
			info.setGender(1);
			
		}else {
			info.setGender(0);
		}
		
		//電話番号の設定
		info.setPhone_Number(infoForm.getName());
		
		//メールの設定
		info.setEmail(infoForm.getEmail());
		
		//職位の設定、初期：一般社員
		info.setPosition_Flg(0);
		
		//所属の設定
		if(infoForm.getDept().equals("第一部")) {	
		info.setDept_Id(1001);	
	   }else if(infoForm.getDept().equals("第二部")){
		 info.setDept_Id(1002);  
	   }else if(infoForm.getDept().equals("第三部")){
		   info.setDept_Id(1003);
	   }
		
		//入社日の設定
		info.setEntry_Date(infoForm.getEntry_Date());
		
		//登録日の設定
		info.setCreate_Date(new Date());
		
		//登録者の設定
		info.setCreate_UserId(0);
		
		//更新日と更新者　null
		info.setUpdate_Date(null);
		info.setUpdate_userId(0);
		
		//削除フラグ
		info.setDel_Flg(1);
		
		//新社員情報add
		infoRepository.save(info);
		
	}
	
	
	
	//更新モードgetById
	public InfoForm getInfo(int employees_Id){
		
		InfoForm infoForm = new InfoForm();
		Info info = infoRepository.findById(employees_Id).get();
		infoForm.setId(info.getEmployees_Id());
		infoForm.setName(info.getName());
		infoForm.setDept("第一部");
		infoForm.setGender("性別");
		infoForm.setPhone_Number(info.getPhone_Number());
		infoForm.setEntry_Date(info.getEntry_Date());
		infoForm.setAge(info.getAge());
		infoForm.setEmail(info.getEmail());
		
		return infoForm;
		
	}
	//更新モード（update）
	public void updateInfo(InfoForm infoForm) {
		if(infoRepository.findById(infoForm.getId()) != null) {
			
			
			Info info = infoRepository.findById(infoForm.getId()).get();
			
			info.setName(infoForm.getName());
			
			//年齢設定
			info.setAge(infoForm.getAge());
			
			//性別設定
			if(infoForm.getGender().equals("男")) {
				info.setGender(1);
				
			}else {
				info.setGender(0);
			}
			
			//電話番号の設定
			info.setPhone_Number(infoForm.getName());
			
			//メールの設定
			info.setEmail(infoForm.getEmail());
			
			//職位の設定、初期：一般社員
			info.setPosition_Flg(0);
			
			//所属の設定
			if(infoForm.getDept().equals("第一部")) {	
			info.setDept_Id(1001);	
		   }else if(infoForm.getDept().equals("第二部")){
			 info.setDept_Id(1002);  
		   }else if(infoForm.getDept().equals("第三部")){
			   info.setDept_Id(1003);
		   }
			
			//更新日と更新者　null
			info.setUpdate_Date(new Date());
			info.setUpdate_userId(0);
			
			//社員情報更新update
			infoRepository.save(info);
		}	
	}
	
	
	
	
	

}
