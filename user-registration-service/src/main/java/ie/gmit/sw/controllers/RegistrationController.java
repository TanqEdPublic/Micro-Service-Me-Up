package ie.gmit.sw.controllers;

import ie.gmit.sw.domain.User;
import ie.gmit.sw.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private RegistrationService service;

    @Autowired
    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @GetMapping("/getUser/{name}")
    public User getUser(@PathVariable String name){
        return service.findUser(name);
    }
}
