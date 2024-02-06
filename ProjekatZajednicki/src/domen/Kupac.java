package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Objects;

public class Kupac implements DomainObject,Serializable{
    private long kupacID;
    private String imeKupca;
    private String prezimeKupca;
    private String adresa;
    private String brojTelefona;
    private String email;

    public Kupac() {
    }

    public Kupac(long kupacID, String imeKupca, String prezimeKupca, String adresa, String brojTelefona, String email) {
        this.kupacID = kupacID;
        this.imeKupca = imeKupca;
        this.prezimeKupca = prezimeKupca;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.email = email;
    }


  

    
    @Override
    public String getTableName() {
        return "kupac";
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(long aLong) {
        kupacID=aLong;
    }

    @Override
    public String getAttributeNamesForInsert() {
         String s = "";
        
        s+= "imeKupca";
        s+= ",prezimeKupca";
        s+= ",adresa";
        s+= ",brojTelefona";
        s+= ",email";
        
        return s;
    }

    @Override
    public String getAttributeValuesForInsert() {
        return "'"+imeKupca+"', '"+prezimeKupca+"', '"+adresa+"', '"+brojTelefona+"', '"+email+"'";
    }

    @Override
    public long getId() {
        return kupacID;
    }

    @Override
    public String getIdName() {
        return "kupacID";
    }

    @Override
    public LinkedList<DomainObject> getListFromRs(ResultSet rs) throws Exception {
           LinkedList<DomainObject> lista = new LinkedList<>();
        while(rs.next()){
          long id = rs.getLong("kupacID");
          String ime = rs.getString("imeKupca");
          String prezime = rs.getString("prezimeKupca");
          String adresa = rs.getString("adresa");
          String brojTelefona = rs.getString("brojTelefona");
          String email = rs.getString("email");
          
          
          
          
          Kupac k= new Kupac(id, ime, prezime, adresa, brojTelefona, email);
          lista.add(k);
          
        }
        return lista;
    }

    @Override
    public String setQueryForUpdate() {
        return "update kupac set imeKupca = '"+imeKupca+
                "', prezimeKupca = '"+prezimeKupca+"', adresa = '"+adresa+"', brojTelefona = '"+brojTelefona+"', email = '"+email+"' WHERE kupacID = "+kupacID;
    }

    @Override
    public String prepareQueryForSelect() {
        return "select * from kupac";
    }
    
        public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getKupacID() {
        return kupacID;
    }

    public void setKupacID(long kupacID) {
        this.kupacID = kupacID;
    }

    public String getImeKupca() {
        return imeKupca;
    }

    public void setImeKupca(String imeKupca) {
        this.imeKupca = imeKupca;
    }

    public String getPrezimeKupca() {
        return prezimeKupca;
    }

    public void setPrezimeKupca(String prezimeKupca) {
        this.prezimeKupca = prezimeKupca;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kupac other = (Kupac) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        
        return true;
    }
    
    
      @Override
    public String toString() {
        return imeKupca+" "+prezimeKupca;
    }
  
    
}
