package idh.java;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class ATM {
	int ATMBalance = 10000;
	int i;

	ArrayList<UserAccount> users = new ArrayList<UserAccount>();
	
	// Error, da users noch keinen index hat. Index i (i = 0) ist nicht möglich)
	int accountBalance = users.get(i).getAccountBalance();

//	UserAccount user1 = new UserAccount(1834, "2681");
//	UserAccount user2 = new UserAccount(26738, "7321");
//	UserAccount user3 = new UserAccount(573, "8267");

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
				users.add(new UserAccount(1834, "2681"));
				users.add(new UserAccount(26738, "7321"));
				
				//funktioniert nicht, da am Anfang nicht die ganze Array-List durchlaufen wird, sondern nur der erste Index.
				for (i = 0; i <= users.size(); i++) {
					System.out.print("Enter your account number: ");
					if (br.readLine().equals(users.get(i).getAccountID())) {
						System.out.print("Enter the amount to withdraw: ");
						int amount = Integer.parseInt(br.readLine());
						ATMBalance(amount);
					} else {
						System.out.println("Account number not found.");
					}
				}
			} catch (Exception e) {
				break;
			}

		}
	}

	public void ATMBalance(int amount) {
		if (amount <= ATMBalance)
			cashout(amount);
		else
			System.out.println("Sorry, the ATM doesn't have enough money.");
	}

	public void cashout(int amount) {
		if (amount <= users.get(i).getAccountBalance()) {
			accountBalance = accountBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
		} else {
			System.out.println("Sorry, not enough money in your bank account.");
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
