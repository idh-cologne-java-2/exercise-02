package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int moneyATM = 10000;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	
	int IDindex;
	
	Users user1 = new Users(11, 100);
	Users user2 = new Users(12, 400);
	Users user3 = new Users(13, 15); 

	Users userList[] = {user1, user2, user3};
	
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println("Enter ID");
				int ID = Integer.parseInt(br.readLine());
				IDindex = accountingIndex(ID);
				
				if (IDindex != -1) {System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());		
					if (amount < moneyATM) {
						cashout(amount);
					}
					else {System.out.println("not enough money in the ATM");
				}}
				else {System.out.println("wrong ID");}
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount) {

		if (amount < userList[IDindex].getBalance() ) {
			userList[IDindex].setBalance (userList[IDindex].getBalance() - amount);
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}
		

	};

	public int accountingIndex(int ID) {

		for (int i = 0; i < userList.length; i++) {
			if (ID == userList[i].getID()) {
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
