package com.hibernate.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sun.org.apache.bcel.internal.classfile.Field;

public class HibernateTest {

	public static void main(String[] args) {
		
		File file = new File("D:/JAVA/Hibernate/Student1/src/main/resources/download.jpg");
		byte[] bimg = new byte[(int)file.length()];
		try {
			FileInputStream fio = new FileInputStream(file);
			fio.read(bimg);
			fio.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
	
		
	
		
		Student std = new Student();
		
		std.setSid(1003);
		std.setSname("Abhishek");
		std.setGender("Male");
		std.setAge(25);
		std.setDOB(new Date());
		std.setImage(bimg);
		Address addr1 = new Address();
		addr1.setStreet("14 Main");
		addr1.setCity("Delhi");
		addr1.setState("Delhi");
		addr1.setPincode("110022");
		std.setHomeAddress(addr1);
		Address addr2 = new Address();
		addr2.setStreet("14 Cross");
		addr2.setCity("Bangalore");
		addr2.setState("Karnataka");
		addr2.setPincode("256633");
		std.setOfficeAddress(addr2);
		
		
		SessionFactory factory =  new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(std);
		session.getTransaction().commit(); 
		session.close();
	}

}
