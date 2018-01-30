package ie.gmit.sw.controllers;

import ie.gmit.sw.controllers.requests.NewUserRequest;
import ie.gmit.sw.domain.User;
import ie.gmit.sw.domain.UserFactory;
import ie.gmit.sw.exceptions.*;
import ie.gmit.sw.services.users.UserRegistratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {
    private UserRegistratorService service;

    @Autowired
    private UserFactory uf;

    @Autowired
    public RegistrationController(UserRegistratorService service) {
        this.service = service;
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public ResponseEntity<?> newUser(@RequestBody NewUserRequest user){

        User newUser = uf.getUserFromRequest(user);

        try {
            service.createNewUser(newUser);

            return ResponseEntity.ok("Successfully registered!");
        } catch (DuplicateUserException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (UnexpectedRegistrationException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    // follows are extra methods:
    @GetMapping("/verify/{token}")
    public ResponseEntity<?> verifyUser(@PathVariable String token){
        // return boolean for verification
        try{
            service.verifyUserByToken(token);
            return ResponseEntity.ok("Account verified. You may login.");
        } catch(VerificationTokenNotFoundException ex){

            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch(VerificationTokenExpiredException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }
}
