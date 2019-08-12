package com.demo.entities;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Trade {
    public static float buyCurrentPrice;
    public static float sellCurrentPrice;
    public static Queue tradeQueue=new ConcurrentLinkedQueue();

    public  synchronized String pollout(){
        if(!tradeQueue.isEmpty())
            return tradeQueue.poll().toString();
        else
            return null;
    }

}
