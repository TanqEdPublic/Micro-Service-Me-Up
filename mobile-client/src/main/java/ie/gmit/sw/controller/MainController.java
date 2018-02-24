package ie.gmit.sw.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import ie.gmit.sw.model.Item;
import ie.gmit.sw.model.UserDetail;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.*;

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
            return new UserDetail();
        }
        // read UserDetail from response
        ObjectMapper objectMapper=new ObjectMapper();
        UserDetail detail = objectMapper.readValue(response.getEntity().getContent(),
                UserDetail.class);
        System.out.println("");
        return detail;
    }
    @PostMapping("/updateUserdetail")
    public String updateUserdetail(@RequestBody UserDetail user) throws Exception {
        String url = "http://54.201.208.226:8086/profile/userdetail/update";
        CloseableHttpClient client = HttpClientBuilder.create().build();
        // POST method
        HttpPost post = new HttpPost(url);
        // add header
        post.setHeader("Content-Type", "application/json");
        // add data
        ObjectMapper mapper = new ObjectMapper();
        String jsonstr = mapper.writeValueAsString(user);
        StringEntity para = new StringEntity(jsonstr);
        post.setEntity(para);
        // receive response
        HttpResponse response = client.execute(post);
        if (response == null){
            client.close();
        }
        // read response
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        String result = rd.readLine();
        return result;
    }

    @RequestMapping("/item/all")
    public List<Item> dashboard() throws Exception{
        String url = "http://54.201.208.226:8086/profile/item/all";
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
        List<Item> items = Arrays.asList(objectMapper.readValue
                (response.getEntity().getContent(), Item[].class));
        return items;
    }

    @RequestMapping("/item/get")
    public List<Item> myitem(Principal user) throws Exception{
        String username = user.getName();
        String url = "http://54.201.208.226:8086/profile/item?email="+username;
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
        List<Item> items = Arrays.asList(objectMapper.readValue
                (response.getEntity().getContent(), Item[].class));
        return items;
    }

    @PostMapping("/item/new")
    public String createItem(@RequestBody Item item) throws Exception {
        String url = "http://54.201.208.226:8086/profile/item/new";
        CloseableHttpClient client = HttpClientBuilder.create().build();
        // POST method
        HttpPost post = new HttpPost(url);
        // add header
        post.setHeader("Content-Type", "application/json");
        // add data
        ObjectMapper mapper = new ObjectMapper();
        String jsonstr = mapper.writeValueAsString(item);
        StringEntity para = new StringEntity(jsonstr);
        post.setEntity(para);
        // receive response
        HttpResponse response = client.execute(post);
        if (response == null){
            client.close();
        }
        // read response
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        String result = rd.readLine();
        return result;
    }

    @PostMapping("/item/delete")
    public String deleteItem(@RequestParam String title) throws Exception {
        // use URLEncoder to encode title in url with blanks
        title = URLEncoder.encode(title,"UTF-8");
        String url = "http://54.201.208.226:8086/profile/item/delete?title="+title;
        CloseableHttpClient client = HttpClientBuilder.create().build();
        // POST method
        HttpPost post = new HttpPost(url);
        // add header
        post.setHeader("Content-Type", "application/json");
        // receive response
        HttpResponse response = client.execute(post);
        if (response == null){
            client.close();
        }
        // read response
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        String result = rd.readLine();
        return result;
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
