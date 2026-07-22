package com.tpc;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mapped.HBUtil;

public class Test {
	
	public static void main(String args[]) {
		
		Vehicle v= new Car(6,"tata nexon", 890000);
		Vehicle v1= new Bike(45,"Maruti", 70000);
		
		Session session = HBUtil.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		session.persist(v);
		session.persist(v1);// to insert data into sql
		tr.commit();
		session.close();
	}

}
