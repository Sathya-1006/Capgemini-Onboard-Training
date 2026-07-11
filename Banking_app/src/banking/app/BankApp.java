package banking.app;

import java.util.Scanner;

import banking.exceptions.DailyLimitExceededException;
import banking.exceptions.InSufficientBalanceException;
import banking.exceptions.InvalidAccountException;
import banking.exceptions.InvalidAmountException;

public class BankApp {

	public static void main(String[] args) {
		Scanner obj=new Scanner(System.in);
		Bank bank=new Bank();
		bank.addAccount(new BankAccount(102, "Sam", 80000));
		bank.addAccount(new BankAccount(103, "Ram", 60000));
		bank.addAccount(new BankAccount(104, "AG", 5000));
		
		try {
			System.out.println("Enter Sender account Number: ");
			int sender = obj.nextInt();
			System.out.println("Enter Receiver account Number: ");
			int receiver = obj.nextInt();
			System.out.println("Enter Transfer amount: ");
			int amount = obj.nextInt();
			
			BankAccount senderObj = bank.searchAccount(sender);
			BankAccount receiverObj = bank.searchAccount(receiver);
			
			senderObj.transfer(receiverObj, amount);
			senderObj.display();
			receiverObj.display();
	
		}
		
		catch(InvalidAmountException am) {
			System.err.println(am.getMessage());
		}
		catch(InSufficientBalanceException in) {
			System.err.println(in.getMessage());
		}
		
		catch(InvalidAccountException ina) {
			System.err.println(ina.getMessage());
		}
		catch(DailyLimitExceededException d) {
			System.err.println(d.getMessage());
		}
	}
}
