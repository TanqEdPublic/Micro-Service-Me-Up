package ie.gmit.sw.exceptions;

public class VerificationTokenExpiredException extends RegistrationException{

    public VerificationTokenExpiredException(String msg) {
        super(msg);
    }

    public VerificationTokenExpiredException(String msg, Throwable t) {
        super(msg, t);
    }
}
