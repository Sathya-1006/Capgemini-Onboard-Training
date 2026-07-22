package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Test {
 public static void main(String args[]) {
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Sathya@123");
		 
		 String qry = "call getEmpCount(?)";
		 CallableStatement cst = con.prepareCall(qry);
		 ///type of output parameter
		 cst.registerOutParameter(1,Types.INTEGER);
		 
		// cst.setInt(1, 5);
		 cst.executeUpdate();
		 int result = cst.getInt(1);
		 System.out.println("Result "+result);
		 con.close();
		 
		 
	 }catch(SQLException e) { e.printStackTrace();}
	 catch(ClassNotFoundException e) {e.printStackTrace();}
 }
}
