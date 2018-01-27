package ie.gmit.sw.controllers;

import ie.gmit.sw.controllers.requests.NewUserRequest;
import ie.gmit.sw.controllers.responses.RegResponse;
import ie.gmit.sw.domain.User;
import ie.gmit.sw.domain.UserFactory;
import ie.gmit.sw.services.EmailService;
import ie.gmit.sw.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {
    private RegistrationService service;


    @Autowired
    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public RegResponse newUser(@RequestBody NewUserRequest user){

        // Call user factory here
        UserFactory uf = UserFactory.getInstance();
        User newUser = uf.getUserFromRequest(user);
        return service.newUser(newUser);
    }

    // follows are extra methods:
    @GetMapping("/verify/{token}")
    public String verifyUser(@PathVariable String token){
        // return boolean for verification
        if(service.verifyUser(token)){
            try {
                // Call method asynchronously to return responses
                // earlier than this method finish. Reduce delay time to produce responses.
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
