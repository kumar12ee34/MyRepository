package com.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		
		Student std = new Student();
		
		std.setSid(1003);
		std.setSname("Abhishek");

		Address addr1 = new Address();
		addr1.setStreet("14 Main");
		addr1.setCity("Delhi");
		addr1.setState("Delhi");
		addr1.setPincode("110022");
	
		Address addr2 = new Address();
		addr2.setStreet("14 Cross");
		addr2.setCity("Bangalore");
		addr2.setState("Karnataka");
		addr2.setPincode("256633");
		
		std.getListOfAddresses().add(addr1);
		std.getListOfAddresses().add(addr2);
		
		
		SessionFactory factory =  new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(std);
		session.getTransaction().commit(); 
		session.close();
	}

}
