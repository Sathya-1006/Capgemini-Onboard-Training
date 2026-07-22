import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Example1 {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Sathya@123");
			Statement st = con.createStatement();
			//String qry = "insert into account(id,Name, Balance)" + "values(112,'Mohana',7000),(113,'Preethi',90000),(114,'Sathya',17000)";
			
//			String qry = "delete from account where id = 112";
			String qry = "update account set Balance = 8090 where id = 114";
			
			int res = st.executeUpdate(qry);
			if(res > 0)
				System.out.println(res + " no of rows affected..");
				con.close();
				
			
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
