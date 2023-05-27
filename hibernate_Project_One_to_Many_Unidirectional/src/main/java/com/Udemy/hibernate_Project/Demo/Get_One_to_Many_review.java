package com.Udemy.hibernate_Project.Demo;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Get_One_to_Many_review {

	public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Review.class).addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Instructor_Details.class).buildSessionFactory();

		
		// create session 
		
		Session  session=factory.getCurrentSession();
		
		try {
			
			
			// start a Transaction
			session.beginTransaction();
			int theId=1;
			
			Review review=session.get(Review.class, theId);
			
			System.out.println("Get the Review data --->>>"+review.getComment());
			
	  
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			session.close();
			factory.close();
		}
		
	}


		
		
		
	}


