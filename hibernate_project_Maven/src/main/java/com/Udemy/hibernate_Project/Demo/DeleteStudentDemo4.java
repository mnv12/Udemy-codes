package com.Udemy.hibernate_Project.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo4 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session

		//Session session = factory.getCurrentSession();

		try {

//			int studentId = 1;
//
//			// start a Transaction
//			session.beginTransaction();
//
//			// Query students logic
//			System.out.println("Deleting the student ");
//			Student myStudent = session.get(Student.class, studentId);
//
//			session.delete(myStudent);
//			System.out.println("Done");
//			session.getTransaction().commit();

			

			// New Code query
		Session	session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery(" delete from Student where id=2 ").executeUpdate();

			System.out.println("query Sucessful");
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
