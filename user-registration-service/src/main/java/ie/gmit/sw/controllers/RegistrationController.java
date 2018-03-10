package ie.gmit.sw.controllers;

import ie.gmit.sw.controllers.requests.NewUserRequest;
import ie.gmit.sw.controllers.responses.RegistrationResponse;
import ie.gmit.sw.domain.User;
import ie.gmit.sw.domain.UserFactory;
import ie.gmit.sw.exceptions.*;
import ie.gmit.sw.services.users.UserRegistratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        RegistrationResponse response;

        try {
            service.createNewUser(newUser);
            response = new RegistrationResponse("Successfully created!");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DuplicateUserException ex){
            response = new RegistrationResponse(ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        } catch (UnexpectedRegistrationException ex){
            response = new RegistrationResponse(ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }

    // follows are extra methods:
    @GetMapping("/verify/{token}")
    public ResponseEntity<?> verifyUser(@PathVariable String token){
        // return boolean for verification
        RegistrationResponse response;
        try{

            service.verifyUserByToken(token);
            response = new RegistrationResponse("Account verified. You may login.");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        } catch(VerificationTokenNotFoundException ex){

            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch(VerificationTokenExpiredException ex){
            response = new RegistrationResponse(ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }
}
