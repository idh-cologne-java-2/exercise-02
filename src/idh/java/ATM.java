package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ATM {
	
	private int ATMBalance = 2000; 
	private Konten N = new Konten(1234, "Niklas Brudde", 500); 
	private Konten P = new Konten(4321, "john Locke" , 700 );
	private Konten S = new Konten(5678, "Silvia gebrüll", 1300); 

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
				System.out.print(" Please Enter your Account ID:  "); 
				int currentID = Integer.parseInt(br.readLine());
				if(currentID != N.ID && currentID != P.ID && currentID != S.ID) {
					System.err.println("\n Sorry Wrong ID please Try again .. ");
					run(); 
				}
					
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount , currentID);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount , int currentID) {
		if( amount > ATMBalance) {
			System.err.print("Sorry there is not enough money in the ATM"); 
		} else {
			switch(currentID) {
			case 1234: 
				if (amount > N.MoneyBalance) {
					System.err.print("Sorry you dont habe enough Money in your Bank account \n");
					break ; 
				}
				N.MoneyBalance -= amount; 
				ATMBalance -= amount ; 
				System.out.print("crazy man you cashed out " + amount + " you have "+ N.MoneyBalance + " $ left. \n");
				break ; 
			case 4321: 
				if (amount > P.MoneyBalance) {
					System.err.print("Sorry you dont habe enough Money in your Bank account \n");
					break ; 
				}
				P.MoneyBalance -= amount; 
				ATMBalance -= amount ; 
				System.out.print("crazy man you cashed out " + amount + " you have "+ P.MoneyBalance + " $ left. \n");
				break ; 
			case 5678: 
				if (amount > S.MoneyBalance) {
					System.err.print("Sorry you dont habe enough Money in your Bank account \n");
					break ; 
				}
				S.MoneyBalance -= amount; 
				ATMBalance -= amount ; 
				System.out.print("crazy man you cashed out " + amount + " you have "+ S.MoneyBalance + " $ left. \n");
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
