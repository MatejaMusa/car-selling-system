package domen;

import java.util.Date;

public class KonverterObjekata {
     public static DomainObject kreirajObjekat(Class klasa){
       
        if(klasa == Korisnik.class)
            return new Korisnik();
        if(klasa == Kupac.class)
            return new Kupac(-1, "", "", "", "", "");
        if(klasa == Automobil.class)
            return new Automobil(-1, "", 0, null, false, false, 0, 0);
        if(klasa == StavkaNarudzbine.class)
            return new StavkaNarudzbine(null,-1, 0, 0, null);
        if(klasa == Narudzbina.class)
            return new Narudzbina(-1, null, 0, 0, null, null, null);

   
        return null;
    }
}
