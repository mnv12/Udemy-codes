package com.spring.mvcdemo;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
private String country;

private LinkedHashMap<String, String> hashMap;


private String favouritelanguage;

private String[] operatingSystem;


public String[] getOperatingSystem() {
	return operatingSystem;
}



public void setOperatingSystem(String[] operatingSystem) {
	this.operatingSystem = operatingSystem;
}



public Student() {
	
	hashMap=new LinkedHashMap<>();
	
	hashMap.put("US", "United States");
	hashMap.put("IN", "India");
	hashMap.put("UK", "England");
	hashMap.put("BR", "Brazil");
	
	
	
}



	public LinkedHashMap<String, String> getHashMap() {
	return hashMap;
}

public void setHashMap(LinkedHashMap<String, String> hashMap) {
	this.hashMap = hashMap;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}



	public String getFavouritelanguage() {
		return favouritelanguage;
	}



	public void setFavouritelanguage(String favouritelanguage) {
		this.favouritelanguage = favouritelanguage;
	}



	
	
	
}
