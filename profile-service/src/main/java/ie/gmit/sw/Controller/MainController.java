package ie.gmit.sw.Controller;

import ie.gmit.sw.Model.UserDetail;
import ie.gmit.sw.Service.UserService;
import ie.gmit.sw.domain.ProfileRequest;
import ie.gmit.sw.domain.ProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping( path = "/userdetail/new", method = RequestMethod.POST)
    public ProfileResponse newUserDetail(@RequestBody ProfileRequest request) throws Throwable {
        return userService.createUserDetail(request);
    }

    @RequestMapping( path = "/userdetail/update", method = RequestMethod.POST)
    public ProfileResponse updateUserDetail(@RequestBody ProfileRequest request) throws Throwable {
        return userService.updateUserDetail(request);
    }

    @RequestMapping( path = "/userdetail/delete", method = RequestMethod.POST)
    public ProfileResponse deleteUserDetail(@RequestBody ProfileRequest request) throws Throwable {
        return userService.deleteUserDetail(request);
    }

    @RequestMapping( path = "/userdetail/get", method = RequestMethod.GET)
    public UserDetail getUserDetail(@RequestParam("email") String email) throws Throwable {
        return userService.getUserByEmail(email);
    }
}