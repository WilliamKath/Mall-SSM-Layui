package org.example.vo;

import org.example.entity.StockDo;

/*
用于分页插件的实体类
可以实现传入页码（page）
以及每页显示条数（limit）后
自动进行分页显示
*/
public class StockVo extends StockDo {
    //与LayUI默认传回的参数相同
    private Integer page;
    private Integer limit;

    //与需要用于查询的条件相同
    private Integer stockId;
    private String stockName;

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
    public Integer getStockId() {
        return stockId;
    }

    @Override
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    @Override
    public String getStockName() {
        return stockName;
    }

    @Override
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Override
    public String toString() {
        return "StockVo{" +
                "page=" + page +
                ", limit=" + limit +
                ", stockId=" + stockId +
                ", stockName='" + stockName + '\'' +
                '}';
    }
}
