//package com.demo.entities;
//
//import com.demo.orders.mapper.OrdersMapper;
//import com.demo.orders.pojo.Orders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class GetOrders {
//
//    @Autowired
//    private OrdersMapper ordersMapper;
//
//    @Async
//    public void getOrder() {
//        //get orders from Orders table
//        Long id = -1L;
//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        TradeOrder t = new TradeOrder();
//        List<Orders> orderList = ordersMapper.getListMoreId(id);
//        if (orderList != null && orderList.size() > 0) {
//            id = orderList.get(orderList.size() - 1).getOrderId();
//            for (int i = 0; i < orderList.size(); i++) {
//                t.tradeQueue.offer(orderList.get(i));
//            }
//        }
//    }
//}
