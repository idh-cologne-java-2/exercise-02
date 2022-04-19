package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	private int storage = 3000;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	
	
	// Ich habe leider keine Lösung dafür gefunden den Kontostand der Kunden auf die nächste Abbuchung zu übertragen :(
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
				 int cashintash = current.getCashintash();
				 System.out.println("Hi " + current.getName() + ". currently you have: " + cashintash + " €");

				
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				
				cashintash = cashintash - amount;
				
				if(cashintash > storage) {
					System.out.println("you have to withdraw less");
				} else if (cashintash >= 0) {
					storage = storage - amount;
					System.out.println("Your new balance: " + cashintash + " €. There are " + storage + " € left in this ATM.");
				} else {
					System.out.println("you´re too broke or there is not enough money left :(");
				}
				
			} catch (Exception e) {
				break;
			}
		}
	} 
	
	
	private BankAccount getBankAccountByPin(BankAccount[] bankAccounts, int pin) {
		
		for(BankAccount BankAccount : bankAccounts) {
			if(BankAccount.getPin() == pin) {
				return BankAccount;
			}
		}
		return null;
	}
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
	

}

	
	
	
	