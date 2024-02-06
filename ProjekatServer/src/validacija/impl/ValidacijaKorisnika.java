package validacija.impl;

import domen.DomainObject;
import domen.Korisnik;
import validacija.Validator;

public class ValidacijaKorisnika implements Validator{

    @Override
    public void validate(DomainObject value) throws Exception {
        try {
            Korisnik k=(Korisnik) value;
            if(k.getImeKorisnika().equals("")){
                throw new Exception("Ime ne sme biti prazno");
            }
            if(k.getPrezimeKorisnika().equals("")){
                throw new Exception("Prezime ne sme biti prazno");
            }
            if(k.getJmbg().equals("")){
                throw new Exception("JMBG ne sme biti prazan");
            }
            String regex="[0-9]{13}";
            if(!k.getJmbg().matches(regex)){
                throw new Exception("JMBG mora biti sacinjen od 13 cifara ");
            }
            
            if(k.getUsername().equals("")){
                throw new Exception("Korisnicko ime ne sme biti prazno");
            }
            if(k.getPassword().equals("")){
                throw new Exception("Lozinka ne sme biti prazna");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
