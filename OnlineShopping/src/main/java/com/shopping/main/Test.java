package com.shopping.main;

import com.shopping.dao.ProductDAO;

public class Test {

	public static void main(String[] args) {

		ProductDAO dao = new ProductDAO();

	//	dao.displayProducts();
	//	dao.updateWarranty(1, 5);
		dao.deleteClothing(2);

	}

}