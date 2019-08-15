package com.demo.service;

import com.demo.common.StockPrice;
import com.demo.stock.pojo.Stock;

import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
public interface StockSercive {
    /**
     * 添加stock
     * @param stock
     * @return
     */
    int addStock(Stock stock);

    /**
     * 查询所有
     * @return
     */
    List<Stock> findAll();

    /**
     * 根据条件查询股票一般是根据股票的Code
     * @param stock
     * @return
     */
    List<Stock> findStockByConditions(Stock stock);

    /**
     * 查询所有股票的现价
     * @return
     */
    List<StockPrice> stockPrice();
}
