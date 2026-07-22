package com.joined;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mapped.HBUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Employee e = new Employee("Abinash");
RegEmployee re = new RegEmployee(50000, "Ram");
ContractEmployee ce = new ContractEmployee("Mano",1000,40);

Session session = HBUtil.getSessionFactory().openSession();
Transaction tr = session.beginTransaction();
session.persist(e);
session.persist(re);// to insert data into sql
session.persist(ce);
tr.commit();
session.close();

	}

}
