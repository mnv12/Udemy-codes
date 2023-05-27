package com.luv2code.springdemo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOimpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override

	public List<Customer> getCustomers() {
		// get the current hibernate session

		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute query

		List<Customer> custoemrs = theQuery.getResultList();
		// return it
		return custoemrs;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(customer);

	}

	@Override
	public Customer getCustomers(Integer theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Customer customer = currentSession.get(Customer.class, theId);

		return customer;
	}

	@Override
	public void deleteCustomers(Integer id) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query createQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		createQuery.setParameter("customerId", id);

		createQuery.executeUpdate();

	}

	@Override
	public List<Customer> searchDao(String add) {
		  Session currentSession = sessionFactory.getCurrentSession();
	        
	        Query theQuery = null;
	        
	        //
	        // only search by name if theSearchName is not empty
	        //	
	        if (add != null && add.trim().length() > 0) {
	            // search for firstName or lastName ... case insensitive
	            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
	            theQuery.setParameter("theName", "%" + add.toLowerCase() + "%");
	        }
	        else {
	            // theSearchName is empty ... so just get all customers
	            theQuery =currentSession.createQuery("from Customer", Customer.class);            
	        }
	        
	        // execute query and get result list
	        List<Customer> customers = theQuery.getResultList();
	                
	        // return the results        
	        return customers;
		
	}

}
