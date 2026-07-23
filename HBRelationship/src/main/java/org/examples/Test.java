package org.examples;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.examples.HBUtil;

public class Test {

	public static void main(String[] args) {
		
		IdCard idCard = new IdCard("NEC1U54232");
		Student student = new Student("Ramesh", idCard);
		
		Session session = HBUtil.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		//session.persist(idCard);
		session.persist(student);// to insert data into sql
		tr.commit();
		session.close();

	}
	
	

}
