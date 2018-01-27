package ie.gmit.sw.exceptions;

public class UnexpectedRegistrationException extends RegistrationException {

    public UnexpectedRegistrationException(String msg) {
        super(msg);
    }

    public UnexpectedRegistrationException(String msg, Throwable t) {
        super(msg, t);
    }
}
