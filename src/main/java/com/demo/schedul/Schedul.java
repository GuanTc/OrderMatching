package com.demo.schedul;

import com.alibaba.fastjson.JSONObject;
import com.demo.WebSocket.MyWebSocket;
import com.demo.common.ResultMap;
import com.demo.common.StockPrice;
import com.demo.orders.pojo.Orders;
import com.demo.service.BuyOrderBookService;
import com.demo.service.OrderService;
import com.demo.service.SellOrderBookService;
import com.demo.service.StockSercive;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/13
 * @description:
 */
@Component
public class Schedul {
    private  static final SimpleDateFormat dataFromat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private  static volatile boolean flag = true;
    //秒（0-59）， 分，小时（0-23） 日期天/日（1-31） ，日期月份（1-12） 星期（1-7）年（1970-2099可以省略）
    private static final Logger logger = LoggerFactory.getLogger(Schedul.class);
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyOrderBookService buyOrderBookService;
    @Autowired
    private SellOrderBookService sellOrderBookService;
    @Autowired
    private StockSercive stockSercive;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void start(){

        Date currentDate = new Date();

        List<Orders> orders = orderService.findOrdersByStatis();
        for(int i = 0; i < orders.size(); i++){
            Orders o = orders.get(i);
            logger.info("现在时间：{}",dataFromat.format(new Date())+"        order的截止日期是："+o.getGtdDate());
            if(currentDate.after(o.getGtdDate())){
                logger.info("修改状态");
                if(o.getStatus()==1){
                    flag = false;
                    o.setStatus(4);

                    orderService.updateOrder(o);
                    if("S".equals(o.getType())){
                        sellOrderBookService.deleteSellOrderBook(o.getOrderId());
                    }
                    if("B".equals(o.getType())){
                        buyOrderBookService.deleteBuyOrder(o.getOrderId());
                    }
                }
            }

        }
        String s = dataFromat.format(new Date());


        try {

            List<StockPrice> stockPrices = stockSercive.stockPrice();
            ResultMap resultMap = new ResultMap();
            resultMap.setData(stockPrices);
            resultMap.setMsg("SCP");
            MyWebSocket.sendInfoJson(resultMap);
            if(!flag){
                ResultMap map = new ResultMap();
                map.Success();
                map.setData(buyOrderBookService.findAll());
                map.setMsg("Buy");
                //    String buymsg = JSONObject.toJSONString(map);
                MyWebSocket.sendInfoJson(map);
                map.setData(sellOrderBookService.findAll());
                //  String selmsg = JSONObject.toJSONString(map);
                map.setMsg("Sell");
                MyWebSocket.sendInfoJson(map);
            }


        }catch (Exception e){

        }

    }

}
