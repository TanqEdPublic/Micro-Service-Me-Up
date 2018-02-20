package ie.gmit.sw.Service;

import ie.gmit.sw.Model.Item;
import ie.gmit.sw.Repository.MongoItemDAO;
import ie.gmit.sw.domain.ProfileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    // set logger
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private MongoItemDAO mongoDB;

    // Before call this method, make sure all attributes in Item is not null !
    @Override
    public ProfileResponse createItem(Item item) throws Exception {
        // save user details
        try {
            mongoDB.save(item);
        } catch (Exception exc) {
            // Need to handle other exceptions here, like invalid entry to DB,
            // preferably on a Clients before sending Request
            logger.error("@@@ Item failed to be saved... Reason: " + exc.getMessage() + " @@@");
        }
        return new ProfileResponse("item create success !");
    }

    @Override
    public ProfileResponse deleteItem(String title) {
        Item item = new Item();
        try{
            item = mongoDB.findByTitle(title);
        }catch (Exception e){
            logger.info("@@@ item: " + item.getTitle() + " is fail to delete! @@@");
            return new ProfileResponse(e.toString());
        }

        mongoDB.delete(item);
        logger.info("@@@ item: " + item.getTitle() + " from " + item.getEmail() + " is deleted! @@@");
        return new ProfileResponse("Item: " + item.getTitle() +" delete success !");
    }

    @Override
    public List<Item> getAllItems() {
        return mongoDB.findAll();
    }

    @Override
    public List<Item> getItemByEmail(String email) {
        return mongoDB.findByEmail(email);
    }

    @Override
    public Item getItemByTitle(String title) {
        return mongoDB.findByTitle(title);
    }
}
