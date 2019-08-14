package com.demo.controller;

import com.demo.common.OrderVo;
import com.demo.common.ResultMap;
import com.demo.orders.pojo.Orders;
import com.demo.service.OrderService;
import com.demo.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @ResponseBody
    public ResultMap AddOrder( Orders orders){
        ResultMap map = new ResultMap();
        try {
            orderService.addOrder(orders);
            map.Success();
            map.setMsg("添加成功");

        }catch (Exception e){
            map.Error();
            map.setMsg("网络异常");
        }
        return map;
    }
    @RequestMapping("toAdd")
    public String toAdd(){
        return "add_orders";
    }


    @RequestMapping("/findAll")
    @ResponseBody
    public ResultMap findAll(){
        ResultMap map = new ResultMap();
        try {
            List<Orders> list = orderService.findAll();
            map.Success();
            map.setData(list);

        }catch (Exception e){
            map.Error();
            map.setMsg("网络异常");

        }
        System.out.println(map);
        return  map;
    }

    @RequestMapping("/findAllUser")
    @ResponseBody
    private ResultMap findAllUser(){
      ResultMap map = new ResultMap();
        try {
            List<OrderVo> orderVos = orderService.findAllUser();
            map.Success();
            map.setData(orderVos);
        }catch (Exception e){
            map.Error();
        }
        return map;
    }


    @RequestMapping("/findOrdersByCondition")
    @ResponseBody
    public ResultMap findOrdersByCondition(@RequestBody Orders orders,@RequestBody String start,@RequestBody String end){
        System.out.println(orders);
        System.out.println("strat:"+start);
        System.out.println("end:"+end);
        ResultMap map = new ResultMap();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startdate = null;
        Date enddate = null;
        try {
            startdate  = format.parse(start);
            enddate = format.parse(end);
            List<Orders> list = orderService.findOrdersByCondition(orders,startdate,enddate);
            map.Success();
            map.setData(list);
        }catch (Exception e){
            map.Error();
            map.setMsg("网络异常");
        }
        return map;
    }

}
