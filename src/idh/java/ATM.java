package idh.java;

import java.io.*;

public class ATM {
	
	//Solution of jorinehatake
	
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}
	
	int accountBalance = 2000;
	
	public void cashout(int amount) {
		if( amount <= accountBalance ) {
			System.out.println("Ok,here is your money");
			accountBalance = accountBalance-amount;
		}
		else {
			System.out.println("Sorry, not enough money in the bank. ");
		}
	};
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
};