package com.demo.BuyOrderBook.pojo;

public class BuyOrderBook {
    private Long bobId;

    private Long stockId;

    private Long orderId;

    private Integer buySize;

    private Float buyPrice;

    public Long getBobId() {
        return bobId;
    }

    public void setBobId(Long bobId) {
        this.bobId = bobId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getBuySize() {
        return buySize;
    }

    public void setBuySize(Integer buySize) {
        this.buySize = buySize;
    }

    public Float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Float buyPrice) {
        this.buyPrice = buyPrice;
    }
}