package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

public class ATM {

	int geldATM = 100000;

	HashMap<Integer,Float> konten = new HashMap<>();


	public void run() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print("Gib bitte zuerst deine Kontonummer an: ");
				String kontoNummerString = br.readLine();
				if (kontoNummerString.equalsIgnoreCase("exit")){
					System.out.println("Vorgang wird beendet, Bis bald");
					break;
				}

				int kontoNr = Integer.parseInt(kontoNummerString);
				if (!konten.containsKey(kontoNr)){
					System.out.println("Angegebene KontoNr. existiert nicht (zulässige Nr. 100-200)");

					continue;
				}


				System.out.print("Gib den Betrag an der abgehoben werden soll: ");
				String betragString = br.readLine();

				if (betragString.equalsIgnoreCase("exit")){
					System.out.println("Vorgang wird beendet, Bis bald");
					break;
				}


				int amount = Integer.parseInt(betragString);

				cashout(amount, kontoNr);

			}
			catch (Exception e) {
				e.printStackTrace();
				break;

			}

		}


	}

	public void init () {
		Random random = new Random();

		for (int i = 100; i <= 200; i++) {

			konten.put(i, random.nextFloat(0,10000));
		}
	}



	public void cashout(int amount, int kontoNr) {

		if (amount > konten.get(kontoNr)){
			System.out.println("Du hast nicht genug Geld auf deinem Konto!");
			return;
		}

		if (amount <= 0) {
			System.out.println("Negativer Betrag wird nicht akzeptiert");
			return;
		}

		if (amount % 5 != 0) {
			System.out.println("Betrag kann nicht ausgegeben werden, da keine Münzen vorhanden sind");
			System.out.println("Mögliche Beträge sind: " + amount/5 * 5 + " oder " + ((amount / 5) + 1) * 5 + " Euro") ;
			return;
		}

		if (amount > geldATM){
			System.out.println("Dieser Automat hat zu wenig Geld!");
		}
		else {
			geldATM -= amount;
			konten.put(kontoNr, konten.get(kontoNr) -amount);

			System.out.println("Hier ist dein Geld, viel Spass damit!");

		}
	}

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.init();
		atm.run();


	}
}