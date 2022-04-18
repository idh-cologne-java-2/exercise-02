package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amina
 *
 */
public class ATM {
	int accountBalance; // kontostand
	int atmBalance = 500; // Bargeldbestand des automaten
	int newBalance;

	List<Account> accountList = new ArrayList<Account>(); // list of Accounts

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
				int accountNumber = Integer.parseInt(br.readLine()); // prompt for user input
				Account account = new Account(accountNumber);

				// check if element already exists in accountlist
				if (accountList.contains(account)) {
					int index = accountList.indexOf(account);
					accountBalance = accountList.get(index).getBalance();
//					System.out.println("balance if true: " + accountBalance); // nur zu Testzwecken
				}
				if (!accountList.contains(account)) {
//					System.out.println("false"); //nur zu Testzwecken
					account.setBalance(100); // default accountbalance
					accountBalance = account.getBalance();
					accountList.add(account); // add account with the given accountnumber to accountlist
				}

				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(account, amount, accountBalance);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(Account account, int amount, int accountBalance) {

		if (amount <= accountBalance && amount <= atmBalance) {
			newBalance = accountBalance - amount;
			atmBalance = atmBalance - amount;
			System.out.println("Ok, here is your money, enjoy! Your current balance is " + newBalance);
			account.setBalance(newBalance); //set new Balance for account
			updateAccount(account, newBalance); //pass values to update account in Accountlist
		} else if (amount > accountBalance) {
			System.out.println("Sorry, there's not enough money in your account.");
		} else if (amount > atmBalance)
			System.out.println("Sorry, the ATM doesn't have that much cash anymore.");

	};

	/**
	 * Updates Balance for account in the accountlist
	 * @param account account Object
	 * @param accountBalance passed new Balance 
	 */
	public void updateAccount(Account account, int accountBalance) {

		int index = accountList.indexOf(account); //get index of element account
		accountList.get(index).setBalance(accountBalance);// update balance of element in list
		accountList.set(index, account); // update element in list

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}