package com.example.Springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Springbootcrud.DAO.EmployeeDAO;
import com.example.Springbootcrud.entity.Employee;

@RestController
public class Employee_controller {

	@Autowired
	@Qualifier("employee_jpaDAO")
	private EmployeeDAO dao;

	@GetMapping("/find")
	public List<Employee> find(String lastname) {

		return dao.findAll(lastname);

	}

	@GetMapping("/find/{id}")
	public Employee findId(@PathVariable Integer id) {

		return dao.findbyID(id);
	}

	@PostMapping("/save")
	public void saveEmployee(@RequestBody Employee employee) {
		Employee employee2 = new Employee();

		employee2.setId(0);

		dao.save(employee);

	}

	@DeleteMapping("/find/{IdEmp}")
	public void delete(@PathVariable Integer IdEmp) {

		 dao.deletebyID(IdEmp);

	}

}
