package logika.impl;

import domen.DomainObject;
import domen.Korisnik;
import java.util.LinkedList;
import logika.SistemskeOperacije;
import validacija.impl.ValidacijaKorisnika;

public class RegistrujSeSO extends SistemskeOperacije{

    public RegistrujSeSO(Korisnik k) {
        super();
        odo=k;
        validator=new ValidacijaKorisnika();
    }

    
    @Override
    protected void operation() throws Exception {
        LinkedList<DomainObject> korisnici = dbbr.getAll(Korisnik.class, "","");
        if(korisnici.isEmpty()){
            odo=dbbr.insert(odo);
            return;
        }
//        for (DomainObject domain : korisnici) {
//            Korisnik korisnik = (Korisnik)domain;
//            if (!(odo.equals(korisnik))) {
//                dbbr.insert(odo);
//                return;
//            }
//        }

        for (DomainObject domainObject : korisnici) {
            Korisnik k=(Korisnik) domainObject;
            Korisnik zaUbacivanje=(Korisnik) odo;
            
            if(k.getUsername().matches(zaUbacivanje.getUsername()) || k.getJmbg().matches(zaUbacivanje.getJmbg())){
                throw new Exception("Proverite JMBG ili promenite korisnicko ime!");
            }    
        }
        odo=dbbr.insert(odo);
    }
    
}
