package com.mapped;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	
	public static void main(String args[]) {
		Car car = new Car(4,"Tata",120000);
		
		Bike bike = new Bike(45,"Yamaha", 20000);
		
		Session session = HBUtil.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		session.persist(car);
		session.persist(bike);// to insert data into sql
		tr.commit();
		session.close();
				
	}

}
