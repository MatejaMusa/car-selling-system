package logika.impl;

import domen.Kupac;
import logika.SistemskeOperacije;


public class VratiKupceSO extends SistemskeOperacije{

    public VratiKupceSO() {
        super();
    }

    @Override
    protected void operation() throws Exception {
        lista=dbbr.getAll(Kupac.class, "", "");
        
    }
}
