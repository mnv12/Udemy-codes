package com.Udemy.hibernate_Project.Demo;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Create_One_to_Many {

	public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Instructor_Details.class).buildSessionFactory();

		
		// create session 
		
		Session  session=factory.getCurrentSession();
		
		try {
			
			
			// start a Transaction
			session.beginTransaction();
			
	     Instructor instructors=new Instructor("Shalia","Rojen","rojen@gmail.com");
			
			Instructor_Details details=new Instructor_Details("Pubg","YoutubeStreaming");
			
			//associate the Object
			
			instructors.setInstructorDetail(details);
			// save the object
			// it will  save the Instructor_details object also due to cascading 
			System.out.println("Saving the Instructor --> "+instructors);
			session.save(instructors);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
		
	}


		
		
		
	}


