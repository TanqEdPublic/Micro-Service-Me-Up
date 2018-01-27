package ie.gmit.sw.domain;

import ie.gmit.sw.controllers.requests.NewUserRequest;

import java.util.ArrayList;
import java.util.List;

public class UserFactory {
    private static UserFactory instance;

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

        User user = new User(request.getEmail(), request.getPassword());
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("PENDING_USER"));
        user.setRoles((roles));
        user.setEnabled(false);

        return user;
    }
}
