package logika.impl;

import domen.Automobil;
import domen.DomainObject;
import java.util.LinkedList;
import logika.SistemskeOperacije;
import validacija.impl.ValidacijaAutomobila;


public class DodajAutomobilSO extends SistemskeOperacije{

    public DodajAutomobilSO(Automobil a) {
        super();
        odo = a;
        validator=new ValidacijaAutomobila();
    }
    
    
    
    @Override
    protected void operation() throws Exception {
        SistemskeOperacije so = new VratiAutomobileSO();
        so.execute();
        LinkedList<DomainObject> automobili = so.getLista();
        
//        if(!automobili.contains(odo)){
//            odo = dbbr.insert(odo);
//        }
//        else throw new Exception("Uneti automobil vec postoji u bazi!");
        
        for (DomainObject domainObject : automobili) {
            Automobil a=(Automobil) domainObject;
            Automobil zaUbacivanje=(Automobil) odo;
            
            if(a.getMarka().equals(zaUbacivanje.getMarka()) && a.getGodiste()==zaUbacivanje.getGodiste() && a.getTip().equals(zaUbacivanje.getTip()) && a.getCenaBezPDV()==zaUbacivanje.getCenaBezPDV()){
                throw new Exception("Uneti automobil vec postoji u bazi!");
            }    
        }
        odo=dbbr.insert(odo);

    }
    
    
}
