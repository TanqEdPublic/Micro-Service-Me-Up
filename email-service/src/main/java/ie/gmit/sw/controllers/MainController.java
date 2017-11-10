package ie.gmit.sw.controllers;

import ie.gmit.sw.domain.MailMsg;
import ie.gmit.sw.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private EmailService emailService;

    @Autowired
    public MainController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendemail")
    public String sendEmail(@RequestBody MailMsg mailMessage){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(mailMessage.getFrom());
        mail.setTo((String[])mailMessage.getTo().toArray());
        mail.setSubject(mailMessage.getSubject());
        mail.setReplyTo(mailMessage.getReplyTo());
        mail.setCc((String[])mailMessage.getCc().toArray());
        mail.setBcc((String[])mailMessage.getBcc().toArray());
        mail.setSentDate(mailMessage.getSentDate());
        mail.setText(mailMessage.getText());
        try {
            emailService.sendEmail(mail);
        }catch (Exception e){
            return e.getMessage();
        }

        return new String("Email sent success!");

    }

}
