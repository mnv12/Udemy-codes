package com.example.demo.annotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=	SpringApplication.run(Application.class, args);
		
//	    starter x=context.getBean(starter.class);
//	    x.start(); 
//	
//      racket y=context.getBean(racket.class);
//           
//      y.injection();
//	
//	    service z=context.getBean(service.class);
//	    z.starter();
	
		
		}
	}
	
	