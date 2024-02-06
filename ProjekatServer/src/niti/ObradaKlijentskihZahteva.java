package niti;

import domen.Automobil;
import domen.DomainObject;
import domen.Korisnik;
import domen.Kupac;
import domen.Narudzbina;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import kontroler.KontrolerServer;
import operacije.Operacija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;


public class ObradaKlijentskihZahteva extends Thread{
        private Socket socket;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        KlijentskiZahtev zahtev = null;
        ServerskiOdgovor odgovor = null;
        while (!socket.isClosed()) {
            try {
                zahtev = primiZahtev();

                switch (zahtev.getOperacija()) {
                    case Operacija.LOGIN:
                        odgovor = login(zahtev);
                        break;
                    case Operacija.REGISTRUJ_SE:
                        odgovor = registrujSe(zahtev);
                        break;
                    case Operacija.VRATI_AUTOMOBILE:
                        odgovor = vratiAutomobile();
                        break;
                    case Operacija.VRATI_KUPCE:
                        odgovor = vratiKupce();
                        break;
                    case Operacija.VRATI_NARUDZBINE:
                        odgovor = VratiNarudzbine();
                        break;    
                    case Operacija.VRATI_KORISNIKE:
                        odgovor = vratiKorisnike();
                        break;
                    case Operacija.UNESI_NARUDZBINU:
                        odgovor = unesiNarudzbinu(zahtev);
                        break;  
                     case Operacija.UNESI_AUTOMOBIL:
                        odgovor = unesiAutomobil(zahtev);
                        break;
                    case Operacija.UNESI_KUPCA:
                        odgovor = unesiKupca(zahtev);
                        break;     
                     case Operacija.IZMENI_NARUDZBINU:
                        odgovor = izmeniNarudzbinu(zahtev);
                        break;  
                     case Operacija.OBRISI_NARUDZBINU:
                        odgovor = obrisiNarudzbinu(zahtev);
                        break;      
                        
                }
                posaljiOdgovor(odgovor);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    

      private KlijentskiZahtev primiZahtev() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        return (KlijentskiZahtev) in.readObject();
    }

    private void posaljiOdgovor(ServerskiOdgovor odgovor) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(odgovor);
        out.flush();
    }

    
    public Socket getSocket() {
        return socket;
    }

    private ServerskiOdgovor login(KlijentskiZahtev zahtev) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try{
        Korisnik k = (Korisnik) zahtev.getParametar();
        DomainObject odo = KontrolerServer.getInstance().login(k);

        odgovor.setOdgovor(odo);
        }
        catch(Exception e){
           odgovor.setOdgovor(null);
           odgovor.setException(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor registrujSe(KlijentskiZahtev zahtev) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try{
        Korisnik k = (Korisnik) zahtev.getParametar();
        DomainObject odo = KontrolerServer.getInstance().registrujSe(k);
        odgovor.setOdgovor(odo);
        }
        catch(Exception e){
           odgovor.setOdgovor(null);
           odgovor.setException(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor VratiNarudzbine() {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        LinkedList<DomainObject> narudzbine;
        try {
            narudzbine = KontrolerServer.getInstance().vratiNarudzbine();
            odgovor.setOdgovor(narudzbine);
        } catch (Exception ex) {
            odgovor.setException(ex);
        }
        return odgovor;
    }

    private ServerskiOdgovor obrisiNarudzbinu(KlijentskiZahtev zahtev) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        Narudzbina n = (Narudzbina) zahtev.getParametar();
        try{
        boolean ret = KontrolerServer.getInstance().obrisiNarudzbinu(n);
        odgovor.setOdgovor(ret);
        }
        catch(Exception e){
            odgovor.setException(e);
            odgovor.setOdgovor(false);
        }
        return odgovor;
    }

    private ServerskiOdgovor vratiAutomobile() {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        LinkedList<DomainObject> automobili;
        try {
            automobili = KontrolerServer.getInstance().vratiAutomobile();
            odgovor.setOdgovor(automobili);
        } catch (Exception ex) {
            odgovor.setException(ex);
        }
        return odgovor;
    }

    private ServerskiOdgovor vratiKupce() {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        LinkedList<DomainObject> kupci;
        try {
            kupci = KontrolerServer.getInstance().vratiKupce();
            odgovor.setOdgovor(kupci);
        } catch (Exception ex) {
            odgovor.setException(ex);
        }
        return odgovor;
    }

    private ServerskiOdgovor vratiKorisnike() {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        LinkedList<DomainObject> korisnici;
        try {
            korisnici = KontrolerServer.getInstance().vratiKorisnike();
            odgovor.setOdgovor(korisnici);
        } catch (Exception ex) {
            odgovor.setException(ex);
        }
        return odgovor;
    }

    private ServerskiOdgovor unesiKupca(KlijentskiZahtev zahtev) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try{
        Kupac k = (Kupac) zahtev.getParametar();
        DomainObject odo = KontrolerServer.getInstance().unesiKupca(k);

        odgovor.setOdgovor(odo);
        }
        catch(Exception e){
           odgovor.setOdgovor(null);
           odgovor.setException(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor unesiAutomobil(KlijentskiZahtev zahtev) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try{
        Automobil a = (Automobil) zahtev.getParametar();
        DomainObject odo = KontrolerServer.getInstance().unesiAutomobil(a);

        odgovor.setOdgovor(odo);
        }
        catch(Exception e){
           odgovor.setOdgovor(null);
           odgovor.setException(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor unesiNarudzbinu(KlijentskiZahtev zahtev) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try{
        Narudzbina n = (Narudzbina) zahtev.getParametar();
        DomainObject odo = KontrolerServer.getInstance().unesiNarudzbinu(n);

        odgovor.setOdgovor(odo);
        }
        catch(Exception e){
           odgovor.setOdgovor(null);
           odgovor.setException(e);
        }
        return odgovor;
    }

    private ServerskiOdgovor izmeniNarudzbinu(KlijentskiZahtev zahtev) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        try{
        Narudzbina n = (Narudzbina) zahtev.getParametar();
        DomainObject odo = KontrolerServer.getInstance().izmeniNarudzbinu(n);

        odgovor.setOdgovor(odo);
        }
        catch(Exception e){
           odgovor.setOdgovor(null);
           odgovor.setException(e);
        }
        return odgovor;
    }
  
}
