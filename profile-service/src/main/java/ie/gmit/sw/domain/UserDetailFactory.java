package ie.gmit.sw.domain;

import ie.gmit.sw.Model.UserDetail;

public class UserDetailFactory {
    public static UserDetail create(ProfileRequest user){
        // check each attributes in obj(UserDetail), assign ""(empty) if there is a null.
        return new UserDetail(
            user.getProfileImg()==null?"":user.getProfileImg(),
            user.getEmail()==null?"":user.getEmail(),
            user.getNickName()==null?"":user.getNickName(),
            user.getGender()==null?"":user.getGender(),
            user.getDob()==null?"":user.getDob(),
            user.getPhoneNum()==null?"":user.getPhoneNum(),
            user.getAboutMe()==null?"":user.getAboutMe()
        );
    }
}
