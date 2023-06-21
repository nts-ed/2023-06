package com.EmployeeSystem.repo;

import java.util.List;

import org.springframework.context.annotation.Primary;

import com.EmployeeSystem.dto.Register_Update_Dto;
import com.EmployeeSystem.dto.Get_Form;
import com.EmployeeSystem.dto.Post_Form;
import com.EmployeeSystem.dto.Put_Form;

@Primary
public interface Register_Update_Repository {
	List<Register_Update_Dto> findList(Get_Form form);
	
	int update(Put_Form form);
	
	int insert(Post_Form form);
	
	//勤怠情報一覧（日別）が実装済みの場合、以降の処理は全て消してください。
	Register_Update_Dto findById(int employees_id);
	
	int delete(int employees_id);
}
