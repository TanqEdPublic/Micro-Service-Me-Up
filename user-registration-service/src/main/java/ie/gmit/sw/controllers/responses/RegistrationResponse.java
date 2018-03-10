package ie.gmit.sw.controllers.responses;

import java.io.Serializable;

public class RegistrationResponse implements Serializable{
    private static final long serialVersionUID = 3449577661901920742L;

    private String message;

    public RegistrationResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
