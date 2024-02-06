package logika.impl;

import domen.StavkaNarudzbine;
import logika.SistemskeOperacije;

public class DodajStavku extends SistemskeOperacije {

    public DodajStavku(StavkaNarudzbine st) {
        super();
        odo=st;
    }

    @Override
    protected void operation() throws Exception {
        odo=dbbr.insert(odo);
    }
    
}
