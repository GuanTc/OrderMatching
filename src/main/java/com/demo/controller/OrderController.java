package com.demo.controller;

import com.demo.orders.pojo.Orders;
import com.demo.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/13
 * @description:
 */
@Controller
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/add")
    public String AddOrder(Orders orders){
        orderService.addOrder(orders);
        return "add_orders";
    }
    @RequestMapping("toAdd")
    public String toAdd(){
        return "add_orders";
    }


    @RequestMapping("/findAll")
    @ResponseBody
    public List<Orders> findAll(){
        return orderService.findAll();
    }


    @RequestMapping("/findOrdersByCondition")
    @ResponseBody
    public List<Orders> findOrdersByCondition(Orders orders, String start, String end){
        System.out.println(orders);
        System.out.println("strat:"+start);
        System.out.println("end:"+end);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startdate = null;
        Date enddate = null;
        try {
            startdate  = format.parse(start);
            enddate = format.parse(end);
        }catch (Exception e){

        }
        return orderService.findOrdersByCondition(orders,startdate,enddate);
    }

}
