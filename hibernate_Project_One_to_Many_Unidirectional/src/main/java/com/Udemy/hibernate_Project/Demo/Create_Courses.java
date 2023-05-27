package com.Udemy.hibernate_Project.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Create_Courses {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Review.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Instructor_Details.class).buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			// start a Transaction
			session.beginTransaction();
			int id = 3;
			Instructor instance = session.get(Instructor.class, id);

			Course cour = new Course("Spanish");

			Course course2 = new Course("German");

			instance.add(cour);
			instance.add(course2);

			session.save(cour);
			session.save(course2);

			session.getTransaction().commit();

			System.out.println("Done");

		} finally {

			session.close();
			;
			factory.close();
		}

	}

}
