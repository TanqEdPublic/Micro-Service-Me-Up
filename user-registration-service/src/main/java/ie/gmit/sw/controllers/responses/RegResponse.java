package ie.gmit.sw.controllers.responses;

import java.io.Serializable;

/**
 * Bean class, used for returning response object with a msg
 * e.g. duplicate user, wrong password etc.
 */
public class RegResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String status;

    public RegResponse(String status) {
        this.status = status;
    }

    public RegResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
