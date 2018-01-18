package ie.gmit.sw.Model;

import org.springframework.data.annotation.Id;
public class UserDetail {

    @Id
    private String id;

    private String profileImg;
    private String email;
    private String nickName;
    private String gender;
    private String dob;
    private String phoneNum;
    private String aboutMe;

    public UserDetail() {}

    public UserDetail(String profileImg, String email, String nickName,
                      String gender, String dob, String phoneNum, String aboutMe) {
        this.profileImg = profileImg;
        this.email = email;
        this.nickName = nickName;
        this.gender = gender;
        this.dob = dob;
        this.phoneNum = phoneNum;
        this.aboutMe = aboutMe;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
}
