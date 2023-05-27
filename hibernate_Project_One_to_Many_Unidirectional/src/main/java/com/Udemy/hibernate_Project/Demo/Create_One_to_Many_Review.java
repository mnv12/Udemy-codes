package com.Udemy.hibernate_Project.Demo;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Create_One_to_Many_Review {

	public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Review.class).addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Instructor_Details.class).buildSessionFactory();

		
		// create session 
		
		Session  session=factory.getCurrentSession();
		
		try {
			
			
			// start a Transaction
			session.beginTransaction();
			
	 Course course=new Course("Pacman how to know the scores");
	 
	 course.add(new Review("Great course "));
	 course.add(new Review("Awesome course "));		
	 course.add(new Review("Everyone take the course "));	
	 course.add(new Review("not Good as course "));	
			
	 //save the data 
	 System.out.println("Review it ");
	 session.save(course);
	 System.out.println("------THE END-------");
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			session.close();
			factory.close();
		}
		
	}


		
		
		
	}


