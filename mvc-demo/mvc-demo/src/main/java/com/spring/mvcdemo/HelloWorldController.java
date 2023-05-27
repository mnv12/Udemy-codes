package com.spring.mvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;

import jakarta.servlet.http.HttpServletRequest;

@Controller // inherit the component scan
@RequestMapping("/hello")// parent level when there are multiple request mapping use 
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {

		return "Hello-World";
	}

	@RequestMapping("/processForm")
	public String processForm() {

		return "hello";
	}

	// Model 
	@RequestMapping("/convert")
	public String convertData(HttpServletRequest request,Model model) {
		String theName=request.getParameter("studentName");
		
		theName=theName.toUpperCase(); 
		String result="Yo! " +theName;
		model.addAttribute("message",result);
		return "hello";
	
	}
		
		// USing RequestParam

		@RequestMapping("/converts")
		public String convertDataParam(@RequestParam("studentName") String theName ,Model model) {
	
			
			theName=theName.toUpperCase(); 
			String result="Yo! " +theName;
			model.addAttribute("message",result);
			return "hello";
		
		
}
		

		
		
}
