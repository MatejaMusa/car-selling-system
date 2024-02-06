package logika.impl;

import domen.DomainObject;
import domen.Korisnik;
import java.util.LinkedList;
import logika.SistemskeOperacije;

public class LoginSO extends SistemskeOperacije{

    public LoginSO(Korisnik k) {
        super();
        odo = k;
    }
    @Override
    protected void operation() throws Exception {
         LinkedList<DomainObject> korisnici = dbbr.getAll(Korisnik.class, "", "");
        for (DomainObject domain : korisnici) {
            Korisnik k = (Korisnik)domain;
            if (odo.equals(k)) {
                odo = k;
                return;
            }
        }
    }
    
}
