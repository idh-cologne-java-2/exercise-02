package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ATM {

	int geldATM = 100000;
	int customerNumber;


	public int setCustomerNumber(int customerNumber)
	{
		this.customerNumber=customerNumber;
		return customerNumber;
	}

	public int getCustomerNumber()
	{
		return customerNumber;
	}

	HashMap<Integer,Float> konten = new HashMap<>();


	public void run() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print("Gib bitte zuerst deine Kontonummer an: ");
				setCustomerNumber(Integer.parseInt(br.readLine()));

				System.out.print("Gib den Betrag an der abgehoben werden soll: ");
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

	public void init (){
		Random random = new Random();

		for (int i = 100; i <= 200; i++ ){

			konten.put(i, random.nextFloat());

			for(Map.Entry<Integer,Float> entry:konten.entrySet())
			{
				if(entry.getKey()==getCustomerNumber()){
					//cashout();

				}
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

		if (amount > geldATM){
			System.out.println("Dieser Automat hat zu wenig Geld!");
		}
		else {
			geldATM -= amount;
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