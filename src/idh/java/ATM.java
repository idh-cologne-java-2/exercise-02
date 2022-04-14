package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ATM {
	int accountBalance = 100;
	static List<Konto> konten = new ArrayList<>();

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
				System.out.print("Enter the account number: ");
				int kontoNummer = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				
				Konto konto = konten.get(kontoNummer);
				
				cashout(konto, amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(Konto konto, int amount) {
		
		if (amount < accountBalance && amount < konto.kontoInhalt) {
			accountBalance = accountBalance - amount;
			konto.kontoInhalt = konto.kontoInhalt - amount;
			System.out.println("Ok " + konto.name + ", here is your money, enjoy!");
		} else if (amount > accountBalance && amount < konto.kontoInhalt) {
			System.out.println("Sorry, not enough money in the ATM. Current maximum cashout: " + accountBalance);
		} else if (amount < accountBalance && amount > konto.kontoInhalt) {
			System.out.println("Sorry, not enough money on your account. Current balance of " + konto.name + ": " + konto.kontoInhalt);
		} else {
			System.out.println("Sorry, not enough money in the ATM and on your account.");
		}

	};
	

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		
		
		//ID = Kontonummer
		konten.add(new Konto("David Müller", 100)); //ID 0
		konten.add(new Konto("Peter Zwegard", 500)); //ID 1
		konten.add(new Konto("Nils Reiter", 1000)); //ID 2
		
		atm.run();
	};

}
