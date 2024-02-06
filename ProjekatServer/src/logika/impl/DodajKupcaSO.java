package logika.impl;

import domen.DomainObject;
import domen.Kupac;
import java.util.LinkedList;
import logika.SistemskeOperacije;
import validacija.impl.ValidacijaKupca;

public class DodajKupcaSO extends SistemskeOperacije{

    public DodajKupcaSO(Kupac k) {
        super();
        odo=k;
        validator=new ValidacijaKupca();
    }

    @Override
    protected void operation() throws Exception {
        SistemskeOperacije so = new VratiKupceSO();
        so.execute();
        LinkedList<DomainObject> kupci = so.getLista();
        
//        if(!kupci.contains(odo)){
//            odo = dbbr.insert(odo);
//        }
//        else throw new Exception("Uneti kupac vec postoji u bazi!");
            for (DomainObject domainObject : kupci) {
                Kupac k=(Kupac) domainObject;
                Kupac zaUbacivanje=(Kupac) odo;
            
                if(k.getEmail().equals(zaUbacivanje.getEmail())){
                throw new Exception("Uneti kupac vec postoji u bazi!");
            }    
        }
            odo=dbbr.insert(odo);
    }
    
}
