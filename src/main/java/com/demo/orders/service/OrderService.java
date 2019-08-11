package com.demo.orders.service;

import com.demo.orders.pojo.Orders;

import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/11
 * @description:
 */
public interface OrderService {

    List<Orders> findOrdersByConditions(Orders orders);
}
