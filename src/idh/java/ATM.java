package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ATM {
	int cash = 1000;
    int number;

    HashMap<Integer, Integer> bank = new HashMap<>() {{
        put(1122, 500);
        put(3344, 800);
    }};

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
            	System.out.print("Enter the accountnumber: ");
            	number = Integer.parseInt(br.readLine());
            	
            	if (bank.get(number) != null) {
            		System.out.print("Enter the amount to withdraw: ");
            		int amount = Integer.parseInt(br.readLine());
            		cashout(amount);
                } else {
                	System.out.println("Account doesn´t exist. Try again.");
                }
            
            } catch (Exception e) {
                break;
            }
        }
    }

    public void cashout(int amount) {
        if(cash >= amount){
            if(bank.get(number) >= amount){
                System.out.print("Ok, here is your money, enjoy!\n");
                bank.replace(number, bank.get(number) - amount);
                cash -= amount;
                System.out.println("Your Balance: " + bank.get(number));
            } else {
                System.out.print("Sorry, not enough money on your account. Change the amount.\n");
            }
        } else {
            System.out.print("Sorry, not enough money in the bank. Change the amount or bank.\n");
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
