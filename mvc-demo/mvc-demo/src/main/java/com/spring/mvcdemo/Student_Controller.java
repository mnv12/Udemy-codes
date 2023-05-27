package com.spring.mvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class Student_Controller {
// showing form 
	@RequestMapping("/showForm")
	public String showForm(Model model) {

		Student student = new Student();

		model.addAttribute("student", student);

		return "student-form";
	}

	// processing of data
	@RequestMapping("processForm")
	public String processForm(@ModelAttribute("student") Student student) {

		System.out.println("the Student " + student.getFirstName() + "and" + student.getLastName());

		return "Confirmation-Page";

	}
	
	

}
