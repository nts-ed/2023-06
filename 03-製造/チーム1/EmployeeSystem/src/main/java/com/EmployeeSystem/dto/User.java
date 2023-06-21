package com.EmployeeSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class User {
private Integer id; 
private String password;

}
