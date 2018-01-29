package ie.gmit.sw.services.users;

import ie.gmit.sw.domain.User;
import ie.gmit.sw.domain.VerificationToken;
import ie.gmit.sw.exceptions.*;
import ie.gmit.sw.repository.UserRepository;
import ie.gmit.sw.repository.VerificationTokenRepository;
import ie.gmit.sw.services.mailing.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;

@Service
public class UserRegistrationServiceImpl implements UserRegistratorService {

    private UserRepository userRepo;
    private VerificationTokenRepository tokenRepo;
    private EmailService emailService;

    @Autowired
    @Qualifier("executor")
    private Executor executor;

    @Autowired
    public UserRegistrationServiceImpl(UserRepository userRepo,
                                   VerificationTokenRepository tokenRepo,
                                   EmailService emailService) {
        this.userRepo = userRepo;
        this.tokenRepo = tokenRepo;
        this.emailService = emailService;
    }

    @Override
    public void createNewUser(User user) throws RegistrationException {
        // check if the user is exist
        // here, user email is unique !!!
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new DuplicateUserException("User with this email address already exist.");
        }

        userRepo.save(user);

        VerificationToken token = new VerificationToken(user);
        tokenRepo.save(token);


        try{
            // send email with verification link
            emailService.sendEmail(user.getUsername(), token.getToken());
        }catch(Exception e){
            System.out.println(e.getMessage());

            // do roll back
            executor.execute(() -> {
                userRepo.delete(user);
                tokenRepo.delete(token);
            });
            throw new UnexpectedRegistrationException("Ops, something went wrong while registering! Try again later...");
        }

    }

    @Override
    public void verifyUserByToken(String token) throws RegistrationException {

        VerificationToken vt = tokenRepo.findByToken(token);

        if(vt == null) throw new VerificationTokenNotFoundException("Verification link is not valid.");
        if(vt.isTokenExpired()) throw new VerificationTokenExpiredException("Verification link is expired.");

        // Execute remaining of the operations in a separate thread
        // for faster response time of registration method.
        // Note how lambda expression can implement Runnable on a fly.
        executor.execute(() ->{
            // if token is found, get current user, and set enabled to true
            User user = vt.getUser();
            user.setEnabled(true);
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);

            // Need to figure out efficient way to add, remove, change authorities.
            // user.setAuthority(new Authority("USER"));

            userRepo.save(user);
            tokenRepo.delete(vt);
        });

    }
}
