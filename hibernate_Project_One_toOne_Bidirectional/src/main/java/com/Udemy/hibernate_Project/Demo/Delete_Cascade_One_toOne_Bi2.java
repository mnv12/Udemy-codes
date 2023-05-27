package com.Udemy.hibernate_Project.Demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Delete_Cascade_One_toOne_Bi2 {

	public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Instructor_Details.class).buildSessionFactory();

		
		// create session 
		
		Session  session=factory.getCurrentSession();
		
		try {
			
			
			// start a Transaction
			session.beginTransaction();
			int id=3;
	Instructor_Details insta=session.get(Instructor_Details.class, id);
	
	System.out.println("delete detail bidirectional"+insta);
	
			// delete the data 
	
	//breaking the link b/w instructor class and instructor details(bi directional link)
	insta.getInstructor().setInstructorDetail(null);
	session.delete(insta);
		
		
		
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


