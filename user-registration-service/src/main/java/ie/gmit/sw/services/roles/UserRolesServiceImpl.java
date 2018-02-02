package ie.gmit.sw.services.roles;

import ie.gmit.sw.domain.Role;
import ie.gmit.sw.domain.User;
import ie.gmit.sw.domain.UserRole;
import ie.gmit.sw.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserRolesServiceImpl implements UserRolesService {

    private UserRolesRepository rolesRepo;

    @Autowired
    public UserRolesServiceImpl(UserRolesRepository rolesRepo) {
        this.rolesRepo = rolesRepo;
    }

    @PostConstruct
    public void init(){

        List<Role> roles = (List<Role>) rolesRepo.findAll();
        if(roles.isEmpty()){
            roles.add(new Role(UserRole.ROLE_PENDING));
            roles.add(new Role(UserRole.ROLE_ADMIN));
            roles.add(new Role(UserRole.ROLE_USER));

            rolesRepo.save(roles);
        }

    }

    @Override
    public void setRole(User user, UserRole userRole) {

        rolesRepo.addRole(user.getUsername(), userRole.toString());
    }

    @Override
    public void changeRole(User user, UserRole oldRole, UserRole newRole) {

        rolesRepo.removeRole(user.getUsername(), oldRole.toString());

        rolesRepo.addRole(user.getUsername(), newRole.toString());

    }

    @Override
    public void removeRole(User user, UserRole userRole) {
        rolesRepo.removeRole(user.getUsername(), userRole.toString());
    }
}
