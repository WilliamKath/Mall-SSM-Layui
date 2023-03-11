package org.example.entity;

public class UserDo {
    private Integer userId;
    private String userName;
    private String userSex;
    private String userAccount;
    private String userPassword;
    private String userPhone;
    private String userAddress;
    private String userIdentity;
    private Integer vipId;
    private Integer vipGrade;
    private String vipIntegral;

    public UserDo() {
    }

    public UserDo(Integer userId, String userName, String userSex,
                  String userAccount, String userPassword, String userPhone,
                  String userAddress, String userIdentity, Integer vipId,
                  Integer vipGrade, String vipIntegral) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userIdentity = userIdentity;
        this.vipId = vipId;
        this.vipGrade = vipGrade;
        this.vipIntegral = vipIntegral;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public Integer getVipGrade() {
        return vipGrade;
    }

    public void setVipGrade(Integer vipGrade) {
        this.vipGrade = vipGrade;
    }

    public String getVipIntegral() {
        return vipIntegral;
    }

    public void setVipIntegral(String vipIntegral) {
        this.vipIntegral = vipIntegral;
    }
}
