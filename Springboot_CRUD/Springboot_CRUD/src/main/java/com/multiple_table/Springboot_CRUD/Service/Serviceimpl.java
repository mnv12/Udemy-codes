package com.multiple_table.Springboot_CRUD.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;

import com.multiple_table.Springboot_CRUD.ENtity.Instructor;
import com.multiple_table.Springboot_CRUD.ENtity.Student;
import com.multiple_table.Springboot_CRUD.ENtity.course;
import com.multiple_table.Springboot_CRUD.ENtity.instructor_details;
import com.multiple_table.Springboot_CRUD.ENtity.review;
import com.multiple_table.Springboot_CRUD.Repository.Repo;
import com.multiple_table.Springboot_CRUD.Repository.Repo2;
import com.multiple_table.Springboot_CRUD.Repository.Repo3;
import com.multiple_table.Springboot_CRUD.Repository.Repo4;
import com.multiple_table.Springboot_CRUD.Repository.Repo5;

@org.springframework.stereotype.Service
public class Serviceimpl implements Service {

	@Autowired
	private Repo repo;
	@Autowired
	private Repo3 repo3;
	@Autowired
	private Repo2 repo2;
	@Autowired 
	private Repo4 repo4;
	@Autowired
	private Repo5 repo5;

	// Student findall
	public List<Student> findAll() {

		return repo.findAll();
	}

	// Student save

	public Student saveAll(Student student) {

		

		return repo.save(student);

	}

	// Student find By id

	public Student findId(int id) {
		Student student = null;
		Optional<Student> find = repo.findById(id);

		if (find.isPresent()) {

			student = find.get();
		} else {

			throw new RuntimeException("Students Id not found");
		}

		return student;
	}

	// course save

	public course save(course thecourse) {

		return repo3.save(thecourse);

	}

	public course find(int id) {
		course courses = null;
		Optional<course> find = repo3.findById(id);

		if (find.isPresent()) {

			courses = find.get();
		} else {

			throw new RuntimeException("Id not found");
		}

		return courses;
	}

	public Instructor retrive() {

		return null;
	}

	public instructor_details detail() {

		return null;
	}

	public review Review() {

		return null;
	}

// delte course 
	@Override
	public void deleteByID(int id) {
		repo3.deleteById(id);
	}

	 // Instructor save 
	
	public Instructor save(Instructor instructor){
		
		
		
		return repo2.save(instructor);
	}
// instructor details save
	@Override
	public instructor_details save(instructor_details details) {
		
		return repo4.save(details);
	}
	
	// review save 
	
	public review save(review reviews) {
		
		
		return repo5.save(reviews);
	}
	
}
