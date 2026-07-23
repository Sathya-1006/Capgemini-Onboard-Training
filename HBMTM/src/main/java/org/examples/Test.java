package org.examples;

public class Test {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
	//	dao.save();
//		dao.retrieve();
//		System.out.println("-------------------------");
//	dao.retrieveC();
//	dao.delete(2);
	dao.update(1, "Vismaya");
	}

}
