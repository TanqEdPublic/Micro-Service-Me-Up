package ie.gmit.sw.repositories;

import ie.gmit.sw.models.User;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GraphRepository<User> {
    User findByUsername(String name);
    //User findByEmail(String email);
}
