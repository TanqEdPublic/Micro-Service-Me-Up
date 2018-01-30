package ie.gmit.sw.exceptions;

public class UnexpectedRegistrationException extends RegistrationException {

    private static final long serialVersionUID = 2269490536070404094L;

    public UnexpectedRegistrationException(String msg) {
        super(msg);
    }

    public UnexpectedRegistrationException(String msg, Throwable t) {
        super(msg, t);
    }
}
