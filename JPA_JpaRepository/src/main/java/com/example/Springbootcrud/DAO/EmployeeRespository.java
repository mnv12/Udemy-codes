package com.example.Springbootcrud.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Springbootcrud.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer>{

}
