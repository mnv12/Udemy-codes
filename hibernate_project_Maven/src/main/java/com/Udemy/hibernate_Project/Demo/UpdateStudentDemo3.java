package com.Udemy.hibernate_Project.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo3 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			// start a Transaction
			session.beginTransaction();

			// Query students logic
			System.out.println("Updating the student ");
			Student myStudent = session.get(Student.class, studentId);

			myStudent.setFirstName("Scooby");

			session.getTransaction().commit();

			System.out.println("Done");

			// New Code
			session = factory.getCurrentSession();

			session.beginTransaction();
			System.out.println("Update email for Students");

			session.createQuery("update Student set email='manav@gmail.com'").executeUpdate();
			System.out.println("Update email done");
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
