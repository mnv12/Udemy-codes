package com.Udemy.hibernate_Project.Demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Primary_Key_demo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {
			Student student = new Student("paul", "smith", "paul@gmail.com");
			Student student1 = new Student("krishna", "mhabharat", "hello@gmail.com");
			Student student2 = new Student("Rama", "gupta", "rama@gmail.com");
			Student student3 = new Student("Kalyug", "hell", "kurbani@gmail.com");

			// start a Transaction
			session.beginTransaction();
			// save the data
			session.save(student);
			session.save(student1);
			session.save(student2);// not good approach
			session.save(student3);
			session.getTransaction().commit();

			// reterive the data
			session = factory.getCurrentSession();

			session.beginTransaction();
			Student student4 = session.get(Student.class, student.getId());
			System.out.println("Getting an ID: "+student4);
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			factory.close();
		}

	}

}
