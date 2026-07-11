package banking.app;

import banking.exceptions.DailyLimitExceededException;
import banking.exceptions.InSufficientBalanceException;
import banking.exceptions.InvalidAccountException;
import banking.exceptions.InvalidAmountException;

public class BankAccount {
	
	private int accountNumber;
	private String accountHolder;
	private double balance;
	
	static final double DAILY_LIMIT=50000;

	public BankAccount(int accountNumber, String accontHolder, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accontHolder;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccontHolder() {
		return accountHolder;
	}

	public void setAccontHolder(String accontHolder) {
		this.accountHolder = accontHolder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
public void deposit(double amount) throws InvalidAmountException{
	if(amount <= 0) 
		throw new InvalidAmountException("Deposit amount must be greater than 0");
		
		balance += amount;
		System.out.println("Deposit Successfull");
		System.out.println("Current Balance is "+balance);
		
	
	
	
}

public void withdraw(double amount) throws InvalidAmountException, InvalidAccountException, DailyLimitExceededException, InSufficientBalanceException{
	if(amount < 0) {
		throw new InvalidAmountException("Withdraw amount must be greate than 0");
	}
	if(amount > DAILY_LIMIT) {
		throw new DailyLimitExceededException("Daily limit exceeded");
	}
	if(amount > balance) {
		throw new InSufficientBalanceException("Insufficient balance");
	}
	
	balance += amount;
	System.out.println("Withdraw of Rs. "+ amount + " Successfull");
	System.out.println("Current Balance is "+balance);

}


public void transfer(BankAccount receiver, double amount) throws InvalidAmountException, InvalidAccountException, DailyLimitExceededException, InSufficientBalanceException{
	
	withdraw(amount);
	receiver.balance += amount;
	System.out.println("Transfer Successful");
}

public void display() {
	System.out.println("---------------------------------------------------");
	System.out.println("Account No "+accountNumber +"\n Account Holder: " + accountHolder+ "\n Balance: "+balance);
}

	
	
}
