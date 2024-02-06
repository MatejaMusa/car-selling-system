package logika.impl;

import domen.DomainObject;
import domen.Narudzbina;
import domen.StavkaNarudzbine;
import java.util.LinkedList;
import logika.SistemskeOperacije;

public class ObrisiNarudzbenicuSO extends SistemskeOperacije{

    public ObrisiNarudzbenicuSO(Narudzbina n) {
        super();
        odo=n;
    }

    @Override
    protected void operation() throws Exception {
        Narudzbina narudzbina = (Narudzbina) odo;
        LinkedList<DomainObject> stavke = dbbr.getAll(StavkaNarudzbine.class, "st.narudzbinaID ="+narudzbina.getNarudzbinaID(), "");
        for (DomainObject st : stavke) {
            dbbr.remove(st);
        }
        ret = dbbr.remove(odo);
    }
    
}
