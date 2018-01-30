package ie.gmit.sw.domain;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SimpleMailMessageFactory {
    private static SimpleMailMessageFactory ourInstance = new SimpleMailMessageFactory();

    public static SimpleMailMessageFactory getInstance() {
        return ourInstance;
    }

    private SimpleMailMessageFactory() {
    }


    public SimpleMailMessage mapFromRequest(RemoteMailMessage rmm){
        SimpleMailMessage smm = new SimpleMailMessage();

        smm.setFrom("noreply@tanqed-public.com"); // need to move to config file
        smm.setTo(rmm.getTo());
        smm.setReplyTo(rmm.getReplyTo());
        smm.setCc(rmm.getCc());
        smm.setBcc(rmm.getBcc());
        smm.setSubject(rmm.getSubject());
        smm.setText(rmm.getText());
        smm.setSentDate(new Date());

        return smm;
    }
}
