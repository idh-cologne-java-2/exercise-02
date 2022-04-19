package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 1000; //Wert des Gelbetrags im Automaten
	
	private Account a1 = new Account(434, 100); //Account Nummer 1
	private Account a2 = new Account(789, 15);  //Account Nummer 2
	Account[] accounts = {a1,a2}; //Array, welches die Accounts gemeinsam sammelt
	
	

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
				System.out.println("Enter account number:"); //Aufforderung eine Accountnummer einzugeben
				Account current = getAccountByAccountNo(accounts, Integer.parseInt(br.readLine()));
				if (current == null) {
					System.out.println("Account not found!");
					break; //Wenn ein nicht hinterlegter Accountname eingegeben wird, wird man nicht weitergeführt
				}  
				//System.out.println("Account found!");
					else {
				
				System.out.print("Enter the amount to withdraw: "); //Man wird dazu aufgefordert einen Betrag einzugeben
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, amount); }}
			 catch (Exception e) {
				break;
			}
		}
	}
	
	private Account getAccountByAccountNo(Account[] accounts, int accountNo) {
		
		for (Account account : accounts) {
			
			if(account.getAccountNo() == accountNo) {
				return account;
			}
		}
		return null;
	}  //Die eingegebenen Daten werden mit den hinterlegten verglichen
	
	
    

	public void cashout(int amount, int money) {
		if (amount > accountBalance) {
			System.out.println("not enough money!"); 
		} //Wenn ein zu hoher Betrag eingegeben wird, dann kommt der Hinweis, das zu wenig Geld vorhanden ist
			
	       else if (amount < accountBalance) { 
	    	   accountBalance -= amount ; 
			   System.out.print("here is your money, enjoy!");
					 
				} //Der Betrag wird abgezogen und es kommt der Hinweis, das man sein Geld erhalten hat
				
	
	}
	
	
	
	

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		
		
		ATM atm = new ATM();
		atm.run();
	};

}

/**
 * Bei der Eingabe der Accountnummer geht der Automat nicht automatisch weiter
 * 
 */
