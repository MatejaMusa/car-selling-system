package logika.impl;

import domen.DomainObject;
import domen.Narudzbina;
import domen.StavkaNarudzbine;
import java.util.LinkedList;
import logika.SistemskeOperacije;


public class VratiNarudzbeniceSO extends SistemskeOperacije{

    public VratiNarudzbeniceSO() {
        super();
    }

    
    @Override
    protected void operation() throws Exception {
        LinkedList<DomainObject> listaNarudzbina = dbbr.getAll(Narudzbina.class, "", "");
        LinkedList<DomainObject> listaStavkiNarudzbina = dbbr.getAll(StavkaNarudzbine.class, "", "");
        
        
        for (DomainObject stavka : listaStavkiNarudzbina) {
           StavkaNarudzbine st = (StavkaNarudzbine) stavka;     
                      for (DomainObject narudzbina : listaNarudzbina) {
                          Narudzbina n = (Narudzbina)narudzbina;
                          if (st.getNaruzbinaID().getNarudzbinaID()== n.getNarudzbinaID()){
                              n.getStavke().add(st);
                          }
                      }
                  }
        lista=listaNarudzbina;
            
    }
        
}
    

