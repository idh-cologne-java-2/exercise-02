package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ATM {

	//Summe, die auf ATM vorhanden ist
	int geldATM = 100000;


	public void run() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print("Gib bitte zuerst deine Kontonummer an: ");
				String kontoNummerString = br.readLine();

				//Prüfen, ob User "exit" eingetippt hat
				if (kontoNummerString.equalsIgnoreCase("exit")){
					System.out.println("Vorgang wird beendet, Bis bald");
					break;
				}

				//Parsen des Strings in Integer
				int kontoNr = Integer.parseInt(kontoNummerString);

				//Prüfen ob Konto (Funktion "kontoExistiert") existiert
				if (!Konto.kontoExistiert(kontoNr)){
					System.out.println("Angegebene KontoNr. existiert nicht (zulässige Nr. 100-200)");

					continue;
				}

				//schaue in HashMap nach ob entsprechender Eintrag existiert
				Konto k = Konto.getKonto(kontoNr);

				System.out.println("Dein aktueller Kontostand: " + k.getKontoStand() + " €");

				System.out.print("Gib den Betrag an der abgehoben werden soll: ");
				String betragString = br.readLine();

				if (betragString.equalsIgnoreCase("exit")){
					System.out.println("Vorgang wird beendet, Bis bald");
					break;
				}

				int betragAbbuchung = Integer.parseInt(betragString);

				cashout(betragAbbuchung, k);

			}
			catch (Exception e) {
				e.printStackTrace();
				break;

			}
		}
	}

	//Initialisierung
	//Erstellen von random Zahlen (Kontonr. zw. 100 und 200)
	//Nachkommastellen (float) auf 2 reduzieren
	public void init () {
		Random random = new Random();

		for (int i = 100; i <= 200; i++) {

			float f = random.nextFloat(0,10000);
			f *= 100;
			f = Math.round(f) / 100f;

			new Konto (f, i);

		}
	}


	public void cashout(int betrag, Konto k) {

		if (betrag <= 0) {
			System.out.println("Negativer Betrag wird nicht akzeptiert");
			return;
		}

		if (betrag % 5 != 0) {
			System.out.println("Betrag kann nicht ausgegeben werden, da keine Münzen vorhanden sind");
			System.out.println("Mögliche Beträge sind: " + betrag / 5 * 5 + " oder " + ((betrag / 5) + 1) * 5 + " Euro");
			return;
		}

		if (betrag > geldATM) {
			System.out.println("Dieser Automat hat zu wenig Geld!");
		} else {
			boolean success = k.geldAbheben(betrag);
			if (success) {
				geldATM -= betrag;
			}
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