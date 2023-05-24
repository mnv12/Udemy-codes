package com.TODO.List.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "FullName")
	
	private String fullName;
	@Column(name = "Tasks")

	private String task;
	@Column(name = "Remarks")
	private String remarks;
	@Column(name = "Date")

	private String lastSeen;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Login taskss;

	public Login getTaskss() {
		return taskss;
	}

	public void setTaskss(Login taskss) {
		this.taskss = taskss;
	}

	public String getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(String lastSeen) {
		this.lastSeen = lastSeen;
	}

	public User() {

	}

	public User(String fullName, String task, String remarks, String lastSeen) {
		super();
		this.fullName = fullName;
		this.task = task;
		this.remarks = remarks;
		this.lastSeen = lastSeen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", task=" + task + ", remarks=" + remarks + "]";
	}

}
