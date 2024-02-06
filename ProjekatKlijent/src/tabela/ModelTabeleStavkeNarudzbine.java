package tabela;


import domen.StavkaNarudzbine;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleStavkeNarudzbine extends AbstractTableModel{
    LinkedList<StavkaNarudzbine> stavkeNarudzbine;
    String[] kolone={"Automobil","Iznos bez PDV","Iznos sa PDV"};
    public ModelTabeleStavkeNarudzbine() {
    }

    public ModelTabeleStavkeNarudzbine(LinkedList<StavkaNarudzbine> stavkeNarudzbine) {
        this.stavkeNarudzbine = stavkeNarudzbine;
    }
    
    @Override
    public int getRowCount() {
        return stavkeNarudzbine.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaNarudzbine sn=(StavkaNarudzbine) stavkeNarudzbine.get(rowIndex);
        
        switch(columnIndex){
            
            case 0: return sn.getAutomobilID();
            case 1: return sn.getIznosStavkiNarudzbineBezPDV();
            case 2: return sn.getIznosStavkiNarudzbineSaPDV();
            
            default:return "STAGOD";
        }
    }

    @Override
    public String getColumnName(int column) {
            return kolone[column];
    }

    public void obrisi(int row) {
        stavkeNarudzbine.remove(row);
        fireTableDataChanged();
    }

    public void dodaj(StavkaNarudzbine st) {
            if (!stavkeNarudzbine.contains(st)){
                stavkeNarudzbine.add(st);
                fireTableDataChanged();
        }
    }

    public LinkedList<StavkaNarudzbine> vratiListu() {
        return stavkeNarudzbine;
    }

    public StavkaNarudzbine vratiStavku(int row) {
        return stavkeNarudzbine.get(row);
    }
    
}
