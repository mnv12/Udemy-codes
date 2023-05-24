package com.example.demo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class starter {

private Car car;
   
   
	       
	public void start() {
		
		
		System.out.println("ff");
	
	car.engine();
		
	}
	@Autowired
	public void body(Car car) {
		
		this.car=car;
		System.out.println("ghyg");// setter injection 
	}
	


	
	
}
