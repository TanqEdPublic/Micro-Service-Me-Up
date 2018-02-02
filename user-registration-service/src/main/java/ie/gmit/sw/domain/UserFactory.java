package ie.gmit.sw.domain;

import ie.gmit.sw.controllers.requests.NewUserRequest;
import ie.gmit.sw.services.roles.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {
    private static UserFactory instance;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRolesService userRolesService;

    public static UserFactory getInstance() {

        if(instance == null) instance = new UserFactory();

        return instance;
    }


    private UserFactory() {
    }


    // Factory method is good in Web MVC to map request domain objects to
    // database model objects. This way we encapsulate creation of model from Controllers
    // and Services, therefor free to change mapping of domain requests and database models.


    public User getUserFromRequest(NewUserRequest request){

        User user = new User();
        user.setUsername(request.getEmail());
        String encoded_pass = passwordEncoder.encode(request.getPassword());
        user.setPassword(encoded_pass);
        user.setEnabled(false);

        return user;
    }
}
