package idh.java;

import java.util.HashMap;

public class Konto {

   // final private String inhaber;
    private float kontoStand;
    private static final HashMap<Integer,Konto> konten = new HashMap<>();

    public Konto(float kontoStand, int kontoNummer) {
        this.kontoStand = kontoStand;

        konten.put(kontoNummer,this);
    }

    public float getKontoStand() {
        return kontoStand;
    }

    public static Konto getKonto (int kontoNummer) throws Exception {
        if (!kontoExistiert(kontoNummer)){
            throw new Exception ("Konto gibt es nicht!");

        }
        return konten.get(kontoNummer);
    }

    public static boolean kontoExistiert (int kontoNummer) {
        return konten.containsKey(kontoNummer);
    }


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
