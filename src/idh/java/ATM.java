package idh.java;

import java.io.BufferedReader;
import idh.java.BankAccount;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ATM {
	private int storage;
	//int cashintash = 200;
	public void Cashmashine() {
	storage = 5000;
	}

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	
	/*public static void BankingSystem() {
		BankAccount Dirk = new BankAccount("Dirk", 123, 2000);
		BankAccount Annette = new BankAccount("Annette", 321, 4000);
		//BankAccount[] bankAccounts = {Dirk, Annette};
		
		System.out.println("Pin: ");
		 Scanner check = new Scanner(System.in);
		  int pin = check.nextInt();  */
	}
	
	/*public void Pin_Check(int pin) {
		System.out.println("Pin: "); 
		Scanner check = new Scanner(System.in);
		 pin = check.nextInt();
		 int enteredpin = check.nextInt();
		 
		if (enteredpin == pin) {
			
			System.out.println("Hi, your Pin is correct! Now you can get your Mula!");
			ATM atm = new ATM();
			atm.run();
			
		}
		
		if (enteredpin != pin)
			System.out.println("Pin is incorrect, you dumbass!");
	} */
	
	
	
	public void run() {
		BankAccount Dirk = new BankAccount("Dirk", 123, 2000);
		BankAccount Annette = new BankAccount("Annette", 321, 4000);
		BankAccount[] bankAccounts = {Dirk, Annette};

	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println("Enter your Pinnumber:");
				BankAccount current = getBankAccountByPin(bankAccounts, Integer.parseInt(br.readLine()));
				 if (current == null) {
					 System.out.println("Pin was incorrect");
					 break;
				 }
				 int balance = 

				 }
				
				
				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	} 
	
	/*public void Customer (String[] args) {
		Customer Dirk = new Customer("Dirk", 123, 2000);
}
*/
	public void cashout(int amount ) {
		
		if (amount <= cashintash) {
			cashintash -= amount;
			System.out.println("Youre current balance is: " + cashintash);
		}
		else if (amount > cashintash){
			System.out.println("You´re to Broke!" + "\n" + "try again!");
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

	
	
	
	