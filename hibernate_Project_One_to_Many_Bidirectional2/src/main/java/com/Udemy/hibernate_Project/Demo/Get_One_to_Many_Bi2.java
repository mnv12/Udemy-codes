package com.Udemy.hibernate_Project.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Get_One_to_Many_Bi2 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(Instructor_Details.class).buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			// start a Transaction
			session.beginTransaction();
			int id = 3;
			Instructor_Details insta = session.get(Instructor_Details.class, id);

			System.out.println("Instrutor detail bidirectional" + insta);
			// reterive the data
			System.out.println("get associated instructor" + insta.getInstructor());
			// get the data of courses list
			int getId = 3;
			Instructor get = session.get(Instructor.class, getId);

			System.out.println(" List of the courses : \n  " + get.getCourses());

			// reteive data from course class
			int theId = 10;
			Course reteerive = session.get(Course.class, theId);

			System.out.println("from course data " + reteerive);
			session.getTransaction().commit();

			System.out.println("Done");

		}

		catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			session.close();
			factory.close();
		}

	}

}
