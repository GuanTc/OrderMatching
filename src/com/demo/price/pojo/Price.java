package com.demo.price.pojo;

import java.util.Date;

public class Price {
    private Long priceId;

    private Long stockId;

    private Float buyCurrentPrice;

    private Float sellCurrentPrice;

    private Date priceCurrentDate;

    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Float getBuyCurrentPrice() {
        return buyCurrentPrice;
    }

    public void setBuyCurrentPrice(Float buyCurrentPrice) {
        this.buyCurrentPrice = buyCurrentPrice;
    }

    public Float getSellCurrentPrice() {
        return sellCurrentPrice;
    }

    public void setSellCurrentPrice(Float sellCurrentPrice) {
        this.sellCurrentPrice = sellCurrentPrice;
    }

    public Date getPriceCurrentDate() {
        return priceCurrentDate;
    }

    public void setPriceCurrentDate(Date priceCurrentDate) {
        this.priceCurrentDate = priceCurrentDate;
    }
}