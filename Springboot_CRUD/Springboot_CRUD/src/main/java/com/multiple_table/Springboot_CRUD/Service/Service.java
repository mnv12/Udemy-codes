package com.multiple_table.Springboot_CRUD.Service;

import java.util.List;
import java.util.Optional;

import com.multiple_table.Springboot_CRUD.ENtity.Instructor;
import com.multiple_table.Springboot_CRUD.ENtity.Student;
import com.multiple_table.Springboot_CRUD.ENtity.course;
import com.multiple_table.Springboot_CRUD.ENtity.instructor_details;
import com.multiple_table.Springboot_CRUD.ENtity.review;

public interface Service {

	public List<Student> findAll();

	public Student saveAll(Student student);
	
	public Student findId(int id);
	public course save(course thecourse);
	public course find(int id);
	public void deleteByID(int id);
	public Instructor save( Instructor instructor);
	
	public instructor_details save(instructor_details details);
	public review save(review reviews);
	public Instructor retrive();

	public instructor_details detail();

	public review Review();

}
