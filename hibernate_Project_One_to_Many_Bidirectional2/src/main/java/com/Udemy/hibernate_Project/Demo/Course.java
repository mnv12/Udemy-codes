package com.Udemy.hibernate_Project.Demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")

public class Course {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private int id;
	@Column(name="title")
	private String titles;
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instra;

	
	public Course() {
		
		
		
	}
	
	
	public Course( String title) {
		
		this.titles= title;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return titles;
	}

	public void setTitle(String title) {
		this.titles = title;
	}

	public Instructor getInstructor() {
		return instra;
	}

	public void setInstructor(Instructor instructor) {
		this.instra = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + titles + ", instructor=" + instra + "]";
	}


	
	
	
}
