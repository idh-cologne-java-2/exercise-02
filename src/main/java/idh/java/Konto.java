package idh.java;

import java.util.HashMap;

public class Konto {

   // final private String inhaber;

    //kontoStand des Inhabers als float
    private float kontoStand;

    //HashMap mit Key (Kontonummer) und Value (Konto bzw. Kontostand)
    private static final HashMap<Integer,Konto> konten = new HashMap<>();

    //Konstruktor
    public Konto(float kontoStand, int kontoNummer) {
        this.kontoStand = kontoStand;

        //Befüllen der HashMap mit kontoNummer und Konto (this)
        konten.put(kontoNummer,this);
    }

    //GETTER getKontostand
    public float getKontoStand() {
        return kontoStand;
    }

    //Prüfen ob Kontonummer existiert
    //Wenn keine existiert - Exception werfen, ansonsten
    public static Konto getKonto (int kontoNummer) throws Exception {
        if (!kontoExistiert(kontoNummer)){
            throw new Exception ("Konto gibt es nicht!");

        }
        //extrahiere Konto aus HashMap
        return konten.get(kontoNummer);
    }

    //Funktion, ob Konto mit angegebener KontoNr. existiert
    public static boolean kontoExistiert (int kontoNummer) {

        return konten.containsKey(kontoNummer);
    }


    //geldAbheben erfolgreich ja oder nein
    public boolean geldAbheben (int betrag){
        if (betrag > this.kontoStand){
            System.out.println("Du hast nicht genug Geld auf deinem Konto!");
            return false;
        }
        kontoStand -= betrag;
        System.out.println("Hier ist dein Geld!, dein neuer Kontostand: " + kontoStand + " Euro");
        return true;




    }



}
