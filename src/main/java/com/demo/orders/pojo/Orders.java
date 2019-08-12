package com.demo.orders.pojo;

import java.util.Date;

public class Orders {
    private Long orderId;

    private Long userId;

    private Long stockId;

    private String type;

    private Float price;

    private Integer qty;

    private Integer remainQty;

    private String orderType;

    private Float marketPrice;

    private Float limitPrice;

    private Float triggerPrice;

    private Float stopPrice;

    private Integer fullOrKill;

    private String duration;

    private Date gtdDate;

    private Integer minute;

    private Date submitDate;

    private Integer status;

    private Date sendOutDate;

    private Date finalDate;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public Integer getRemainQty() {
        return remainQty;
    }

    public void setRemainQty(Integer remainQty) {
        this.remainQty = remainQty;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public Float getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Float marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Float getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(Float limitPrice) {
        this.limitPrice = limitPrice;
    }

    public Float getTriggerPrice() {
        return triggerPrice;
    }

    public void setTriggerPrice(Float triggerPrice) {
        this.triggerPrice = triggerPrice;
    }

    public Float getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(Float stopPrice) {
        this.stopPrice = stopPrice;
    }

    public Integer getFullOrKill() {
        return fullOrKill;
    }

    public void setFullOrKill(Integer fullOrKill) {
        this.fullOrKill = fullOrKill;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public Date getGtdDate() {
        return gtdDate;
    }

    public void setGtdDate(Date gtdDate) {
        this.gtdDate = gtdDate;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSendOutDate() {
        return sendOutDate;
    }

    public void setSendOutDate(Date sendOutDate) {
        this.sendOutDate = sendOutDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }
}