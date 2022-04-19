package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalanceAntje = 100;
	int accountBalanceHerbert = 50;
	int accountBalanceMaria = 4000;
	int inventory = 5000;

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

				}

					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(amount);
			 catch(Exception e){
						break;
					}

			}
		}
	}
	/*Asks for an Account ID. Then checks accountbalance and atm inventory. A little messy, but the best
	 * I could do at the moment. Might revisit if I find the time
	 */
	public void UserID() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in);
		System.out.println("Enter Account details");
		int Antje = 123;
		int Herbert = 666;
		int Maria = 420;
		if (Integer.parseInt(br.readLine())) ; =Antje ){


			public int cashoutAntje ( int amount){
				if (amount < accountBalanceAntje) {
					accountBalanceAntje = accountBalanceAntje - amount;
					inventory = inventory - amount;
					if(amount > inventory) {
					System.out.println("this atm is empty, please try another one");
					}
					else {
						System.out.println("Ok, here is your money, enjoy!");
						return inventory;
					}
				 else {
					System.out.println("Sorry, not enough money in the bank.");
				}

			}
			;
		}
		else if ( Integer.parseInt(br.readLine()); =Herbert){
			public int cashoutHerbert ( int amount){
				if (amount < accountbalanceHerbert) {
					accountBalanceHerbert = accountBalanceHerbert - amount;
					inventory = inventory - amount;
					if (amount > inventory) {
					   System.out.println("this atm is empty, please try another one");
					}
					else{

					System.out.println("Ok, here is your money, enjoy!");
					return inventory;
				  else {
					System.out.println("Sorry, not enough money in the bank.");
				}

			}
			;
		}
		else if ( Integer.parseInt(br.readLine()); =Maria){
			public int cashoutMaria ( int amount){
				if (amount < accountbalanceMaria) {
					accountBalanceMaria = accountBalanceMaria - amount;
					inventory = inventory - amount;
					if (amount > inventory){
						System.out.println("this atm is empty, please try another one");
					}
					else {
						System.out.println("Ok, here is your money, enjoy!");
					}
				  else {
					System.out.println("Sorry, not enough money in the bank.");
				}
			}
		}

		else {
		System.out.println("Incorrect Login Data");
		}
	}
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.UserID();
		atm.run();
	};

}
