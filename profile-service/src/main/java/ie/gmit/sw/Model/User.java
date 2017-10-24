package ie.gmit.sw.Model;

import org.springframework.data.annotation.Id;
public class User {

    @Id
    public String id;

    public String username;
    public String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, username, password);
    }
}
