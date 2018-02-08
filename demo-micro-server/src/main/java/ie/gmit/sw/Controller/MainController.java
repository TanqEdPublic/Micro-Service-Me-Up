package ie.gmit.sw.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:9999")
@RestController
@RequestMapping("/dashboard")
public class MainController {

    @RequestMapping("/public")
    public Map<String, Object> Public() {
        return Collections.singletonMap("message", "Public end point!");
    }

    @RequestMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Map<String, Object> UserFree(){
       return Collections.singletonMap("message", "User end point!");
    }


    @RequestMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Map<String, Object> AdminPoint(){
        return Collections.singletonMap("message", "Admin end point!");
    }
}
