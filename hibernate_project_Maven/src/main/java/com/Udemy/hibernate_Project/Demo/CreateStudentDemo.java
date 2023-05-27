package com.Udemy.hibernate_Project.Demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class CreateStudentDemo {

	public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		
		// create session 
		
		Session  session=factory.getCurrentSession();
		
		try {
			Student  student=new Student("paul","smith","paul@gmail.com");
			
			
			// start a Transaction
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			session.close();
			factory.close();
		}
		
	}


		
		
		
	}


