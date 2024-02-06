package logika.impl;

import domen.Korisnik;
import logika.SistemskeOperacije;

public class VratiKorisnikeSO extends SistemskeOperacije{

    public VratiKorisnikeSO() {
        super();
    }
    
    @Override
    protected void operation() throws Exception {
        lista=dbbr.getAll(Korisnik.class, "", "");
    }
    
}
