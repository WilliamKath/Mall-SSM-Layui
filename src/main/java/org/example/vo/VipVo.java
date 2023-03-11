package org.example.vo;

import org.example.entity.VipDo;

public class VipVo extends VipDo {

    private Integer page;
    private Integer limit;

    private Integer vipId;
    private String vipName;

    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getLimit() {
        return limit;
    }
    public void setLimit(Integer limit) {
        this.limit = limit;
    }


    public Integer getVipId() { return vipId;
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

    @Override
    public String toString() {
        return "VipVo{" +
                "page=" + page +
                ", limit=" + limit +
                ", vipId=" + vipId +
                ", vipName='" + vipName + '\'' +
                '}';
    }
}

