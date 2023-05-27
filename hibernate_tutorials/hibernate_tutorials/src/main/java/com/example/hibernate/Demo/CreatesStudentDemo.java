package com.example.hibernate.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class CreatesStudentDemo {

	public static void main(String[] args) {
		
		
		
SessionFactory factory=new Configuration().configure("cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		
		// create session 
		
		Session  session=factory.getCurrentSession();
		
		try {
			Student  student=new Student(1, "paul","smith","smit@gmail.com");
			
			
			// start a Transaction
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
		
		
	}
	
	
}
