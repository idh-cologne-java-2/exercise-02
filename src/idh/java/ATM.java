package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class ATM {
	int[] accountBalance = {100,20,40}; //geld position wie users aufgeteilt.
	int balanceATM = 90;

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run(List<Integer> users) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int found = 0;
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int user = Integer.parseInt(br.readLine());
				
				if(users.indexOf(user) == -1) {
					System.out.println("Falscher Account!");
					run(users);
				}else {
					found = users.indexOf(user);; //ändern für position
				}
				
					
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount, found);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, int person) {
		if(amount > balanceATM) {
			System.out.println("Sorry, the ATM does't have that much cash anymore.");
		}else {
			if (amount < accountBalance[person]) {
				accountBalance[person] = accountBalance[person] - amount;
				balanceATM -= amount;
				System.out.println("Ok, here is your money, enjoy!");
			} else {
				System.out.println("Sorry, you don't have enough money in the bank.");
			}
		}
	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		
		List<Integer> users = new ArrayList<Integer>(3); //könnte auch über eine Klasse mit dem kontostand zusammen in einer Klasse implementiert werden.
		users.add(123);
		users.add(234);
		users.add(345);
		
		atm.run(users);
	};

}
