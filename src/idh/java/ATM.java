package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	User user1 = new User(123, 400);
	User user2 = new User(111, 50);
	User user3 = new User(224, 80);
	User[] userList = {user1, user2, user3};
	
	int accountBalance = 500;

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
				System.out.print("Enter your account number: ");
				int number = Integer.parseInt(br.readLine());
				User nameUser = numberStorage(number);
				if(nameUser == null) {
					run();
				}	
				while (true) {
					try {
						System.out.print("Enter the amount to withdraw: ");
						int amount = Integer.parseInt(br.readLine());
						cashout(amount, nameUser);
						break;
					} catch (Exception e) {
						break;
					}
				}
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, User user) {
		if (amount <= user.getCashAmount() && amount <= accountBalance) {
			user.setCashAmount(user.getCashAmount() - amount);
			accountBalance -= amount;
			System.out.println("Ok, here is your money, enjoy!");
			System.out.println(user.getCashAmount());
			System.out.println(accountBalance);
		} else {
			System.out.println("Sorry, not enough money in the bank.");
		}

	}
	
	public User numberStorage(int userNumber) {
		for(User u : userList) {
			if(userNumber == u.getAccountNumber()) {
				return u;
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
	}

}
