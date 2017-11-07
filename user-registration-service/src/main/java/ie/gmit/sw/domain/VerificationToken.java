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
    private static final int EXPIRATION =  60 * 24; // expiration in minutes
    @GraphId private Long id;
    private String token;
    private Date expiryDate;

    @Relationship(type = "VERIFY", direction = Relationship.OUTGOING)
    private User user;

    public VerificationToken() {
    }

    public VerificationToken(User user) {
        this.token = UUID.randomUUID().toString();
        this.user = user;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
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

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    // method that verify current token instance expiration date
    public boolean isTokenExpired(){
        Calendar cal = Calendar.getInstance();
        // after() method checks if this date is after the specified date
        if(expiryDate.after(cal.getTime())){
            return true; // return true if token is not expired
        }
        return false; // return false if token is expired
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
}
