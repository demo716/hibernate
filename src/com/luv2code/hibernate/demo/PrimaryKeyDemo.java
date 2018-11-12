package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create three student objects
			System.out.println("Creating 3 student objects...");
			Student Student1 = new Student("John", "Doe", "john@luv2code.com");
			Student Student2 = new Student("Mary", "Public", "mary@luv2code.com");
			Student Student3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");
			
			// start the transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the students...");
			session.save(Student1);
			session.save(Student2);
			session.save(Student3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
			
				
	}
}

