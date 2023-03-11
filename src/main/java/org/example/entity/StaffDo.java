package org.example.entity;

public class StaffDo {
    private Integer staffId;

    private String staffName;

    private Integer staffAge;

    private String staffSex;

    private String staffPhone;

    private String staffNote;
    
    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
    
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public Integer getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex == null ? null : staffSex.trim();
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone == null ? null : staffPhone.trim();
    }

    public String getStaffNote() {
        return staffNote;
    }

    public void setStaffNote(String staffNote) {
        this.staffNote = staffNote == null ? null : staffNote.trim();
    }
    
    @Override
    public String toString() {
        return "StaffDo{" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", staffAge=" + staffAge +
                ", staffSex='" + staffSex + '\'' +
                ", staffPhone='" + staffPhone + '\'' +
                ", staffNote='" + staffNote + '\'' +
                '}';
    }
}