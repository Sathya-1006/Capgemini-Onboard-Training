package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
	public double getBalance(Connection con, int account_no) throws Exception{
		String qry ="select balance from account where account_no = ?";
		PreparedStatement pst = con.prepareStatement(qry);
		pst.setInt(1, account_no);
		ResultSet rs = pst.executeQuery();
		
		if(rs.next())
			return rs.getDouble(1);
		return 0;
		
	}
	
	public void updateBalance(Connection con, int account_no,double balance) throws Exception{
		String qry = "update account set balance = ? where " + "account_no = ?";
		
		PreparedStatement pst = con.prepareStatement(qry);
		pst.setDouble(1, balance);
		pst.setInt(2, account_no);
		pst.executeUpdate();
		
	}
	
	public void saveTransaction(Connection con, int from, int to, double amount) throws Exception {
		String qry = "insert into transaction(from_account, to_account,amount) values(?,?,?)";
		
		PreparedStatement pst = con.prepareStatement(qry);
		
		pst.setInt(1, from);
		pst.setInt(2, to);
		pst.setDouble(3, amount);
		pst.executeUpdate();
		
	}
}
