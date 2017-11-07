package ie.gmit.sw.controllers;

import ie.gmit.sw.controllers.requests.NewUserRequest;
import ie.gmit.sw.domain.User;
import ie.gmit.sw.services.EmailService;
import ie.gmit.sw.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {

    private RegistrationService service;
    private EmailService emailService;

    @Autowired
    public RegistrationController(RegistrationService service, EmailService emailService) {
        this.service = service;
        this.emailService = emailService;
    }

    @RequestMapping("/user/{name}")
    public User getUser(@PathVariable String name){
        return service.findUser(name);
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public User newUser(@RequestBody NewUserRequest user){
        User newUser = new User(user.getEmail(), user.getUsername(), user.getPassword());
        String token = service.newUser(newUser);

        // send email
        String appUrl = "http://localhost:8091";// need change to zuul url later
        SimpleMailMessage registrationEmail = new SimpleMailMessage();
        registrationEmail.setTo(user.getEmail());
        registrationEmail.setSubject("Registration Confirmation");
        registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
                + appUrl + "/verify/" + token);
        registrationEmail.setFrom("noreply@domain.com");
        emailService.sendEmail(registrationEmail);

        return service.findUser(user.getUsername());
    }

    @GetMapping("/verify/{token}")
    public String verifyUser(@PathVariable String token){

        // return boolean for verification
        if(service.verifyUser(token)){
            try {
                // Call method asynchronously to return response
                // earlier than this method finish. Reduce delay time to produce response.
                service.finishVerification(token);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            return "good";
        }else {
            return "bad";
        }
    }


    @RequestMapping("/users")
    public List<User> allUsers(){
        return service.allUsers();
    }
}
