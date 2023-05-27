package com.multiple_table.Springboot_CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiple_table.Springboot_CRUD.ENtity.Student;


public interface Repo extends JpaRepository<Student, Integer> {

	
	
	
	
}
