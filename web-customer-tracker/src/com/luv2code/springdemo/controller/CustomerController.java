package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model model) {

		// get customers from service
		List<Customer> theCustomer = customerService.getCustomers();

		// add customers on model
		model.addAttribute("customers", theCustomer);
		return "list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer customer=new Customer();
		
		theModel.addAttribute("customer",customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer customer) {
		customerService.save(customer);
		return "redirect:/customer/list";
	}
	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") Integer theId,Model model ) {
		
		Customer customer=customerService.getCustomers(theId);
		model.addAttribute("customer",customer);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") Integer Id,Model model) {
		
		customerService.delete(Id);
		return "redirect:/customer/list";
	}
@GetMapping("/search")
public String searchCustomer(@RequestParam("SearchName") String add,Model model) {
List<Customer>	searching=customerService.search(add);
	model.addAttribute("customers",searching);
	return "list";
	
}
}
