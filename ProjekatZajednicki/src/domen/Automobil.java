package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Automobil implements DomainObject,Serializable{
    
    private long automobilID;
    private String marka;
    private int godiste;
    private TipAutomobila tip;
    private boolean dodaci;
    private boolean polovno;
    private double cenaBezPDV;
    private double cenaSaPDV;
    //private boolean narucen;

    public Automobil() {
    }

    public Automobil(long automobilID, String marka, int godiste, TipAutomobila tip, boolean dodaci, boolean polovno, double cenaBezPDV, double cenaSaPDV) {
        this.automobilID = automobilID;
        this.marka = marka;
        this.godiste = godiste;
        this.tip = tip;
        this.dodaci = dodaci;
        this.polovno = polovno;
        this.cenaBezPDV = cenaBezPDV;
        this.cenaSaPDV = cenaSaPDV;
        //this.narucen = narucen;
    }

   
    
    
      @Override
    public String getTableName() {
        return "automobil";
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(long aLong) {
        automobilID=aLong;
    }

    @Override
    public String getAttributeNamesForInsert() {
         String s = "";
        
        s+= "marka";
        s+= ",godiste";
        s+= ",tip";
        s+= ",dodaci";
        s+= ",polovno";
        s+= ",cenaBezPDV";
        s+= ",cenaSaPDV";
        
        
        return s;
    }

    @Override
    public String getAttributeValuesForInsert() {
        return "'"+marka+"', "+godiste+", '"+tip.toString()+"', "+dodaci+", "+polovno+", "+cenaBezPDV+", "+cenaSaPDV;
    }

    @Override
    public long getId() {
        return automobilID;
    }

    @Override
    public String getIdName() {
        return "automobilID";
    }

    @Override
    public LinkedList<DomainObject> getListFromRs(ResultSet rs) throws Exception {
         LinkedList<DomainObject> lista = new LinkedList<>();
        while(rs.next()){
          long id = rs.getLong("automobilID");
          String marka = rs.getString("marka");
          int godiste=rs.getInt("godiste");
          String tip = rs.getString("tip");
          boolean dodaci=rs.getBoolean("dodaci");
          boolean polovno=rs.getBoolean("polovno");
          double cenaBezPDV=rs.getDouble("cenaBezPDV");
          double cenaSaPDV=rs.getDouble("cenaSaPDV");
          
          
          
          TipAutomobila tipAuto=TipAutomobila.getName(tip);
          
          Automobil a= new Automobil(id, marka, godiste, tipAuto, dodaci, polovno, cenaBezPDV, cenaSaPDV);
          lista.add(a);
          
        }
        return lista;
    }

    @Override
    public String setQueryForUpdate() {
        return "update automobil set marka = '"+marka+
                "', godiste = "+godiste+", tip = '"+tip.toString()+"', dodaci = "+dodaci+", polovno = "+polovno+", cenaBezPDV = "+cenaBezPDV+", cenaSaPDV= "+cenaSaPDV+" WHERE automobilID = "+automobilID;
    }

    @Override
    public String prepareQueryForSelect() {
        return "select * from automobil";
    }

    public long getAutomobilID() {
        return automobilID;
    }

    public void setAutomobilID(long automobilID) {
        this.automobilID = automobilID;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getGodiste() {
        return godiste;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    public TipAutomobila getTip() {
        return tip;
    }

    public void setTip(TipAutomobila tip) {
        this.tip = tip;
    }

    public boolean isDodaci() {
        return dodaci;
    }

    public void setDodaci(boolean dodaci) {
        this.dodaci = dodaci;
    }

    public boolean isPolovno() {
        return polovno;
    }

    public void setPolovno(boolean polovno) {
        this.polovno = polovno;
    }

    public double getCenaBezPDV() {
        return cenaBezPDV;
    }

    public void setCenaBezPDV(double cenaBezPDV) {
        this.cenaBezPDV = cenaBezPDV;
    }

    public double getCenaSaPDV() {
        return cenaSaPDV;
    }

    public void setCenaSaPDV(double cenaSaPDV) {
        this.cenaSaPDV = cenaSaPDV;
    }



    @Override
    public String toString() {
        return marka;
    }
    
    
}
