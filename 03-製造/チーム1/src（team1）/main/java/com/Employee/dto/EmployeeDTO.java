/*package com.nts._ed.ks.dto;

	import org.springframework.stereotype.Component;

import com.nts._ed.ks.controller.Employee;

	@Component
	public class T_EMPLOYEES {

	    public <EmployeeDTO> EmployeeDTO toDto(Employee employee) {
	        EmployeeDTO dto = new EmployeeDTO();
	        dto.setFirstName(employee.getFirstName());
	        dto.setLastName(employee.getLastName());
	        dto.setPosition(employee.getPosition());
	        return dto;
	    }

	    public Employee toEntity(EmployeeDTO dto) {
	        Employee employee = new Employee();
	        employee.setFirstName(dto.getFirstName());
	        employee.setLastName(dto.getLastName());
	        employee.setPosition(dto.getPosition());
	        return employee;
	    }

	}
	
	*/
	package com.nts._ed.ks.dto;

	public class EmployeeDTO {
	    private String firstName;
	    private String lastName;
	    private String position;

	    // コンストラクタ、ゲッター、セッター

	    public EmployeeDTO() {
	    }

	    public EmployeeDTO(String firstName, String lastName, String position) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.position = position;
	    }

	    // ゲッターとセッター

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getPosition() {
	        return position;
	    }

	    public void setPosition(String position) {
	        this.position = position;
	    }
	}