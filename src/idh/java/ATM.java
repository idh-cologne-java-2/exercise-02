package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	public int atmcash = 50;
	
	public static void main(String[] args) {

		ATM atm = new ATM();
		atm.run();

	};

	
	public void run() {
		
		Accounts a123 = new Accounts(123, 200);
		Accounts a234 = new Accounts(234, 500);
		Accounts a345 = new Accounts(345, 50);
		Accounts[] accounts = {a123, a234, a345};
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				//get Kontonummer 
				System.out.print("Enter your account number: ");
				int accountnumber= Integer.parseInt(bfr.readLine());
				Accounts current = getAccountnumber(accounts, accountnumber);
				if(current == null) {
					System.out.println("Sorry, we don´t know this account number!");
					break;
				}
				// get withdraw
				System.out.print("Enter the amount to withdraw: ");
				int amount= Integer.parseInt(bfr.readLine());
				if(amount > atmcash) {
					System.out.println("Sorry we don´t have enough cash!");
					run();
				}
				cashout(accounts, amount, accountnumber);
				
			} catch (Exception e) {
				System.out.println("Please enter numbers!");
				break;
			}
		}
		
	};
	
	public static Accounts getAccountnumber(Accounts[] accounts, int accountnumber) {
		for(Accounts account : accounts) {
			if(account.getKontoNummer() == accountnumber) {
				return account;
			}
		}

		return null;
		
	}
	
    
	//hier wird dann je nach Kontonummer und Kontostand das Geld ausgegeben
    //außerdem wird  der kontostand minimiert und der Cashspeicher des ATMS
    
    
	public void cashout(Accounts[] accounts, int amount, int accountnumber) {	
		
		switch(accountnumber) {
			case (123): {
				if(accounts[0].getAccountBalance() > amount) {
					accounts[0].setAccountBalance((accounts[0].getAccountBalance() - amount));
					atmcash = atmcash - amount;
					System.out.println("Ok, here is your money, enjoy!");
		
				}
				else {
					System.out.println("Sorry, you don't have enough money in the bank.");
				}
				break;
			}
			case (234): {
				if(accounts[1].getAccountBalance() >= amount) {
				   accounts[1].setAccountBalance((accounts[1].getAccountBalance() - amount));
				   atmcash = atmcash - amount;
				   System.out.println("Ok, here is your money, enjoy!");
				}
				else {
					System.out.println("Sorry, you don't have enough money in the bank.");
				}	
				break;
			}
			case (345): {
				if(accounts[2].getAccountBalance() >= amount) {
				   accounts[2].setAccountBalance((accounts[2].getAccountBalance() - amount));
				   atmcash = atmcash - amount;
				   System.out.println("Ok, here is your money, enjoy!");
				}
				else {
					System.out.println("Sorry, you don't have enough money in the bank.");
				}	
				break;
			}
			
		}
	}; 
};