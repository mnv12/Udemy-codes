package com.Udemy.hibernate_Project.Demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Delete_One_toOne2 {

	public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Instructor_Details.class).buildSessionFactory();

		
		// create session 
		
		Session  session=factory.getCurrentSession();
		
		try {
			
			
			// start a Transaction
			session.beginTransaction();
			
	
			
			//associate the Object
			int theId=1;
			Instructor details=session.get(Instructor.class, theId);
			
			// save the object
			// it will  save the Instructor_details object also due to cascading 
			System.out.println("Deleting  the Instructor --> "+details);
			
			if(details!=null) {
			session.delete(details);
			}
			
		
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
		
	}


		
		
		
	}


