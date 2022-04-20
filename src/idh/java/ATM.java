package idh.java;

import java.io.*;


public class ATM {
	
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	

	
	public void run() {
		
		UserArray[0] = User1;
		UserArray[1] = User2;
		UserArray[2] = User3;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print("Enter your account ID: ");
				int InputID = Integer.parseInt(br.readLine());
				activeIndex = FindAccountIndex(InputID);
				
				if (activeIndex != -1) {
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					
					if (amount <= amountOfCash) {
						cashout(amount); 
						
					}
					
					else {
						System.out.print("Sorry, not enough money in the ATM.");
					}
				}
	
				else {
					System.out.print("This account doesn't exist. Please try again.");
				}
				
			} catch (Exception e) {
				break;
			}
		}
	}
	
	
	
	public int FindAccountIndex (int InputID) {
		
		for(int i = 0; i < UserArray.length; i++ ) {
			
			if (UserArray[i].getuserID() == InputID) {
				
				return i;	
				
			}
			
		}
		
		return -1;
		
	}
	

	int amountOfCash = 1000;
	user User1 = new user(22, 100);
	user User2 = new user(5, 5000);
	user User3 = new user(10, 1);
	
	user UserArray[] = new user[3];
	
	int activeIndex;  
	
	
	
	public void cashout(int amount) {
		if (amount <= UserArray[activeIndex].getuserBalance()) {
			System.out.println("Ok, here is your money, enjoy!");
			UserArray[activeIndex].setuserBalance(UserArray[activeIndex].getuserBalance() - amount);
			amountOfCash -= amount;
		} 
		
		else {
			System.out.println("Sorry, not enough money in the bank");
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
