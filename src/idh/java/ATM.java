package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance;
	int cash = 250;
	int account1= 100;
	int account2 = 50;
	int account3 = 200;
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int account = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				boolean valid = checkaccount(account, amount);
				if (valid != true) {
				run();	
				}
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public boolean checkaccount (int account, int amount) {
	if (account == 123) {
		 accountBalance = account1;
		account1 = account1 - amount;
		 return true;
	}
	else if (account == 234) {
		accountBalance = account2;
		account2 = account2 - amount;
		return true;
	}
	else if (account == 345) {
		accountBalance = account3;
		account3 = account3 - amount;
		return true;
	}
	else {
		System.out.println("Sorry, your account number is not valid.");	
		return false;
	}
	}
	public void cashout(int amount) {
		if (amount <= accountBalance && amount <= cash) {
			accountBalance = accountBalance - amount;
			cash = cash - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else if (amount > cash) {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore");
		}
		else {
			System.out.println("Sorry, not enough money in the bank.");
		}
		System.out.println(cash);
		System.out.println(accountBalance);
	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();	
		atm.run();
	};

}
