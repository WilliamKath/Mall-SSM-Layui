package org.example.entity;

public class VipDo {
    
        private Integer vipId;

        private String vipName;

        private Integer vipAge;

        private String vipSex;

        private String vipPhone;

        private String vipAddress;

        private Integer vipGrade;

        private Integer vipIntegral;

    @Override
    public String toString() {
        return "VipDo{" +
                "vipId=" + vipId +
                ", vipName='" + vipName + '\'' +
                ", vipAge=" + vipAge +
                ", vipSex='" + vipSex + '\'' +
                ", vipPhone='" + vipPhone + '\'' +
                ", vipAddress='" + vipAddress + '\'' +
                ", vipGrade=" + vipGrade +
                ", vipIntegral=" + vipIntegral +
                '}';
    }

    public VipDo(Integer vipId, String vipName, Integer vipAge, String vipSex, String vipPhone, String vipAddress, Integer vipGrade, Integer vipIntegral) {
        this.vipId = vipId;
        this.vipName = vipName;
        this.vipAge = vipAge;
        this.vipSex = vipSex;
        this.vipPhone = vipPhone;
        this.vipAddress = vipAddress;
        this.vipGrade = vipGrade;
        this.vipIntegral = vipIntegral;
    }

    public VipDo() {
    }

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public Integer getVipAge() {
        return vipAge;
    }

    public void setVipAge(Integer vipAge) {
        this.vipAge = vipAge;
    }

    public String getVipSex() {
        return vipSex;
    }

    public void setVipSex(String vipSex) {
        this.vipSex = vipSex;
    }

    public String getVipPhone() {
        return vipPhone;
    }

    public void setVipPhone(String vipPhone) {
        this.vipPhone = vipPhone;
    }

    public String getVipAddress() {
        return vipAddress;
    }

    public void setVipAddress(String vipAddress) {
        this.vipAddress = vipAddress;
    }

    public Integer getVipGrade() {
        return vipGrade;
    }

    public void setVipGrade(Integer vipGrade) {
        this.vipGrade = vipGrade;
    }

    public Integer getVipIntegral() {
        return vipIntegral;
    }

    public void setVipIntegral(Integer vipIntegral) {
        this.vipIntegral = vipIntegral;
    }
}
