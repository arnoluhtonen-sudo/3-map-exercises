package esimerkit;

import java.util.HashMap;
import java.util.Set;

public class MapNimetEsimerkki {
    public static void main(String[] args) {
        
        // Mapin luonti
        HashMap<String, Integer> nimetJaArvosanat = new HashMap<>();
        // Arvojen laitto mappiin
        nimetJaArvosanat.put("Arno", 5);
        nimetJaArvosanat.put("Arton", 5);
        nimetJaArvosanat.put("Tea", 5);

        // tulostetaan arnon arvosana
        System.out.println(nimetJaArvosanat.get("Arno"));

        // Kaikkien arvojen läpikäynti
        // Tarvitaan keino hakea lista avaimia
        Set<String> arvot = nimetJaArvosanat.keySet();

        for (String nimi : arvot){
            System.out.println(nimi);
        }
    }

}
