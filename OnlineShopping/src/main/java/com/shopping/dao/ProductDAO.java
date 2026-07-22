package com.shopping.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shopping.entity.Product;
import com.shopping.entity.Clothing;
import com.shopping.entity.Electronics;
import com.shopping.entity.Furniture;
import com.shopping.util.HibernateUtil;

public class ProductDAO {

	public void saveProduct(Product product) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.persist(product);

		transaction.commit();

		session.close();

		System.out.println("Product Saved Successfully...");
	}
	
	public void displayProducts() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		System.out.println("-------- Electronics --------");

		session.createQuery("from Electronics", Electronics.class)
				.list()
				.forEach(System.out::println);

		System.out.println("\n-------- Clothing --------");

		session.createQuery("from Clothing", Clothing.class)
				.list()
				.forEach(System.out::println);

		System.out.println("\n-------- Furniture --------");

		session.createQuery("from Furniture", Furniture.class)
				.list()
				.forEach(System.out::println);

		session.close();
	}
	
	
	public void updateWarranty(int id, int years) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Electronics electronics = session.get(Electronics.class, id);

		if (electronics != null) {

			electronics.setWarrantyYears(years);

			session.merge(electronics);

			System.out.println("Warranty Updated Successfully.");

		} else {

			System.out.println("Electronics Product Not Found.");

		}

		transaction.commit();

		session.close();
	}
	
	public void deleteClothing(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Clothing clothing = session.get(Clothing.class, id);

		if (clothing != null) {

			session.remove(clothing);

			System.out.println("Clothing Deleted Successfully.");

		} else {

			System.out.println("Clothing Not Found.");

		}

		transaction.commit();

		session.close();
	}

}