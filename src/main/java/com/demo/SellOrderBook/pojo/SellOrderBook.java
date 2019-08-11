package com.demo.SellOrderBook.pojo;

public class SellOrderBook {
    private Long sobId;

    private Long stockId;

    private Integer askSize;

    private Float askPrice;

    public Long getSobId() {
        return sobId;
    }

    public void setSobId(Long sobId) {
        this.sobId = sobId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Integer getAskSize() {
        return askSize;
    }

    public void setAskSize(Integer askSize) {
        this.askSize = askSize;
    }

    public Float getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(Float askPrice) {
        this.askPrice = askPrice;
    }
}