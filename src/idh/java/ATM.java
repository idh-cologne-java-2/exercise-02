package idh.java;
// Tim Schäfer 7380391
import java.io.*;

public class ATM {
	
	BankAccount AccountList[] = new BankAccount[3];
	BankAccount a1 = new BankAccount(67,134);
	BankAccount a2 = new BankAccount(33,687);
	BankAccount a3 = new BankAccount(73,354);
	
	int aktivIndex;
	int moneyInATM = 598;
	
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	public void run() {
		AccountList[0] = a1;
		AccountList[1] = a2;
		AccountList[2] = a3;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				
				// asking for the ID
				System.out.print("Enter your Accound-ID: ");
				int inputID = Integer.parseInt(br.readLine());
				aktivIndex = findAccoundIndex(inputID);
				
				// checking if the ID is valid
				if(aktivIndex != -1) {
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					
				// check if enough money is in the atm
					if(amount <= moneyInATM ) {
						cashout(amount);
						moneyInATM = moneyInATM - amount;
					}else {
						System.out.println("There is not enough money in the ATM");
					}
				}else{
					System.out.println("This account dosen't exist. Please try again.");
				}
			} catch (Exception e) {
				break;
			}
		}
	}
	/**
	 * 
	 * @return den Index der Stelle an der sich der Accound in der Liste befindet 
	 * 			wenn nichts gefunden wird wird -1 zurückgegeben 
	 */
	public int findAccoundIndex(int searchedID) {
		for(int i = 0;i < AccountList.length;i++)
		{
			if(AccountList[i].getAccountID() == searchedID) {
				return i;
			}
		}
		return -1;
	}
	
	public void cashout(int amount) {
		
		if(amount > AccountList[aktivIndex].getAccountBalance()) {
			
			System.out.println("Sorry, not enough money in your account.");
			
		}else {
			
			AccountList[aktivIndex].setAccountBalance(
					AccountList[aktivIndex].getAccountBalance()- amount);
			System.out.println("Ok, here is your money, enjoy!");
			System.out.println("Current money in your account: " + AccountList[aktivIndex].getAccountBalance());
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