package com.Udemy.hibernate_Project.Demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")

public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "title")
	private String titles;
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "instructor_id")
	private Instructor instra;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private List<Review> review;
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name="student_id"))// other side of table (inverse)
	private List<Student> students;

	public void addStudent(Student thestudent) {

		if (students == null) {

			students = new ArrayList<Student>();
		} else {
			students.add(thestudent);

		}
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public void add(Review theReview) {

		if (review == null) {

			review = new ArrayList<Review>();

		}
		review.add(theReview);

	}

	public Course() {

	}

	public Course(String title) {

		this.titles = title;

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
