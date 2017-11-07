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


    @Autowired
    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @RequestMapping("/user/{name}")
    public User getUser(@PathVariable String name){
        return service.findUser(name);
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public User newUser(@RequestBody NewUserRequest user){
        User newUser = new User(user.getEmail(), user.getUsername(), user.getPassword());

        return service.newUser(newUser);
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
