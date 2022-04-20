package idh.java;

public class user {
	
	private int userID;
	private int userBalance;
	
	public user (int userID, int userBalance) {
		
		this.userID=userID;
		this.userBalance=userBalance;
	
	}
	
	public int getuserID() {
		return userID;
	}

	public int getuserBalance() {
		return userBalance;
	}
	
	public void setuserID(int userID) {
		
		this.userID=userID;
		
	}
	
	public void setuserBalance(int userBalance) {
		
		this.userBalance=userBalance;
		
	}
	
	public user () {
		
	}
	
}
