package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {

		ATM atm = new ATM();
		atm.run();
	};

	int atmBalance = 10000;
	
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		Account a = new Account("Jasmin", "Druyen", 123, 400);
		Account b = new Account("Celine", "Druyen", 456, 200);
		Account c = new Account("Ute", "Druyen", 789, 1000);
		//Accounts in Array
		Account[] accounts = {a, b, c};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				//get AccountNumber
				System.out.print("Enter your account number: ");
				int accountnumber = Integer.parseInt(br1.readLine());
				Account enteredNumber = getAccountbyAccountNumber(accounts, Integer.parseInt(br.readLine()));
				if (enteredNumber == null) {
					System.out.println("Account number isn't valid!");
					break;
				}
				System.out.println("Account found!");
				
				
				//withdraw
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accounts, amount, accountnumber);
				
				// ceckAccountBalance ATM
				if (amount > atmBalance) {
					System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
					run(); 
				}
			} catch (Exception e) {
				break;
			}
		}
	}
	
	/**
	 * 
	 * @param accounts
	 * @param accountNumber
	 * @return null or account
	 */
	private Account getAccountbyAccountNumber(Account[] accounts, int accountNumber) {
		for (Account account : accounts) { // für jedes Object im Array account: nimmt Wert an bei jedem Durchlauf
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}

		return null;
	}

	private void cashout(Account[] accounts, int amount, int accountnumber) {
		
		switch (accountnumber) {
		case 123: {
			if (accounts[0].getAccountBalance() > amount) {
				accounts[0].setAccountBalance((accounts[0].getAccountBalance() - amount));
				atmBalance = atmBalance - amount;
				System.out.println("Ok, here you go!");
			} else {
				System.out.println("Sorry, you don't have enough money in the bank.");
			}
			break; 
		}
		case 456: {
			if (accounts[1].getAccountBalance() > amount) {
				accounts[1].setAccountBalance((accounts[1].getAccountBalance() - amount));
				atmBalance = atmBalance - amount;
				System.out.println("Ok, here you go!");
			} else {
				System.out.println("Sorry, you don't have enough money in the bank.");
			}
			break; 
		}
		case 789: {
			if (accounts[2].getAccountBalance() > amount) {
				accounts[2].setAccountBalance((accounts[2].getAccountBalance() - amount));
				atmBalance = atmBalance - amount;
				System.out.println("Ok, here you go!");
			} else {
				System.out.println("Sorry, you don't have enough money in the bank.");
			}
			break; 
		}
		default:
			System.out.println("ATM isn't working!");
			break;
		}

	};
}

