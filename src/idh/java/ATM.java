package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	
	/**
	 * This list contains the balances of all the accounts the ATM offers access to.
	 */
	private int[] balance;
	
	/** A list of PIN numbers used to authenticate a user trying to log into an account before
	 * offering withdrawal.
	 */
	private int[] pin;
	
	/**
	 * The number of the account currently logged into the ATM.
	 */
	private int currentAccount;
	
	/**
	 * The total amount of cash the ATM has available. A user cannot withdraw more cash than the
	 * ATM can distribute.
	 */
	private int totalAvailable;
	
	/**
	 * Initializes the ATM, setting the totalAvailable field and parts of the two array fields.
	 */
	public ATM() {
		this.balance = new int[100];
		this.balance[0] = 5000;
		this.balance[1] = 1000;
		
		this.pin = new int[100];
		this.pin[0] = 1832;
		this.pin[1] = 9177;
		
		this.totalAvailable = 10000;
		
	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// The login loop.
		while (true) {
			System.out.println("Please enter your account number and your PIN.");
			System.out.println("Account number: ");
			
			/* 
			 * Initializes a temporary variable to save the account number entered into the
			 * ATM. If authentication succeeds, the object field "currentAccount" is set to
			 * this variable.
			 */
			int accNumber;
			while (true) {
				try {
					accNumber = Integer.parseInt(br.readLine());
					// This loop is only broken if no exception is thrown.
					break;
				} catch (Exception e) {
					System.out.println("Invalid input.");
				}
			}
			System.out.println("PIN: ");
			
			/*
			 * Authentication via PIN. The PIN entered is directly compared to the PIN corresponding
			 * to the number of the account entered prior.
			 */
			int enteredPIN;
			while (true) {
				try {
					enteredPIN = Integer.parseInt(br.readLine());
					// This loop is only broken if no exception is thrown.
					break;
				} catch (Exception e) {
					System.out.println("Invalid input.");
				}
			}
			if (enteredPIN == this.pin[accNumber]) {
				// Sets the object field "currentAccount" to the temporary variable.
				this.currentAccount = accNumber;
				System.out.println("Welcome to your ATM account.");
				break;
				// If authentication succeeds, the login loop is broken.
			}
			System.out.println("Your account number or PIN is incorrect.");
			// If authentication does not succeed, the login loop repeats.
		}
		while (true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
		return;
	}

	public void cashout(int amount) {
		if (amount > balance[this.currentAccount]) {
			/*
			 * This message is displayed if the user attempts to withdraw more money than
			 * their account stores.
			 */
			System.out.println("Sorry, your desired withdrawal exceeds your current balance.");
			return;
		} 
		else if (amount > this.totalAvailable) {
			/*
			 * This message is displayed if the user attempts to withdraw more money than
			 * the ATM has available.
			 */
			System.out.println("Sorry, this ATM does not have enough cash available to complete your desired withdrawal.");
			return;
		}
		balance[this.currentAccount] -= amount;
		System.out.println("Ok, here is your money, enjoy!");
	}

}
