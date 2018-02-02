package ie.gmit.sw.repository;

import ie.gmit.sw.domain.Role;
import ie.gmit.sw.domain.UserRole;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface UserRolesRepository extends GraphRepository<Role> {

    Role findRoleByName(UserRole role);

    @Query("MATCH (user {username: {0}})-[rel: HAS_ROLE]-(role {name: {1}}) DELETE rel")
    void removeRole(String user, String role);

    @Query("MATCH (u:User {username: {0}}), (r:Role {name: {1}})" +
            "CREATE (u)-[: HAS_ROLE]->(r)")
    void addRole(String user, String role);

}
