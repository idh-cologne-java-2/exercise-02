package idh.java;

public class Account {

	private int account; // Kontonummer
	private int balance; // Kontostand

	public Account (int account) {
		this.account = account;
	}
	public Account(int account, int balance) {
		this.account = account;
		this.balance = balance;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null
				&& obj instanceof Account
				&& getAccount() == (((Account)obj).getAccount());
	}
	
	
}