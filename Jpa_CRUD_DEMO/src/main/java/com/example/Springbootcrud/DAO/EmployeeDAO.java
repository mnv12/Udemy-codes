package com.example.Springbootcrud.DAO;

import java.util.List;

import com.example.Springbootcrud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll(String lastname);
	public Employee findbyID(Integer theId);
	public void deletebyID(Integer theId);
	public void save(Employee theEmployee);
	
}
