package ie.gmit.sw.exceptions;

public class VerificationTokenNotFoundException extends RegistrationException {

    public VerificationTokenNotFoundException(String msg) {
        super(msg);
    }

    public VerificationTokenNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }
}
