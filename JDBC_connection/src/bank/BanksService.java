package bank;

import java.sql.Connection;

public class BanksService {
	AccountDAO dao = new AccountDAO();
	
	public void transferMoney(int from, int to, double amount) {
		Connection con = null;
		try {
			con = DBcon.getConn();
			con.setAutoCommit(false);
			double fromBal = dao.getBalance(con, from);
			double toBal = dao.getBalance(con, to);
			if(fromBal < amount) {
				throw new Exception("Insufficient funds");
				
			}
			dao.updateBalance(con, from, fromBal - amount);
			dao.updateBalance(con, to, toBal + amount);
			dao.saveTransaction(con, from, to, amount);
			
			con.commit();
			System.out.println("Transaction Completed");
			
			
		}catch(Exception e) {
			try {
				if(con != null) {
					con.rollback();
				}
				
			}catch(Exception ee) {}
			
			System.out.println("Transaction Failed");
			System.out.println(e.getMessage());
		}
	}
}
