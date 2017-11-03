package ie.gmit.sw.services;

import ie.gmit.sw.domain.Authority;
import ie.gmit.sw.domain.User;
import ie.gmit.sw.domain.VerificationToken;
import ie.gmit.sw.repository.UserRepository;
import ie.gmit.sw.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService {

    private UserRepository userRepo;
    private VerificationTokenRepository tokenRepo;

    @Autowired
    public RegistrationService(UserRepository userRepo,VerificationTokenRepository tokenRepo) {
        this.userRepo = userRepo;
        this.tokenRepo = tokenRepo;
    }


/*
    public RegistrationService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
*/

    public User findUser(String username){
        User user = userRepo.findByUsername(username);
        System.out.println(user.getUsername());
        return user;
    }

    public void newUser(User user){
        user.setAuthority(new Authority("PENDING_USER"));
        user.setEnabled(false);
        userRepo.save(user);

        // generate token
        VerificationToken token = new VerificationToken(user);
        tokenRepo.save(token);
    }

    public List<User> allUsers(){

        return (ArrayList) userRepo.findAll();
    }

}
