package com.Udemy.hibernate_Project.Demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo2 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {
			Student student = new Student("paul", "smith", "paul@gmail.com");

			// start a Transaction
			session.beginTransaction();

			// Query students logic

			List<Student> students = session.createQuery("from Student").list();

			DisplayName(students);
			// query students for lastName
			System.out.println("The LastMan on the Earth : \n");
			students = session.createQuery("from Student s where s.lastName='smith'").list();

			DisplayName(students);

			/// query students lastname or firstname

			students = session.createQuery("from Student s where" + " s.lastName='smith' OR s.firstName='paul'").list();

			System.out.println("Here is the Person : ");
			
			DisplayName(students);

			// query students where email id .com
			
			students=session.createQuery("from Student s where" + " s.email LIKE '%com'" ).list();
			
			System.out.println("Here is the Email ");
			
			DisplayName(students);
			
			
			
			
			// comit transaction
			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			factory.close();
		}

	}

	private static void DisplayName(List<Student> students) {
		for (Student tempStudents : students) {

			System.out.println("LastName is : " + tempStudents);

		}
	}

}
