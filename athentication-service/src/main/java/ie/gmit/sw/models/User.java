package ie.gmit.sw.models;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


@NodeEntity
public class User implements UserDetails {

    @GraphId
    private Long id;

    @Index(unique = true)
    //private String email;
    private String username;
    private String password;
    //private boolean enabled;

    @Relationship(type = "HAS_ROLE", direction = Relationship.OUTGOING)
    private List<Role> roles;

    public User() {
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
//    public User(Long id, String email, String username, String password, boolean enabled, Set<Role> authorities) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.enabled = enabled;
//        this.authorities = authorities;
//    }

    public User(String email, String username, String password) {
        this.username = username;
        this.password = password;
        //this.email = email;
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

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<Role> roles = this.getRoles();
        for (Role role : roles) {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}