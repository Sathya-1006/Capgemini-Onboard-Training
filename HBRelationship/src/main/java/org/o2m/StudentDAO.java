package org.o2m;

import org.o2m.HBUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {
	public void retrieve() {
		
		Session session = HBUtil.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		
		Department d = session.get(Department.class, 1);
		for(Student s: d.getStudents()) {
			System.out.println(s.getRoll()+ s.getName()+s.getAge());
			
		}
	
		session.getTransaction().commit();
		session.close();
	
	}
	
	public void delete() {
		Session session = HBUtil.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		
		Department d = session.get(Department.class, 1);
		session.remove(d);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void updateName(int roll, String name) {
	    Session session = HBUtil.getSessionFactory().openSession();
	    Transaction tr = session.beginTransaction();
	    Student student = session.get(Student.class, roll);
	    if(student != null) {
	        student.setName(name);
	        tr.commit();
	    } else {
	        tr.rollback();
	        System.out.println("Student not found.");
	    }

	    session.close();
	}
	
	public void updateDept(int roll, String name, int age, int deptId) {

		Session session = HBUtil.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		Student student = session.get(Student.class, roll);

	    if (student != null) {

	        student.setName(name);
	        student.setAge(age);

	        Department dept = session.get(Department.class, deptId);

	        if (dept != null) {
	            student.setDepartment(dept);
	        }

	        System.out.println("Student Updated Successfully");

	    } else {
	        System.out.println("Student Not Found");
	    }

	    tr.commit();
	    session.close();
	}

}
