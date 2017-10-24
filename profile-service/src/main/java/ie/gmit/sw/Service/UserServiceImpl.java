package ie.gmit.sw.Service;

import ie.gmit.sw.Model.User;
import ie.gmit.sw.Repository.MongoDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // set logger
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private MongoDAO mongoDB;

    @Override
    public String createUser(String username, String password) throws Exception {
        if (mongoDB.findByUsername(username) == null) {
            try {
                // if user is new, save to database
                mongoDB.save(new User(username, password));
                //mongoDB.save(new MongoUser(username, password));
            } catch (Exception exc) {

                // Need to handle other exceptions here, like invalid entry to DB,
                // preferably on a Clients before sending Request
                logger.error("@@@ User failed to be saved... Reason: " + exc.getMessage() + " @@@");
            }

            logger.error("@@@ User: " + username + " is registered! @@@");
            return "registered";
        } else {
            logger.error("@@@ User: " + username + " Already Exists @@@");
            return "duplicate_user";
        }
    }

    @Override
    public String loginUser(String username, String password) {
        return null;
    }

    @Override
    public List<Object> showAll() {
        return null;
    }
}
