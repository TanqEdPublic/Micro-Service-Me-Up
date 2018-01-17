package ie.gmit.sw.services;

import ie.gmit.sw.controllers.requests.MailTokenRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


@Service("emailService")
public class EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    private RestTemplate restTemplate;

    @Value("${gateway.gateway-path}")
    String appUrl;// need change to zuul url later
    @Value("${gateway.email-path}")
    String emailUrl;

    @Autowired
    public EmailService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Async("executor")
    public void sendEmail(String email, String token) {

        LOGGER.info("@@@@@@@@@@ Email Sender Service thread: "
                + Thread.currentThread().getName());

        List<String> to = new ArrayList<>();
        MailTokenRequest tokenMail = new MailTokenRequest();
        to.add(email);

        tokenMail.setTo(to);
        tokenMail.setSubject("Registration Confirmation");
        tokenMail.setText("To confirm your e-mail address, please click the link below:\n"
                + appUrl + "/reg/verify/" + token); // use API root defined in Zuul
                                                    // Registration API /reg/ in this case
        tokenMail.setFrom("noreply@domain.com");

        // send email
/*
        SimpleMailMessage registrationEmail = new SimpleMailMessage();
        registrationEmail.setTo(email);
        registrationEmail.setSubject("Registration Confirmation");
        registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
                + appUrl + "/verify/" + token);
        registrationEmail.setFrom("noreply@domain.com"); */

        String response = restTemplate.postForObject(emailUrl, tokenMail, String.class);


        LOGGER.info("###### Email Service responses: " + response);

    }
}