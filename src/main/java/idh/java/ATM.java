package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {

	int kontostandBenutzer = 5000;

	public void run() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print("Enter the amount to withdraw: ");

				String str = br.readLine();
				if (str.equalsIgnoreCase("exit")){
					System.out.println("Vorgang wird beendet, Bis bald");
					break;
				}
				int amount = Integer.parseInt(str);
				cashout(amount);

			}
			catch (Exception e) {
				e.printStackTrace();
				break;

			}

		}

	}

	public void cashout(int amount) {

		if (amount <= 0) {
			System.out.println("Negativer Betrag wird nicht akzeptiert");
			return;
		}

		if (amount % 5 != 0) {
			System.out.println("Betrag kann nicht ausgegeben werden, da keine Münzen vorhanden sind");
			System.out.println("Mögliche Beträge sind: " + amount/5 * 5 + " oder " + ((amount / 5) + 1) * 5 + " Euro") ;
			return;
		}

		if (amount > kontostandBenutzer){
			System.out.println("Du hast zu wenig Geld auf deinem Konto, Achtung Dispo!");
		}
		else {
			kontostandBenutzer -= amount;
			System.out.println("Hier ist dein Geld, viel Spass damit! \n Neuer Kontostand: " + kontostandBenutzer + " Euro" );

		}
	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();


	}
}