package com.demo.service;

import com.demo.BuyOrderBook.pojo.BuyOrderBook;

import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
public interface BuyOrderBookService {
    /**
     *
     * @param buyOrderBook
     */
    void addBuyOrder(BuyOrderBook buyOrderBook);

    /**
     *查询全部
     * @return
     */
    List<BuyOrderBook> findAll();

    /**
     * 查询最高价格订单（orderbook的第一条数据）
     * @return
     */
    BuyOrderBook findMaxPrice(Long Sock_Id);

    /**
     * 更新orderbook
     * @param buyOrderBook
     */
    void updateBuyOrderBook(BuyOrderBook buyOrderBook);

    /**
     * 将订单移出orderbook
     * @param Bob
     */
    void deleteBuyOrder(Long Bob);

    BuyOrderBook findMaxPriceByStockId(Long stockId);
}
