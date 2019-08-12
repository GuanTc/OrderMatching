package com.demo.entities;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class test2 {

    @Async
    public void out2(){
        Trade t2=new Trade();
        while(true)
            System.out.println("t2 pull value:" + t2.pollout());
    }

}
