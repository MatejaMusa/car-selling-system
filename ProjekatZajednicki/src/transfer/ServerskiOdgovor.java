package transfer;

import java.io.Serializable;

public class ServerskiOdgovor implements Serializable{
      
    private Exception exception;
    private Object odgovor;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Exception exception, Object odgovor) {
        this.exception = exception;
        this.odgovor = odgovor;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
