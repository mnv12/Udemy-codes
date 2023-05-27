package com.example.Springbootcrud.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.CommonQueryContract;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Springbootcrud.entity.Employee;

import jakarta.persistence.EntityManager;


public class EmployeeDAO_impl implements EmployeeDAO {
	@Autowired
	private EntityManager entityManager;

	@Transactional
	@Override
	public List<Employee> findAll(String lastname) {
		Session session = entityManager.unwrap(Session.class);

		Query<Employee> query = session.createQuery("FROM Employee where lastName=:theData", Employee.class);

		List<Employee> resultList = query.getResultList();
((CommonQueryContract) resultList).setParameter("theData",lastname );
		return resultList;
	}

	@Transactional
	@Override
	public Employee findbyID(Integer theId) {

		Session session = entityManager.unwrap(Session.class);

		Employee employee = session.get(Employee.class, theId);

		return employee;

	}

	@Transactional
	@Override
	public void deletebyID(Integer Id) {
		Session session = entityManager.unwrap(Session.class);

		Query createQuery = session.createQuery("delete from Employee where id=:Id");

		 createQuery.setParameter("Id", Id);
		 
		 createQuery.executeUpdate();
		
	

	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate( theEmployee);
		
		
	}
	
	

}
