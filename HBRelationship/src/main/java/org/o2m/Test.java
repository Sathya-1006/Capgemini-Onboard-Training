package org.o2m;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.examples.HBUtil;

public class Test {

	public static void main(String[] args) {
		
	
		Student s1 = new Student("Ramesh", 23);
		Student s2 = new Student("Manoj",21);
		Student s3 = new Student("Vikram",20);
		Student s4 = new Student("Gugesh",22);
		
		
		Department d1 = new Department("IT");
		Department d2 = new Department("CSE");
		
		d1.addStudent(s1);
		d1.addStudent(s2);
		
		
		d2.addStudent(s3);
		d2.addStudent(s4);
		
		Session session = HBUtil.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		session.persist(d1);
		session.persist(d2);
		//session.persist(student);// to insert data into sql
		tr.commit();
		session.close();
		
		
		System.out.println("Data Inserted Successfully");
		
		StudentDAO dao = new StudentDAO();
		//dao.retrieve();
		//dao.delete();
		//dao.updateName(1, "Priya");
		dao.updateDept(2, "Guru", 48, 5);

	}
	
	

}
