package tabela;

import domen.DomainObject;
import domen.Narudzbina;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleNarudzbina extends AbstractTableModel{
    LinkedList<DomainObject> narudzbine;
    String[] kolone={"Korisnik","Kupac","Datum izdavanja","Ukupan iznos bez PDV", "Ukupan iznos sa PDV"};

    public ModelTabeleNarudzbina(LinkedList<DomainObject> narudzbine) {
        this.narudzbine = narudzbine;
    }
    
    @Override
    public int getRowCount() {
        return narudzbine.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Narudzbina n=(Narudzbina) narudzbine.get(rowIndex);
        SimpleDateFormat sdf= new SimpleDateFormat("dd.MM.yyyy");
        switch(columnIndex){
            case 0: return n.getKorisnikID();
            case 1: return n.getKupacID();
            case 2: return sdf.format(n.getDatumIzdavanja());
            case 3: return n.getUkupanIznosBezPDV();
            case 4: return n.getUkupanIznosSaPDV();
            
            default: return "STAGOD";
            
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public Narudzbina vratiNaruzbinu(int red){
        return (Narudzbina) narudzbine.get(red);
    }
    
    
      public void pretrazi(String s) {
        LinkedList<DomainObject> novaLista = new LinkedList<>();
        for (DomainObject n : narudzbine) {
            Narudzbina narudzbina = (Narudzbina) n;
            if(narudzbina.getKorisnikID().toString().toUpperCase().contains(s.toUpperCase())){
                novaLista.add(narudzbina);
            }
            if(narudzbina.getKupacID().toString().toUpperCase().contains(s.toUpperCase())){
                novaLista.add(narudzbina);
            }
        }
        narudzbine = novaLista;
        fireTableDataChanged();
    }
    
}
