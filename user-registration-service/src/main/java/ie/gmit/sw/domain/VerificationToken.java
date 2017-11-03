package ie.gmit.sw.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Transient;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@NodeEntity
public class VerificationToken {
    @Transient
    private static final int EXPIRATION = 60 * 24;
    @GraphId private Long id;
    private String token;
    private final Date expiryDate = calculateExpiryDate(EXPIRATION);

    @Relationship(type = "VERIFY", direction = Relationship.OUTGOING)
    private User user;

    public VerificationToken() {
    }

    public VerificationToken(User user) {
        this.token = UUID.randomUUID().toString();
        this.user = user;
       // this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
}
