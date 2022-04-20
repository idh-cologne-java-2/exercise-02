package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ATM {
	Map<Integer, Integer> bank_accounts = new HashMap<>();
	int atm_balance = 1500;


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
				int account_nbr = Integer.parseInt(br.readLine());
				boolean account_valid = check_account(account_nbr);

				if (account_valid) {
					withdraw(account_nbr);
				} else {
					System.out.println("No bank account found with account number: " + account_nbr);
				}

			} catch (Exception e) {
				break;
			}
		}
	}

	/**
	 * Check if bank account number exists
	 *
	 * @param account_nbr The customers bank account number
	 * @return Returns true if account is valid
	 */
	public boolean check_account(int account_nbr) {

		return bank_accounts.containsKey(account_nbr);
	}

	/**
	 * Withdraw money from ATM
	 *
	 * @param account_nbr The customers bank account number
	 */
	public void withdraw(int account_nbr) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				boolean cashout_successful = cashout(account_nbr, amount);

				if (cashout_successful) {
					break;
				}

			} catch (Exception e) {
				break;
			}
		}
	}

	/**
	 * Gives customer the desired amount of money and updates customer and ATM balances
	 *
	 * @param account_nbr The customers bank account number
	 * @param amount The amount of money the customer wants to withdraw
	 * @return Returns true if operation was successful
	 */
	public boolean cashout(int account_nbr, int amount) {
		int account_balance = bank_accounts.get(account_nbr);

		if (!check_atm_balance(amount)) {
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");
			return false;
		}

		if (amount <= account_balance) {
			int new_balance = account_balance - amount;
			bank_accounts.put(account_nbr, new_balance);
			atm_balance = atm_balance - amount;
			System.out.println("Ok, here is your money, enjoy!");
			return true;
		} else {
			System.out.println("Sorry, not enough money in the bank.");
			return false;
		}

	};

	/**
	 * Check if ATM has enough money
	 *
	 * @param withdraw_amount The ammount the customers wants to withdraw
	 * @return Returns true if ATM has enough money
	 */
	public boolean check_atm_balance(int withdraw_amount) {
		return atm_balance - withdraw_amount >= 0;
	}

	/**
	 * Initialize bank accounts with hardcoded amounts of money
	 */
	public void init_accounts() {
		bank_accounts.put(12345, 1000);
		bank_accounts.put(67890, 750);
	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.init_accounts();
		atm.run();
	};

}
