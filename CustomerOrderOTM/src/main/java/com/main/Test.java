package com.main;

import com.dao.CustomerDAO;

public class Test {

	public static void main(String[] args) {

		CustomerDAO dao = new CustomerDAO();

		dao.saveCustomer();

	}

}
