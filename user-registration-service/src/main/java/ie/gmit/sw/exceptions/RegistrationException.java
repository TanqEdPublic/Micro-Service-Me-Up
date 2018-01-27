package ie.gmit.sw.exceptions;

public class RegistrationException extends RuntimeException {

    public RegistrationException(String msg){
        super(msg);
    }

    public RegistrationException(String msg, Throwable t){
        super(msg, t);
    }
}
