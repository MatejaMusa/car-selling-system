package logika.impl;

import domen.DomainObject;
import domen.Narudzbina;
import domen.StavkaNarudzbine;
import java.util.LinkedList;
import logika.SistemskeOperacije;
import validacija.impl.ValidacijaNarudzbenice;

public class DodajNarudzbenicuSO extends SistemskeOperacije{

    public DodajNarudzbenicuSO(Narudzbina n) {
        super();
        odo=n;
        validator=new ValidacijaNarudzbenice();
    }

    @Override
    protected void operation() throws Exception {
        SistemskeOperacije so = new VratiNarudzbeniceSO();
        so.execute();
        LinkedList<DomainObject> narudzbenice = so.getLista();
        
        if(!narudzbenice.contains(odo)){
            odo = dbbr.insert(odo);
            for (StavkaNarudzbine st :((Narudzbina)odo).getStavke()) {
                st.setNaruzbinaID((Narudzbina) odo);
                SistemskeOperacije so2= new DodajStavku(st);
                so2.execute();
            }
        }
        else throw new Exception("Uneta narudzbina vec postoji u bazi!");
    }

   
    }
    

