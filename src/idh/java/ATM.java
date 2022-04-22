package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ATM {
	int currentBalance = 200;
	Scanner sc = new Scanner(System.in);
	
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

	
	
	
	public void cashout(int amount) {
		
		//int withdraw = sc.nextInt();
		if (currentBalance >= amount) {
					
					//the account is balanced, money can be removed 
					currentBalance = currentBalance - amount;
					System.out.println("Ok, here is your money, enjoy!");
					System.out.println("Your new balance is " + currentBalance);
				} 
				else {
					//show error message if there's not enough money
					System.out.println("Sorry, not enough money in the bank.");
				}
				System.out.println("");
	};
	
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
};