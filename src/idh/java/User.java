package idh.java;

public class User {

	private int accountNumber;
	private int cashAmount;
	
	public User(
			int accountNumber,
			int cashAmount) {
		this.accountNumber = accountNumber;
		this.cashAmount = cashAmount;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public int getCashAmount() {
		return cashAmount;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void setCashAmount(int cashAmount) {
		this.cashAmount = cashAmount;
	}
}
