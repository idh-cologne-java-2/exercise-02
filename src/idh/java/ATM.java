package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;


public class ATM {
	
int atmMoney = 500;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		int[] accountBalance = new int[999];
		for (int i = 0; i < accountBalance.length; i++) {
			Random random = new Random();
			accountBalance[i] = random.nextInt(1337);
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Geben sie ihre Kontonummer ein: ");
				int accountNumber = Integer.parseInt(br.readLine());
				if(accountNumber < 1000) {
					System.out.println("Ihr aktueller Kontostand beträgt " + accountBalance[accountNumber]+"€");
					System.out.print("Gib ein und ich gebe aus: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(amount, accountBalance, accountNumber);
				} else {
					System.out.println("Dieses Konto gibt es nicht");
					break;
				}
			
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, int[] accountBalance, int accountNumber) {
		if (amount <= atmMoney) {
			if (amount <= accountBalance[accountNumber]) {
				accountBalance[accountNumber] = accountBalance[accountNumber] - amount;
				atmMoney = atmMoney - amount;
				System.out.println("Ok, hier sind deine Moneten, genieße! \n");
			} else {
				System.out.println("Entschuldigung, du bist zu arm. \n");
			}
			
		} else {
			System.out.println("Entschuldigung, dieser Geldautomat is ärmer als du. \n");
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
