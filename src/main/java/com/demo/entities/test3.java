package com.demo.entities;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class test3 {

    @Async
    public void out3(){
        Trade t3 = new Trade();
        for (int i = 0; i <20; i++) {
            t3.tradeQueue.offer(i);
        }

    }

}
