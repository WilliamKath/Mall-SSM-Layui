package org.example.vo;

import org.example.entity.WareDo;

public class WareVo extends WareDo {
    //与LayUI默认传回的参数相同
    private Integer page;
    private Integer limit;

    //与需要用于查询的条件相同
    private String wareId;
    private String wareName;

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

    @Override
    public String getWareId() {
        return wareId;
    }

    @Override
    public void setWareId(String wareId) {
        this.wareId = wareId;
    }

    @Override
    public String getWareName() {
        return wareName;
    }

    @Override
    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    @Override
    public String toString() {
        return "WareVo{" +
                "page=" + page +
                ", limit=" + limit +
                ", wareId='" + wareId + '\'' +
                ", wareName='" + wareName + '\'' +
                '}';
    }
}
