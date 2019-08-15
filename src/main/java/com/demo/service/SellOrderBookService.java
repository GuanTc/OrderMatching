package com.demo.service;

import com.demo.SellOrderBook.pojo.SellOrderBook;

import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
public interface SellOrderBookService {
    /**
     * 添加
     * @param sellOrderBook
     */
    void addSellOrderBook(SellOrderBook sellOrderBook);

    /**
     * 查询现价，最小的价格
     * @param StockId
     * @return
     */
    SellOrderBook findMinPrice(Long StockId);

    /**
     * 删除已经完成的订单
     * @param SobId
     */
    void deleteSellOrderBook(Long SobId);

    /**
     * 更新orderbook因为有些order一次卖不完
     * 需要更新
     * @param sellOrderBook
     */
    void updateSellOrderBook(SellOrderBook sellOrderBook);

    /**
     * 查找全部
     * @return
     */
    List<SellOrderBook> findAll();

    /**
     * 查询最小价格
     * @param stockId
     * @return
     */
    SellOrderBook findMinPriceByStockId(Long stockId);
}
