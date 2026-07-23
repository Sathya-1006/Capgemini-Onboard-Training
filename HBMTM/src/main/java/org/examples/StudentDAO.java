package org.examples;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.examples.HBUtil;

public class StudentDAO {

		public void save() {
			Session session = HBUtil.getSessionFactory().openSession();
			Transaction tr = session.beginTransaction();
			
			Course java = new Course("Java");
			Course spring = new Course("Spring");
			
			Student rahul = new Student("Rahul");
			Student amit = new Student("Amit");
			
			
			rahul.addCourse(java);
			rahul.addCourse(spring);
			amit.addCourse(java);
			
			session.persist(rahul);
			session.persist(amit);
			session.getTransaction().commit();
			session.close();
			
			
		}
		
		public void retrieve() {
			Session session = HBUtil.getSessionFactory().openSession();
			Transaction tr = session.beginTransaction();
			
			Student st = session.get(Student.class, 1);
			System.out.println("Name" + st.getName());
			for(Course c : st.getCourses()) {
				System.out.println("Course "+c.getCourseId() + c.getCourseName());
			}
			
			session.getTransaction().commit();
			session.close();
			}
		
		
		public void retrieveC() {
			Session session = HBUtil.getSessionFactory().openSession();
			Transaction tr = session.beginTransaction();
			
			Course c = session.get(Course.class, 2);
			System.out.println("Course name" + c.getCourseName());
			for(Student s : c.getStudents()) {
				System.out.println("Student " + s.getName());
			}
			
			session.getTransaction().commit();
			session.close();
			}
		
		public void delete(int studentId) {

		    Session session = HBUtil.getSessionFactory().openSession();
		    Transaction tr = session.beginTransaction();

		    Student student = session.get(Student.class, studentId);

		    if (student != null) {
		        for (Course course : student.getCourses()) {
		            course.getStudents().remove(student);
		        }

		        student.getCourses().clear();

		        session.remove(student);

		        tr.commit();
		        System.out.println("Student Deleted Successfully");

		    } else {
		        System.out.println("Student Not Found");
		        tr.rollback();
		    }

		    session.close();
		}
		
		public void update(int studentId, String newName) {

		    Session session = HBUtil.getSessionFactory().openSession();
		    Transaction tr = session.beginTransaction();

		    Student student = session.get(Student.class, studentId);

		    if (student != null) {

		        student.setName(newName);

		        tr.commit();

		        System.out.println("Student Updated Successfully");

		    } else {

		        System.out.println("Student Not Found");
		        tr.rollback();

		    }

		    session.close();
		}
}

