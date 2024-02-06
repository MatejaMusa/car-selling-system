package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Objects;

public class Korisnik implements DomainObject, Serializable{
    private long korisnikID;
    private String imeKorisnika;
    private String prezimeKorisnika;
    private String jmbg;
    private String username;
    private String password;

    public Korisnik() {
    }

    public Korisnik(long korisnikID, String imeKorisnika, String prezimeKorisnika, String jmbg, String username, String password) {
        this.korisnikID = korisnikID;
        this.imeKorisnika = imeKorisnika;
        this.prezimeKorisnika = prezimeKorisnika;
        this.jmbg = jmbg;
        this.username = username;
        this.password = password;
    }
    
    public Korisnik(String korisnickoIme, String lozinka) {
        this.username = korisnickoIme;
        this.password = lozinka;
    }
   

    @Override
    public String getTableName() {
        return "korisnik";
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(long aLong) {
        korisnikID = aLong;
    }

    @Override
    public String getAttributeNamesForInsert() {
         String s = "";
        
        s+= "imeKorisnika";
        s+= ",prezimeKorisnika";
        s+= ",jmbg";
        s+= ",username";
        s+= ",password";
        
        return s;
    }

    @Override
    public String getAttributeValuesForInsert() {
        return "'"+imeKorisnika+"', '"+prezimeKorisnika+"', '"+jmbg+"', '"+username+"', '"+password+"'";
    }

    @Override
    public long getId() {
        return korisnikID;
    }

    @Override
    public String getIdName() {
        return "korisnikID";
    }

    @Override
    public LinkedList<DomainObject> getListFromRs(ResultSet rs) throws Exception {
          LinkedList<DomainObject> lista = new LinkedList<>();
        while(rs.next()){
          long id = rs.getLong("korisnikID");
          String ime = rs.getString("imeKorisnika");
          String prezime = rs.getString("prezimeKorisnika");
          String jmbg = rs.getString("jmbg");
          String username = rs.getString("username");
          String password = rs.getString("password");
          
          
          Korisnik ko= new Korisnik(id, ime, prezime, jmbg, username, password);
          lista.add(ko);
          
        }
        return lista;
    }

    @Override
    public String setQueryForUpdate() {
         return "update korisnik set imeKorisnika = '"+imeKorisnika+
                "', prezimeKorisnika = '"+prezimeKorisnika+"', jmbg = '"+jmbg+"', username = '"+username+"', password= '"+password+"' WHERE korisnikid = "+korisnikID;
    }

    @Override
    public String prepareQueryForSelect() {
        return "select * from korisnik";
    }
    
 
         @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(long korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getImeKorisnika() {
        return imeKorisnika;
    }

    public void setImeKorisnika(String imeKorisnika) {
        this.imeKorisnika = imeKorisnika;
    }

    public String getPrezimeKorisnika() {
        return prezimeKorisnika;
    }

    public void setPrezimeKorisnika(String prezimeKorisnika) {
        this.prezimeKorisnika = prezimeKorisnika;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return imeKorisnika+" "+prezimeKorisnika;
    }
    
    
}
