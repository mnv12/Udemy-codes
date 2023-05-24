package com.example.demo.annotations;

import org.springframework.stereotype.Component;

@Component
public class racket {

	private constructor constructor;
	
   public racket(constructor constructor) {
	this.constructor=constructor;
		System.out.println("Constructor injection ");//constructor injection
		
	}

	public void  injection () {
		constructor.show();
		System.out.println("new era");
	}
	
	
}
