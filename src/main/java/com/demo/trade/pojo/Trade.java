package com.demo.trade.pojo;

import java.util.Date;

public class Trade {
    private Long tradeId;

    private Long userId;
    private String buyname;
    private Long stockId;

    private Long buyOrderId;

    private Long sellOrderId;

    private String sellname;

    private String stockName;

    private Float price;

    private Integer qty;

    private Date tradeDate;

    public String getBuyname() {
        return buyname;
    }

    public void setBuyname(String buyname) {
        this.buyname = buyname;
    }

    public String getSellname() {
        return sellname;
    }

    public void setSellname(String sellname) {
        this.sellname = sellname;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(Long buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    public Long getSellOrderId() {
        return sellOrderId;
    }

    public void setSellOrderId(Long sellOrderId) {
        this.sellOrderId = sellOrderId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }
}