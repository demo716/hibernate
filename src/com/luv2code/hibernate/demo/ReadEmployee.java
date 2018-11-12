package com.luv2code.hibernate.demo;

import javax.swing.plaf.synth.SynthSliderUI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;


public class ReadEmployee {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a new employee
			System.out.println("Creating a new employee");
			Employee newEmployee = new Employee("Elaine", "Benes", "The J.Peterman Company");
			
			//start the transaction
			session.beginTransaction();
			
			//save the employee object
			session.save(newEmployee);
			
			session.getTransaction().commit();
			
			//retrieve based on key
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Employee myEmployee = session.get(Employee.class, newEmployee.getId());
			System.out.println("Get complete: " + myEmployee);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
			
		} finally {
			
			factory.close();
		}

	}

}
