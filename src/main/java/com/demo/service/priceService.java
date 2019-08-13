package com.demo.service;

import com.demo.price.pojo.Price;

import java.util.Date;
import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
public interface priceService {
    /**
     * 添加price
     * @param price
     */
    void addPrice(Price price);

    /**
     * 查询全部
     * @return
     */
    List<Price> findAll();

    /**
     * 根据条件查询current price
     * @param price
     * @param startdate
     * @param enddate
     * @return
     */
    List<Price> findPriceByConditions(Price price, Date startdate,Date enddate);
}
