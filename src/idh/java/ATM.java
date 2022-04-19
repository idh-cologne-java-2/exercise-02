package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 1000;
	
	public int bargeldbestand = 420;
	
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		
		Accounts a123 = new Accounts(123, 40);
		Accounts a456 = new Accounts(456, 80);
		Accounts a789 = new Accounts(789, 120);
		Accounts[] accounts = {a123, a456, a789};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println("Enter your ID-number: ");
				int idnumber = Integer.parseInt(br.readLine());
				Accounts current = getidnumber(accounts, idnumber);
				
				if(current == null) {
					System.out.println("This ID is unknown!");
					break;
				}
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				
				if(amount > bargeldbestand) {
					System.out.println("Sorry, the ATM doesn´t have that amount of cash anymore.");
					run();
				}
				cashout(accounts, amount, idnumber);
				
			} catch(Exception e ) {
				break;
			}
		}
	};

	public static Accounts getidnumber(Accounts[] accounts, int idnumber) {
		for(Accounts account : accounts) {
			if(account.getAccountNo() == idnumber) {
				return account;
			}
		}
		
		return null;
	}
	public void cashout(Accounts[] accounts, int amount, int idnumber) {
		
		switch(idnumber) {
		case(123): {
			if(accounts[0].getAccountNo() > amount) {
			   accounts[0].setAccountNo((accounts[0].getAccountNo() - amount));
				bargeldbestand = bargeldbestand - amount;
				System.out.println("Ok, here you go!");
			}
			else {
				System.out.println("Sorry, you don't have enough money in your account!");
			}
			break;
		}
		case(456): {
			if(accounts[1].getAccountNo() >= amount) {
			   accounts[1].setAccountNo((accounts[1].getAccountNo() - amount));
				bargeldbestand = bargeldbestand - amount;
				System.out.println("Ok, here you go!");
			}
			else {
				System.out.println("Sorry, you don't have enough money in your account!");
			}
			break;
		}
		case(789): {
			if(accounts[2].getAccountNo() >= amount) {
			   accounts[2].setAccountNo((accounts[2].getAccountNo() - amount));
			   bargeldbestand = bargeldbestand - amount;
			   System.out.println("Ok, here you go!");
			}
			else {
				System.out.println("Sorry, you don't have enough money in your account!");
			}
			break;
		}
		}
	};
}
