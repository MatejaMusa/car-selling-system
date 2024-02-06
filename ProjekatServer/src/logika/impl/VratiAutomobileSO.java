package logika.impl;

import domen.Automobil;
import domen.DomainObject;


import domen.StavkaNarudzbine;
import java.util.Iterator;
import java.util.LinkedList;
import logika.SistemskeOperacije;

public class VratiAutomobileSO extends SistemskeOperacije{
    
    public VratiAutomobileSO(){
        super();
    }
    @Override
    protected void operation() throws Exception {
        LinkedList<DomainObject> listaAutomobila = dbbr.getAll(Automobil.class, "", "");
        LinkedList<DomainObject> stavke = dbbr.getAll(StavkaNarudzbine.class, "", "");
        for(Iterator<DomainObject> iterator=listaAutomobila.iterator(); iterator.hasNext();){
            Automobil auto=(Automobil) iterator.next();
            for(DomainObject stavka: stavke){
                StavkaNarudzbine st=(StavkaNarudzbine) stavka;
                if(auto.getAutomobilID()==st.getAutomobilID().getAutomobilID()){
                    iterator.remove();
                }
            }
        }
       // LinkedList<DomainObject> zaIzbaciti=new LinkedList<>();
//            for (DomainObject automobil : listaAutomobila) {
//                  Automobil auto = (Automobil)automobil;
//                  for (DomainObject stavka : stavke) {
//                      StavkaNarudzbine st=(StavkaNarudzbine) stavka;
//                      
//                        //if(st.getAutomobilID().getAutomobilID()== auto.getAutomobilID()){
//                            //listaAutomobila.remove(auto);
//                            //DomainObject a=(DomainObject)auto;
//                            //zaIzbaciti.add(a);
//                        }
//                    }
                lista=listaAutomobila;
            }
        
    }
    

