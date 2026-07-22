package bank;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBcon {
	private static final String URL ="jdbc:mysql://localhost:3306/bankdb";
	private static final String UNM = "root";
	private static final String PWD = "Sathya@123";
	
	public static Connection getConn() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL,UNM,PWD);
	}
	
}
