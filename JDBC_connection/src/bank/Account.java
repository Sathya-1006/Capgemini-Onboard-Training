package bank;

public class Account {
	private int account_no;
	private double balance;
	
	public Account(int account_no, double balance) {
		super();
		this.account_no = account_no;
		this.balance = balance;
	}

	public int getAccount_no() {
		return account_no;
	}

	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account() {
		
	}
	
}
