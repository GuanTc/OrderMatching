package com.demo.entities;

public class MoveOrders {
    public void moveOrder() {
        Trade t = new Trade();
        while (true) {
            if(t.waitQueue.peek()!=null){
                t.offerTradeQueue(t.polloutWaitQueue());
            }
        }
    }
}
