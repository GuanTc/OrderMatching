package com.demo.entities;

import com.demo.BuyOrderBook.mapper.BuyOrderBookMapper;
import com.demo.BuyOrderBook.pojo.BuyOrderBook;
import com.demo.SellOrderBook.mapper.SellOrderBookMapper;
import com.demo.SellOrderBook.pojo.SellOrderBook;
import com.demo.orders.mapper.OrdersMapper;
import com.demo.orders.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class MonitorOrders {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private SellOrderBookMapper sellOrderBookMapper;
    @Autowired
    private BuyOrderBookMapper buyOrderBookMapper;

    @Async
    public void monitor(){
        System.out.println("Test monitor");
        while(true) {
            List<Orders> orderList = ordersMapper.selectByStatus(0);
            for (int i = 0; i <orderList.size() ; i++) {
                Orders order=orderList.get(i);
                if(order!=null&&order.getType().equals("B")){
                    //buy
                    //Market If Touched(MIT) and Limit If Touched(MIT)
                    if(order.getOrderType().equals("MIT")){
                        BuyOrderBook bob = buyOrderBookMapper.selectMaxCurrentPrice(order.getStockId());
                        if(bob.getBuyPrice()<=order.getMarketPrice()){
                            //change the status, order_Type and send out date
                            ordersMapper.modifySendOut(order.getOrderId(),"MKT",1,new Date());
                        }
                    }
                    if(order.getOrderType().equals("LIT")){
                        BuyOrderBook bob = buyOrderBookMapper.selectMaxCurrentPrice(order.getStockId());
                        if(bob.getBuyPrice()<=order.getTriggerPrice()){
                            //change the status, order_Type and send out date
                            ordersMapper.modifyLMTSendOut(order.getOrderId(),"LMT",1,order.getLimitPrice(), new Date());
                            BuyOrderBook buyOrderBook=new BuyOrderBook();
                            buyOrderBook.setStockId(order.getStockId());
                            buyOrderBook.setOrderId(order.getOrderId());
                            buyOrderBook.setBuyPrice(order.getLimitPrice());
                            buyOrderBook.setBuySize(order.getRemainQty());
                            buyOrderBookMapper.insert(buyOrderBook);
                        }
                    }
                }
                if(order!=null&&order.getType().equals("S")){
                    //buy
                    //Market If Touched(MIT) and Limit If Touched(MIT)
                    if(order.getOrderType().equals("MIT")){
                        SellOrderBook sob = sellOrderBookMapper.selectMinCurrentPrice(order.getStockId());
                        if(sob.getAskPrice()>=order.getMarketPrice()){
                            //change the status, order_Type and send out date
                            ordersMapper.modifySendOut(order.getOrderId(),"MKT",1,new Date());
                        }
                    }
                    if(order.getOrderType().equals("LIT")){
                        SellOrderBook sob = sellOrderBookMapper.selectMinCurrentPrice(order.getStockId());
                        if(sob.getAskPrice()>=order.getTriggerPrice()){
                            //change the status, order_Type and send out date
                            ordersMapper.modifyLMTSendOut(order.getOrderId(),"LMT",1,order.getLimitPrice(), new Date());
                            SellOrderBook sellOrderBook=new SellOrderBook();
                            sellOrderBook.setStockId(order.getStockId());
                            sellOrderBook.setOrderId(order.getOrderId());
                            sellOrderBook.setAskPrice(order.getLimitPrice());
                            sellOrderBook.setAskSize(order.getRemainQty());
                            sellOrderBookMapper.insert(sellOrderBook);
                        }
                    }
                }
            }
            //after once,sleep 10s
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
