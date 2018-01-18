package ie.gmit.sw.domain;

import java.io.Serializable;

/**
 * Bean class, used for returning response object with a msg
 * e.g. create success etc.
 */
public class ProfileResponse {
    private static final long serialVersionUID = 1L;

    private String status;

    public ProfileResponse(String status) {
        this.status = status;
    }

    public ProfileResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
