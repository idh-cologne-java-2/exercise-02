package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ATM {
	int atmBalance = 500; //Bargeldbestand des Automaten wird auf 500€ festgelegt

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		int[] accountBalance = new int[1000]; //1000 Konten werden erstellt (0-999) und jeweils mit bis zu 2000€ befüllt
		for (int i = 0; i < accountBalance.length; i++) {
			Random random = new Random();
			accountBalance[i] = random.nextInt(2000);
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				if (accountNumber < accountBalance.length) {
					System.out.print("Account Balance: " + accountBalance[accountNumber] + "€\t");
					System.out.println("ATM Balance: " + atmBalance + "€"); //Kontostand und Bargeldbestand des Automaten werden ausgegeben
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(accountNumber, accountBalance, amount);
				} else {
					System.out.println("Invalid account number\n"); //Alles außerhalb von 0-999 ist keine gültige Kontonummer
				}
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int accountNumber, int[] accountBalance, int amount) {
		if (amount <= atmBalance) {
			if (amount <= accountBalance[accountNumber]) {
				accountBalance[accountNumber] = accountBalance[accountNumber] - amount;
				atmBalance = atmBalance - amount;
				System.out.println("Ok, here you go!\n");
			} else {
				System.out.println("Sorry, you don't have enough money in the bank.\n");
			}
		} else {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.\n");
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
