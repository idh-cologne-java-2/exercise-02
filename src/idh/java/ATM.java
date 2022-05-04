package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 100;
	

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		Account a = new Account();
		Account b = new Account();
		Account c = new Account();
		
		a.accounts(3333, 50);
		b.accounts(4444, 30);
		c.accounts(2222, 20);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println("First, enter your accountnumber please: ");
				int accnr = Integer.parseInt(br.readLine());
			if (accnr == a.getAccountnumber()){
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
				break;
			}
			else if (accnr == b.getAccountnumber()){
				System.out.println("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				if (amount <= b.getMoneyInAcc()) {
				cashout(amount);
			}	
				else  {
				System.out.print("Sorry, not enough Money in your Bankacc ");
				}	
				}
			else if (accnr == c.getAccountnumber()){
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
				break;
			}
			else {
				System.out.println("Something went wrong, try again: ");
				System.out.println("First, enter your accountnumber please: ");
				
				accnr = Integer.parseInt(br.readLine());
				
			}
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount) {
		if (amount < accountBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
