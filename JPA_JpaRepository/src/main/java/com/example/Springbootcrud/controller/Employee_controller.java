package com.example.Springbootcrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Springbootcrud.DAO.EmployeeDAO;
import com.example.Springbootcrud.DAO.EmployeeRespository;
import com.example.Springbootcrud.entity.Employee;

@RestController
public class Employee_controller {
@Autowired
private EmployeeRespository employeeRespository;
	@GetMapping("/find/{Id}")
	public Employee findById(@PathVariable  Integer Id){
		Employee employee=null;
		
	 Optional<Employee> findById = employeeRespository.findById(Id);
	 
	 if(findById.isPresent()) {
		 employee=findById.get();
		 
	 }
	 
	 else {
		 throw new RuntimeException("Id not find");
	 }
	 return employee;
		
	}
	
	
	
	
	
}
