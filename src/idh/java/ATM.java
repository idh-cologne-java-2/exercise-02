package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int atmBalance = 8000;
	
	int[] userAccountBalance = {500, 3500, 9950}; // Verschiedene Kontost‰nde erstellt
	int[] user = {111, 222, 333}; // Kontost‰nden user IDs zugewiesen

	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			try {
				System.out.print("Bitte Account-ID angeben: "); // hier wird nun nach einer Konto-ID gefragt und nach falls vorhanden, gespeichert. Wenn nicht, wird Fehlermeldung angezeigt.
				int number = Integer.parseInt(br.readLine());
				int index = -1;
					for (int a = 0; a < user.length; a++) { 
						if (number == user[a]) {
							index = a;
						}
					}
					
				if (index != -1) {
					System.out.println("Bitte gew¸nschte Bargeldmenge angeben: ");
					int amount = Integer.parseInt(br.readLine());
					cashout(index, amount);
				} else {
					System.err.println("Entschuldigung, aber ein solches Konto existiert bei unserer Bank nicht!");
				}
				
			} catch (Exception e) {
				break;
			}
		}
	}

	public void cashout(int index, int amount) {

		if (atmBalance >= amount) { // hier wird nun der abzuhebene Betrag vom jeweiligen Kontostand abgebucht. Auﬂerdem werden Fehlermeldungen angezeigt, wenn der Geldautomat oder der Kontostand zu wenig Geld enth‰lt.
			if (amount <= userAccountBalance[index]) {
				userAccountBalance[index] = userAccountBalance[index] - amount;
				atmBalance = atmBalance - amount;
				System.out.println("Bitteschˆn, ihre gew¸nschte Menge Bargeld wurde von Ihrem Konto abgebucht");
			} else {
				System.err.println("Entschuldigen Sie, aber Ihr Konto verf¸gt aktuell nicht ¸ber diese Menge Geld!");
			}
			} else {
			System.err.println("Es tut uns leid, aber der Geldautomat verf¸gt derzeit nicht ¸ber diese Menge Geld!");
			}

	};

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};

}
