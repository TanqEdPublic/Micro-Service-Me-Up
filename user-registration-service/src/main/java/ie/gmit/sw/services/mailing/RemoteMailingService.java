package ie.gmit.sw.services.mailing;

import org.springframework.mail.MailMessage;

public interface RemoteMailingService {

    void sendEmail(String address, MailMessage mailMessage);

}
