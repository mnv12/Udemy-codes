package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.DAO.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
@Service
public class CustomerServiceimpl implements CustomerService {
@Autowired
private CustomerDAO customerDAO;
	@Override
	@Transactional
	public List<Customer> getCustomers() {
	
		return customerDAO.getCustomers();
	}
	@Override
	@Transactional
	public void save(Customer customer) {
		customerDAO.saveCustomer(customer);
		
	}
	@Override
	@Transactional
	public Customer getCustomers(Integer theId) {
	
		return 	customerDAO.getCustomers(theId);
	}
	@Override
	@Transactional
	public void delete(Integer id) {
		
		customerDAO.deleteCustomers(id);
		
	}
	@Override
	@Transactional
	public List<Customer> search(String add) {
		List<Customer>  dao=customerDAO.searchDao(add);
		return dao;
	}

}
