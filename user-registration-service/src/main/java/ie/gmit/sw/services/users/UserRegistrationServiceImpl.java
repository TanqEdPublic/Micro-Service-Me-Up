package ie.gmit.sw.services.users;

import ie.gmit.sw.domain.Role;
import ie.gmit.sw.domain.User;
import ie.gmit.sw.domain.VerificationToken;
import ie.gmit.sw.exceptions.*;
import ie.gmit.sw.repository.UserRepository;
import ie.gmit.sw.repository.VerificationTokenRepository;
import ie.gmit.sw.services.mailing.EmailService;
import ie.gmit.sw.services.mailing.MailMessageBuilder;
import ie.gmit.sw.services.mailing.RemoteMailMessage;
import ie.gmit.sw.services.mailing.RemoteMailSender;
import ie.gmit.sw.services.mailing.exceptions.MailServiceNotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.UnaryOperator;

@Service
public class UserRegistrationServiceImpl implements UserRegistratorService {

    private UserRepository userRepo;
    private VerificationTokenRepository tokenRepo;

    private RemoteMailSender remoteMailSender;
    private MailMessageBuilder mailMessageBuilder;

    @Value("${gateway.gateway-path}")
    private String appUrl;// need change to zuul url later

    @Autowired
    @Qualifier("executor")
    private Executor executor;

    @Autowired
    public UserRegistrationServiceImpl(UserRepository userRepo,
                                   VerificationTokenRepository tokenRepo,
                                   RemoteMailSender remoteMailSender,
                                   MailMessageBuilder mailMessageBuilder) {
        this.userRepo = userRepo;
        this.tokenRepo = tokenRepo;
        this.remoteMailSender = remoteMailSender;
        this.mailMessageBuilder = mailMessageBuilder;
    }

    @Override
    public void createNewUser(User user) throws RegistrationException {
        // check if the user is exist
        // here, user email is unique !!!
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new DuplicateUserException("User with this email address already exist.");
        }

        VerificationToken token = new VerificationToken(user);
        System.out.println("CREATE USER METHOD CALLED BY - " + Thread.currentThread().getName());

        executor.execute(() -> {
            try{
                System.out.println("EXECUTOR CALLED BY CREATE USER METHOD - " + Thread.currentThread().getName());

                userRepo.save(user);
                tokenRepo.save(token);


                RemoteMailMessage rmm = mailMessageBuilder
                        .setTo(new String[]{user.getUsername()})
                        .setSubject("Registration Confirmation")
                        .setText("To confirm your e-mail address, please click the link below:\n"
                                /*+ appUrl + */ + "http://localhost:8091" + "/verify/" + token.getToken())
                        .buildMessage();                                    // /reg

                remoteMailSender.sendMail(rmm);
            }catch(MailServiceNotAvailableException e){
                System.out.println(e.getMessage());
                // do roll back
                userRepo.delete(user);
                tokenRepo.delete(token);
                throw new MailServiceNotAvailableException("Mail Service is not available");
            }
        });


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

            System.out.println("VERIFY TOKEN METHOD CALLED BY - " + Thread.currentThread().getName());

            List<Role> roles = new ArrayList<>();
            roles.add(new Role("ROLE_USER"));
            // if token is found, get current user, and set enabled to true

            User user = vt.getUser();
            userRepo.delete(user);
            user.setEnabled(true);
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);

            user.setRoles(roles);
            //user.setRoles(roles);

            System.out.println("@@@@@@@@@@@@@@@@@@@@ " + user.toString());

            // Need to figure out efficient way to add, remove, change authorities.
            // user.setAuthority(new Authority("USER"));

            userRepo.save(user);
            //tokenRepo.delete(vt);
        });

    }
}
