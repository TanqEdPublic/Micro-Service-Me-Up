package ie.gmit.sw.domain;

import org.neo4j.ogm.annotation.*;


import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class User{

    @GraphId
    private Long id;

    @Index(unique = true, primary = true)
    private String username;
    private String password;
    private String email;
    private boolean enabled;
    @Relationship(type = "HAS_A")
    private Set<Authority> authorities;

    public User() {
    }

    public User(Long id, String username, String password, String email, boolean enabled, Set<Authority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public void setAuthority(Authority authority) {
        if(this.authorities == null){
            authorities = new HashSet<>();
        }
        this.authorities.add(authority);
    }


}
