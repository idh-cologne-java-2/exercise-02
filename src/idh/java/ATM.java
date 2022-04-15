package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	int accountBalance = 2500;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		System.out.print("Enter your account number: ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	/**
	 * User enter an amount of money he/she wants to withdraw.
	 * If there is enough money in the bank, the user gets the money he/she wanted to withdraw.
	 * If the user wants to withdraw more money than he/she has, the user will be informed.
	 * It is possible that there is not enough money in the bank, if that is the case the user will be informed too.
	 * @param amount
	 */
	public void cashout(int amount) {
		
		if (amount < accountBalance) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here you go.");
		} else {
			System.out.println("Sorry, you don't have enough money.");
			
		}  if (amount >= 1000) {
			accountBalance = accountBalance - amount;
			System.out.println("Sorry, the ATM doesn't have that much money.");
		}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	}
}

