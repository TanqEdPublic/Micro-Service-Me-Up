package ie.gmit.sw.controllers;

import ie.gmit.sw.domain.RemoteMailMessage;
import ie.gmit.sw.domain.SimpleMailMessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MailController {

    // Also service in my opinion, so no need to create custom.
    private MailSender mailSender;

    // Maps mailing request to a simple mail message
    private SimpleMailMessageFactory simpleMailMessageFactory;

    @Autowired
    public MailController(MailSender mailSender,
                          SimpleMailMessageFactory simpleMailMessageFactory) {
        this.mailSender = mailSender;
        this.simpleMailMessageFactory = simpleMailMessageFactory;
    }

    @PostMapping("/sendemail")
    public ResponseEntity<?> sendEmail(@RequestBody RemoteMailMessage rmm){
        SimpleMailMessage smm = simpleMailMessageFactory.mapFromRequest(rmm);

        try {
            mailSender.send(smm);
        }catch (MailException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok("Email Sent Successfully");

    }

}
