package ie.gmit.sw.controllers;

import ie.gmit.sw.controllers.requests.NewUserRequest;
import ie.gmit.sw.domain.User;
import ie.gmit.sw.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
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
        User newUser = new User(user.getUsername(), user.getPassword(), user.getEmail());
        service.newUser(newUser);
        return service.findUser(user.getUsername());
    }

    @RequestMapping("/users")
    public List<User> allUsers(){
        return service.allUsers();
    }
}
