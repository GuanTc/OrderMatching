package com.demo.entities;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Trade {
    public static Queue tradeQueue=new ConcurrentLinkedQueue();

    public  synchronized String pollout(){
        return tradeQueue.poll().toString();
    }

}
