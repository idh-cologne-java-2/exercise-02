package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance;
	int cashReserveATM = 1000;

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
				int accountNumber = Integer.parseInt(br.readLine());
				user(accountNumber);
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount) {
		if (amount <= accountBalance && amount <= cashReserveATM) {
			accountBalance = accountBalance - amount;
			cashReserveATM = cashReserveATM - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else if (amount <= accountBalance && amount > cashReserveATM){
			cashReserveATM = 1000;
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
		} else {
			System.out.println("Sorry, you don't have enough money in the bank.");
		}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
	
	public void user(int accountNumber) throws Exception {
		switch(accountNumber) {
		case 123: accountBalance = 100;
		break;
		case 456: accountBalance = 1000;
		break;
		default: System.out.println("Sorry, we don't have that account number registered.");
		throw new Exception("Invalid account number");
		}
	}

}
