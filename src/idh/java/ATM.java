package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ATM {
	
	//Solution of jorinehatake
	
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	
	// initializing variables
	
	int accountBalance1 = 2000;
	int accountBalance2 = 500;
	int accountBalance3 = 6969;
	
	
	private Account LEON = new Account(187, "Leon Werner", 6969);
	private Account JORINE = new Account(606, "Jorine Twint", 1870);
	private Account LUSCH = new Account(123, "Lusch Schreib", 5040);
	int cashInATM = 10000;
	
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				
				System.out.print("Enter your account number: ");
				int currentAccountNumber = Integer.parseInt(br.readLine());
				
				if(currentAccountNumber != LEON.getAccountID() && currentAccountNumber != JORINE.getAccountID() && currentAccountNumber != LUSCH.getAccountID()) {
					System.err.println("\n You entered a Account ID that doesnt exist. Please Try again:");
					run(); 
				}
				
				
				System.out.println("Correct Account ID, please enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, currentAccountNumber);
				
				
			} catch (Exception e) {
				break;
			}
		}
	}
	
	
	
	public void cashout(int amount, int currentAccountNumber) {
		
		
		if( amount > cashInATM ) { //check if the ATM has enough money to cash out the typed in amount.
			
			System.out.println("Sorry, this ATM has not enough money. Try again with a lower Cashout amount.");
			run();
		}
		else {
			switch(currentAccountNumber) {
			
			
			case 187:  //creating cases for the accounts we've created, Leon 
				if (amount > LEON.getAccountBalance()) {
					System.err.print("Sorry, there is not enough money in your Account " + LEON.accountName + "." );
					break ; 
				}
				LEON.setAccountBalance(LEON.getAccountBalance() - amount); 
				cashInATM -= amount ; 
				System.out.println("Thank you for cashing out " + amount + ". You now have "+ LEON.getAccountBalance() + " € left. \n");
				break ; 

				
			case 606:  //creating cases for the accounts we've created, now for Jorine
				if (amount > JORINE.getAccountBalance()) {
					System.err.print("Sorry, there is not enough money in your Account " + JORINE.accountName + "." );
					break ; 
				}
				JORINE.setAccountBalance(JORINE.getAccountBalance() - amount); 
				cashInATM -= amount ; 
				System.out.println("Thank you for cashing out " + amount + ". You now have "+ JORINE.getAccountBalance() + " € left. \n");
				break ; 

			case 123:  //creating cases for the accounts we've created, now for Lusch
				if (amount > LUSCH.getAccountBalance()) {
					System.err.print("Sorry, there is not enough money in your Account " + LUSCH.accountName + "." );
					break ; 
				}
				LUSCH.setAccountBalance(LUSCH.getAccountBalance() - amount); 
				cashInATM -= amount ; 
				System.out.println("Thank you for cashing out " + amount + ". You now have "+ LUSCH.getAccountBalance() + " € left. \n");
				break ; 

			}	
				
				
		}	
			
	
		
	};
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
};