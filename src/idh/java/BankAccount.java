package idh.java;

public class BankAccount {

	private int AccountID;
	private int AccountBalance;
	
	public BankAccount() {
		this.AccountID = 0;
		this.AccountBalance = 0;
	}
	public BankAccount(int AccountID, int AccountBalance) {
		this.AccountID = AccountID;
		this.AccountBalance = AccountBalance;
	}
	
	public void setAccountBalance(int newAccountBalance) {
		this.AccountBalance = newAccountBalance;
	}
	public int getAccountBalance() {
		return AccountBalance;
	}
	
	public void setAccountID(int newAccountID) {
		this.AccountID = newAccountID;
	}
	public int getAccountID() {
		return AccountID;
	}
	
}
