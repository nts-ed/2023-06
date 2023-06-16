package Employees.repository;

import java.util.List;

import Employees.dto.Register_Update_Dto;
import Employees.form.Get_Form;
import Employees.form.Post_Form;
import Employees.form.Put_Form;

public interface Register_Update_Repository {
	List<Register_Update_Dto> findList(Get_Form form);
	
	int update(Put_Form form);
	
	int insert(Post_Form form);
	
	Register_Update_Dto findById(int employees_id);
}
