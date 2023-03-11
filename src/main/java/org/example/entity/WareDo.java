package org.example.entity;

public class WareDo {
    private String wareId;

    private String wareName;

    private Double rPrice;

    private String sStandard;

    private String imgSrc;

    public String getWareId() {
        return wareId;
    }

    public void setWareId(String wareId) {
        this.wareId = wareId;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public Double getrPrice() {
        return rPrice;
    }

    public void setrPrice(Double rPrice) {
        this.rPrice = rPrice;
    }

    public String getsStandard() {
        return sStandard;
    }

    public void setsStandard(String sStandard) {
        this.sStandard = sStandard;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    @Override
    public String toString() {
        return "WareDo{" +
                "wareId='" + wareId + '\'' +
                ", wareName='" + wareName + '\'' +
                ", rPrice=" + rPrice +
                ", sStandard='" + sStandard + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                '}';
    }
}
