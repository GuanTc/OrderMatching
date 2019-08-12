package com.demo.entities;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Trade {
    public static float buyCurrentPrice;
    public static float sellCurrentPrice;
    public static Queue tradeQueue=new ConcurrentLinkedQueue();
    public static Queue waitQueue=new ConcurrentLinkedQueue();

    public  synchronized void offerTradeQueue(Trade trade){
        tradeQueue.offer(trade);
    }

    public  synchronized Trade polloutTradeQueue(){
        if(!tradeQueue.isEmpty())
            return (Trade) tradeQueue.poll();
        else
            return null;
    }

    public  synchronized void offerWaitQueue(Trade trade){
        waitQueue.offer(trade);
    }

    public  synchronized Trade polloutWaitQueue(){
        if(!waitQueue.isEmpty())
            return (Trade) waitQueue.poll();
        else
            return null;
    }

}
