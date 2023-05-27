package com.example.Springbootcrud.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Springbootcrud.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
@Repository

public class Employee_jpaDAO implements EmployeeDAO {
	
	@Autowired
  private EntityManager entityManager;
	@Override
	public List<Employee> findAll(String lastname) {
		
		Query query=entityManager.createQuery("from Employee where lastName =:theData",Employee.class);
		
		
		
		List<Employee> resultList = query.getResultList();
		((Query) resultList).setParameter("theData",lastname);
		
		return resultList;
	}

	@Override
	public Employee findbyID(Integer theId) {
		Employee employee=entityManager.find(Employee.class, theId);
		return employee;
	}

	@Override
	public void deletebyID(Integer theId) {
		Query createQuery = entityManager.createQuery("delete from Employee where id=:Id");

		 createQuery.setParameter("Id", theId);
		 
		 createQuery.executeUpdate();
		

	}

	@Override
	public void save(Employee theEmployee) {
		
		Employee employee=entityManager.merge(theEmployee);
	
		employee.setId(employee.getId());

}
}