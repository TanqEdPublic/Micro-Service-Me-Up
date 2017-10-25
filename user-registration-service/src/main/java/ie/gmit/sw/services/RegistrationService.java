package ie.gmit.sw.services;

import ie.gmit.sw.domain.Authority;
import ie.gmit.sw.domain.User;
import ie.gmit.sw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private UserRepository userRepo;

    @Autowired
    public RegistrationService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User findUser(String username){
        User user = userRepo.findByUsername(username);
        System.out.println(user.getUsername());
        return user;
    }

    public void newUser(User user){
        user.setAuthority(new Authority("PENDING_USER"));
        user.setEnabled(false);
        userRepo.save(user);
    }


}
