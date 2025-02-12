package aggregate;

import java.io.Serializable;

public class Member implements Serializable {
    private int memberNumber;
    private String userId;
    private String userPassword;
    private UserType userType;

    /* 설명: Constructor*/
    // region
    public Member() {
    }

    public Member(String userId, String userPassword, UserType userType) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public Member(int memberNumber, String userId, String userPassword, UserType userType) {
        this.memberNumber = memberNumber;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    // endregion
    /* 설명: toString*/

    @Override
    public String toString() {
        return "Member{" +
                "memberNumber=" + memberNumber +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType=" + userType +
                '}';
    }
}
