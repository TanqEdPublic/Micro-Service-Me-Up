package ie.gmit.sw.Repository;

import ie.gmit.sw.Model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoItemDAO extends MongoRepository<Item, String> {
    public List<Item> findByEmail(String email);
    public Item findByTitle(String title);
}
