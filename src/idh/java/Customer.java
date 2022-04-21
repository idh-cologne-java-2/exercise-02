package idh.java;

public class Customer {
	
	private String customer;
	private int accountNumber;
	private int balance;

	public Customer(String customer, int accountNumber, int balance) {
		this.customer = customer;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getCustomer() {
		return customer;
	}
	

	public int getAccountNumber() {
		return accountNumber;
	}


	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}

