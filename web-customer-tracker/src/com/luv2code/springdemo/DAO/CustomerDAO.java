package com.luv2code.springdemo.DAO;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomers( Integer theId);

	public void deleteCustomers(Integer id);

	public List<Customer> searchDao(String add);
	
	
	
}
