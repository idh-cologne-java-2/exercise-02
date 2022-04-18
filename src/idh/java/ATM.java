package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int cash = 1000;

	int[] accountNumber = new int[] { 1122, 2233, 4455, 6677 };
	int[] accountBalance = new int[] { 150, 200, 400, 1000 };


	/**
	 * Main command loop of the ATM Asks the user to enter an account number and
	 * then a number, and passes this number to the function cashout(...) which
	 * actually does the calculation and produces money. If the user enters anything
	 * else than an integer number, the loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("The following account numbers exist: 1122, 2233, 4455, 6677");
		
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int number = Integer.parseInt(br.readLine());
				int index = -1;
				for (int i = 0; i < accountNumber.length; i++) {
					if (number == accountNumber[i]) {
						index = i;
					}
				}
				if (index != -1) {
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

		if (cash >= amount) {
			if (amount <= accountBalance[index]) {
				accountBalance[index] = accountBalance[index] - amount;
				cash = cash - amount;
				System.out.println("Ok, here you go!");
			} else {
				System.out.println("Sorry, you don't have enough money in the bank.");
			}
		} else {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
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
