package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.LinkedList;

public class StavkaNarudzbine implements DomainObject,Serializable{
    private Narudzbina naruzbinaID;
    private long stavkaNarudzbineID;
    private double iznosStavkiNarudzbineBezPDV;
    private double iznosStavkiNarudzbineSaPDV;
    private Automobil automobilID;

    public StavkaNarudzbine() {
    }

    public StavkaNarudzbine(Narudzbina naruzbinaID, long stavkaNarudzbineID, double iznosStavkiNarudzbineBezPDV, double iznosStavkiNarudzbineSaPDV, Automobil automobilID) {
        this.naruzbinaID = naruzbinaID;
        this.stavkaNarudzbineID = stavkaNarudzbineID;
        this.iznosStavkiNarudzbineBezPDV = iznosStavkiNarudzbineBezPDV;
        this.iznosStavkiNarudzbineSaPDV = iznosStavkiNarudzbineSaPDV;
        this.automobilID = automobilID;
    }

    
    @Override
    public String getTableName() {
            return "stavkanaruzbine";
    }

    @Override
    public boolean isAutoincrement() {
            return true;
    }

    @Override
    public void setObjectId(long aLong) {
        stavkaNarudzbineID = aLong;
    }

    @Override
    public String getAttributeNamesForInsert() {
        String s = "";
        s+= "narudzbinaID";
        s+= ",iznosStavkiNarudzbineBezPDV";
        s+= ",iznosStavkiNarudzbineSaPDV";
        s+= ", automobilID";
        
        return s;
    }

    @Override
    public String getAttributeValuesForInsert() {
            return naruzbinaID.getNarudzbinaID()+", "+iznosStavkiNarudzbineBezPDV+", "+iznosStavkiNarudzbineSaPDV+", "+automobilID.getAutomobilID();
    }

    @Override
    public long getId() {
            return naruzbinaID.getNarudzbinaID();
    }

    @Override
    public String getIdName() {
        return "narudzbinaID";
    }

    @Override
    public LinkedList<DomainObject> getListFromRs(ResultSet rs) throws Exception {
        LinkedList<DomainObject> lista = new LinkedList<>();
        while(rs.next()){
          long id1=rs.getLong("n.narudzbinaID");
          
          long id = rs.getLong("st.stavkaNarudzbineID");
          double cenaBezPDV=rs.getDouble("st.iznosStavkiNarudzbineBezPDV");
          double cenaSaPDV=rs.getDouble("st.iznosStavkiNarudzbineSaPDV");
          
          long idAutomobila=rs.getLong("a.automobilID");  
          String marka = rs.getString("a.marka");
          int godiste=rs.getInt("a.godiste");
          String tip = rs.getString("a.tip");
          boolean dodaci=rs.getBoolean("a.dodaci");
          boolean polovno=rs.getBoolean("a.polovno");
          double cenaBezPDVAuto=rs.getDouble("a.cenaBezPDV");
          double cenaSaPDVAuto=rs.getDouble("a.cenaSaPDV");
          
          
          
          TipAutomobila tipAuto=TipAutomobila.getName(tip);
          
          Automobil a= new Automobil(idAutomobila, marka, godiste, tipAuto, dodaci, polovno, cenaBezPDVAuto, cenaSaPDVAuto);
          
//          Automobil a= new Automobil();
//          a.setAutomobilID(idAutomobila);
          
          Narudzbina n=new Narudzbina(id1, null, 0, 0, null, null);
          
          StavkaNarudzbine st= new StavkaNarudzbine(n, id, cenaBezPDV, cenaSaPDV, a);
          lista.add(st);
        }
        return lista;
    }

    @Override
    public String setQueryForUpdate() {
        return "update stavkanaruzbine set iznosStavkiNarudzbineBezPDV = "+iznosStavkiNarudzbineBezPDV+
                ", iznosStavkiNaruzbineSaPDV = "+iznosStavkiNarudzbineSaPDV+", automobilID= "+automobilID+" WHERE stavkaNarudzbineID = "+stavkaNarudzbineID+" and narudzbinaID= "+naruzbinaID.getNarudzbinaID();
    }

    @Override
    public String prepareQueryForSelect() {
        return "select * from stavkanaruzbine st join automobil a on (st.automobilID=a.automobilID) join narudzbina n on (st.narudzbinaID=n.narudzbinaID)";
    }

    public long getStavkaNarudzbineID() {
        return stavkaNarudzbineID;
    }

    public void setStavkaNarudzbineID(long stavkaNarudzbineID) {
        this.stavkaNarudzbineID = stavkaNarudzbineID;
    }

    public double getIznosStavkiNarudzbineBezPDV() {
        return iznosStavkiNarudzbineBezPDV;
    }

    public void setIznosStavkiNarudzbineBezPDV(double iznosStavkiNarudzbineBezPDV) {
        this.iznosStavkiNarudzbineBezPDV = iznosStavkiNarudzbineBezPDV;
    }

    public double getIznosStavkiNarudzbineSaPDV() {
        return iznosStavkiNarudzbineSaPDV;
    }

    public void setIznosStavkiNarudzbineSaPDV(double iznosStavkiNarudzbineSaPDV) {
        this.iznosStavkiNarudzbineSaPDV = iznosStavkiNarudzbineSaPDV;
    }



    public Narudzbina getNaruzbinaID() {
        return naruzbinaID;
    }

    public void setNaruzbinaID(Narudzbina naruzbinaID) {
        this.naruzbinaID = naruzbinaID;
    }

    public Automobil getAutomobilID() {
        return automobilID;
    }

    public void setAutomobilID(Automobil automobilID) {
        this.automobilID = automobilID;
    }
    
}
