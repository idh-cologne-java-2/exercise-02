package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int accountBalance = 1000;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	User user1 = new User(123, 700);
	User user2 = new User(333, 5);
	User user3 = new User(777, 10000);
	int IDIndex;
	
	User[] userList = {user1, user2, user3};
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int number = Integer.parseInt(br.readLine());
				IDIndex = IDIndex(number);
				
				if(IDIndex != -1) {
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
				
					if(amount <= accountBalance) {
						cashout(amount);
					}
					else {
						System.out.println("Sorry, there's not enough money in the bank!");
						};
					
			}
				else { System.out.println("Wrong ID Number");};
				
			} catch (Exception e) {
				break;
			}
			
		}
	}

	public void cashout(int amount) {
		if (amount < userList[IDIndex].getCash()) {
			userList[IDIndex].setCash (userList[IDIndex].getCash() - amount);
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	};
	
	public int IDIndex(int number){
		 for (int i = 0; i < userList.length; i++) {
			 if(number == userList[i].getID()) {
				 return i;
			 }
		 }
		 return -1;
		
	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
