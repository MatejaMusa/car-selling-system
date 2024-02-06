package logika.impl;

import domen.DomainObject;
import domen.Narudzbina;
import domen.StavkaNarudzbine;
import java.util.LinkedList;
import logika.SistemskeOperacije;
import validacija.impl.ValidacijaNarudzbenice;

public class IzmeniNarudzbenicuSO extends SistemskeOperacije {

    public IzmeniNarudzbenicuSO(Narudzbina n) {
        super();
        odo=n;
        validator=new ValidacijaNarudzbenice();
        
    }

    @Override
    protected void operation() throws Exception {
        Narudzbina naruzbina = (Narudzbina) odo;
        LinkedList<DomainObject> stavke = dbbr.getAll(StavkaNarudzbine.class, "st.narudzbinaID ="+naruzbina.getNarudzbinaID(), "");
        for (DomainObject st : stavke) {
            dbbr.remove(st);
        }
        odo = dbbr.update(odo);
        for (StavkaNarudzbine st :((Narudzbina)odo).getStavke()) {
                st.setNaruzbinaID((Narudzbina) odo);
               // st.setStavkaNarudzbineID(-1);
               // SistemskeOperacije so= new DodajStavku(st);
               // so.execute();
                 DomainObject sn=new StavkaNarudzbine((Narudzbina)odo, -1,st.getIznosStavkiNarudzbineBezPDV(), st.getIznosStavkiNarudzbineSaPDV(), st.getAutomobilID());
                 dbbr.insert(sn);
        }
    }
    
}
