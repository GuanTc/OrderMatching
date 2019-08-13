package com.demo.service;

import com.demo.trade.pojo.Trade;

import java.util.Date;
import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
public interface TradeService {
    /**
     * 插入一条数据
     * @param trade
     */
    void addTrade(Trade trade);

    /**
     *
     * @return
     */
    List<Trade> findAll();

    /**
     * 按条件查询trade交易记录
     * 主要是是按照 日期区间，stockId,buyOrderId,sellOrderId,
     * @param trade
     * @param starttime
     * @param endtime
     * @return
     */
    List<Trade> findTradesByCondition(Trade trade, Date starttime,Date endtime);

}
