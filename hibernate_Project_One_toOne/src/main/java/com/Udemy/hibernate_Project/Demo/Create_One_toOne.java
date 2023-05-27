package com.Udemy.hibernate_Project.Demo;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Create_One_toOne {

	public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Instructor_Details.class).buildSessionFactory();

		
		// create session 
		
		Session  session=factory.getCurrentSession();
		
		try {
			
			
			// start a Transaction
			session.beginTransaction();
			
	     Instructor instructor=new Instructor("manav","ojha","manav@gmail.com");
			
			Instructor_Details details=new Instructor_Details("MAnavGAmer","Football");
			
			//associate the Object
			
			instructor.setInstructorDetail(details);
			// save the object
			// it will  save the Instructor_details object also due to cascading 
			System.out.println("Saving the Instructor --> "+instructor);
			session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
		
	}


		
		
		
	}


