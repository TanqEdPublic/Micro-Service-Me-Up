package ie.gmit.sw.controller;

import ie.gmit.sw.model.UserDetail;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class MainController {
    @RequestMapping("/userdetail")
    public UserDetail userdetail(Principal user) throws Exception {
        String username = user.getName();
        String url = "http://54.201.208.226:8086/profile/userdetail/get?email="+username;
        CloseableHttpClient client = HttpClientBuilder.create().build();
        // GET method
        HttpGet request = new HttpGet(url);
        // receive response
        HttpResponse response = client.execute(request);
        if (response == null){
            client.close();
        }
        // read UserDetail from response
        ObjectMapper objectMapper=new ObjectMapper();
        UserDetail detail = objectMapper.readValue(response.getEntity().getContent(),
                UserDetail.class);
        System.out.println("");
        return detail;
    }

    @RequestMapping("/message")
    public Map<String, Object> dashboard() {
        return Collections.<String, Object> singletonMap("message", "Yay!");
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }



}
