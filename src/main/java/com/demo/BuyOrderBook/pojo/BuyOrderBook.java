package com.demo.BuyOrderBook.pojo;

public class BuyOrderBook {
    private Long bobId;

    private Integer buySize;

    private Float buyPrice;

    public Long getBobId() {
        return bobId;
    }

    public void setBobId(Long bobId) {
        this.bobId = bobId;
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

    @Override
    public String toString() {
        return "BuyOrderBook{" +
                "bobId=" + bobId +
                ", buySize=" + buySize +
                ", buyPrice=" + buyPrice +
                '}';
    }
}