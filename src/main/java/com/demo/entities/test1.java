package com.demo.entities;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class test1 {

    @Async
    public void out1(){
        Trade t1=new Trade();
        while(true)
            System.out.println("t1 pull value:" + t1.pollout());
    }

}
