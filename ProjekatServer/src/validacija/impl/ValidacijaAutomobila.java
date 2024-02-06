package validacija.impl;

import domen.Automobil;
import domen.DomainObject;
import validacija.Validator;

public class ValidacijaAutomobila implements Validator{

    @Override
    public void validate(DomainObject value) throws Exception {
         try {
             Automobil a=(Automobil) value;
            if(a.getMarka().equals("")){
                throw new Exception("Marka automobila ne sme biti prazna");
            }
            if(Double.compare(a.getCenaBezPDV(), 0.00)==-1 || Double.compare(a.getCenaBezPDV(), 0.00)==0){
                throw new Exception("Cena ne moze da bude manja ili jednaka 0");
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
