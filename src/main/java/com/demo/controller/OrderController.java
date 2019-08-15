package com.demo.controller;

import com.demo.BuyOrderBook.pojo.BuyOrderBook;
import com.demo.SellOrderBook.pojo.SellOrderBook;
import com.demo.common.ResultMap;
import com.demo.orders.pojo.Orders;
import com.demo.service.BuyOrderBookService;
import com.demo.service.OrderService;
import com.demo.service.SellOrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private SellOrderBookService sellOrderBookService;
    @Autowired
    private BuyOrderBookService buyOrderBookService;

    @RequestMapping("/add")
    @ResponseBody
    public ResultMap AddOrder(Orders orders){
        ResultMap map = new ResultMap();
        try {
            if("S".equals(orders.getType())){
                SellOrderBook sellOrderBook = sellOrderBookService.findMinPriceByStockId(orders.getStockId());
              if(sellOrderBook !=null && sellOrderBook.getAskPrice()>0){
                  if("LMT".equals(orders.getOrderType())){

                      if(orders.getPrice() <= sellOrderBook.getAskPrice()){
                          map.Error();
                          map.setMsg("The Sell Limit Price should be higher the Sell current Price. The current Price is "+sellOrderBook.getAskPrice());
                          return  map;
                      }
                  }
                  if("STP".equals(orders.getOrderType())){
                      if(orders.getPrice() >= sellOrderBook.getAskPrice()){
                          map.Error();
                          map.setMsg("The Sell Stop loss Price should be lower the Sell currenr Price. The current Price is "+sellOrderBook.getAskPrice());
                          return map;
                      }
                  }
              }

            }else if("B".equals(orders.getType())){
                BuyOrderBook buyOrderBook = buyOrderBookService.findMaxPriceByStockId(orders.getStockId());
              if(buyOrderBook != null && buyOrderBook.getBuyPrice() > 0){
                  if("LMT".equals(orders.getOrderType())){
                      if(orders.getPrice() >= buyOrderBook.getBuyPrice()){
                          map.Error();
                          map.setMsg("The Buy Limit Price should be lower the Sell current Price. The current Price is "+ buyOrderBook.getBuyPrice());
                          return  map;
                      }
                  }
                  if("STP".equals(orders.getOrderType())){
                      if(orders.getPrice() <= buyOrderBook.getBuyPrice()){
                          map.Error();
                          map.setMsg("The Buy Stop loss Price should be higher the Sell currenr Price. The current Price is"+buyOrderBook.getBuyPrice() );
                          return map;
                      }
                  }
              }
            }
            orderService.addOrder(orders);
            map.Success();
            map.setMsg("Add Success");

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
    private Object findAllUser(){
        ResultMap map = new ResultMap();

        try {
            JSONObject s = orderService.findAllUser();
            map.Success();
            map.setData(s.toString());
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
