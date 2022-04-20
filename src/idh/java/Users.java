package idh.java;

public class Users {
	
		private int ID;
		private int balance;
		
		public Users (int ID, int balance) {
			this.ID = ID;
			this.balance = balance;
		}

		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}

		public int getBalance() {
			return balance;
		}

		public void setBalance(int balance) {
			this.balance = balance;
		}
				
	}
