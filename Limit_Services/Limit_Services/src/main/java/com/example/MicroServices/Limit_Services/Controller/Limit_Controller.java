package com.example.MicroServices.Limit_Services.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MicroServices.Limit_Services.Cofiguration.Configuration;
import com.example.MicroServices.Limit_Services.Service.Limits;

@RestController
public class Limit_Controller {

	@Autowired
	private Configuration configuration;
	
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		
		return new Limits(configuration.getMinimum(),configuration.getMaximum());
		
	}
	
}
