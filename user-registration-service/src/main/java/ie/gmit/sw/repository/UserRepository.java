package ie.gmit.sw.repository;


import ie.gmit.sw.domain.User;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface UserRepository extends GraphRepository<User>{

    User findByUsername(String name);
}
