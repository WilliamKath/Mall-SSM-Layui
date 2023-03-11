package org.example.vo;

import org.example.entity.StaffDo;

/*
用于分页插件的实体类
可以实现传入页码（page）
以及每页显示条数（limit）后
自动进行分页显示
*/
public class StaffVo extends StaffDo {
    //与LayUI默认传回的参数相同
    private Integer page;
    private Integer limit;
    
    //与需要用于查询的条件相同
    private Integer staffId;
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
    public Integer getStaffId() {
        return staffId;
    }

    @Override
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @Override
    public String getStaffName() {
        return staffName;
    }

    @Override
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Override
    public String toString() {
        return "StaffVo{" +
                "page=" + page +
                ", limit=" + limit +
                ", staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                '}';
    }
}
