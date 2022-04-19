package idh.java;

public class People {
	public int banknumber;
	public int money;

	public People(int banknumber, int money) {
		this.banknumber = banknumber;
		this.money = money;
	}
	
	public int getBanknumber() {
		return banknumber;
	}
	public void setBanknumber(int banknumber) {
		this.banknumber = banknumber;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
}