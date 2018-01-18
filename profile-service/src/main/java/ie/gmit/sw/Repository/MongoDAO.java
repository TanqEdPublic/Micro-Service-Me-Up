package ie.gmit.sw.Repository;

import ie.gmit.sw.Model.UserDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface MongoDAO extends MongoRepository<UserDetail, String>{
    public UserDetail findByEmail(String email);
    public UserDetail findByNickName(String nickName);
}
