package idh.java;

public class Account {
	
	private int accountNo;
	private int money;
	
	public Account(int accountNo, int money) {
		this.accountNo = accountNo;
		this.money = money;
	}
	
	

	public int getAccountNo() {
		return accountNo;
	}

	//public void setAccountNo(int accountNo) {
	//	this.accountNo = accountNo;
	//}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
