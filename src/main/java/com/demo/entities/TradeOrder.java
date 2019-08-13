package com.demo.entities;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TradeOrder {
    public static Queue tradeQueue=new ConcurrentLinkedQueue();
    public static Queue waitQueue=new ConcurrentLinkedQueue();
//
//    public  synchronized void offerTradeQueue(Orders order){
//        tradeQueue.offer(order);
//    }
//
//    public  synchronized Orders polloutTradeQueue(){
//        if(!tradeQueue.isEmpty())
//            return (Orders) tradeQueue.poll();
//        else
//            return null;
//    }
//
//    public  synchronized void offerWaitQueue(Orders order){
//        waitQueue.offer(order);
//    }
//
//    public  synchronized Orders polloutWaitQueue(){
//        if(!waitQueue.isEmpty())
//            return (Orders) waitQueue.poll();
//        else
//            return null;
//    }

}
