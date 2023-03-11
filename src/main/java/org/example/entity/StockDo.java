package org.example.entity;

public class StockDo {
    private Integer stockId;

    private String stockName;

    private Double costprice;

    private String stockStandard;

    private String stockQty;

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Double getCostprice() {
        return costprice;
    }

    public void setCostprice(Double costprice) {
        this.costprice = costprice;
    }

    public String getStockStandard() {
        return stockStandard;
    }

    public void setStockStandard(String stockStandard) {
        this.stockStandard = stockStandard;
    }

    public String getStockQty() {
        return stockQty;
    }

    public void setStockQty(String stockQty) {
        this.stockQty = stockQty;
    }

    @Override
    public String toString() {
        return "StockDo{" +
                "stockId=" + stockId +
                ", stockName='" + stockName + '\'' +
                ", costprice=" + costprice +
                ", stockStandard='" + stockStandard + '\'' +
                ", stockQty='" + stockQty + '\'' +
                '}';
    }
}