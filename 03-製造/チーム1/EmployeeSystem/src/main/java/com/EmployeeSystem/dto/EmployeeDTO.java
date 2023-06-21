package com.EmployeeSystem.dto;

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