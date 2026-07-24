package com.demo.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.entity.Student;
import com.demo.util.HBUtil;


public class StudentDAO {
	
	public long getTotalStudent() {
		
		Session ses = HBUtil.getSessionFactory().openSession();
		 ses.beginTransaction();
		 String hql = "select count(*) from Student";
		 long count = ses.createQuery(hql, Long.class).getSingleResult();
		 ses.getTransaction().commit();
		 ses.close();
		 return count;
		 
		 
	}

	
	public List<Student> getStudents(int page, int pageSize){
		Session ses = HBUtil.getSessionFactory().openSession();
		 ses.beginTransaction();
		 String hql = "from Student order by id";
		 
		 Query<Student> qry = ses.createQuery(hql, Student.class);
		 qry.setFirstResult((page - 1) * pageSize);
		 qry.setMaxResults(pageSize);
		 
		 List<Student> lists = qry.getResultList();
		 
		 
		 ses.getTransaction().commit();
		 ses.close();
		 return lists;
	}
}
