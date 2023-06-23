package com.nts._ed.ks.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String position;
	public Object getFirstName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

    // getterとsetterを省略

}