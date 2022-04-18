package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	//int accountBalance = 100; brauchen wir hier nicht, da wir verschiedene Accounts mit verschiedenen balances haben
	private int ATMBalance = 2000; //Bargeld des ATMs
	
	//verschiedene Konten mit Id, balance und Name; siehe Class Accounts
	private Accounts a = new Accounts(123, 50, "Ali Barber"); 
	private Accounts b = new Accounts(345, 500, "Cecil Dieder");
	private Accounts c = new Accounts(567, 5000, "Emil Feger"); 

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
				System.out.print(" Please Enter your Account Id:  "); //Nutzer soll seine Id eingeben
				int currentId = Integer.parseInt(br.readLine()); //die Id die im Reader im inputStream wird an die Variable currentId übergeben
				if(currentId != a.Id && currentId != b.Id && currentId != c.Id) { //currentId wird mit den Ids der Accounts abgeglichen
					System.err.println("\n Sorry Wrong Id. Try again with a different Id "); //Nachricht wenn die Id nicht vorhanden ist (in roter Schrift)
					run(); 
				}
					
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount , currentId);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, int currentId) {
			if( amount > ATMBalance) { //der cashout amount wird mit dem Bargeld des ATMs verglichen
				System.err.print("Sorry, the ATM doesn't have that much cash anymore."); 
			} else {
				switch(currentId) { //switch Statement für den jeweiligen Account
				case 123:  //case = Account id
					if (amount > a.balance) { //wenn nicht genug Geld auf dem Account ist
						System.err.print("Sorry, not enough money your account. \n");
						break ; 
					}
					a.balance -= amount; //Geld wird vom Kontostand abgezogen
					ATMBalance -= amount ; //Geld wird vom ATM Bargeld abgezogen
					System.out.print("Ok, here is your money, enjoy!" + " \nNow your balance is " + a.balance);
					break ; 
				case 345: 
					if (amount > b.balance) {
						System.err.print("Sorry, not enough money your account. \n");
						break ; 
					}
					b.balance -= amount; 
					ATMBalance -= amount ; 
					System.out.print("Ok, here is your money, enjoy!" + " \nNow your balance is " + b.balance);
					break ; 
				case 567: 
					if (amount > c.balance) {
						System.err.print("Sorry, not enough money your account. \n");
						break ; 
					}
					c.balance -= amount; 
					ATMBalance -= amount ; 
					System.out.print("Ok, here is your money, enjoy!" + " \nNow your balance is " + c.balance);
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

}
