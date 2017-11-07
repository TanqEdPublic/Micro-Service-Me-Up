package ie.gmit.sw.Controllers;

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
    public String sendEmail(@RequestBody SimpleMailMessage emailMessage){
        try {
            emailService.sendEmail(emailMessage);
        }catch (Exception e){
            return e.getMessage();
        }

        return new String("Email sent success!");

    }

}
