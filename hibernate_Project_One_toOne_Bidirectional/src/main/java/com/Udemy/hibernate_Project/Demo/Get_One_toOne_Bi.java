package com.Udemy.hibernate_Project.Demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Get_One_toOne_Bi {

	public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Instructor_Details.class).buildSessionFactory();

		
		// create session 
		
		Session  session=factory.getCurrentSession();
		
		try {
			
			
			// start a Transaction
			session.beginTransaction();
			int id=2;
	Instructor_Details insta=session.get(Instructor_Details.class, id);
	
	System.out.println("Instrutor detail bidirectional"+insta);
	//reterive the data
	System.out.println("get associated instructor"+insta.getInstructor());
			
		
			
		
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		
		catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		finally {
			
			session.close();
			factory.close();
		}
		
	}


		
		
		
	}


