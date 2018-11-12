package com.luv2code.hibernate.demo;

import java.util.List;

import javax.swing.plaf.synth.SynthSliderUI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;


public class UpdateEmployee {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Employee> theEmployee = session.createQuery("from Employee a where a.company='Vandelay Industries'").list();
			
			displayEmployees(theEmployee);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
			
		} finally {
			
			factory.close();
		}

	}
	private static void displayEmployees(List<Employee> theEmployees) {
		for (Employee tempEmployee : theEmployees) {
			System.out.println(tempEmployee);
		}
	}

}
