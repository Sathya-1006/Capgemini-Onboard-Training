package com.dao;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Customer;
import com.entity.Orders;
import com.util.HBUtil;

public class CustomerDAO {

	public void saveCustomer() {

		Session session = HBUtil.getSessionFactory().openSession();

		Transaction tr = session.beginTransaction();

		// Create Customer
		Customer customer = new Customer(101, "Rahul", "9876543210");

		// Create Orders
		Orders o1 = new Orders(1, LocalDate.of(2026, 7, 23), 1500);
		Orders o2 = new Orders(2, LocalDate.of(2026, 7, 24), 2500);
		Orders o3 = new Orders(3, LocalDate.of(2026, 7, 25), 3500);
		Orders o4 = new Orders(4, LocalDate.of(2026, 7, 26), 4500);

		// Set Customer for each Order
		o1.setCustomer(customer);
		o2.setCustomer(customer);
		o3.setCustomer(customer);
		o4.setCustomer(customer);

		// Add Orders to Customer
		customer.getOrders().add(o1);
		customer.getOrders().add(o2);
		customer.getOrders().add(o3);
		customer.getOrders().add(o4);

		// Save Customer (Orders will be saved automatically)
		session.persist(customer);

		tr.commit();

		session.close();

		System.out.println("Customer and 4 Orders Saved Successfully.");
	}
}