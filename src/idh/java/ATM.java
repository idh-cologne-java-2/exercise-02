package idh.java;
//package b;

import java.io.*;

public class ATM {

	
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * Wie war das nochmal mit this?
		 * System.out.println("This is b.ATM.class: " + b.ATM.class);
		 * System.out.println("This is b.ATM.class: " + this.getClass());
		 */
		while(true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				double amount = Double.parseDouble(br.readLine());
				cashout(amount);
			} catch (Exception ex) {
				System.out.println("Bitte keine Buchstaben!");
				continue;
			}
		}
	}
	
	/**
	 * Ach die verdammten Javadoc-Sachen...
	 * Die Menge an Geld die der Benutzer auf dem Konto hat.
	 */
	double balance = 200.0;
	
	
	
	/**
	 * @param amount ist die Menge an Geld die der Benutzer am Geldautomaten
	 * abheben möchte.
	 */
	
	
	public void cashout(double amount) {
		
		if((amount <= balance && balance > 0) && amount > 0) {
			balance -= amount;
			System.out.println("here is your " + amount + " Euros");
		} else {
			System.out.println("You do not have enought money in the bank! You don't hate mondays you hate capitalism!");
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


//package idh.java;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class ATM {
//	int accountBalance = 100;
//
//	/**
//	 * Main command loop of the ATM Asks the user to enter a number, and passes this
//	 * number to the function cashout(...) which actually does the calculation and
//	 * produces money. If the user enters anything else than an integer number, the
//	 * loop breaks and the program exists
//	 */
//	public void run() {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		while (true) {
//			try {
//				System.out.print("Enter the amount to withdraw: ");
//				int amount = Integer.parseInt(br.readLine());
//				cashout(amount);
//			} catch (Exception e) {
//				break;
//			}
//		}
//	}
//
//	public void cashout(int amount) {
//		if (amount < accountBalance) {
//			accountBalance = accountBalance - amount;
//			System.out.println("Ok, here is your money, enjoy!");
//		} else {
//			System.out.println("Sorry, not enough money in the bank.");
//		}
//
//	};
//
//	/**
//	 * Launches the ATM
//	 */
//	public static void main(String[] args) {
//		ATM atm = new ATM();
//		atm.run();
//	};
//
//}
