package idh.java;

public class Accounts {
		
	int Id;
	int balance;
	private String name;
	
	public Accounts(int Id, int balance, String name) {
		this.Id = Id;
		this.balance = balance;
		this.name = name;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
