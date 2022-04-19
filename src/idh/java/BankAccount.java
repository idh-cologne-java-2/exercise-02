package idh.java;

public class BankAccount {
	
	private String name;
	private int pin;
	private int cashintash;
	
	public BankAccount (String name, int pin, int cashintash) {
		this.name = name;
		this.pin = pin;
		this.cashintash = cashintash;
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getCashintash() {
		return cashintash;
	}

	public void setCashintash(int cashintash) {
		this.cashintash = cashintash;
	}

	/*public void cashout(int amount) {
		if (amount <= this.cashintash) {
			this.cashintash = this.cashintash - amount;
			System.out.println("You got" + amount + "€");
		} else {
			System.out.println("You´re too broke!");
		}
	} */
}
