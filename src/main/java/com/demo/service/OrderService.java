package com.demo.service;

import com.demo.orders.pojo.Orders;

import java.util.Date;
import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/13
 * @description:
 */
public interface OrderService {
    /**
     * 添加order
     * @param orders
     */
    void addOrder(Orders orders);

    /**
     * 查找全部
     * @return
     */
    List<Orders> findAll();

    /**
     * 根据条件查询
     * userid ,stockid ,
     * @param orders
     * @param startdate
     * @param enddate
     * @return
     */
    List<Orders> findOrdersByCondition(Orders orders, Date startdate,Date enddate);


}
