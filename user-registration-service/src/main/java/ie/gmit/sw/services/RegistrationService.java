package ie.gmit.sw.services;

import ie.gmit.sw.controllers.responses.RegResponse;
import ie.gmit.sw.domain.Role;
import ie.gmit.sw.domain.User;
import ie.gmit.sw.domain.VerificationToken;
import ie.gmit.sw.repository.UserRepository;
import ie.gmit.sw.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService {

    private UserRepository userRepo;
    private VerificationTokenRepository tokenRepo;
    private EmailService emailService;

    @Autowired
    public RegistrationService(UserRepository userRepo,
                               VerificationTokenRepository tokenRepo,
                               EmailService emailService) {
        this.userRepo = userRepo;
        this.tokenRepo = tokenRepo;
        this.emailService = emailService;
    }


/*
    public RegistrationService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
*/

    public User findUserByEmail(String email){
        return userRepo.findByUsername(email);
    }

    public RegResponse newUser(User user){
        // check if the user is exist
        // here, user email is unique !!!
        if(findUserByEmail(user.getUsername()) != null){
            return new RegResponse("duplicate user !");
        }

        List<Role> roles = new ArrayList<>();
        roles.add(new Role("PENDING_USER"));
        user.setRoles((roles));
        user.setEnabled(false);
        userRepo.save(user);

        // generate token
        VerificationToken token = new VerificationToken(user);
        tokenRepo.save(token);

        // call method here to send email
        try{
            emailService.sendEmail(user.getUsername(), token.getToken());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        // return status
        return new RegResponse("registered !");
    }


    public boolean verifyUser(String token){
        System.out.println("@@@@@@@@@@ Verify User thread: "
                + Thread.currentThread().getName());
        // find token in database
        VerificationToken vt = tokenRepo.findByToken(token);

        if(vt == null){
            // return false if token not found
            return false;
        }else{
            // return
            return vt.isTokenExpired(); // reverse boolean
                                           // because method return true if token
                                           // is expired, but we need to return
                                           // false to controller in this case
        }
    }

    // Method executed asynchronously by specified thread executor
    // This should improve responses time of the Service, while this
    // method performs few more repository actions after token is verified.
    // Note, you can not call this method inside other method in this class, it will be
    // executed by the same thread that is running method from this class.
    @Async("executor")
    public void finishVerification(String token) throws InterruptedException{
        System.out.println("@@@@@@ Execute method asynchronously. "
                + Thread.currentThread().getName());
        VerificationToken vt = tokenRepo.findByToken(token);
        // if token is found, get current user, and set enabled to true
        User user = vt.getUser();
        user.setEnabled(true);

        // Need to figure out efficient way to add, remove, change authorities.
        // user.setAuthority(new Authority("USER"));

        userRepo.save(user);
        tokenRepo.delete(vt);

        // while (true){} // for async call testing
    }


    public List<User> allUsers(){

        return (ArrayList) userRepo.findAll();
    }

}
