package kontroler;

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
import operacije.Operacija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class KontrolerKlijent {
     private static KontrolerKlijent instance;

    private Socket socket;

    private KontrolerKlijent() throws IOException {
        socket = new Socket("localhost", 9000);
    }

    public static KontrolerKlijent getInstance() throws IOException {
        if (instance == null) {
            instance = new KontrolerKlijent();
        }
        return instance;
    }

    private void posaljiZahtev(KlijentskiZahtev zahtev) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(zahtev);
        out.flush();
    }

    private ServerskiOdgovor primiOdgovor() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ServerskiOdgovor odgovor = (ServerskiOdgovor) in.readObject();
        return odgovor;
    }

    public Korisnik login(Korisnik k) throws Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.LOGIN);
        zahtev.setParametar(k);
        posaljiZahtev(zahtev);
        ServerskiOdgovor odgovor = primiOdgovor();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (Korisnik) odgovor.getOdgovor();
    }
        public Korisnik registrujSe(Korisnik k) throws Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.REGISTRUJ_SE);
        zahtev.setParametar(k);
        posaljiZahtev(zahtev);
        ServerskiOdgovor odgovor = primiOdgovor();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (Korisnik) odgovor.getOdgovor();
    }

    public LinkedList<DomainObject> vratiNarudzbine() throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.VRATI_NARUDZBINE);
        posaljiZahtev(zahtev);
        ServerskiOdgovor odgovor = primiOdgovor();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (LinkedList<DomainObject>) odgovor.getOdgovor();
    }

    public boolean obrisiNarudzbinu(Narudzbina n) throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.OBRISI_NARUDZBINU);
        zahtev.setParametar(n);
        posaljiZahtev(zahtev);
        ServerskiOdgovor odgovor = primiOdgovor();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (boolean) odgovor.getOdgovor();
    }

    public LinkedList<DomainObject> vratiAutomobile() throws IOException, ClassNotFoundException, Exception {
                KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.VRATI_AUTOMOBILE);
        posaljiZahtev(zahtev);
        ServerskiOdgovor odgovor = primiOdgovor();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (LinkedList<DomainObject>) odgovor.getOdgovor();
    }

    public LinkedList<DomainObject> vratiKupce() throws IOException, ClassNotFoundException, Exception {
                KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.VRATI_KUPCE);
        posaljiZahtev(zahtev);
        ServerskiOdgovor odgovor = primiOdgovor();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (LinkedList<DomainObject>) odgovor.getOdgovor();
    }

    public LinkedList<DomainObject> vratiKorisnike() throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.VRATI_KORISNIKE);
        posaljiZahtev(zahtev);
        ServerskiOdgovor odgovor = primiOdgovor();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (LinkedList<DomainObject>) odgovor.getOdgovor();
    }

    public Kupac unesiKupca(Kupac k) throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.UNESI_KUPCA);
        zahtev.setParametar(k);
        posaljiZahtev(zahtev);
        ServerskiOdgovor odgovor = primiOdgovor();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (Kupac) odgovor.getOdgovor();
    }

    public Automobil unesiAutomobil(Automobil a) throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.UNESI_AUTOMOBIL);
        zahtev.setParametar(a);
        posaljiZahtev(zahtev);
        ServerskiOdgovor odgovor = primiOdgovor();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (Automobil) odgovor.getOdgovor();
    }

    public Narudzbina dodajNarudzbinu(Narudzbina n) throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.UNESI_NARUDZBINU);
        zahtev.setParametar(n);
        posaljiZahtev(zahtev);
        ServerskiOdgovor odgovor = primiOdgovor();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (Narudzbina) odgovor.getOdgovor();
    }

    public Narudzbina izmeniNarudzbinu(Narudzbina n) throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev();
        zahtev.setOperacija(Operacija.IZMENI_NARUDZBINU);
        zahtev.setParametar(n);
        posaljiZahtev(zahtev);
        ServerskiOdgovor odgovor = primiOdgovor();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (Narudzbina) odgovor.getOdgovor();
    }
}
