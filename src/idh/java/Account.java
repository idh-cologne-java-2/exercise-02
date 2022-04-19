package idh.java;

public class Account {
	int balance;
	int id;

	public Account(int id, int status) {
		this.id = id;
		this.balance = status;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int status) {
		this.balance = status;
	}
	
	public void withdraw(int sum) {
		this.balance = balance - sum;
	}
	
	
}
