package validacija.impl;

import domen.DomainObject;
import domen.Kupac;
import validacija.Validator;

public class ValidacijaKupca implements Validator{



    @Override
    public void validate(DomainObject value) throws Exception {
        try {
            Kupac k=(Kupac) value;
            if(k.getImeKupca().equals("")){
                throw new Exception("Ime ne sme biti prazno");
            }
            if(k.getPrezimeKupca().equals("")){
                throw new Exception("Prezime ne sme biti prazno");
            }
            if(k.getAdresa().equals("")){
                throw new Exception("Adresa ne sme biti prazna");
            }
            if(k.getBrojTelefona().equals("")){
                throw new Exception("Broj telefona ime ne sme biti prazan");
            }
            String regex2="[0-9]*";
            if(!k.getBrojTelefona().matches(regex2)){
                throw new Exception("Broj telefona mora biti sacinjen od cifara ");
            }
            if(k.getEmail().equals("")){
                throw new Exception("Email ne sme biti prazan");
            }
            String regex="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}";
            if(!k.getEmail().matches(regex)){
                throw new Exception("Email nije validan");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
