package com.example.demo.annotations;

import org.springframework.stereotype.Component;

@Component
public class field_injection {

	public field_injection() {
		// TODO Auto-generated constructor stub
	}

	public String run(String a ,Integer b) {
		
		System.out.println("run method");
		return "User sucess";
	}
	
	
}
