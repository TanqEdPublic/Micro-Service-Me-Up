package ie.gmit.sw.services.roles;

import ie.gmit.sw.domain.User;
import ie.gmit.sw.domain.UserRole;

public interface UserRolesService {

    void setRole(User user, UserRole userRole);
    void changeRole(User user, UserRole oldRole, UserRole newRole);
    void removeRole(User user, UserRole userRole);

}
