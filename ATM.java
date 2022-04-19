package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ATM {
	
	int atm = 100;
	int accountBalance;
	static ArrayList<Konto> a = new ArrayList<Konto>();

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
				int number = Integer.parseInt(br.readLine());
				for(Konto k : a) {
					if (number == k.accountNumber) {
						accountBalance = k.getAccountBalance();
					}
				}
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount) {
		if (amount <= accountBalance && amount <= atm) {
			accountBalance = accountBalance - amount;
			atm = atm - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else if (amount > accountBalance) {
			System.out.println("Sorry, not enough money in the bank.");
		} else if (amount > atm) {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
		}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		
		Konto one = new Konto(123, 100);
		Konto two = new Konto(234, 100);
		Konto three = new Konto(345, 100);
		
		a.add(one);
		a.add(two);
		a.add(three);
		
		atm.run();
	};

}
