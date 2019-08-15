package com.demo.common;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/15
 * @description:
 */
public class StockPrice {
    private String stockName;
    private String stockCode;
    private float buy_price;
    private float sell_price;
    private  Long stock_Id;

    public Long getStock_Id() {
        return stock_Id;
    }

    public void setStock_Id(Long stock_Id) {
        this.stock_Id = stock_Id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public float getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(float buy_price) {
        this.buy_price = buy_price;
    }

    public float getSell_price() {
        return sell_price;
    }

    public void setSell_price(float sell_price) {
        this.sell_price = sell_price;
    }
}
