package idh.java;

public class UserAccount {
	private int accountBalance;
	private String accountID;
	
	public UserAccount(int accountBalance, String accountID) {
		this.accountBalance = accountBalance;
		this.accountID = accountID;
	}
	
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	
	
}
