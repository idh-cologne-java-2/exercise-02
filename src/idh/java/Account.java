package idh.java;

public class Account {
	
	String firstname; 
	String surname; 
	private int accountNumber; 
	private int accountBalance;
	
	//Konstruktor
	public Account (String firstname, String surname, int accountNumber, int accountBalance) {
		this.setFirstname(firstname); 
		this.setSurname(surname); 
		this.accountNumber = accountNumber; 
		this.accountBalance = accountBalance; 
	}
	
	//Getter and Setter
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	} 
	
	public int getAccountNumber() {
		return accountNumber;
	}
// kein setter, damit AccountNumber nicht mehr geändert werden kann 
//	public void setAccountNumber(int accountNumber) {
//		this.accountNumber = accountNumber;
//	}
	
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

}
