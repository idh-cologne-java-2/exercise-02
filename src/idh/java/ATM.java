package idh.java;

import java.io.*;

public class ATM {
	   int zaster = 69;
	   int geldspeicher = 50;
	   
	   
	   
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print("Geben sie hier den gewünschten Betrag ein: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				break;
			}
		}
	}

	
	public void cashout(int amount) {
		
		if ( geldspeicher >= amount ) {
			
			if (amount <= zaster) {
			zaster -= amount;
			geldspeicher -= amount;
			System.out.println("Sie haben "+ amount+ "€ abgehoben");
			System.out.println("Ihr Kontostand beträgt jetzt "+ zaster + "€");
					} 
		
		
		else if (amount > zaster){
			System.out.println("Ihr Kontostand ist zu niedrig um "+ amount + "€ auszugeben");
			System.out.println("Ihr Kontostand beträgt "+ zaster + "€");
		}
		
	
		/*
	 	else {
			System.out.println("Ihr Kontostand ist zu niedrig um "+ amount + "€ auszugeben");
			System.out.println("Ihr Kontostand beträgt "+ zaster + "€");
		}*/
	}
	
		else {
			System.out.println("Dieser Geldautomat verfügt nicht über die nötigen Kapazitäten");
		}
	}
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
};