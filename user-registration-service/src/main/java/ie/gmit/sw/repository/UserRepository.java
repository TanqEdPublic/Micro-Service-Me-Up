package ie.gmit.sw.repository;


import ie.gmit.sw.domain.User;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GraphRepository<User>{

    User findByUsername(String email);
}
