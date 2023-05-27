package com.multiple_table.Springboot_CRUD.ENtity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="instructor_detail")

public class instructor_details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id ;
	@Column(name = "youtube_channel")
	private String youtubeChannnel;
	@Column(name = "hobby")
	private String hobby;
	
	@OneToOne(mappedBy = "instructorDetail" , cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})// mappedbY tells hiibernate check the 
	//instructorDetail property in the Instructor class use information from the instructor class @joicoloumn
	// to help find associate instructor
	
	private Instructor instructor;
	public instructor_details() {
		
	}
	
	public instructor_details(String youtubeChannnel, String hobby) {
		super();
		this.youtubeChannnel = youtubeChannnel;
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYoutubeChannnel() {
		return youtubeChannnel;
	}
	public void setYoutubeChannnel(String youtubeChannnel) {
		this.youtubeChannnel = youtubeChannnel;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	
	
}
