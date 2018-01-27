package ie.gmit.sw.exceptions;

public class DuplicateUserException extends RegistrationException {


    public DuplicateUserException(String msg) {
        super(msg);
    }

    public DuplicateUserException(String msg, Throwable t) {
        super(msg, t);
    }
}
