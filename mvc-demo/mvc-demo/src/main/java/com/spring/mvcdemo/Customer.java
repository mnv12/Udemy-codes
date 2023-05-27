package com.spring.mvcdemo;

import com.spring.mvcdemo.validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Customer {

	private String firstName;
	@jakarta.validation.constraints.NotNull(message="is required")
	@jakarta.validation.constraints.Size(min=1,message="is required")

	private String lastName;
	@NotNull(message="field is blank")
	@Min(value=1,message="atleast 1 pass is required")
	@Max(value=5,message="max 5 passes")
	private Integer freePasses;
	@NotNull
	@Pattern(regexp = "^[0-9]{6}",message="only six digit takes")
	private String postalCode;
	@CourseCode                        // custom annotation 
	private String courseCode;
	
	
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	


	
	
	
	
	
}
