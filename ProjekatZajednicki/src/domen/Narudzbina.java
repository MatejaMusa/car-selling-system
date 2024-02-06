package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;

public class Narudzbina implements DomainObject,Serializable{
    private long narudzbinaID;
    private Date datumIzdavanja;
    private double ukupanIznosBezPDV;
    private double ukupanIznosSaPDV;
    private Kupac kupacID;
    private Korisnik korisnikID;
    private LinkedList<StavkaNarudzbine> stavke;

    public Narudzbina() {
    }

    public Narudzbina(long narudzbinaID, Date datumIzdavanja, double ukupanIznosBezPDV, double ukupanIznosSaPDV, Kupac kupacID, Korisnik korisnikID, LinkedList<StavkaNarudzbine> stavke) {
        this.narudzbinaID = narudzbinaID;
        this.datumIzdavanja = datumIzdavanja;
        this.ukupanIznosBezPDV = ukupanIznosBezPDV;
        this.ukupanIznosSaPDV = ukupanIznosSaPDV;
        this.kupacID = kupacID;
        this.korisnikID = korisnikID;
        this.stavke = stavke;
    }
    
     public Narudzbina(long narudzbinaID, Date datumIzdavanja, double ukupanIznosBezPDV, double ukupanIznosSaPDV, Kupac kupacID, Korisnik korisnikID) {
        this.narudzbinaID = narudzbinaID;
        this.datumIzdavanja = datumIzdavanja;
        this.ukupanIznosBezPDV = ukupanIznosBezPDV;
        this.ukupanIznosSaPDV = ukupanIznosSaPDV;
        this.kupacID = kupacID;
        this.korisnikID = korisnikID;
        
    }
     
     
    @Override
    public String getTableName() {
        return "narudzbina";
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(long id) {
        narudzbinaID = id;
    }

    @Override
    public String getAttributeNamesForInsert() {
        String s = "";

        s += "datumIzdavanja";
        s += ",ukupanIznosBezPDV";
        s += ",ukupanIznosSaPDV";
        s += ",kupacID";
        s += ",korisnikID";
        

        return s;
    }

    @Override
    public String getAttributeValuesForInsert() {
        return "'" + new java.sql.Date(datumIzdavanja.getTime()).toString() + "', " + ukupanIznosBezPDV
                + ", " + ukupanIznosSaPDV
                + ", " + kupacID.getKupacID() + ", "
                + korisnikID.getKorisnikID();
    }

    @Override
    public long getId() {
        return narudzbinaID;
    }

    @Override
    public String getIdName() {
        return "narudzbinaID";
    }

    @Override
    public LinkedList<DomainObject> getListFromRs(ResultSet rs) throws Exception {
        LinkedList<DomainObject> list = new LinkedList<>();

        while (rs.next()) {
            long id = rs.getLong("n.narudzbinaID");
            double iznosBezPDV=rs.getDouble("n.ukupanIznosBezPDV");
            double iznosSaPDV=rs.getDouble("n.ukupanIznosSaPDV");
            Date datumIzdavanja = new java.util.Date(rs.getDate("n.datumIzdavanja").getTime());
            
            long kupacID=rs.getLong("ku.kupacID");
            String imeKupca=rs.getString("ku.imeKupca");
            String prezimeKupca=rs.getString("ku.prezimeKupca");
            String adresa=rs.getString("ku.adresa");
            String brojTelefona=rs.getString("ku.brojTelefona");
            String email=rs.getString("ku.email");
            
            long korisnikID=rs.getLong("ko.korisnikID");
            String imeKorisnika=rs.getString("ko.imeKorisnika");
            String prezimeKorisnika=rs.getString("ko.prezimeKorisnika");
            String jmbg=rs.getString("ko.jmbg");
            String username=rs.getString("ko.username");
            String password=rs.getString("ko.password");
            Kupac ku=new Kupac(kupacID, imeKupca, prezimeKupca, adresa, brojTelefona, email);
            Korisnik ko= new Korisnik(korisnikID, imeKorisnika, prezimeKorisnika, jmbg, username,password);
            
            Narudzbina na= new Narudzbina(id, datumIzdavanja, iznosBezPDV, iznosSaPDV, ku, ko, new LinkedList<>());
            list.add(na);
        }
        return list;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE narudzbina SET datumIzdavanja = '" + new java.sql.Date(datumIzdavanja.getTime()).toString()
                + "', ukupanIznosBezPDV = " + ukupanIznosBezPDV + ", ukupanIznosSaPDV = "
                + ukupanIznosSaPDV
                + ", kupacID = " + kupacID.getKupacID() + ", korisnikID = "
                + korisnikID.getKorisnikID() + 
                " WHERE narudzbinaID = " + narudzbinaID;
    }

    @Override
    public String prepareQueryForSelect() {
        return "select * from narudzbina n join kupac ku on (n.kupacID=ku.kupacID) join korisnik ko on (n.korisnikID=ko.korisnikID)";
    }

    public long getNarudzbinaID() {
        return narudzbinaID;
    }

    public void setNarudzbinaID(long narudzbinaID) {
        this.narudzbinaID = narudzbinaID;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public double getUkupanIznosBezPDV() {
        return ukupanIznosBezPDV;
    }

    public void setUkupanIznosBezPDV(double ukupanIznosBezPDV) {
        this.ukupanIznosBezPDV = ukupanIznosBezPDV;
    }

    public double getUkupanIznosSaPDV() {
        return ukupanIznosSaPDV;
    }

    public void setUkupanIznosSaPDV(double ukupanIznosSaPDV) {
        this.ukupanIznosSaPDV = ukupanIznosSaPDV;
    }

    public Kupac getKupacID() {
        return kupacID;
    }

    public void setKupacID(Kupac kupacID) {
        this.kupacID = kupacID;
    }

    public Korisnik getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(Korisnik korisnikID) {
        this.korisnikID = korisnikID;
    }

    public LinkedList<StavkaNarudzbine> getStavke() {
        return stavke;
    }

    public void setStavke(LinkedList<StavkaNarudzbine> stavke) {
        this.stavke = stavke;
    }
    
}
