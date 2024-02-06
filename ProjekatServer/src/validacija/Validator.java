package validacija;

import domen.DomainObject;


public interface Validator {
    public void validate(DomainObject value) throws Exception;
}
