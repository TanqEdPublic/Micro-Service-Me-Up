package ie.gmit.sw.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.Convert;
import org.neo4j.ogm.typeconversion.EnumStringConverter;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Role {

    @GraphId
    private Long id;

    private UserRole name;

    @Relationship(type = "HAS_ROLE", direction = Relationship.INCOMING)
    private Set<User> users;

    public Role() {
        users = new HashSet<>();
    }

    public Role(UserRole name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRole getName() {
        return name;
    }

    public void setName(UserRole name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name=" + name +
                ", users=" + users +
                '}';
    }
}