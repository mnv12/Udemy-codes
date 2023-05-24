package com.example.demo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class service {
@Autowired
private field_injection field_injection;

public void starter() {
	
	
	String s= field_injection.run("manav",874497499);
	System.out.println(s);
}
	
	
	
	
	
}
