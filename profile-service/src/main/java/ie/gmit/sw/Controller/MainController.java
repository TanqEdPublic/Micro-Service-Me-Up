package ie.gmit.sw.Controller;

import ie.gmit.sw.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping( path = "/sign-up", method = RequestMethod.POST)
    public String signUp(@RequestParam("username") String username,
                         @RequestParam("password") String password) throws Throwable {
        return userService.createUser(username,password);

    }
}