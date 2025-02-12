package aggregate;

public class Member {
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
    // endregion

}
