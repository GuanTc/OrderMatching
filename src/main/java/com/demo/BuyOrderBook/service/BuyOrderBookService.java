package com.demo.BuyOrderBook.service;/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/10
 * @description:
 */

import com.demo.BuyOrderBook.pojo.BuyOrderBook;

import java.util.List;

/**
 *@author: WANGSHUAIYI
 *@date : 2019/8/10
 *@description:
 */
public interface BuyOrderBookService {

    /**
     * 插入一条订单
     * @param buyOrderBook
     */
    public void addBuyOrderBookService(BuyOrderBook buyOrderBook);

    /**
     * 取出第一条的订单
     * @return
     */
    public BuyOrderBook findTheFirstBuyOrderBook();

    /**
     * 取出所有的订单
     * @return
     */
    public List<BuyOrderBook> findAll();

    /**
     * 通过Id删除订单
     * @param id
     */
    public void deleteBuyOrderBookById(Long id);


}
