package kontroler;

import domen.Automobil;
import domen.DomainObject;
import domen.Korisnik;
import domen.Kupac;
import domen.Narudzbina;
import java.util.LinkedList;
import logika.SistemskeOperacije;
import logika.impl.DodajAutomobilSO;
import logika.impl.DodajKupcaSO;
import logika.impl.DodajNarudzbenicuSO;
import logika.impl.IzmeniNarudzbenicuSO;
import logika.impl.LoginSO;
import logika.impl.ObrisiNarudzbenicuSO;
import logika.impl.RegistrujSeSO;
import logika.impl.VratiAutomobileSO;
import logika.impl.VratiKorisnikeSO;
import logika.impl.VratiKupceSO;
import logika.impl.VratiNarudzbeniceSO;

public class KontrolerServer {
        private static KontrolerServer instance;

        public KontrolerServer() {
        }
    
    public static KontrolerServer getInstance(){
        if(instance==null){
            instance=new KontrolerServer();
        }
        return instance;
    }
    
        public DomainObject login(Korisnik k) throws Exception {
        SistemskeOperacije so = new LoginSO(k);
        so.execute();
        return so.getDomainObject();
    }
        
        public DomainObject registrujSe(Korisnik k) throws Exception {
        SistemskeOperacije so = new RegistrujSeSO(k);
        so.execute();
        return so.getDomainObject();
    }

    public LinkedList<DomainObject> vratiNarudzbine() throws Exception {
        SistemskeOperacije so = new VratiNarudzbeniceSO();
        so.execute();
        return so.getLista();
    }

    public boolean obrisiNarudzbinu(Narudzbina n) throws Exception {
        SistemskeOperacije so = new ObrisiNarudzbenicuSO(n);
        so.execute();
        return so.isRet();
    }

    public LinkedList<DomainObject> vratiAutomobile() throws Exception {
        SistemskeOperacije so = new VratiAutomobileSO();
        so.execute();
        return so.getLista();
    }

    public LinkedList<DomainObject> vratiKupce() throws Exception {
        SistemskeOperacije so = new VratiKupceSO();
        so.execute();
        return so.getLista();
    }

    public LinkedList<DomainObject> vratiKorisnike() throws Exception {
        SistemskeOperacije so = new VratiKorisnikeSO();
        so.execute();
        return so.getLista();
    }

    public DomainObject unesiKupca(Kupac k) throws Exception {
        SistemskeOperacije so = new DodajKupcaSO(k);
        so.execute();
        return so.getDomainObject();
    }

    public DomainObject unesiAutomobil(Automobil a) throws Exception {
        SistemskeOperacije so = new DodajAutomobilSO(a);
        so.execute();
        return so.getDomainObject();
    }

    public DomainObject unesiNarudzbinu(Narudzbina n) throws Exception {
        SistemskeOperacije so = new DodajNarudzbenicuSO(n);
        so.execute();
        return so.getDomainObject();
    }

    public DomainObject izmeniNarudzbinu(Narudzbina n) throws Exception {
        SistemskeOperacije so = new IzmeniNarudzbenicuSO(n);
        so.execute();
        return so.getDomainObject();
    }

}
