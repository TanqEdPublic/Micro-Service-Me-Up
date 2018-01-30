package ie.gmit.sw.services.mailing.exceptions;

public class MailServiceNotAvailableException extends RemoteMailException{


    public MailServiceNotAvailableException(String message) {
        super(message);
    }

    public MailServiceNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
