package idh.java;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	int cash = 2000;

	
	
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	
//	public void login() {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		while(true) {
//			try {
//				System.out.print("Enter your pin: ");
//				int accountNumber = Integer.parseInt(br.readLine());
//				verification(accountNumber);
//			} catch (Exception e) {
//				System.out.println("Error");
//			}
//		}
//	}
	
	public void run() {
		
		Customer c1 = new Customer("Nathan", 001, 400);
		Customer c2 = new Customer("Simon", 002, 900);
		Customer c3 = new Customer("Flo", 003, 1000000);
		Customer[] customers = {c1,c2,c3};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.println("Enter your Acc. Number: ");
				Customer current = getCustomerByAccountNumber(customers, Integer.parseInt(br.readLine()));
				if (current == null) {
					System.out.println("Unfortunately this Account Number doesn't exist. Bye!");
					break;
				}
				int balance = current.getBalance();
				System.out.println("Hi " + current.getCustomer() + "! Currently you hodl " + balance + " Talers!");
			
				System.out.print("Enter the amount of Talers you'd like to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				
				balance = balance - amount;				
				
				if(balance > cash && balance > 0) {
					System.out.println("Too much Talers you ask for, there is only " + cash + " Talers left in this ATM.");
				} else if (balance >= 0) {
					cash = cash - amount;
					System.out.println("Your new balance is " + balance + " Talers. Cash Talers left in this ATM: " + cash); 
				} else {
					System.out.println("You cant withdraw that amount cuz u broke, bitch.");
				}
				
				
			} catch (Exception e) {
				System.out.println("Erroré :/");
				break;
			}
		}
	}
	
	private Customer getCustomerByAccountNumber(Customer[] customers, int accountNumber) {
		
		for (Customer customer : customers) {
			if(customer.getAccountNumber() == accountNumber) {
				return customer;
			}
		}
		return null;
	}
	
	
//	public void cashout(int amount) {
//		 
//		balance = balance - amount;	
//		String dialogue = balance >= 0 ? "Your current balance is: " + balance : " Can't withdraw Talers. Your bank account is allé :(";
//		System.out.println(dialogue);
//		
//	}
	
	
//	public void verification(int Number) {
//		
//		if (Number == 123) {
//			System.out.println("Enter the void.");
//			ATM atm = new ATM();
//			atm.run();
//		}
//	}
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		
		
		ATM atm = new ATM();
		//atm.login();
		atm.run();
	};
};