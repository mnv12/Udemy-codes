package com.spring.mvcdemo;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor editor=new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, editor);
	}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {

		model.addAttribute("customer", new Customer());

		return "Customer-form";

	}
	@RequestMapping("/processForm")
	public String processForm(@jakarta.validation.Valid @ModelAttribute("customer") Customer thecustomer,BindingResult thebindingResult) {
		System.out.println("Customer Service "+thecustomer.getLastName()+"||");
		
		System.out.println("Binding Result "+thebindingResult);
		
		System.out.println("/n /n /n /n ");
		
		
		if(thebindingResult.hasErrors()) {
			
			return "Customer-form";
			
		}
	
		else {
			
			return "customer-confirmation";
			
		}
		
	}

}
