package idh.java;

public class Account {

	// declare variables for the accounts
	
	private int accountID;
	public String accountName;
	private int accountBalance;
	
	//set variables to the values typed in the ATM
	
	public Account( int accountID, String accountName , int accountBalance) {
		this.setAccountID(accountID); 
		this.accountName = accountName; 
		this.setAccountBalance(accountBalance); 
		
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
}
