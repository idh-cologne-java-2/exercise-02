package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int ATMBalance = 70;
	
	People hans = new People(123, 50);
	People richard = new People(234, 50);
	People susy = new People(345, 70);
	People[] peopleList = {hans, richard, susy};
	
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
				for (int i = 0; i < peopleList.length; i++) {
					if (number == peopleList[i].banknumber) {
						System.out.print("Enter the amount to withdraw: ");
						int amount = Integer.parseInt(br.readLine());
						cashout(amount, number, peopleList[i].money);
						run();
				} else {
					continue;
				}
				}
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int amount, int number, int money) {
		if (amount < ATMBalance && amount < money) {
			ATMBalance = ATMBalance - amount;
			System.out.println("Ok, here is your money, enjoy!");
			System.out.println("This is the new Balance: "+ ATMBalance);
		} else if (amount > ATMBalance && amount < money) {
			System.out.println("Sorry, not enough money in the bank.");
		} else if (amount < ATMBalance && amount > money){
			System.out.println("Sorry, the ATM does not have enough money.");
		} else {
			System.out.println("Sorry, neither does the ATM nor do you have enough money.");
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
