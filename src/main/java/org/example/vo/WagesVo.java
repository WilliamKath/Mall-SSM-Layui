package org.example.vo;

import org.example.entity.WagesDo;


public class WagesVo extends WagesDo {
    //与LayUI默认传回的参数相同
    private Integer page;
    private Integer limit;

    //与需要用于查询的条件相同
    private Integer wagesId;
    private String staffName;

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
    public Integer getWagesId() {
        return wagesId;
    }

    @Override
    public void setWagesId(Integer wagesId) {
        this.wagesId = wagesId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
