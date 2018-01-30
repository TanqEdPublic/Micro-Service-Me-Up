package ie.gmit.sw.services.mailing.exceptions;

public class RemoteMailException extends RuntimeException{
    private static final long serialVersionUID = 5902781148603281917L;

    public RemoteMailException(String message) {
        super(message);
    }

    public RemoteMailException(String message, Throwable cause) {
        super(message, cause);
    }
}
