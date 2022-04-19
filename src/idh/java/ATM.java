package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int[] accountBalance = {4000, 4000, 4000};
	int[] Account = {1234, 5678, 4321};
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
				System.out.println("Enter your account number: ");
				int number = Integer.parseInt(br.readLine());
				
				if (number == 1234 || number == 5678 || number == 4321) {
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(number, amount);
				}
				else {
					System.out.println("This account does not exist.");
					break;
				}
			} catch (Exception e) {
				break;
			}
		}
	}
		
		
	
	public void cashout(int number, int amount) {
		if (amount < accountBalance[number]) {
			accountBalance[number] = accountBalance[number] - amount;
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
