package ie.gmit.sw.services;

import ie.gmit.sw.domain.User;
import ie.gmit.sw.exceptions.RegistrationException;

public interface UserRegistratorService {

    void createNewUser(User user) throws RegistrationException;
    void verifyUserByToken(String token) throws RegistrationException;

}
