package ie.gmit.sw.Repository;

import java.util.List;
import ie.gmit.sw.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface MongoDAO extends MongoRepository<User, String>{
    public User findByUsername(String username);
}
