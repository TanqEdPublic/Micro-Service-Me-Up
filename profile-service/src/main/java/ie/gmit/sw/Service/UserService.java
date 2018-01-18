package ie.gmit.sw.Service;

import ie.gmit.sw.Model.UserDetail;
import ie.gmit.sw.domain.ProfileRequest;
import ie.gmit.sw.domain.ProfileResponse;

import java.util.List;

public interface UserService {
    public ProfileResponse createUserDetail(ProfileRequest request) throws Exception;
    public UserDetail getUser(ProfileRequest request);
    public List<Object> showAll();
}
