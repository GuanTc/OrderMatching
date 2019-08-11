package com.demo.orders.controller;

import com.demo.orders.pojo.Orders;
import com.demo.orders.service.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/11
 * @description:
 */
@Controller
@RequestMapping("/Orders")
public class OrderController {

    @Autowired
    private OrderServiceImpl  orderService;

    @RequestMapping("findOrderByConditions")
    @ResponseBody
    public List<Orders> findOrderByConditions(){

        Orders orders = new Orders();
        orders.setOrderType("xxx");
        return orderService.findOrdersByConditions(orders);
    }

}
