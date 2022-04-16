package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int cash = 100;

	int[] accountNumber = new int[] { 1234, 3847, 3920, 7923};
	int[] accountBalance = new int[] { 100, 200, 300, 400};

	/**
	 * Main command loop of the ATM Asks the user to enter an account number and then a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int number = Integer.parseInt(br.readLine());
				int index = -1;
				for(int i=0; i < accountNumber.length; i++) {
					if(number == accountNumber[i]) {
						index = i;
					}
				}
				if(index != -1) {
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(index, amount);
				}
			} catch (Exception e) {
				break;
			}
		}
	}
	
	public void cashout(int index, int amount) {
		

		if ( cash >= amount) {	
			if(amount <= accountBalance[index]) {
				accountBalance[index] = accountBalance[index] - amount;
				cash = cash - amount;
				System.out.println("Ok, here is your money, enjoy!");
			}
			else {
				System.out.println("Sorry, you don't have enough money!");
			}
		}
		else {
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
