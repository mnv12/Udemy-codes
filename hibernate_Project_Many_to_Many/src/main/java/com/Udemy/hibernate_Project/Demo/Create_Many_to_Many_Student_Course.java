package com.Udemy.hibernate_Project.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Create_Many_to_Many_Student_Course {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Review.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor_Details.class).buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			// start a Transaction
			session.beginTransaction();

			// course data

			Course course = new Course("How to increase your Immunity");
//			
			// Course course2=new Course("Learn Code In 6 Months");
//			
			session.save(course);
			// session.save(course2);
//			
//			
//			//Student data

			Student student = new Student("Jenifer", "Lopez", "jenifer@gmail.com");

			Student student2 = new Student("Ravi", "kisan", "ravi@gmail.com");

			course.addStudent(student);
			course.addStudent(student2);

			session.save(student);
			session.save(student2);

			System.out.println("Students" + course.getStudents());
			// System.out.println("other Students"+course2.getStudents());

			System.out.println("Student Registration sucess");
			// delete data

//int theId=18;
//Course course3 = session.get(Course.class, theId);

//session.delete(course3);
			// session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			session.close();
			factory.close();
		}

	}

}
