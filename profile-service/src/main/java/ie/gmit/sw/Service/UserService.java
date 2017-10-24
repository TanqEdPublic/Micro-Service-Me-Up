package ie.gmit.sw.Service;

import java.util.List;

public interface UserService {
    public String createUser(String username, String password) throws Exception;
    public String loginUser(String username, String password);
    public List<Object> showAll();
}
