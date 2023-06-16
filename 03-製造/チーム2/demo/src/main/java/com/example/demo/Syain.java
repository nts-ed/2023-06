package com.example.demo;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Syain implements Serializable {

	private static final long serialVersionUID = 1L;
	private String iD;

	private String name;
	
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}


}
