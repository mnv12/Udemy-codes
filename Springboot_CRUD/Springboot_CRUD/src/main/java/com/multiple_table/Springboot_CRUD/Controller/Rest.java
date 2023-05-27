package com.multiple_table.Springboot_CRUD.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multiple_table.Springboot_CRUD.ENtity.Instructor;
import com.multiple_table.Springboot_CRUD.ENtity.Student;
import com.multiple_table.Springboot_CRUD.ENtity.course;
import com.multiple_table.Springboot_CRUD.ENtity.instructor_details;
import com.multiple_table.Springboot_CRUD.ENtity.review;
import com.multiple_table.Springboot_CRUD.Service.Serviceimpl;

@RestController
public class Rest {

	@Autowired
	private Serviceimpl serviceimpl;

// STudent
	@GetMapping("/find")
	public List<Student> findStudent() {

		return serviceimpl.findAll();
	}

//Student
	@GetMapping("/student/{id}")
	public Student findById(@PathVariable int id) {

		return serviceimpl.findId(id);

	}

// course save

	@PostMapping("/course")
	public course saveCourse(@RequestBody course title) {
		// course course=new course();

		return serviceimpl.save(title);

	}

// delete course 
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
	
		serviceimpl.deleteByID(id);

	}

	@GetMapping("/find/{id}")
	public course findByid(@PathVariable int id) {

		return serviceimpl.find(id);

	}

	@PostMapping("/save")
	public Student save(@RequestBody Student student) {

		return serviceimpl.saveAll(student);

	}
	
	@PostMapping("/instructor")
	public Instructor saveAll(@RequestBody Instructor instructor){
		
		
		return serviceimpl.save(instructor);
	}
	@PostMapping("/instdetails")

	public instructor_details saveAll(@RequestBody instructor_details details) {
		
		
		return serviceimpl.save(details);
	}
	
	// save review 
	@PostMapping("/review")
	public review saveAll(@RequestBody review review) {
		
		return serviceimpl.save(review);
	}
	
}
