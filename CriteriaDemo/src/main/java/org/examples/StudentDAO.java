package org.examples;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class StudentDAO {
	
	public void retrieveAll() {
		Session ses =  HBUtil.getSessionFactory().openSession();
		ses.beginTransaction();
		
		CriteriaBuilder cb = ses.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		
		cq.select(root);
		List<Student> list = ses.createQuery(cq).getResultList();
		list.forEach(System.out::println);
		ses.getTransaction().commit();
		ses.close();
		
		
	}
	
	public void retrieveOne() {
		Session ses =  HBUtil.getSessionFactory().openSession();
		ses.beginTransaction();
		
		CriteriaBuilder cb = ses.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		
		cq.select(root).where(cb.equal(root.get("id"), 2)); // id = 2
		Student st = ses.createQuery(cq).getSingleResult();
		System.out.println(st);
		
		ses.getTransaction().commit();
		ses.close();
	}
	
	//marks greater than 87
	public void retrieve() {
		Session ses =  HBUtil.getSessionFactory().openSession();
		ses.beginTransaction();
		
		CriteriaBuilder cb = ses.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.select(root).where(cb.greaterThan(root.get("marks"), 87));
		
		List<Student> list = ses.createQuery(cq).getResultList();
		list.forEach(System.out::println);
		ses.getTransaction().commit();
		ses.close();
		
	}

	public void retUsingAnd() {
		Session ses = HBUtil.getSessionFactory().openSession();
		ses.beginTransaction();
		
		CriteriaBuilder cb = ses.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		Predicate p1 = cb.equal(root.get("city"), "Madurai");
		Predicate p2 = cb.greaterThan(root.get("marks"), 76);
		cq.select(root)
			.where(cb.and(p1,p2));
		List<Student> list = ses.createQuery(cq).getResultList();
		list.forEach(System.out::println);
		ses.getTransaction().commit();
		ses.close();
		
	}
	
	public void retUsingLike() {
		Session ses = HBUtil.getSessionFactory().openSession();
		ses.beginTransaction();
		
		CriteriaBuilder cb = ses.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		
		cq.select(root)
			.where(cb.like(root.get("name"),"R%"));
		
		List<Student> list = ses.createQuery(cq).getResultList();
		list.forEach(System.out::println);
		ses.getTransaction().commit();
		ses.close();
		
	}
	
}
