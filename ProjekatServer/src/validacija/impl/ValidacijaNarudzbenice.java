package validacija.impl;

import domen.DomainObject;
import domen.Narudzbina;
import java.util.Date;
import validacija.Validator;

public class ValidacijaNarudzbenice implements Validator{

    @Override
    public void validate(DomainObject value) throws Exception {
        try {
            Narudzbina n = (Narudzbina) value;

//            if (n.getDatumIzdavanja().getTime()<(new Date().getTime())) {
//                throw new Exception("Datum izdavanja ili izmene ne moze biti u proslosti!");
//            }
            if (n.getStavke().size()<1) {
                throw new Exception("Narudzbina mora imati bar jednu stavku");
            }
            if(Double.compare(n.getUkupanIznosBezPDV(), 0.00)==-1 || Double.compare(n.getUkupanIznosBezPDV(), 0.00)==0){
                throw new Exception("Ukupan iznos bez PDV ne moze da bude manji ili jednak 0");
            }
            if(Double.compare(n.getUkupanIznosSaPDV(), 0.00)==-1 || Double.compare(n.getUkupanIznosSaPDV(), 0.00)==0){
                throw new Exception("Ukupan iznos sa PDV ne moze da bude manji ili jednak 0");
            }


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
